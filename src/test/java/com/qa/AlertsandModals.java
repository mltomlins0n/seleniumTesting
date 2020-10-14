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
            // Click each button, close each alert
            // Wait for the autoclose alerts to be closed
            button.click();
        }
        // I tried looping through a list of alerts and clicking all the buttons
        // by selecting all <divs>
        // The only way I can select alert buttons is through XPath, so no loops
        WebElement successCloseButton = driver.findElement(By.xpath(
            "/html/body/div[2]/div/div[2]/div/div[2]/div[2]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(successCloseButton));
        successCloseButton.click();

        WebElement warningCloseButton = driver.findElement(By.xpath(
            "/html/body/div[2]/div/div[2]/div/div[2]/div[4]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(warningCloseButton));
        warningCloseButton.click();

        WebElement dangerCloseButton = driver.findElement(By.xpath(
            "/html/body/div[2]/div/div[2]/div/div[2]/div[6]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(dangerCloseButton));
        dangerCloseButton.click();

        WebElement infoCloseButton = driver.findElement(By.xpath(
            "/html/body/div[2]/div/div[2]/div/div[2]/div[8]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(infoCloseButton));
        infoCloseButton.click();
        
        for (WebElement alert : alerts) {
            // TODO - wait for alerts to be invis and assert
        }
        WebElement successAlert = driver.findElement(By.cssSelector(
            "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.col-md-6 > div.alert.alert-success.alert-autocloseable-success"));
            wait.until(ExpectedConditions.invisibilityOf(successAlert));
        assertFalse("Alerts should be gone", successAlert.isDisplayed());
    }
}
