package utils;

import Pages.LoginPage;
import Pages.Products;
import org.openqa.selenium.WebDriver;

public class PageObjectManger {

    private WebDriver driver;
    private LoginPage loginPage;
    private Products products;
    public PageObjectManger(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage getLoginPage(){
        if (loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public Products getProductsPage(){
        if (products == null){
            products = new Products(driver);
        }
        return products;
    }

}
