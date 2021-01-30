package com.qa;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListBox {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", 
            "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-dual-list-box-demo.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // Bootstrap list box tests
    @Test
    public void leftListBox() {
        WebElement moveLeftButton = driver.findElement(By.cssSelector(
            "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.list-arrows.col-md-1.text-center > button.btn.btn-default.btn-sm.move-left"));
        WebElement moveRightButton = driver.findElement(By.cssSelector(
            "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.list-arrows.col-md-1.text-center > button.btn.btn-default.btn-sm.move-right"));
        WebElement leftListBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul"));
        List <WebElement> leftList = leftListBox.findElements(By.className("list-group-item"));
        
        for (WebElement item : leftList) {
            item.click();
        }
        moveRightButton.click();
        List <WebElement> leftList2 = leftListBox.findElements(By.className("list-group-item"));
        assert(leftList2.isEmpty());
        moveLeftButton.click();
        List <WebElement> leftList3 = leftListBox.findElements(By.className("list-group-item"));
        assert(leftList3.size()==5);

        //wait(leftListBox, 500);
    }

    @Test
    public void rightListBox() {
        WebElement moveLeftButton = driver.findElement(By.cssSelector(
            "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.list-arrows.col-md-1.text-center > button.btn.btn-default.btn-sm.move-left"));
        WebElement moveRightButton = driver.findElement(By.cssSelector(
            "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.list-arrows.col-md-1.text-center > button.btn.btn-default.btn-sm.move-right"));
        WebElement rightListBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul"));
        List <WebElement> rightList = rightListBox.findElements(By.className("list-group-item"));

        for (WebElement item : rightList) {
            item.click();
        }
        moveLeftButton.click();
        List <WebElement> rightList2 = rightListBox.findElements(By.className("list-group-item"));
        assert(rightList2.isEmpty());
        moveRightButton.click();
        List <WebElement> rightList3 = rightListBox.findElements(By.className("list-group-item"));
        assert(rightList3.size()==5);

        //wait(rightListBox, 500);
    }

    @Test
    public void leftCheckAll() {
        WebElement moveLeftButton = driver.findElement(By.cssSelector(
            "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.list-arrows.col-md-1.text-center > button.btn.btn-default.btn-sm.move-left"));
        WebElement moveRightButton = driver.findElement(By.cssSelector(
            "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.list-arrows.col-md-1.text-center > button.btn.btn-default.btn-sm.move-right"));
        WebElement leftListBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul"));
        WebElement leftAllButton = driver.findElement(By.cssSelector("#listhead > div.col-md-2 > div > a"));
        
        leftAllButton.click();
        moveRightButton.click();
        List <WebElement> leftList = leftListBox.findElements(By.className("list-group-item"));
        assert(leftList.isEmpty());
        moveLeftButton.click();
        List <WebElement> leftList2 = leftListBox.findElements(By.className("list-group-item"));
        assert(leftList2.size()==5);

        //wait(leftListBox, 500);
    }

    @Test
    public void rightCheckAll() {
        WebElement moveLeftButton = driver.findElement(By.cssSelector(
            "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.list-arrows.col-md-1.text-center > button.btn.btn-default.btn-sm.move-left"));
        WebElement moveRightButton = driver.findElement(By.cssSelector(
            "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.list-arrows.col-md-1.text-center > button.btn.btn-default.btn-sm.move-right"));
        WebElement rightListBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul"));
        WebElement rightAllButton = driver.findElement(By.xpath("//*[@id='listhead']/div[1]/div/a"));
        
        rightAllButton.click();
        moveLeftButton.click();
        List <WebElement> rightList = rightListBox.findElements(By.className("list-group-item"));
        assert(rightList.isEmpty());
        moveRightButton.click();
        List <WebElement> rightList2 = rightListBox.findElements(By.className("list-group-item"));
        assert(rightList2.size()==5);

        //wait(rightListBox, 500);
    }

    @Test
    public void searchBars() {
        WebElement leftSearchBox = driver.findElement(By.cssSelector("#listhead > div.col-md-10 > div > input"));
        WebElement rightSearchBox = driver.findElement(By.xpath("//*[@id='listhead']/div[2]/div/input"));
        WebElement leftListBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul"));
        WebElement rightListBox = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul"));
        List <WebElement> leftList = leftListBox.findElements(By.className("list-group-item"));
        List <WebElement> rightList = rightListBox.findElements(By.className("list-group-item"));

        // Left search box tests
        leftSearchBox.sendKeys("boot");
        // number of list items displayed
        int itemCount = 0;
        for (WebElement item : leftList) {
            if (item.isDisplayed()) {
                itemCount++;
            }
        }
        assert(itemCount==1);

        leftSearchBox.clear();
        leftSearchBox.sendKeys("dfgkuh"); // nonsense search to ensure no results
        itemCount = 0;
        for (WebElement item : leftList) {
            if (item.isDisplayed()) {
                itemCount++;
            }
        }
        assert(itemCount==0);

        // Right search box tests
        rightSearchBox.sendKeys("ac");
        // number of list items displayed
        for (WebElement item : rightList) {
            if (item.isDisplayed()) {
                itemCount++;
            }
        }
        assert(itemCount==2);

        rightSearchBox.clear();
        rightSearchBox.sendKeys("dfgkuh"); // nonsense search to ensure no results
        itemCount = 0;
        for (WebElement item : rightList) {
            if (item.isDisplayed()) {
                itemCount++;
            }
        }
        assert(itemCount==0);
        //wait(leftListBox, 500);
    }

    public void wait(WebElement elem, int duration) {
        ReentrantLock lock = new ReentrantLock();
        synchronized(elem) {
            try {
                lock.lock();
                Thread.sleep(duration);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}