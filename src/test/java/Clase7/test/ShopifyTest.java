package Clase7.test;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import Clase7.pageObject.Shopify.ShopifyLandingPage;
import Clase7.pageObject.Shopify.ShopifyLoginPage;
import Clase7.pageObject.Shopify.ShopifyPricingPage;

import java.util.List;

public class ShopifyTest extends BaseTest {

    @BeforeClass   //BeforeMethod  pudiera ser también.
    public void setupShopifyTest(){
        driver.get("https://www.shopify.com");
    }

    @Test(priority = 0)
    public void pricingTest() {
        ShopifyLandingPage shopifyLandingPage = new ShopifyLandingPage(driver);
        ShopifyPricingPage shopifyPricingPage = shopifyLandingPage.clickOnPricingButton();

        List<WebElement> h1List = shopifyPricingPage.getH1s();
        boolean h1Found = false;

        for (WebElement h1 : h1List) {
            System.out.println(h1.getText());
            if (h1.getText().equals("Set up your store, pick a plan later")) {
                h1Found = true;
            }
        }

        Assert.assertTrue(shopifyPricingPage.getTitleTest().contains("Shopify Pricing"));
        Assert.assertEquals(shopifyPricingPage.getCurrentUrlTest(), "https://www.shopify.com/pricing");
        Assert.assertTrue(h1Found);
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {

        ShopifyLandingPage shopifyLandingPage = new ShopifyLandingPage(driver);
        ShopifyLoginPage shopifyLoginPage = shopifyLandingPage.navigateToLoginBtn();
        shopifyLoginPage.clickOnSiguienteBtn();

        WebElement errMsg = shopifyLoginPage.getErrorMsg();
        Assert.assertEquals(errMsg.getText(), "Dirección de tienda incorrecta. Una dirección de tienda válida termina en .myshopify.com, .com, u otra extensión de dominio.");
    }

    @AfterClass   //AfterMethod  pudiera ser también.
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
