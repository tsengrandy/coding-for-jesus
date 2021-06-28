# coding-for-jesus
How to build and run the project:
- Make sure you have JDK 1.8 or later
- Make sure you have Gradle 4+
- Run `./gradlew bootRun`
# testing
- Test service by running `curl -X POST http://localhost:8080/message -H "Content-Type: application/json" -d "{ \"id\": \"123\", \"message\": \"hello world\" }"`
- Change id and message fields to send varied data
- Test on the cloud by replacing `localhost` with EC2 url `ec2-34-218-226-30.us-west-2.compute.amazonaws.com`
# stretch goals
- Integrated CI pipeline on CircleCI with Docker here: https://app.circleci.com/pipelines/github/tsengrandy/coding-for-jesus?invite=true
- Service is deployed on EC2 `http://ec2-34-218-226-30.us-west-2.compute.amazonaws.com:8080/message` Note that this instance will remember all ids since the instance inception
- Ids and total word count stored on MySql DB on EC2 instance.
- Would love feedback on the code or even technology choice. This was my first time using Java, Spring, and Gradle.
