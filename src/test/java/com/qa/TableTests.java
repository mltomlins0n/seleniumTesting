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
    // Second table tests
    @Test
    public void filterNumber2() {
      WebElement filterButton = driver.findElement
      (By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div/button"));
      filterButton.click();

      WebElement table2 = driver.findElement(By.xpath
      ("/html/body/div[2]/div/div[2]/div[2]/div/table"));
      WebElement table2Body = table2.findElement(By.tagName("tbody"));
      List<WebElement> table2Rows = table2Body.findElements(By.tagName("tr"));

      filterTableCSS("th:nth-child(1) > .form-control", "1");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(1) > .form-control", "2");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(1) > .form-control", "3");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(1) > .form-control", "4");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(1) > .form-control", "5");
      generateResultsList(table2Rows, 1);
    }
    @Test
    public void filterUser() {
      WebElement filterButton = driver.findElement
      (By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div/button"));
      filterButton.click();

      WebElement table2 = driver.findElement(By.xpath
      ("/html/body/div[2]/div/div[2]/div[2]/div/table"));
      WebElement table2Body = table2.findElement(By.tagName("tbody"));
      List<WebElement> table2Rows = table2Body.findElements(By.tagName("tr"));

      filterTableCSS("th:nth-child(2) > .form-control", "mark");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(2) > .form-control", "jacobs");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(2) > .form-control", "larrypt");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(2) > .form-control", "mikesali");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(2) > .form-control", "chrisford");
      generateResultsList(table2Rows, 1);
    }
    @Test
    public void filterFirstName() {
      WebElement filterButton = driver.findElement
      (By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div/button"));
      filterButton.click();

      WebElement table2 = driver.findElement(By.xpath
      ("/html/body/div[2]/div/div[2]/div[2]/div/table"));
      WebElement table2Body = table2.findElement(By.tagName("tbody"));
      List<WebElement> table2Rows = table2Body.findElements(By.tagName("tr"));

      filterTableCSS("th:nth-child(3) > .form-control", "zieko");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(3) > .form-control", "daniel");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(3) > .form-control", "brigade");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(3) > .form-control", "byron");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(3) > .form-control", "rajano");
      generateResultsList(table2Rows, 1);
    }
    @Test
    public void filterLastName() {
      WebElement filterButton = driver.findElement
      (By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div/button"));
      filterButton.click();

      WebElement table2 = driver.findElement(By.xpath
      ("/html/body/div[2]/div/div[2]/div[2]/div/table"));
      WebElement table2Body = table2.findElement(By.tagName("tbody"));
      List<WebElement> table2Rows = table2Body.findElements(By.tagName("tr"));

      filterTableCSS("th:nth-child(4) > .form-control", "samuels");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(4) > .form-control", "karano");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(4) > .form-control", "swarroon");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(4) > .form-control", "kathaniko");
      generateResultsList(table2Rows, 1);
      filterTableCSS("th:nth-child(4) > .form-control", "dimarison");
      generateResultsList(table2Rows, 1);
    }
    // Table Filter Tests
    @Test
    public void tableFilter() {
      driver.get("https://www.seleniumeasy.com/test/table-records-filter-demo.html#");
      
      driver.findElement(By.cssSelector(".btn-success")).click();
      // TODO - create a list of results and check that it's populated by valid results
      driver.findElement(By.cssSelector(".btn-warning")).click();

      driver.findElement(By.cssSelector(".btn-danger")).click();

      driver.findElement(By.cssSelector(".btn-default")).click();
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
          System.out.println("Table Data: " + tr.getAttribute("innerText"));
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
    // Gets the search field from the page and enters a search term
    // Params:
    //     String selector, the css selector used to find the element
    //     String searchTerm, the keys to send to the search field
    public void filterTableCSS(String selector, String searchTerm) {
      WebElement searchField = driver.findElement(By.cssSelector(selector));
      searchField.click();
      searchField.clear();
      searchField.sendKeys(searchTerm);
    }
}