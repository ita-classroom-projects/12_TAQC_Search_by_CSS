package com.softserve.edu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTest {
    private final String BASE_URL = "http://taqc-opencart.epizy.com/";
    private final Long IMPLICITLY_WAIT_SECONDS = 10L;
    private final Long ONE_SECOND_DELAY = 1000L;
    private WebDriver driver;

    private void presentationSleep() {
        presentationSleep(1);
    }

    private void presentationSleep(int seconds) {
        try {
            Thread.sleep(seconds * ONE_SECOND_DELAY); // For Presentation ONLY
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        // System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        // WebDriverManager.firefoxdriver().setup();
    }

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        presentationSleep(); // For Presentation ONLY
        // driver.close();
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(BASE_URL);
        presentationSleep(); // For Presentation ONLY
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        presentationSleep(); // For Presentation ONLY
        if (!result.isSuccess()) {
            String testName = result.getName();
            System.out.println("***TC error, name = " + testName + " ERROR");
            // Take Screenshot, Save sourceCode, Save to log, Prepare report, Return to previous state, logout, etc.
            // driver.manage().deleteAllCookies(); // clear cache; delete cookie; delete session;
        }
        //driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        //driver.findElement(By.cssSelector("#logo > a")).click();
        driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]/..")).click();
        presentationSleep(); // For Presentation ONLY
    }

    @DataProvider
    public Object[][] dataLogin() {
        return new Object[][] { { "xdknxusqvjeovowpfk@awdrt.com", "awdrt123" }, };
    }

    @Test(dataProvider = "dataLogin")
    public void loginByMixed(String emailAddress, String password) {
        //
        // Click My Account Button
        driver.findElement(By.linkText("My Account")).click();
        presentationSleep(); // For Presentation Only
        //
        // Click login Button
        driver.findElement(By.linkText("Login")).click();
        presentationSleep(); // For Presentation Only
        //
        // Type Login Email
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(emailAddress);
        presentationSleep(); // For Presentation Only
        //
        // Type Password
        // driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);
        presentationSleep(); // For Presentation Only
        //
        // Click Login Button
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        presentationSleep(); // For Presentation Only
        //
        // Goto Edit Account
        driver.findElement(By.linkText("Edit Account")).click();
        presentationSleep(); // For Presentation Only
        //
        // Read Email WebElement
        WebElement email = driver.findElement(By.id("input-email"));
        presentationSleep(); // For Presentation Only
        //
        // Check
        Assert.assertEquals(email.getAttribute("value"), emailAddress);
        //
        // Return to Previous State
        // Click My Account Button
        driver.findElement(By.linkText("My Account")).click();
        presentationSleep(); // For Presentation Only
        //
        // Click Logout Button
        driver.findElement(By.linkText("Logout")).click();
        presentationSleep(); // For Presentation Only
        //
        // Click Continue Button
        driver.findElement(By.linkText("Continue")).click();
        presentationSleep(); // For Presentation Only
        //
    }

    @Test(dataProvider = "dataLogin")
    public void loginByCssSelector(String emailAddress, String password) {
        System.out.println("emailAddress = " + emailAddress + " password = " + password);
        //
        // TODO
        //
    }

    private WebElement getProductByName(String name) {
        WebElement result = null;
        //
        // TODO
        //
        return result;
    }

    @DataProvider
    public Object[][] dataFind() {
        return new Object[][] { { "mac", "USD", "MacBook", "$602.00" }, };
    }

    @Test(dataProvider = "dataFind")
    public void findByCss(String searchName, String currencyName, String expectedName, String expectedPrice) {
        System.out.println("searchName = " + searchName 
                + " currencyName = " + currencyName
                + " expectedName = " + expectedName
                + " expectedPrice = " + expectedPrice);
        //
        // TODO
        //        
    }

}
