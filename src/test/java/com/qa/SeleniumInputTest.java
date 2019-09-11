package com.qa;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;
import java.util.List;

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
    public void simpleFormTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        WebElement inputField = driver.findElement(By.id("user-message"));
        inputField.sendKeys("This is an automated message");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
        submitButton.click();
        Thread.sleep(2000);
    }

    @Test
    public void simpleFormTest2() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
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

    @Test
    public void checkboxTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        WebElement checkbox = driver.findElementById("isAgeSelected");

        for (int i = 0; i < 100; i++) {
            checkbox.click();
        }
        Thread.sleep(2000);
    }

    @Test
    public void multipleCheckboxTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        List<WebElement> checkboxList = driver.findElementsByClassName("cb1-element");

        for (WebElement box : checkboxList) {
            box.click();
            Thread.sleep(500);
        }

        WebElement checkButton = driver.findElementById("check1");

        if (checkButton.getAttribute("value").equals("Uncheck All")) {
            checkButton.click();
            Thread.sleep(1000);
            checkButton.click();
            Thread.sleep(1000);
        }
    }

    @Test
    public void radioButtonTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        List<WebElement> radioButtonList = driver.findElementsByName("optradio");
        WebElement submitButton = driver.findElementById("buttoncheck");

        for (WebElement button : radioButtonList) {
            button.click();
            Thread.sleep(500);
            submitButton.click();
            Thread.sleep(500);
        }
    }

    @Test
    public void groupRadioButtonsTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        List<WebElement> genderButtons = driver.findElementsByName("gender");
        List<WebElement> ageButtons = driver.findElementsByName("ageGroup");
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button"));

        for (WebElement gButton : genderButtons) {
            gButton.click();
            Thread.sleep(500);
            for (WebElement aButton : ageButtons) {
                aButton.click();
                Thread.sleep(500);
                submitButton.click();
            }
        }
        submitButton.click();
    }

    @Test
    public void selectListTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        WebElement dropDown = driver.findElement(By.id("select-demo"));
        Select select = new Select(dropDown);
        List<WebElement> dropDownOptions = select.getOptions();

        for (WebElement option : dropDownOptions) {
            dropDown.click();
            Thread.sleep(200);
            option.click();
            Thread.sleep(200);
        }
        Thread.sleep(2000);
    }
}
