package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumDragDropTest {

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
    public void dragDropTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        //List<WebElement> elemList = driver.findElements(By.id("todrag"));

        WebElement elemToDrag = driver.findElement(By.xpath("//*[@id=\"todrag\"]/span[1]"));
        WebElement target = driver.findElement(By.id("mydropzone"));

        Actions action = new Actions(driver);
        Thread.sleep(1000);
        action.dragAndDrop(elemToDrag, target).perform();

        Thread.sleep(1000);

    }
}
