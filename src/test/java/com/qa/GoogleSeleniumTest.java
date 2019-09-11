package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSeleniumTest {

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
    public void searchTest() throws InterruptedException {
        driver.get("http://www.google.com");
        Thread.sleep(500);
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("funny cat pictures");
        Thread.sleep(500);
        searchField.sendKeys(Keys.ENTER);
        //WebElement submitButton = driver.findElement(By.name("btnK"));
        //submitButton.click();
        Thread.sleep(500);
        WebElement linkToTestingResult = driver.findElementByLinkText(
                "Images for funny cat");
        linkToTestingResult.click();
        Thread.sleep(500);
        WebElement catPic = driver.findElement(By.id("xY4xU-n5chBuNM:"));
        catPic.click();
        Thread.sleep(500);
        WebElement page = driver.findElement(By.id("gsr")); // get html body
        page.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
    }
}
