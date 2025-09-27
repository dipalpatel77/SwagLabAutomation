package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
       String browser = ConfigReader.get("browser");

       switch (browser){
           case "firefox":
               driver = new FirefoxDriver();
               break;
           case "edge":
               driver = new EdgeDriver();
               break;
           default:
               driver = new ChromeDriver();
       }
       driver.manage().window().maximize();
       driver.get("https://www.saucedemo.com");
    }
    @AfterMethod
    public void closeDriver(){
        if(driver != null){
            driver.quit();
        }
    }
}
