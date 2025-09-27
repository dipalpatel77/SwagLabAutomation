package Tests;

import Pages.LoginPage;
import Pages.Products;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BaseTest;
import utils.ConfigReader;
import utils.PageObjectManger;

import java.util.List;

public class ProductsTest extends BaseTest {
    PageObjectManger pageObjectManger;
    SoftAssert softAssert;

    @Test(description = "Verify header and inventory elements after login")
    @Description("Verify header and inventory elements after login")
    public void testHeasderAndInventoryElements(){
        pageObjectManger = new PageObjectManger(driver);
        softAssert = new SoftAssert();

        String username = ConfigReader.get("StanderedUserName");
        String password = ConfigReader.get("password");

        LoginPage loginPage = pageObjectManger.getLoginPage();
        loginPage.login(username, password);

        Products products = pageObjectManger.getProductsPage();

        WebElement cartIcon = products.getCartIcon();
        softAssert.assertTrue(cartIcon.isDisplayed(),"Shopping cart icon should be visible");

        WebElement hamburgerIcon = products.getHamburgerIcon();
        softAssert.assertTrue(hamburgerIcon.isDisplayed(),"Hamburger icon should be visible");

        List<WebElement> productList = products.getProductList();
        softAssert.assertTrue(productList.size() > 0 , "Product list should be visible and contain items.");

        for(WebElement eachItem : productList){
            softAssert.assertTrue(products.getProductName(eachItem).isDisplayed(), "Product Name should be visible.");
            softAssert.assertTrue(products.getProductPrice(eachItem).isDisplayed(),"Product price should be visisble");
            softAssert.assertTrue(products.getAddToCartButton(eachItem).isDisplayed(),"Add to cart button should be visible");
        }
        softAssert.assertAll();

    }
}
