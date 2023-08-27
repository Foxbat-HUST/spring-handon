# Profile and ActiveProfiles in Spring

1. Use `@Profile` to set profile for bean
2. Use `@ActiveProfiles` to set active profile for application
3. To set active profile for testing, use command: `mvn test -Dspring.profiles.active={profile for run test}`
4. To specify active profile when run or debug app in vs code, create a launch.json file with bellow content:

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "App",
      "request": "launch",
      "mainClass": "com.anpq.spring.App", // main class
      "projectName": "chap4", // project name
      "vmArgs": " -Dspring.profiles.active={active profile}"
    }
  ]
}
```