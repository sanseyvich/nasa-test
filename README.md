# nasa-test

-------------------
General description
-------------------
NASA-test is a basic framework for automated verification of NASA REST API - 
(https://api.nasa.gov/index.html#getting-started).
For REST calls org.springframework.web.client.RestTemplate is used.
JSON parsing is made using com.google.code.gson library.
Tests are implemented using simple Junit syntax.
No specific libraries, BDD or reporting frameworks are configured to keep implementation 
simple - minimum necessary for a given task:

Create pilot test framework for testing NASA's open API (https://api.nasa.gov/index.html#getting-started). 
The purpose of the test is to check images which are made by Curiosity.
Test scenario:
1. Get first 10 Mars photos made by "Curiosity" on 1000 sol.
2. Get the same 10 Mars photos made by "Curiosity" on earth date that is equals 1000 Mars sol.
3. Compare downloaded images and metadata from API. Test fails in case if any difference.
Please use standard technologies, tools and frameworks which you are usually use in test frameworks creation.
As a plus:
Using NASA’s API determine how many pictures were made by each camera (by Curiosity on 1000 sol.). If any camera made 10 times more images than any other - test fails.

-----------------
How to run tests
-----------------
To be able to proceed with test executions followed steps should be done:

1. Run mvn clean test from within project home folder.
