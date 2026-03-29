package com.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitUtils {
    private WaitUtils() {
    }

    public static WebElement waitForVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getLong("explicitWaitSeconds")))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getLong("explicitWaitSeconds")))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}
