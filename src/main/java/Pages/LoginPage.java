package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loggingButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String username, String password)
    {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loggingButton).click();
    }
}
