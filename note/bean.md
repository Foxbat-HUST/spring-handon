# This is note about behavior of creating bean in Spring

## In config class, using bean injection instead of calling bean create function directly

### This config class will create only one instance of `Singer` class only

```java
public class AppConfig{
  Logger logger = LoggerFactory.getLogger(AppConfig.class);

  @Bean
  public Singer singer(){
    logger.info("create singer bean...");
    return new BoleroSinger();
  }

  @Bean
  public Advice advice(){
    return new SimpleBeforeAdvice();
  }

  @Bean
  public Band band(Singer singer){
    return new Band(singer);
  }
}
```

### But this class will create two instances of `Singer` class

```java
public class AppConfig{
  Logger logger = LoggerFactory.getLogger(AppConfig.class);

  @Bean
  public Singer singer(){
    logger.info("create singer bean...");
    return new BoleroSinger();
  }

  @Bean
  public Advice advice(){
    return new SimpleBeforeAdvice();
  }

  @Bean
  public Band band(){
    return new Band(singer());
  }
}
```
