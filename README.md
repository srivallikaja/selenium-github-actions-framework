# Selenium + GitHub Actions Framework

A ready-to-upload Selenium automation framework using:
- Java 21
- Maven
- Selenium WebDriver
- TestNG
- WebDriverManager
- GitHub Actions CI
- Page Object Model
- Screenshots on failure

## Project Structure

```text
selenium-github-actions-framework/
├── .github/workflows/selenium-ci.yml
├── pom.xml
├── testng.xml
├── src/test/java/com/example/
│   ├── base/BaseTest.java
│   ├── pages/LoginPage.java
│   ├── tests/LoginTest.java
│   └── utils/
│       ├── ConfigReader.java
│       ├── DriverFactory.java
│       ├── ScreenshotUtils.java
│       └── WaitUtils.java
└── src/test/resources/config.properties
```

## How to Run Locally

```bash
mvn clean test
```

Run with browser override:

```bash
mvn clean test -Dbrowser=firefox -Dheadless=true
```

## What this framework demonstrates

- Clean Page Object Model design
- Reusable driver management
- Centralized config handling
- Explicit waits
- CI/CD integration with GitHub Actions
- Artifact upload for failures and reports

## How to Push to GitHub

```bash
git init
git add .
git commit -m "Initial Selenium framework"
git branch -M main
git remote add origin https://github.com/<your-username>/<repo-name>.git
git push -u origin main
```

## How to Trigger CI

- Push to `main` or `master`
- Open a pull request
- Or run manually from the **Actions** tab using **workflow_dispatch**

## Interview Talking Points

- "I used Java 21, Selenium, TestNG, and Page Object Model to keep the automation maintainable."
- "I externalized browser and headless configuration so the same suite can run locally and in CI."
- "I added screenshot capture for failures and published artifacts in GitHub Actions for debugging."
- "The pipeline runs on push and pull request, which is close to a real CI validation workflow."
