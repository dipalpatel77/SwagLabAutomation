package Tests;

import Pages.LoginPage;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseTest;
import utils.ConfigReader;
import utils.PageObjectManger;

public class HamburgerPartTest extends BaseTest {
    PageObjectManger pageObjectManger;
    SoftAssert softAssert;
    WebDriverWait wait;

    @Test(description = "Verify hamburger elements after login")
    @Description("Verify Hamburger elements after login")
    public void testHamburger(){

        pageObjectManger = new PageObjectManger(driver);
        softAssert = new SoftAssert();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
        String username = ConfigReader.get("StanderedUserName");
        String password = ConfigReader.get("password");

        LoginPage loginPage = pageObjectManger.getLoginPage();
        loginPage.login(username, password);
        driver.findElement(By.xpath("//button[text()='Open Menu']")).click();



        WebElement inventoryLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_sidebar_link")));
        softAssert.assertTrue(inventoryLink.isDisplayed(), "Inventory link should be displayed");

        WebElement aboutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("about_sidebar_link")));
        softAssert.assertTrue(aboutLink.isDisplayed(), "About link should be displayed");

        WebElement logoutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        softAssert.assertTrue(logoutLink.isDisplayed(), "Logout link should be displayed");

        WebElement resetLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reset_sidebar_link")));
        softAssert.assertTrue(resetLink.isDisplayed(), "Reset link should be displayed");
        softAssert.assertAll();

    }
}
