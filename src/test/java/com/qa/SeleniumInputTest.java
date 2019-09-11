package com.qa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumInputTest {

    private ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void seleniumEasyTest() throws InterruptedException {
        WebElement inputField = driver.findElement(By.id("user-message"));
        inputField.sendKeys("This is an automated message");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
        submitButton.click();
        Thread.sleep(2000);
    }

    @Test
    public void seleniumEasyTest2() throws InterruptedException {
        WebElement firstInput = driver.findElementById("sum1");
        WebElement secondInput = driver.findElementById("sum2");
        WebElement submitButton = driver.findElementByXPath("//*[@id=\"gettotal\"]/button");
        WebElement footer = driver.findElementByClassName("footer");

        new Actions(driver).moveToElement(footer).perform();
        Thread.sleep(1000);
        firstInput.sendKeys(Keys.NUMPAD4, Keys.NUMPAD0);
        Thread.sleep(1000);
        secondInput.sendKeys((Keys.NUMPAD2));
        Thread.sleep(1000);
        submitButton.click();
        Thread.sleep(3000);

    }
}
