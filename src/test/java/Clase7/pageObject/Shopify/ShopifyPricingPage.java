package Clase7.pageObject.Shopify;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Clase7.pageObject.BaseUITest;

import java.util.List;

public class ShopifyPricingPage extends BaseUITest {

    public ShopifyPricingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public List<WebElement> getH1s(){
        return driver.findElements(By.tagName("h1"));
    }


}
