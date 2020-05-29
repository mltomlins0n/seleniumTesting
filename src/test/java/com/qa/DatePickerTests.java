package com.qa;
// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

public class DatePickerTests {
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

  // Date Picker Tests
  @Test
  public void specificDateTest() {
    // Test name: Specific Date Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector("tr:nth-child(2) > .day:nth-child(3)")).click();
  }
  @Test
  public void monthPickerTest() {
    // Test name: Month Picker Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).click();
    driver.findElement(By.cssSelector(".month:nth-child(1)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(1) > .day:nth-child(3)")).click();
  }
  @Test
  public void yearPickerTest() {
    // Test name: Year Picker Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).click();
    driver.findElement(By.cssSelector(".datepicker-months .datepicker-switch")).click();
    driver.findElement(By.cssSelector(".datepicker-years .prev")).click();
    driver.findElement(By.cssSelector(".year:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".month:nth-child(10)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(4) > .day:nth-child(3)")).click();
  }
  @Test
  public void backForthArrowsTestRange() {
    // Test name: Back/Forth Arrows Test (Range)
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector(".datepicker-days .prev")).click();
    driver.findElement(By.cssSelector(".datepicker-days .prev")).click();
    driver.findElement(By.cssSelector(".datepicker-days .prev")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".datepicker-days .prev"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector(".datepicker-days .prev")).click();
    driver.findElement(By.cssSelector(".datepicker-days .next")).click();
    driver.findElement(By.cssSelector("tr:nth-child(1) > .day:nth-child(6)")).click();
  }
  @Test
  public void todayTest() {
    // Test name: Today Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector(".datepicker-days tfoot .today")).click();
  }
  @Test
  public void clearButtonTest() {
    // Test name: Clear Button Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector(".datepicker-days tfoot .today")).click();
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector(".datepicker-days .clear")).click();
  }

  // Date Range Picker Tests
  @Test
  public void backForthArrowsTest() {
    // Test name: Back/Forth Arrows Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector("#datepicker > .form-control:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".datepicker-days .prev")).click();
    driver.findElement(By.cssSelector(".datepicker-days .prev")).click();
    {
    WebElement element = driver.findElement(By.cssSelector(".datepicker-days .prev"));
    Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector(".datepicker-days .prev")).click();
    driver.findElement(By.cssSelector(".datepicker-days .next")).click();
    driver.findElement(By.cssSelector("tr:nth-child(2) > .day:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".form-control:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".datepicker-days .next")).click();
    driver.findElement(By.cssSelector(".datepicker-days .next")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".datepicker-days .next"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.cssSelector(".datepicker-days .next")).click();
    driver.findElement(By.cssSelector(".datepicker-days .prev")).click();
    driver.findElement(By.cssSelector("tr:nth-child(2) > .day:nth-child(2)")).click();
  }
  @Test
  public void oneDayRangeTest() {
    // Test name: One Day Range Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector("#datepicker > .form-control:nth-child(1)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(4) > .day:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".row:nth-child(3) .panel-body")).click();
  }
  @Test
  public void oneMonthRangeTest() {
    // Test name: One Month Range Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector("#datepicker > .form-control:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).click();
    driver.findElement(By.cssSelector(".month:nth-child(4)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(1) > .day:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".form-control:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).click();
    driver.findElement(By.cssSelector(".month:nth-child(5)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(1) > .day:nth-child(6)")).click();
  }
  @Test
  public void oneWeekRangeTest() {
    // Test name: One Week Range Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector("#datepicker > .form-control:nth-child(1)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(2) > .day:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".form-control:nth-child(3)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(3) > .day:nth-child(4)")).click();
  }
  @Test
  public void oneYearRangeTest() {
    // Test name: One Year Range Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector("#datepicker > .form-control:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).click();
    driver.findElement(By.cssSelector(".datepicker-months .datepicker-switch")).click();
    driver.findElement(By.cssSelector(".year:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".month:nth-child(1)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(1) > .day:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".form-control:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).click();
    driver.findElement(By.cssSelector(".datepicker-months .datepicker-switch")).click();
    driver.findElement(By.cssSelector(".year:nth-child(12)")).click();
    driver.findElement(By.cssSelector(".month:nth-child(1)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(1) > .day:nth-child(4)")).click();
  }
}
