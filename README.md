# 🚀 SDET Automation Framework (UI + API + E2E)

A **scalable, production-ready test automation framework** built using **Java, Selenium, RestAssured, TestNG, Maven, and GitHub Actions**, following **industry best practices** used by SDET teams.

This framework supports **UI automation, API automation, and End-to-End (API → UI) testing** with environment-based configuration, reporting, logging, retry logic, and CI integration.

---

## 🧠 Key Highlights

* ✅ **UI Automation** using Selenium WebDriver
* ✅ **API Automation** using RestAssured
* ✅ **E2E Testing** (API data → UI validation)
* ✅ **Page Object Model (POM)**
* ✅ **Environment-based configuration** (QA / UAT / PROD)
* ✅ **Thread-safe WebDriver (ThreadLocal)**
* ✅ **Centralized logging (Log4j2)**
* ✅ **Extent Reports with screenshots**
* ✅ **Retry Analyzer for flaky tests**
* ✅ **Test grouping (ui / api / e2e)**
* ✅ **GitHub Actions CI Pipeline**
* ✅ **Clean Git branching strategy**

---

## 🏗️ Project Architecture

### Design Pattern

**Page Object Model (POM)**

### Folder Structure

```
automation-framework
│
├── src/main/java
│
├── src/test/java
│   ├── com.sdet.framework.api        # API layer
│   ├── com.sdet.framework.ui         # UI tests
│   ├── com.sdet.framework.e2e        # API → UI E2E tests
│   ├── com.sdet.framework.base       # BaseTest (setup/teardown)
│   ├── com.sdet.framework.driver     # WebDriver Factory
│   ├── com.sdet.framework.pages      # Page Objects
│   ├── com.sdet.framework.listeners  # TestNG Listeners
│   ├── com.sdet.framework.reporting  # Extent Report Manager
│   └── com.sdet.framework.utils      # Config, Logger, Utilities
│
├── src/test/resources
│   ├── config
│   │   ├── qa.properties
│   │   ├── uat.properties
│   │   └── prod.properties
│   ├── log4j2.xml
│
├── .github/workflows
│   └── ci.yml                        # GitHub Actions CI Pipeline
│
├── pom.xml
├── testng.xml
└── README.md
```

---

## ⚙️ Environment Configuration

The framework supports **multiple environments** using a single command.

### Config Location

```
src/test/resources/config/
```

### Files

```
qa.properties
uat.properties
prod.properties
```

### Example Properties

```properties
baseUrl=https://www.google.com
api.base.url=https://jsonplaceholder.typicode.com
browser=chrome
implicitWait=10
```

---

## ▶️ How to Run Tests

### Run All Tests

```bash
mvn clean test
```

### Run by Environment

```bash
mvn test -Denv=qa
mvn test -Denv=uat
mvn test -Denv=prod
```

### Run by Test Groups

#### UI Tests

```bash
mvn test -Dgroups=ui -Denv=qa
```

#### API Tests

```bash
mvn test -Dgroups=api -Denv=qa
```

#### E2E Tests

```bash
mvn test -Dgroups=e2e -Denv=qa
```

---

## 🧪 Test Grouping Strategy

| Group | Purpose                   |
| ----- | ------------------------- |
| `ui`  | UI automation tests       |
| `api` | API automation tests      |
| `e2e` | API → UI end-to-end tests |

This allows **selective execution** locally and in CI.

---

## 📊 Reporting & Logging

### 📌 Extent Reports

* Auto-generated after every execution
* Screenshots captured on failure
* Location:

```
test-output/ExtentReport.html
```

### 📌 Logging

* Implemented using **Log4j2**
* Centralized logs per execution
* Location:

```
logs/automation.log
```

---

## 🔁 Retry Mechanism

* Failed tests are **automatically retried**
* Helps handle flaky UI tests
* Implemented using **TestNG RetryAnalyzer**

---

## 🔄 Git Branching Strategy

```
main
 ├── feature/logging
 ├── feature/config-management
 ├── feature/testing-groups
 ├── feature/reporting
 └── feature/retry-analyzer
```

Each feature was:

1. Developed in isolation
2. Tested locally
3. Merged to `main` via clean commits

---

## 🤖 GitHub Actions CI Pipeline

### CI Trigger

* On `push` to `main`
* On `pull_request` to `main`

### CI Workflow

```yaml
- Checkout code
- Set up Java 21
- Cache Maven dependencies
- Run API tests on QA environment
```

This ensures **every commit is validated automatically**.

