package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class SeleniumScreenshotTest {

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
    public void screenShotTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(srcFile.getAbsolutePath());
        Thread.sleep(1000);
    }
}
