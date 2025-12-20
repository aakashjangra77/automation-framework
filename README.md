🚀 Automation Framework – UI | API | E2E 

A scalable, production-ready automation framework built using Java, Selenium, TestNG, Rest Assured, Maven, following SDET best practices.

This framework supports:

UI automation

API automation

End-to-End (API → UI) testing

Environment-based configuration

Structured logging

Retry mechanism

Extent Reports

GitHub Actions CI pipeline

🧩 Tech Stack

Language: Java 21

UI Automation: Selenium WebDriver

API Automation: Rest Assured

Test Framework: TestNG

Build Tool: Maven

Logging: Log4j2

Reporting: Extent Reports

CI/CD: GitHub Actions

Design Pattern: Page Object Model (POM)

📂 Project Structure
automation-framework
│
├── src/main/java
│
├── src/test/java
│   ├── com.sdet.framework.api        # API layer
│   ├── com.sdet.framework.ui         # UI tests
│   ├── com.sdet.framework.e2e        # E2E API → UI tests
│   ├── com.sdet.framework.base       # BaseTest (setup/teardown)
│   ├── com.sdet.framework.driver     # WebDriver factory
│   ├── com.sdet.framework.pages      # Page Objects
│   ├── com.sdet.framework.listeners  # TestNG listeners
│   ├── com.sdet.framework.reporting  # Extent report manager
│   └── com.sdet.framework.utils      # Config & utilities
│
├── src/test/resources
│   ├── config
│   │   ├── qa.properties
│   │   ├── uat.properties
│   │   └── prod.properties
│   ├── log4j2.xml
│
├── .github/workflows
│   └── ci.yml                        # GitHub Actions pipeline
│
├── pom.xml
├── testng.xml
└── README.md

⚙️ Environment Configuration

The framework supports multiple environments using Maven profiles.

Config files:
src/test/resources/config/
 ├── qa.properties
 ├── uat.properties
 └── prod.properties

Example:
baseUrl=https://www.google.com
api.base.url=https://jsonplaceholder.typicode.com
browser=chrome

Run with environment:
mvn test -Denv=qa
mvn test -Denv=uat
mvn test -Denv=prod

🧪 Test Grouping (UI | API | E2E)

Tests are organized using TestNG groups.

Run UI tests:
mvn test -Dgroups=ui

Run API tests:
mvn test -Dgroups=api

Run E2E tests:
mvn test -Dgroups=e2e

🔁 Retry Mechanism

Failed tests are automatically retried

Implemented using TestNG RetryAnalyzer

Helps reduce flaky failures in CI runs

📊 Reporting – Extent Reports

Rich HTML reports

Screenshots attached on failure

Logs included per test

📁 Output:

test-output/ExtentReport.html

📝 Logging

Centralized logging using Log4j2

Logs for:

Test lifecycle

API requests/responses

Browser actions

Stored under:

logs/

🤖 CI/CD – GitHub Actions

CI pipeline runs automatically on:

Push to main

Pull requests to main

Current CI flow:

Checkout code

Setup Java 21

Cache Maven dependencies

Run API tests on qa environment

mvn clean test -Dgroups=api -Denv=qa


✅ Pipeline status visible under GitHub Actions

🧠 Key Highlights (SDET Focused)

✔ Clean separation of UI, API, and E2E layers
✔ Reusable BaseTest & DriverFactory
✔ Thread-safe logging & reporting
✔ Environment-driven execution
✔ CI-ready & scalable
✔ Industry-aligned framework design

📌 How to Run Locally

Clone the repo:

git clone https://github.com/<your-username>/automation-framework.git


Navigate to project:

cd automation-framework


Run tests:

mvn clean test

👨‍💻 Author

Aakash Jangra
SDET | QA Automation Engineer

🔗 LinkedIn: https://www.linkedin.com/in/aakash-jangra-78a526191/

⭐ Final Note

This framework is designed to mirror real-world SDET responsibilities and can be easily extended to:

Parallel execution

Docker + Selenium Grid

Cloud execution (BrowserStack / Sauce Labs)
