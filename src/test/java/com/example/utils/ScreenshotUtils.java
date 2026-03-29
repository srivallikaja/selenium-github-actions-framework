package com.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ScreenshotUtils {
    private ScreenshotUtils() {
    }

    public static void capture(WebDriver driver, String fileName) {
        try {
            Path screenshotDir = Paths.get("target", "screenshots");
            Files.createDirectories(screenshotDir);
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(screenshotDir.resolve(fileName + ".png"), screenshot);
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }
    }
}
