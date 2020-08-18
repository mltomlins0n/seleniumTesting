package com.qa;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTests {
    private WebDriver driver;
    JavascriptExecutor js;
  
    @Before
    public void setUp() {
      System.setProperty(
                  "webdriver.chrome.driver",
                  "src/test/java/resources/chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      js = (JavascriptExecutor) driver;
    }
    @After
    public void tearDown() {
      driver.quit();
    }
}