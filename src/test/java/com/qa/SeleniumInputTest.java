package com.qa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumInputTest {

    private ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void seleniumEasyTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(1000);
        WebElement inputField = driver.findElement(By.id("user-message"));
        inputField.sendKeys("This is an automated message");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
        submitButton.click();
        Thread.sleep(2000);
    }

    @Test
    public void seleniumEasyTest2() throws InterruptedException {

    }
}
