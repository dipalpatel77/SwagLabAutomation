package Tests;

import Pages.LoginPage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseTest;
import utils.PageObjectManger;
import utils.ConfigReader;
public class LoginPageTest extends BaseTest {

        PageObjectManger pageObjectManger;
        SoftAssert softAssert;

        @Test(description = "Login with standered_User from config")
        @Description("Valid login using credentials from config.properties.")
        public void testStanderedUserLogin() {
            pageObjectManger = new PageObjectManger(driver);
            softAssert = new SoftAssert();

            String username = ConfigReader.get("StanderedUserName");
            String password = ConfigReader.get("password");

            LoginPage loginPage = pageObjectManger.getLoginPage();
            loginPage.login(username, password);

            String currentUrl = driver.getCurrentUrl();
            softAssert.assertTrue(currentUrl.contains("inventory"), "User should be redirected to inventory page");

            softAssert.assertAll();

        }
    @Test(description = "Login with LockedOutUser from config")
    @Description("Locked out user using credentials from config.properties.")
    public void lockedOutUserLoginTest() {
        pageObjectManger = new PageObjectManger(driver);
        softAssert = new SoftAssert();

        String username = ConfigReader.get("LockedOutUser");
        String password = ConfigReader.get("password");

        LoginPage loginPage = pageObjectManger.getLoginPage();
        loginPage.login(username, password);

        String currentUrl = driver.getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("inventory"), "User should be redirected to inventory page");

        softAssert.assertAll();

    }
    @Test(description = "Login with LockedOutUser from config")
    @Description("Locked out user using credentials from config.properties.")
    public void problemUser() {
        pageObjectManger = new PageObjectManger(driver);
        softAssert = new SoftAssert();

        String username = ConfigReader.get("problemUser");
        String password = ConfigReader.get("password");

        LoginPage loginPage = pageObjectManger.getLoginPage();
        loginPage.login(username, password);

        String currentUrl = driver.getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("inventory"), "User should be redirected to inventory page");

        softAssert.assertAll();

    }

}
