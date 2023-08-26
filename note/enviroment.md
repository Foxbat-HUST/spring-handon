# Spring's lookup PropertyResource behavior

## By default, Spring will lookup PropertyResource in following order

1. System properties for the running JVM
2. Environment variables
3. Application-defined properties (in properties file)

In example, when property such as `user.home` is defined in application.properties file,
Spring does not read this value, but environment variable.
If you will really want Spring use properties defined in properties file instead of system properties or environment variable, you can archive this by following way:

### Extend class `StandardEnvironment` and override methods `getSystemEnvironment` or `getSystemProperties`

```java
import org.springframework.core.env.StandardEnvironment;

public class ApplicationPropertiesConfiguration extends StandardEnvironment {
  @Override
  public Map<String, Object> getSystemEnvironment() {
    return new HashMap<>();
  }

  @Override
  public Map<String, Object> getSystemProperties() {
    return new HashMap<>();
  }
}

```

### Call `setEnvironment()` on `context` object and pass an instance of `ApplicationPropertiesConfiguration`

Don't forget call `context.refresh()`

```java
  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
  context.setEnvironment(new ApplicationPropertiesConfiguration());
  context.register(PropertySourcesCfg.class);
  context.refresh();
```
