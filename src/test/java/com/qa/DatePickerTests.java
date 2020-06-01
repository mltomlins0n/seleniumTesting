package com.qa;
// Generated by Selenium IDE
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import static org.hamcrest.CoreMatchers.is;

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
  public void todayTest() {
    // Test name: Today Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector(".datepicker-days tfoot .today")).click();
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
  public void specificDateTest() {
    // Test name: Specific Date Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector("tr:nth-child(2) > .day:nth-child(3)")).click();
  }
  @Test
  public void backForthArrowsTestRange() {
    // Test name: Back/Forth Arrows Test (Range)
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    WebElement backArrow = driver.findElement(By.cssSelector(".datepicker-days .prev"));
    WebElement forwardArrow = driver.findElement(By.cssSelector(".datepicker-days .next"));
    for (int i = 0; i < 6; i++) {
      backArrow.click();
      forwardArrow.click();
    }
    driver.findElement(By.cssSelector("tr:nth-child(1) > .day:nth-child(6)")).click();
  }
  @Test
  public void clearButtonTest() {
    // Test name: Clear Button Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector(".datepicker-days tfoot .today")).click();
    driver.findElement(By.cssSelector(".date > .form-control")).click();
    driver.findElement(By.cssSelector(".datepicker-days .clear")).click();
    // Verify that field is empty
    assertThat(driver.findElement(By.cssSelector("#sandbox-container1 > div > input")).getText(), is (""));
  }

  // Date Range Picker Tests
  @Test
  public void oneDayRangeTest() {
    // Test name: One Day Range Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector("#datepicker > .form-control:nth-child(1)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(4) > .day:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".row:nth-child(3) .panel-body")).click();
    // Check the value of the field
    assertThat(driver.findElement(By.cssSelector("#datepicker > input:nth-child(3)"))
    .getAttribute("value"), is ("20/05/2020"));
  }
  @Test
  public void oneWeekRangeTest() {
    // Test name: One Week Range Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector("#datepicker > .form-control:nth-child(1)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(2) > .day:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".form-control:nth-child(3)")).click();
    driver.findElement(By.cssSelector("tr:nth-child(3) > .day:nth-child(4)")).click();
    // Check that each field has the correct values
    assertThat(driver.findElement(By.cssSelector("#datepicker > input:nth-child(1)"))
    .getAttribute("value"), is ("06/05/2020"));

    assertThat(driver.findElement(By.cssSelector("#datepicker > input:nth-child(3)"))
    .getAttribute("value"), is ("13/05/2020"));
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
    // Check that each field has the correct value
    assertThat(driver.findElement(By.cssSelector("#datepicker > input:nth-child(1)"))
    .getAttribute("value"), is ("01/04/2020"));

    assertThat(driver.findElement(By.cssSelector("#datepicker > input:nth-child(3)"))
    .getAttribute("value"), is ("01/05/2020"));
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
    // Check that each field has the correct values
    assertThat(driver.findElement(By.cssSelector("#datepicker > input:nth-child(1)"))
    .getAttribute("value"), is ("01/01/2019"));

    assertThat(driver.findElement(By.cssSelector("#datepicker > input:nth-child(3)"))
    .getAttribute("value"), is ("01/01/2020"));
  }
  @Test
  public void backForthArrowsTest() {
    // Test name: Back/Forth Arrows Test
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.cssSelector("#datepicker > .form-control:nth-child(1)")).click();
    WebElement backArrow = driver.findElement(By.cssSelector(".datepicker-days .prev"));
    WebElement forwardArrow = driver.findElement(By.cssSelector(".datepicker-days .next"));
    
    for (int i = 0; i < 5; i++) {
      backArrow.click();
    }

    forwardArrow.click();
    driver.findElement(By.cssSelector("tr:nth-child(2) > .day:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".form-control:nth-child(3)")).click();
    WebElement forwardArrow2 = driver.findElement(By.cssSelector(".datepicker-days .next"));

    for (int i = 0; i < 5; i++) {
      forwardArrow2.click();
    }

    driver.findElement(By.cssSelector(".datepicker-days .prev")).click();
    driver.findElement(By.cssSelector("tr:nth-child(2) > .day:nth-child(2)")).click();
  }

  // JQuery Date Picker Tests
  @Test
  public void oneWeekRange() {
    driver.get("https://www.seleniumeasy.com/test/jquery-date-picker-demo.html");
    driver.findElement(By.id("from")).click();
    WebElement prev = driver.findElement(By.cssSelector(".ui-icon-circle-triangle-w"));
    prev.click();
    driver.findElement(By.linkText("1")).click();
    driver.findElement(By.id("to")).click();
    driver.findElement(By.linkText("8")).click();
  }
  @Test
  public void backForthArrows() {
    driver.get("https://www.seleniumeasy.com/test/jquery-date-picker-demo.html");
    driver.findElement(By.id("from")).click();
    WebElement prev = driver.findElement(By.cssSelector(".ui-icon-circle-triangle-w"));
    prev.click();
    driver.findElement(By.linkText("1")).click();
    driver.findElement(By.id("to")).click();
    WebElement next = driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e"));
    next.click();
    driver.findElement(By.linkText("1")).click();
  }
  @Test
  public void oneYearRange() {
    driver.get("https://www.seleniumeasy.com/test/jquery-date-picker-demo.html");
    driver.findElement(By.id("from")).click();

    for (int i = 0; i < 5; i++) {
      WebElement prev = driver.findElement(By.cssSelector(".ui-icon-circle-triangle-w"));
      prev.click();
    }
    driver.findElement(By.linkText("1")).click();
    driver.findElement(By.id("to")).click();

    for (int i = 0; i < 5; i++) {
      WebElement next = driver.findElement(By.cssSelector(".ui-icon-circle-triangle-e"));
      next.click();
    }
    driver.findElement(By.linkText("1")).click();
  }
  @Test
  public void Days() {
    driver.get("https://www.seleniumeasy.com/test/jquery-date-picker-demo.html");
    driver.findElement(By.id("from")).click();

    WebElement daysTable = driver.findElement(By.tagName("tbody"));
    List <WebElement> daysList = daysTable.findElements(By.tagName("td"));

    int dayIndex = 0;
    for (WebElement day : daysList) {
      // Filter out diabled values
      if (!(day.getAttribute("innerHTML").equals("&nbsp;"))) {
        String dayText = day.getTagName();
        dayIndex += 1;
        System.out.println(dayText + " " + dayIndex);
        //day.click();
        //driver.findElement(By.id("from")).click();
      }
    }
  }
}