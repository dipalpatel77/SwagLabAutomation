package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Products {
    WebDriver driver;
    public Products(WebDriver driver){
        this.driver = driver;
    }


    public WebElement getCartIcon(){
            return driver.findElement(By.className("shopping_cart_link"));
    }
    public WebElement getHamburgerIcon() {
        return driver.findElement(By.className("bm-burger-button"));
    }
//    bm-burger-button
    public List<WebElement> getProductList(){
        return driver.findElements(By.className("inventory_item"));
    }

    public WebElement getProductName(WebElement product){
        return product.findElement(By.className("inventory_item_name"));
    }

    public WebElement getProductPrice(WebElement product){
        return product.findElement(By.className("inventory_item_price"));
    }

    public WebElement getAddToCartButton(WebElement product){
        return product.findElement(By.xpath("//button[contains(@class,'btn_inventory')]"));
    }

}

