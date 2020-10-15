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
    private WebDriverWait wait;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", 
        "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);

        js = (JavascriptExecutor) driver;
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    // Alert Tests
    @Test
    public void bootstrapAlerts() {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");

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
    @Test
    public void bootstrapModals() {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html");
        WebElement launchButton = driver.findElement(By.cssSelector(
            "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > div > div.panel-body > a"));
        launchButton.click();
        WebElement modal = driver.findElement(By.cssSelector(
            "#myModal0 > div > div > div.modal-footer"));
        wait.until(ExpectedConditions.visibilityOf(modal));
        // Click the top right close icon
        driver.findElement(By.className("close")).click();
        launchButton.click();
        wait.until(ExpectedConditions.visibilityOf(modal));
        // Click the close button
        WebElement closeButton = driver.findElement(By.className("btn"));
        // Using js executor to get around "Element Click Intercepted" exception
        js.executeScript("arguments[0].click()", closeButton);
        launchButton.click();
        wait.until(ExpectedConditions.visibilityOf(modal));
        // Click the "Save Changes" button
        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"myModal0\"]/div/div/div[4]/a[2]"));
        js.executeScript("arguments[0].click()", saveButton);

        // TODO - Use this switch statement to automate the modal
        for (int i = 0; i < 3; i++) {
            switch(i) {
                case 0:
                System.out.println(i);
                break;
                case 1:
                System.out.println("case 1 " + i);
                break;
                case 2:
                System.out.println("Case 2 " + i);
                break;
                default:
                System.out.println("You shouldn't be here...");
            }
        }
    }
}
