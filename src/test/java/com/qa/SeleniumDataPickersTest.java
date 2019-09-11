package com.qa;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDataPickersTest {

    private ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty(
                "webdriver.chrome.driver",
                "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
