package com.qa;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
      @Test
      public void dragDropSliders() {
        driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
        WebElement slider1 = driver.findElement(By.id("slider1"));
        WebElement slider2 = driver.findElement(By.id("slider2"));
        WebElement slider3 = driver.findElement(By.id("slider3"));
        WebElement slider4 = driver.findElement(By.id("slider4"));
        WebElement slider5 = driver.findElement(By.id("slider5"));
        WebElement slider6 = driver.findElement(By.id("slider6"));
        
        List<WebElement> sliderList = new ArrayList<WebElement>();

        sliderList.add(slider1);
        sliderList.add(slider2);
        sliderList.add(slider3);
        sliderList.add(slider4);
        sliderList.add(slider5);
        sliderList.add(slider6);

        Random rand = new Random();
        Actions builder = new Actions(driver);

        for (WebElement slider : sliderList) {
          WebElement sliderRange = slider.findElement(By.className("range"));
          WebElement sliderInput = sliderRange.findElement(By.tagName("input"));
          WebElement sliderVal = slider.findElement(By.tagName("output"));
          // This random int is the offset from the center of the element to be clicked
          // The range is -200 to 200 pixels
          int randX = rand.nextInt(200 + 10) - 200;
          builder.moveToElement(sliderInput, randX, 0).click().build().perform();
          System.out.println("Slider value: " + sliderVal.getText());
        }

        //TODO - Add some assert statements to make sure the slider value is valid
      }
}