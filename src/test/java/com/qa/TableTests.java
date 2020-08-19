package com.qa;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
      driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
    }
    @After
    public void tearDown() {
      driver.quit();
    }

    // Table Tests
    @Test
    public void paginationTest() {
      driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
        driver.findElement(By.linkText("»")).click();

        List<WebElement> elements = driver.findElements(By.linkText("«"));
        assert(elements.size() > 0);

        driver.findElement(By.linkText("»")).click();

        assert(elements.size() > 0);

        driver.findElement(By.linkText("«")).click();
        driver.findElement(By.linkText("2")).click();
        driver.findElement(By.linkText("3")).click();
        driver.findElement(By.linkText("2")).click();
        driver.findElement(By.linkText("1")).click();
    }
    @Test
    public void filterNumber() {
        WebElement table1 = driver.findElement(By.id("task-table"));
        WebElement table1Body = table1.findElement(By.tagName("tbody"));
        List<WebElement> tableRows = table1Body.findElements(By.tagName("tr"));

        filterTable("1");
        filterTable("2");
        filterTable("3");
        filterTable("4");
        filterTable("5");
        filterTable("6");
        filterTable("7");

        generateResultsList(tableRows, 1);
    }
    @Test
    public void filterTask() {
      WebElement table1 = driver.findElement(By.id("task-table"));
      WebElement table1Body = table1.findElement(By.tagName("tbody"));
      List<WebElement> tableRows = table1Body.findElements(By.tagName("tr"));

      filterTable("wire");
      generateResultsList(tableRows, 1);
      filterTable("land");
      generateResultsList(tableRows, 1);
      filterTable("seo");
      generateResultsList(tableRows, 1);
      filterTable("bootstrap");
      generateResultsList(tableRows, 1);
      filterTable("jQuery");
      generateResultsList(tableRows, 1);
      filterTable("browser");
      generateResultsList(tableRows, 1);
      filterTable("bug");
      generateResultsList(tableRows, 1);

    }
    @Test
    public void filterAssignees() {
      WebElement table1 = driver.findElement(By.id("task-table"));
      WebElement table1Body = table1.findElement(By.tagName("tbody"));
      List<WebElement> tableRows = table1Body.findElements(By.tagName("tr"));

      filterTable("john");
      generateResultsList(tableRows, 2);
      filterTable("mike");
      generateResultsList(tableRows, 1);
      filterTable("loblab");
      generateResultsList(tableRows, 1);
      filterTable("emily");
      generateResultsList(tableRows, 1);
      filterTable("holden");
      generateResultsList(tableRows, 1);
      filterTable("jane doe");
      generateResultsList(tableRows, 1);
      filterTable("kilgore");
      generateResultsList(tableRows, 1);
    }
    @Test
    public void filterStatus() {
      WebElement table1 = driver.findElement(By.id("task-table"));
      WebElement table1Body = table1.findElement(By.tagName("tbody"));
      List<WebElement> tableRows = table1Body.findElements(By.tagName("tr"));

      filterTable("in progress");
      generateResultsList(tableRows, 3);
      filterTable("completed");
      generateResultsList(tableRows, 1);
      filterTable("failed QA");
      generateResultsList(tableRows, 1);
    }
    // Creates a new list of elements that can be used in an assert()
    // by looping through an existing list.
    // Also asserts the elements exist and are not null.
    // Params:
    //     List list, the list to loop through
    //     and compare elements to add to the new list
    //     int comparator, the num to use in the assert statement
    //     to check the size of the new list
    public void generateResultsList(List<WebElement> list, int comparator) {
      List<WebElement> tableResults = new ArrayList<>();
      for(WebElement tr : list) {
        if (tr.isDisplayed()) {
          tableResults.add(tr);
          System.out.println("table data: " + tr.getAttribute("innerText"));
        }
      }
      assert tableResults.size() >= comparator;
      assertNotNull(tableResults.get(0));
    }
    // Gets the search field from the page and enters a search term
    // Params:
    //     String searchTerm, the keys to send to the search field
    public void filterTable(String searchTerm) {
      WebElement searchField = driver.findElement(By.id("task-table-filter"));
      searchField.click();
      searchField.clear();
      searchField.sendKeys(searchTerm);
    }
}