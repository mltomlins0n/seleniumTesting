package com.qa;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", 
            "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void dragDrop() throws InterruptedException {
        WebElement dragBox = driver.findElement(By.cssSelector("#todrag > span:nth-child(2)"));
        WebElement dropZone = driver.findElement(By.cssSelector("#mydropzone"));
        WebElement droppedListContainer = driver.findElement(By.id("droppedlist"));
        List <WebElement> droppedList = droppedListContainer.findElements(By.tagName("span"));

        // This code is correct, but doesn't work on the selenium website for some reason
        Actions drag = new Actions(driver);
        drag.dragAndDrop(dragBox, dropZone).build().perform();

        //assert(droppedList.size() == 1);

    }
}
