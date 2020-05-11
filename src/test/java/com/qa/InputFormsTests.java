package com.qa;

// Generated by Selenium IDE
import java.util.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import static org.hamcrest.CoreMatchers.is;

public class InputFormsTests {
  private WebDriver driver;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty(
                "webdriver.chrome.driver",
                "src/test/java/resources/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    driver.manage().window().maximize();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void simpleForm() {
    // Test name: Simple Form
    driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
    driver.findElement(By.id("user-message")).click();
    driver.findElement(By.id("user-message")).sendKeys("test message");
    driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
    driver.findElement(By.id("sum1")).click();
    driver.findElement(By.id("sum1")).sendKeys("40");
    driver.findElement(By.id("sum2")).click();
    driver.findElement(By.id("sum2")).sendKeys("2");
    driver.findElement(By.cssSelector(".btn:nth-child(3)")).click();
  }
  @Test
  public void checkBox() {
    // Test name: Check Box
    driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
    driver.findElement(By.id("isAgeSelected")).click();    
    driver.findElement(By.id("isAgeSelected")).click();
    driver.findElement(By.cssSelector(".checkbox:nth-child(3) .cb1-element")).click();
    driver.findElement(By.cssSelector(".checkbox:nth-child(4) .cb1-element")).click();
    driver.findElement(By.cssSelector(".checkbox:nth-child(5) .cb1-element")).click();
    driver.findElement(By.cssSelector(".checkbox:nth-child(6) .cb1-element")).click();
    driver.findElement(By.id("check1")).click();
    driver.findElement(By.id("check1")).click();
    driver.findElement(By.id("check1")).click();
  }
  @Test
  public void radioButtons() {
    // Test name: Radio Buttons
    driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
    driver.findElement(By.name("optradio")).click();
    driver.findElement(By.id("buttoncheck")).click();
    driver.findElement(By.cssSelector(".panel-body > .radio-inline:nth-child(3) > input")).click();
    driver.findElement(By.id("buttoncheck")).click();
    driver.findElement(By.name("gender")).click();
    driver.findElement(By.name("ageGroup")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".btn:nth-child(5)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    // 10 | mouseOut | css=.btn:nth-child(5) |  | 
    { // click out of the element
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.cssSelector("div:nth-child(3) > .radio-inline:nth-child(3) > input")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
    driver.findElement(By.cssSelector(".radio-inline:nth-child(4) > input")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
    driver.findElement(By.cssSelector(".panel-body > div:nth-child(2) > .radio-inline:nth-child(3) > input")).click();
    driver.findElement(By.name("ageGroup")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
    driver.findElement(By.cssSelector("div:nth-child(3) > .radio-inline:nth-child(3) > input")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
    driver.findElement(By.cssSelector(".radio-inline:nth-child(4) > input")).click();
    driver.findElement(By.cssSelector(".btn:nth-child(5)")).click();
  }
  @Test
  public void selectDropdown() {
    // Test name: Select Dropdown
    /*
    This is kind of ridiculous coming from the Selenium IDE.
    Using a for each loop is much better.
    ----------------------------------------------------------------------
    /*
    driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
    driver.findElement(By.id("select-demo")).click();
    {
      WebElement dropdown = driver.findElement(By.id("select-demo"));
      dropdown.findElement(By.xpath("//option[. = 'Sunday']")).click();
    }
    driver.findElement(By.id("select-demo")).click();
    driver.findElement(By.id("select-demo")).click();
    {
      WebElement dropdown = driver.findElement(By.id("select-demo"));
      dropdown.findElement(By.xpath("//option[. = 'Monday']")).click();
    }
    driver.findElement(By.id("select-demo")).click();
    driver.findElement(By.id("select-demo")).click();
    {
      WebElement dropdown = driver.findElement(By.id("select-demo"));
      dropdown.findElement(By.xpath("//option[. = 'Tuesday']")).click();
    }
    driver.findElement(By.id("select-demo")).click();
    driver.findElement(By.id("select-demo")).click();
    {
      WebElement dropdown = driver.findElement(By.id("select-demo"));
      dropdown.findElement(By.xpath("//option[. = 'Wednesday']")).click();
    }
    driver.findElement(By.id("select-demo")).click();
    driver.findElement(By.id("select-demo")).click();
    {
      WebElement dropdown = driver.findElement(By.id("select-demo"));
      dropdown.findElement(By.xpath("//option[. = 'Thursday']")).click();
    }
    driver.findElement(By.id("select-demo")).click();
    driver.findElement(By.id("select-demo")).click();
    {
      WebElement dropdown = driver.findElement(By.id("select-demo"));
      dropdown.findElement(By.xpath("//option[. = 'Friday']")).click();
    }
    driver.findElement(By.id("select-demo")).click();
    driver.findElement(By.id("select-demo")).click();
    {
      WebElement dropdown = driver.findElement(By.id("select-demo"));
      dropdown.findElement(By.xpath("//option[. = 'Saturday']")).click();
    }
    driver.findElement(By.id("select-demo")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'California']")).click();
    }
    driver.findElement(By.id("printMe")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Florida']")).click();
    }
    driver.findElement(By.id("printAll")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'New Jersey']")).click();
    }
    driver.findElement(By.id("printAll")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
    }
    driver.findElement(By.id("printAll")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Ohio']")).click();
    }
    driver.findElement(By.id("printAll")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Texas']")).click();
    }
    driver.findElement(By.id("printAll")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Pennsylvania']")).click();
    }
    driver.findElement(By.id("printAll")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Washington']")).click();
    }
    driver.findElement(By.id("printAll")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'California']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'New Jersey']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Ohio']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Texas']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Pennsylvania']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Washington']")).click();
    }
    driver.findElement(By.id("printMe")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Florida']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'New Jersey']")).click();
    }
    driver.findElement(By.id("printMe")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'New Jersey']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
    }
    driver.findElement(By.id("printMe")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Ohio']")).click();
    }
    driver.findElement(By.id("printMe")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Ohio']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Texas']")).click();
    }
    driver.findElement(By.id("printMe")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Texas']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Pennsylvania']")).click();
    }
    driver.findElement(By.id("printMe")).click();
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Pennsylvania']")).click();
    }
    {
      WebElement dropdown = driver.findElement(By.id("multi-select"));
      dropdown.findElement(By.xpath("//option[. = 'Washington']")).click();
    }
    driver.findElement(By.id("printMe")).click();
    */
    driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        WebElement dropDown = driver.findElement(By.id("select-demo"));
        Select select = new Select(dropDown);
        List<WebElement> dropDownOptions = select.getOptions();

        for (WebElement option : dropDownOptions) {
            dropDown.click();
            option.click();
        }
  }
  @Test
  public void inputFormSubmit() {
    // Test name: Input Form Submit
    driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
    driver.findElement(By.name("first_name")).click();
    driver.findElement(By.name("first_name")).sendKeys("martin");
    driver.findElement(By.name("last_name")).sendKeys("tomlinson");
    driver.findElement(By.name("email")).sendKeys("someemail@email.com");
    driver.findElement(By.name("phone")).sendKeys("5552666");
    driver.findElement(By.name("address")).sendKeys("some place");
    driver.findElement(By.name("city")).sendKeys("some city");
    driver.findElement(By.name("state")).click();
    {
      WebElement dropdown = driver.findElement(By.name("state"));
      dropdown.findElement(By.xpath("//option[. = 'Missouri']")).click();
    }
    driver.findElement(By.name("state")).click();
    driver.findElement(By.name("zip")).click();
    driver.findElement(By.name("zip")).sendKeys("my6 2hy");
    driver.findElement(By.name("website")).click();
    driver.findElement(By.name("website")).sendKeys("somewebsite.com");
    driver.findElement(By.name("hosting")).click();
    driver.findElement(By.name("comment")).click();
    driver.findElement(By.name("comment")).sendKeys("product description");
    driver.findElement(By.cssSelector(".btn")).click();
  }
  @Test
  public void ajaxFormSubmit() {
    // Test name: Ajax Form Submit
    driver.get("https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
    driver.findElement(By.id("title")).click();
    driver.findElement(By.id("title")).sendKeys("Martin");
    driver.findElement(By.id("description")).sendKeys("Some sweet comment.");
    driver.findElement(By.id("btn-submit")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 30);
      wait.until(ExpectedConditions.textToBe(By.id("submit-control"), "Form submited Successfully!"));
    }
  }
  @Test
  public void jQuerySelectDropdown() {
    // Test name: JQuery Select Dropdown
    driver.get("https://www.seleniumeasy.com/test/jquery-dropdown-search-demo.html");    

    WebElement countryDropdown = driver.findElement(By.cssSelector(
      "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > div.panel-body > span > span.selection > span"));
    countryDropdown.click();

    WebElement searchBox = driver.findElement(By.cssSelector(
      "body > span > span > span.select2-search.select2-search--dropdown > input"));

    searchBox.sendKeys("Denmark");
    assertThat(driver.findElement(By.cssSelector("#select2-country-results > li")).getText(), is("Denmark"));
    // append some text to make the search invalid
    searchBox.sendKeys("Invalid search term");
    assertThat(driver.findElement(By.cssSelector("#select2-country-results > li")).getText(), is("No results found"));
    
    // Automate Select Multiple Values
    WebElement stateSearchBox = driver.findElement(By.cssSelector(
      "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div.panel-body > span > span.selection > span"));
    stateSearchBox.click();

    // List <WebElement> statesList = driver.findElements(By.className("select2-results__option"));
    // // Allows you to get a dynamic element, such as ID, after pageload
    // for (WebElement state : statesList) {
    //   String stateID = state.getAttribute("id");
    //   System.out.println(stateID);
    // }

    // Using full XPath as a last resort
    driver.findElement(By.xpath("/html/body/span/span/span/ul/li[5]")).click();
    stateSearchBox.click();
    driver.findElement(By.xpath("/html/body/span/span/span/ul/li[16]")).click();
    stateSearchBox.click();
    driver.findElement(By.xpath("/html/body/span/span/span/ul/li[26]")).click();
    

    // TODO - Automate Drop Down with Disabled Values

    driver.findElement(By.id("files")).click();
    {
      WebElement dropdown = driver.findElement(By.id("files"));
      dropdown.findElement(By.xpath("//option[. = 'PHP']")).click();
    }
    driver.findElement(By.id("files")).click();
    driver.findElement(By.id("files")).click();
    {
      WebElement dropdown = driver.findElement(By.id("files"));
      dropdown.findElement(By.xpath("//option[. = 'C']")).click();
    }
    driver.findElement(By.id("files")).click();
    driver.findElement(By.id("files")).click();
    {
      WebElement dropdown = driver.findElement(By.id("files"));
      dropdown.findElement(By.xpath("//option[. = 'Unknown Script']")).click();
    }
    driver.findElement(By.id("files")).click();
  }
}
