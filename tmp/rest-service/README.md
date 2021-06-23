# coding-for-jesus
How to build and run the project:
- Make sure you have JDK 1.8 or later
- Make sure you have Gradle 4+
- Change directory into 'rest-service'
- Run `gradle wrapper --gradle-version 7.0`
- Run `./gradlew bootRun`
# testing
- Test service by running `curl -X POST http://localhost:8080/message -H "Content-Type: application/json" -d "{ \"id\": \"123\", \"message\": \"hello world\" }"`
- Change id and message fields to send varied data