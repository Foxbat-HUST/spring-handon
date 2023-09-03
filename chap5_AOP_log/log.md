# Application of Spring AOP to create Log Annotation

## Usage

`@Log` can be used at class level or method level

1. class level

```java

import com.anpq.spring.util.Log;
import org.springframework.stereotype.Component
@Component
@Log
public class ServiceImplement implements Service{
  private static Logger logger = LoggerFactory.getLogger(ServiceImplement.class);

  @Override
  public String doJob(String input) {
    logger.info("do job: {}", input);
    return String.format("do job: %s", input);
  }

  @Override
  public Adult growUp(Children children) {
    return new Adult(children.getName(), children.getAge() + 18);
  }

}

```

2. Method level

```java
import com.anpq.spring.util.Log;
import org.springframework.stereotype.Component
@Component
public class ServiceImplement implements Service{
  private static Logger logger = LoggerFactory.getLogger(ServiceImplement.class);

  @Override
  @Log
  public String doJob(String input) {
    logger.info("do job: {}", input);
    return String.format("do job: %s", input);
  }

  @Override
  public Adult growUp(Children children) {
    return new Adult(children.getName(), children.getAge() + 18);
  }

}

```

## TODO

implementation of `@IgnoreLog` to prevent logging of sensitive data
`@IgnoreLog` will be used at field level or param level

1. Field level

```java
import com.anpq.spring.util.IgnoreLog;
Class User{
  @IgnoreLog
  private String password;
  //other properties
}

```

2. Parameter level

```java
import com.anpq.spring.util.IgnoreLog;
Class Service{
  public void login(String userName, @IgnoreLog String password){
    // method body
  }
}

```
