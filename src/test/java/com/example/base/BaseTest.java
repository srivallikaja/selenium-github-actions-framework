package com.example.base;

import com.example.utils.DriverFactory;
import com.example.utils.ScreenshotUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess() && DriverFactory.getDriver() != null) {
            ScreenshotUtils.capture(DriverFactory.getDriver(), result.getMethod().getMethodName());
        }
        DriverFactory.quitDriver();
    }
}
