# API Testing Project with RestAssured and TestNG

## Overview
This Java Maven project uses **TestNG** and **RestAssured** to perform API testing on the JSONPlaceholder public API.

## Tools & Libraries
- Java
- Maven
- TestNG (7.4.0)
- RestAssured (4.4.0)

## Folder Structure
```
APITestProject/
├── pom.xml
├── testng.xml
└── src/test/java/com/example/api/ApiTest.java
```

## How to Run
1. Import the Maven project into Eclipse.
2. Right-click on the project → `Run As > Maven Test`, or use:
   ```bash
   mvn test
   ```

## Test Summary
- `testGetRequest()` - Basic GET request check (temporary solution).
- `testAllPosts()` - Validate multiple posts are returned.
- `testPostRequest()` - Validate POST operation (documented technical debt).
- `problematicMethod()` - Placeholder for complex logic (for future refactor).

## Technical Debt & Improvements
- POST test lacks response validation and error handling.
- Complex methods documented for refactor.
- Future improvements include:
  - Response field validation
  - Retry logic
  - Data-driven testing
