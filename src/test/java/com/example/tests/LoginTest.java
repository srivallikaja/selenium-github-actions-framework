package com.example.tests;

import com.example.base.BaseTest;
import com.example.pages.LoginPage;
import com.example.utils.ConfigReader;
import com.example.utils.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify valid login redirects user to inventory page")
    public void validLoginShouldNavigateToInventory() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver())
                .open(ConfigReader.get("baseUrl"))
                .loginAs("standard_user", "secret_sauce");

        Assert.assertEquals(loginPage.getPageTitle(), "Products", "User should land on Products page after login");
    }

    @Test(description = "Verify locked user sees correct error message")
    public void lockedOutUserShouldSeeErrorMessage() {
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver())
                .open(ConfigReader.get("baseUrl"))
                .loginAs("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.getErrorMessage().contains("locked out"), "Expected locked out error message was not displayed");
    }
}
