package com.qa;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.ExpectedConditions;


public class DynamicDataLoading {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", 
            "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void getUserTest() throws InterruptedException {
        WebElement userContainter = driver.findElement(By.id("loading"));
        WebElement getUserButton = driver.findElement(By.id("save"));
        getUserButton.click();
        // Use regex to wait until the text "First" appears inside the user container
        // This means the user has loaded
        wait.until(ExpectedConditions.textMatches(By.id("loading"), Pattern.compile("First")));
        WebElement userImage = driver.findElement(By.cssSelector("#loading > img"));
        System.out.println(userContainter.getText() + "\n");
        // Get the image's link text from the HTML
        System.out.println(userImage.getAttribute("src"));
    }
}