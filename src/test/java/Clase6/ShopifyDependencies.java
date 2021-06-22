package Clase6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ShopifyDependencies {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.shopify.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void titleTest(){
        String title = driver.getTitle();
        Assert.assertEquals(title, "BEST Ecommerce Platform to Start a Business (2021)");
    }

    @Test (dependsOnMethods = {"titleTest"})
    public void clickOnGetStartTest(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.shopify.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("(//*[@data-ga-action='Get Started'])[1]")).click();
        WebElement titleH2 = driver.findElement(By.id("ModalTitle"));
        Assert.assertEquals(titleH2.getText(), "Start your free 14-day trial of Shopify");
    }

    @Test (dependsOnMethods = {"clickOnGetStartTest"})
    public void fillingFormWithoutShopnameTest(){
        driver.findElement(By.xpath("//*[@placeholder='Email address']")).sendKeys("testing@test.com");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("holamundo");
        driver.findElement(By.name("button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.shopify.com/" );
    }

    @AfterTest
    public void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}
