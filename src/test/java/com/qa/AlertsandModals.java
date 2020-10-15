package com.qa;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertFalse;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
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
    public void bootstrapAlerts() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement buttonContainer = driver.findElement(By.className("col-md-4"));
        List <WebElement> buttons = buttonContainer.findElements(By.tagName("button"));

        WebElement alertContainer = driver.findElement(By.cssSelector(
        "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.col-md-6"));
        List <WebElement> alerts = alertContainer.findElements(By.tagName("div"));

        for (WebElement button : buttons) {
            button.click();
        }
        // Loop through alerts and if they aren't autoclose ones, click the close button
        for (WebElement alert : alerts) {
            // Select only the alerts that don't auto close
            if (alert.getAttribute("hidden") != null) {
                WebElement  closeButton = alert.findElement(By.tagName("button"));
                wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
            }
            wait.until(ExpectedConditions.invisibilityOf(alert));
            assertFalse("The alerts should be gone", alert.isDisplayed());
        }
    }
}
