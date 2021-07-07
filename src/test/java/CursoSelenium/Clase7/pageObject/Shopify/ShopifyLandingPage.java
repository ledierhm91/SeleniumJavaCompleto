package CursoSelenium.Clase7.pageObject.Shopify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import CursoSelenium.Clase7.pageObject.BaseUITest;

public class ShopifyLandingPage extends BaseUITest {

    public ShopifyLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public ShopifyPricingPage clickOnPricingButton(){
        driver.findElement(By.xpath("//*[@href='/pricing']")).click();
        ShopifyPricingPage nextPage = new ShopifyPricingPage(driver);
        return nextPage;
    }

    public ShopifyLoginPage navigateToLoginBtn(){
        driver.findElement(By.linkText("Log in")).click();
        //driver.navigate().to("https://accounts.shopify.com/store-login");
        ShopifyLoginPage nextPage = new ShopifyLoginPage(driver);
        return nextPage;
    }


}


