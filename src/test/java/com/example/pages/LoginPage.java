package com.example.pages;

import com.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By pageTitle = By.cssSelector("span.title");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl);
        return this;
    }

    public LoginPage enterUsername(String username) {
        WaitUtils.waitForVisible(driver, usernameInput).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        WaitUtils.waitForVisible(driver, passwordInput).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        WaitUtils.waitForClickable(driver, loginButton).click();
        return this;
    }

    public LoginPage loginAs(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }

    public String getPageTitle() {
        return WaitUtils.waitForVisible(driver, pageTitle).getText();
    }

    public String getErrorMessage() {
        return WaitUtils.waitForVisible(driver, errorMessage).getText();
    }
}
