package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GoogleSeleniumTest {

    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Allows script execution such as scrolling a window
        js = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void searchTest() throws InterruptedException {
        driver.get("http://www.google.com");
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("funny cat pics");
        searchField.sendKeys(Keys.ENTER);
        //WebElement submitButton = driver.findElement(By.name("btnK"));
        //submitButton.click();
        WebElement linkToTestingResult = driver.findElement(By.linkText("Images for funny cat"));
        linkToTestingResult.click();
        js.executeScript("window.scrollTo(0,1281)");
        { // Wait until element is visible on screen
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
            "#islrg > div.islrc > div:nth-child(53) > a.wXeWr.islib.nfEiy.mM5pbd > div.bRMDJf.islir > img")));
        } // Find and click on element
        driver.findElement(By.cssSelector(
            "#islrg > div.islrc > div:nth-child(53) > a.wXeWr.islib.nfEiy.mM5pbd > div.bRMDJf.islir > img")).click();
    }
}