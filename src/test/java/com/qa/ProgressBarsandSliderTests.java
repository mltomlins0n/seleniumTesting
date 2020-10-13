package com.qa;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProgressBarsandSliderTests {
    private WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                           "src/test/java/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        js = (JavascriptExecutor) driver;
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    // Progress Bar Tests
    @Test
    public void jQueryUIProgessBarTest() {
        driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
        
        WebElement progressLabel = driver.findElement(By.className("progress-label"));
    
        driver.findElement(By.id("downloadButton")).click();
        // wait for progress label to say "completed!"
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElement(progressLabel, "Complete!"));
        driver.findElement(By.cssSelector(".ui-dialog-buttonset > button")).click();
        // Cancel the download
        driver.findElement(By.id("downloadButton")).click();
        driver.findElement(By.cssSelector(".ui-dialog-buttonset > button")).click();
      }
      @Test
      public void bootstrapProgressBar() {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-download-progress-demo.html");
        // If the test breaks, someone probably corrected the typo in "cricle"
        WebElement downloadButton = driver.findElement(By.id("cricle-btn"));
        WebElement downloadIcon = driver.findElement(By.className("percenttext"));
        {
          String downloadText = downloadIcon.getText();
          downloadButton.click();
          System.out.println("Download: " + downloadText);
        }
    
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        wait.until(ExpectedConditions.textToBePresentInElement(downloadIcon, "50%"));
        {
          String downloadText = downloadIcon.getText();
          System.out.println("Download: " + downloadText);
        }
        
        wait.until(ExpectedConditions.textToBePresentInElement(downloadIcon, "100%"));
        {
          String downloadText = downloadIcon.getText();
          System.out.println("Download: " + downloadText);
        }
      }
}