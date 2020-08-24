package com.qa;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TableTests {
    private WebDriver driver;
    JavascriptExecutor js;
  
    @Before
    public void setUp() {
      System.setProperty(
                  "webdriver.chrome.driver",
                  "src/test/java/resources/chromedriver.exe");
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--ignore-certificate-errors");
      driver = new ChromeDriver(options);
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

        for (int i = 0; i < tableRows.size(); i++) {
          filterTableID("task-table-filter", Integer.toString(i+1));
          generateResultsList(tableRows, 1);  
        }
    }
    @Test
    public void filterTask() {
      WebElement table1 = driver.findElement(By.id("task-table"));
      WebElement table1Body = table1.findElement(By.tagName("tbody"));
      List<WebElement> tableRows = table1Body.findElements(By.tagName("tr"));

      filterTableID("task-table-filter", "wire");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "land");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "seo");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "bootstrap");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "jQuery");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "browser");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "bug");
      generateResultsList(tableRows, 1);

    }
    @Test
    public void filterAssignees() {
      WebElement table1 = driver.findElement(By.id("task-table"));
      WebElement table1Body = table1.findElement(By.tagName("tbody"));
      List<WebElement> tableRows = table1Body.findElements(By.tagName("tr"));

      filterTableID("task-table-filter", "john");
      generateResultsList(tableRows, 2);
      filterTableID("task-table-filter", "mike");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "loblab");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "emily");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "holden");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "jane doe");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "kilgore");
      generateResultsList(tableRows, 1);
    }
    @Test
    public void filterStatus() {
      WebElement table1 = driver.findElement(By.id("task-table"));
      WebElement table1Body = table1.findElement(By.tagName("tbody"));
      List<WebElement> tableRows = table1Body.findElements(By.tagName("tr"));

      filterTableID("task-table-filter", "in progress");
      generateResultsList(tableRows, 3);
      filterTableID("task-table-filter", "completed");
      generateResultsList(tableRows, 1);
      filterTableID("task-table-filter", "failed QA");
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
      driver.get("https://www.seleniumeasy.com/test/table-records-filter-demo.html");

      WebElement table = driver.findElement(By.xpath
      ("/html/body/div[2]/div/div[2]/section/div/div/div[2]/div[2]/table"));
      WebElement tableBody = table.findElement(By.tagName("tbody"));
      List<WebElement> tableRows = tableBody.findElements(By.tagName("tr"));

      driver.findElement(By.cssSelector(".btn-success")).click();
      generateResultsList(tableRows, 1);
      driver.findElement(By.cssSelector(".btn-warning")).click();
      generateResultsList(tableRows, 1);
      driver.findElement(By.cssSelector(".btn-danger")).click();
      generateResultsList(tableRows, 1);
      driver.findElement(By.cssSelector(".btn-default")).click();

      WebDriverWait wait = new WebDriverWait(driver, 5);
      // Wait until all table rows are fully visible
      wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
      generateResultsList(tableRows, 1);
    }
    // Table sort and search tests
    @Test
    public void tablePages() {
      driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");  
      driver.findElement(By.id("example_next")).click();
      driver.findElement(By.id("example_next")).click();
      driver.findElement(By.id("example_next")).click();
      driver.findElement(By.id("example_previous")).click();
      driver.findElement(By.id("example_previous")).click();
      driver.findElement(By.id("example_previous")).click();
      driver.findElement(By.linkText("2")).click();
      driver.findElement(By.linkText("3")).click();
      driver.findElement(By.linkText("4")).click();
      driver.findElement(By.linkText("3")).click();
      driver.findElement(By.linkText("2")).click();
      driver.findElement(By.linkText("1")).click();
    }
    @Test
    public void tableQuantityTest() {
      driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
      WebElement dropdown = driver.findElement(By.name("example_length"));
      WebElement table = driver.findElement(By.id("example"));
      WebElement tableBody = table.findElement(By.tagName("tbody"));
      List<WebElement> tableRows = tableBody.findElements(By.tagName("tr"));

      // Verify that initial table has 10 rows
      generateResultsList(tableRows, 10);
      dropdown.click();
      dropdown.findElement(By.xpath("//option[. = '25']")).click();
      // Get a new list of the table rows
      List<WebElement> table25Rows = tableBody.findElements(By.tagName("tr"));
      generateResultsList(table25Rows, 25);

      dropdown.click();
      dropdown.findElement(By.xpath("//option[. = '50']")).click();
      List<WebElement> table50Rows = tableBody.findElements(By.tagName("tr"));
      // assert that the whole table is visible when there are less rows than
      // the options clicked
      generateResultsList(table50Rows, table50Rows.size());

      dropdown.click();
      dropdown.findElement(By.xpath("//option[. = '100']")).click();
      List<WebElement> table100Rows = tableBody.findElements(By.tagName("tr"));
      generateResultsList(table100Rows, table100Rows.size());
    }
    @Test
    public void tableSortTest() {
      // TODO - assert that the top of the sorted table has x value each time the table is sorted
      driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
      driver.findElement(By.cssSelector(".sorting_asc")).click();
      driver.findElement(By.cssSelector(".sorting_desc")).click();
      driver.findElement(By.cssSelector(".sorting:nth-child(2)")).click();
      driver.findElement(By.cssSelector(".sorting_asc")).click();
      driver.findElement(By.cssSelector(".sorting:nth-child(3)")).click();
      driver.findElement(By.cssSelector(".sorting_asc")).click();
      driver.findElement(By.cssSelector(".sorting:nth-child(4)")).click();
      driver.findElement(By.cssSelector(".sorting_asc")).click();
      driver.findElement(By.cssSelector(".sorting:nth-child(5)")).click();
      driver.findElement(By.cssSelector(".sorting_asc")).click();
      driver.findElement(By.cssSelector(".sorting:nth-child(6)")).click();
      driver.findElement(By.cssSelector(".sorting_asc")).click();
    }
    @Test
    public void tableSearchTest() {
      driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
      WebElement dropdown = driver.findElement(By.name("example_length"));
      WebElement table = driver.findElement(By.id("example"));
      WebElement tableBody = table.findElement(By.tagName("tbody"));
      
      dropdown.click();
      dropdown.findElement(By.xpath("//option[. = '100']")).click();
      
      filterTableCSS("input", "cox");
      List<WebElement> nameFilterResults = tableBody.findElements(By.tagName("tr"));
      generateResultsList(nameFilterResults, 1);

      filterTableCSS("input", "accountant");
      List<WebElement> posFilterResults = tableBody.findElements(By.tagName("tr"));
      generateResultsList(posFilterResults, 1);

      filterTableCSS("input", "dev");
      List<WebElement> posFilterResults2 = tableBody.findElements(By.tagName("tr"));
      generateResultsList(posFilterResults2, 1);

      filterTableCSS("input", "30");
      List<WebElement> ageFilterResults1 = tableBody.findElements(By.tagName("tr"));
      generateResultsList(ageFilterResults1, 1);

      filterTableCSS("input", "08");
      List<WebElement> sdateFilterResults = tableBody.findElements(By.tagName("tr"));
      generateResultsList(sdateFilterResults, 1);

      filterTableCSS("input", "85,");
      List<WebElement> salaryFilterResults = tableBody.findElements(By.tagName("tr"));
      generateResultsList(salaryFilterResults, 1);

      filterTableCSS("input", "wasd");
      List<WebElement> nonsenseFilterResults = tableBody.findElements(By.tagName("tr"));
      generateResultsList(nonsenseFilterResults, 1);
      WebElement noResult = nonsenseFilterResults.get(0);
      assertTrue("Are you sure there aren't results?", noResult.getText().equals("No matching records found"));
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
      System.out.println("Rows: " + tableResults.size());
      System.out.println("\n");
      assert tableResults.size() >= comparator;
      assertNotNull(tableResults.get(0));
    }
    // Gets the search field from the page and enters a search term
    // Params:
    //     String searchFieldID, the ID of the searchfield to use
    //     String searchTerm, the keys to send to the search field
    public void filterTableID(String searchFieldID, String searchTerm) {
      WebElement searchField = driver.findElement(By.id(searchFieldID));
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