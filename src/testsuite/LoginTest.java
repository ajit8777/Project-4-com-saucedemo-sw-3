package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;
/** Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 1. LoginTest
 4. Write down the following test into ‘LoginTest’ class
 1. userSholdLoginSuccessfullyWithValid

 Credentials
 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * Verify the text “PRODUCTS”

 2. verifyThatSixProductsAreDisplayedOnPage

 * Enter “standard_user” username
 * Enter “secret_sauce” password
 * Click on ‘LOGIN’ button
 * Verify that six products are displayed on page
 */

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        sendTextOnElement(By.id("user-name"), "standard_user");
        //Enter password
        sendTextOnElement(By.id("password"), "secret_sauce");
        //Click on Login
        clickOnElement(By.id("login-button"));
        //Verify actual and expected text
        verifyTextDisplayed(By.xpath("//span[contains(text(), 'Products')]"), "Products");
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username
        sendTextOnElement(By.id("user-name"), "standard_user");
        //Enter password
        sendTextOnElement(By.id("password"), "secret_sauce");
        //Click on Login
        clickOnElement(By.id("login-button"));
        //Verify 6 Products are displayed
        verifyNumberFromElement(By.className("inventory_item"), 6);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }



public boolean verifyTextDisplayed(By by, String expectedText) {
        boolean actualText =
        (driver.findElement(by).getText()).contains(expectedText);
        // Find and get actual text on page and check whether it contains expected text or not?
        assert actualText : "Text is not found: " + expectedText;
        return true;
        }

public boolean verifyNumberFromElement(By by, int expectedNumber) {
        int actualNumber = driver.findElements(by).size();
        assert actualNumber == expectedNumber : "Expected Number of items not displayed: " + expectedNumber;
        return true;
        }
}

