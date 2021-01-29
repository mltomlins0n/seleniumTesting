package com.qa;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.hamcrest.MatcherAssert.assertThat;

public class AlertsandModals {
    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", 
                           "src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        js = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    // Alert Tests
    @Test
    public void bootstrapAlerts() {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");

        WebElement buttonContainer = driver.findElement(By.className("col-md-4"));
        List<WebElement> buttons = buttonContainer.findElements(By.tagName("button"));

        WebElement alertContainer = driver.findElement(By.cssSelector(
                "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div > div.col-md-6"));
        List<WebElement> alerts = alertContainer.findElements(By.tagName("div"));

        for (WebElement button : buttons) {
            button.click();
        }
        // Loop through alerts and if they aren't autoclose ones, click the close button
        for (WebElement alert : alerts) {
            // Select only the alerts that don't auto close
            if (alert.getAttribute("hidden") != null) {
                WebElement closeButton = alert.findElement(By.tagName("button"));
                wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
            }
            wait.until(ExpectedConditions.invisibilityOf(alert));
            assertFalse("The alerts should be gone", alert.isDisplayed());
        }
    }

    // Modal Tests
    @Test
    public void bootstrapModals() {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html");

        // Modal 1
        WebElement launchButton = driver.findElement(By.cssSelector(
                "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > div > div.panel-body > a"));
        WebElement modal = driver.findElement(By.cssSelector("#myModal0 > div > div > div.modal-footer"));
        for (int i = 0; i < 3; i++) {
            launchButton.click();
            wait.until(ExpectedConditions.visibilityOf(modal));
            switch (i) {
                case 0:
                    // Click the top right close icon
                    driver.findElement(By.className("close")).click();
                    break;
                case 1:
                    // Click the close button
                    WebElement closeButton = driver.findElement(By.className("btn"));
                    // Using js executor to get around "Element Click Intercepted" exception
                    js.executeScript("arguments[0].click()", closeButton);
                    break;
                case 2:
                    // Click the "Save Changes" button
                    WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"myModal0\"]/div/div/div[4]/a[2]"));
                    js.executeScript("arguments[0].click()", saveButton);
                    break;
            }
        }
        WebElement launchButton2 = driver.findElement(By.cssSelector(
                "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div > div.panel-body > a"));
        WebElement modal2 = driver.findElement(By.cssSelector("#myModal > div > div > div.modal-footer"));
        // Modal 2
        for (int i = 0; i < 3; i++) {
            launchButton2.click();
            wait.until(ExpectedConditions.visibilityOf(modal2));
            switch (i) {
                case 0:
                    // Click the top right close icon
                    driver.findElement(By.cssSelector("#myModal > div > div > div.modal-header > button")).click();
                    break;
                case 1:
                    // Click the close button
                    WebElement closeButton2 = driver
                            .findElement(By.cssSelector("#myModal > div > div > div.modal-footer > a:nth-child(1)"));
                    // Using js executor to get around "Element Click Intercepted" exception
                    js.executeScript("arguments[0].click()", closeButton2);
                    break;
                case 2:
                    // Click the "Save Changes" button
                    WebElement saveButton2 = driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[4]/a[2]"));
                    js.executeScript("arguments[0].click()", saveButton2);
                    break;
            }
        }
    }

    @Test
    public void innerBootstrapModal() {
        // This code should be in the bootstrapModals() function, but is here to get
        // around
        // the stale element exception caused by it being in there
        driver.get("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html");

        WebElement launchButton2 = driver.findElement(By.cssSelector(
                "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div > div.panel-body > a"));
        WebElement modal2 = driver.findElement(By.cssSelector("#myModal > div > div > div.modal-footer"));
        WebElement modal3 = driver.findElement(By.cssSelector("#myModal2 > div > div > div.modal-body"));
        WebElement launchButton3 = driver.findElement(By.cssSelector("#myModal > div > div > div.modal-body > a"));

        launchButton2.click();
        wait.until(ExpectedConditions.visibilityOf(modal2));
        // Modal 3
        for (int i = 0; i < 3; i++) {
            launchButton3.click();
            wait.until(ExpectedConditions.visibilityOf(modal3));
            switch (i) {
                case 0:
                    // close icon
                    wait.until(ExpectedConditions
                            .elementToBeClickable(By.cssSelector("#myModal2 > div > div > div.modal-header > button")));
                    driver.findElement(By.cssSelector("#myModal2 > div > div > div.modal-header > button")).click();
                    break;
                case 1:
                    // close button
                    WebElement closeButton = driver
                            .findElement(By.cssSelector("#myModal2 > div > div > div.modal-footer > a:nth-child(1)"));
                    js.executeScript("arguments[0].click()", closeButton);
                    break;
                case 2:
                    // Save changes
                    WebElement saveButton = driver.findElement(
                            By.cssSelector("#myModal2 > div > div > div.modal-footer > a.btn.btn-primary"));
                    js.executeScript("arguments[0].click()", saveButton);
                    break;
            }
        }
    }

    // Popup Modal Tests
    @Test
    public void windowPopupModals() {
        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

        String parentWindow = driver.getWindowHandle();
        // Twitter button
        driver.findElement(By.cssSelector(
                "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > div.panel-body > div:nth-child(1) > a"))
                .click();
        verifyChildWindow(parentWindow, 2);
        // Facebook button
        driver.findElement(By.cssSelector(
                "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(2) > div > div.panel-body > div:nth-child(2) > a"))
                .click();
        verifyChildWindow(parentWindow, 2);
        // Twitter & facebook button
        driver.findElement(By.cssSelector(
                "body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) > div > div.panel-body > div.two-windows > a"))
                .click();
        verifyChildWindow(parentWindow, 3);
        // Twitter, Facebook, and Google+ (lmao) button
        driver.findElement(By.cssSelector("#followall")).click();
        verifyChildWindow(parentWindow, 4);
    }

    // Progress Bar Modals
    @Test
    public void progressModals() {
        driver.get("https://www.seleniumeasy.com/test/bootstrap-progress-bar-dialog-demo.html");

        WebElement buttonContainer = driver
                .findElement(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left"));
        List<WebElement> buttons = buttonContainer.findElements(By.tagName("button"));

        for (WebElement button : buttons) {
            try {
                button.click();
                wait.until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert();
            }
            catch (Exception e) {
                
            }
        }   
    }

    // JavaScript Alerts
    @Test
    public void javascriptAlerts() {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");

        // JavaScript alert box
        WebElement alertButton = driver.findElement(By.cssSelector(
            "#easycont > div > div.col-md-6.text-left > div:nth-child(4) > div.panel-body > button"));
        alertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        // JavaScript confirm box
        WebElement confirmText = driver.findElement(By.id("confirm-demo"));
        WebElement confirmButton = driver.findElement(By.cssSelector(
            "#easycont > div > div.col-md-6.text-left > div:nth-child(5) > div.panel-body > button"));
        confirmButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        assert(confirmText.getText().equalsIgnoreCase("You pressed OK!"));
        confirmButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
        assert(confirmText.getText().equalsIgnoreCase("You pressed Cancel!"));

        // JavaScript alert box
        WebElement promptButton = driver.findElement(By.cssSelector(
            "#easycont > div > div.col-md-6.text-left > div:nth-child(6) > div.panel-body > button"));
        promptButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys("Arthur Dent");
        driver.switchTo().alert().accept();
        String promptText = driver.findElement(By.id("prompt-demo")).getText();
        // Text to match against is hard coded as there is no way to store
        // the input text from an alert apparently
        assert(promptText.equalsIgnoreCase("You have entered 'Arthur Dent' !"));
    }

    @Test
    public void fileDownload() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/generate-file-to-download-demo.html");

        WebElement textBox = driver.findElement(By.id("textbox"));
        textBox.click();
        textBox.sendKeys("... No, don’t move,’ he added as Arthur began to uncurl himself, " +
                            "‘you’d better be prepared for the jump into hyperspace. It’s unpleasantly like being drunk.’ " +
                            "‘What’s so unpleasant about being drunk?’ " +
                            "‘You ask a glass of water.’ " +
                            "Arthur thought about this. " +
                            "‘Ford,’ he said. " +
                            "‘Yeah?’ " +
                            "‘What’s this fish doing in my ear?’ ");

        ReentrantLock lock = new ReentrantLock();
        // Using a lock here for a wait(), and for learning purposes
        try {
            lock.lock();
            textBox.wait(2000);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        WebElement generateFileButton = driver.findElement(By.id("create"));
        generateFileButton.click();
        // TODO - handle file download and read

    }

    // Switches to the child window, verifies the url
    // then closes and switches back to the parent window
    // Params: String parentWindow
    // The window that opened the child window
    // int numWindows
    // The number of total windows open (parent + child)
    public void verifyChildWindow(String parentWindow, int numWindows) {
        // wait until pageload to get the correct url
        wait.until(ExpectedConditions.numberOfWindowsToBe(numWindows));
        System.out.println("Number of windows open: " + numWindows);
        for (String childWindow : driver.getWindowHandles()) {
            if (!(parentWindow.equals(childWindow))) {
                driver.switchTo().window(childWindow);
                String childUrl = driver.getCurrentUrl();
                System.out.println(childUrl);
                assertThat("Do the URLs match?", driver.getCurrentUrl().equals(childUrl));
                driver.close(); // close child window
            }
        }
        driver.switchTo().window(parentWindow);
    }
}