package com.qa;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsandModals {
    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", 
        "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        js = (JavascriptExecutor) driver;
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    // Alert Tests
    @Test
    public void bootstrapAlerts() {
        
    }
    
}
