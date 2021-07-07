package CursoSelenium.Clase7.iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TelefonicaTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.telefonica.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void telefonicaTest() throws InterruptedException {
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getTitle(), "Telefónica");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.telefonica.com/es/home");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(5000);
        WebElement iframecotizacion= driver.findElement(By.id("euroland-ticker-es"));
        driver.switchTo().frame(iframecotizacion);
        //driver.switchTo().frame("euroland-ticker-es");

        List<WebElement> tabs = driver.findElements(By.className("Tab"));
        Assert.assertEquals(tabs.size(), 2);
        WebElement activeTab = driver.findElement(By.className("Tab_Active"));
        Assert.assertEquals(activeTab.getText(), "BME");

        for (WebElement elementTab: tabs) {
            System.out.println("-----> " + elementTab.getText());
            if (elementTab.getText().equals("NYSE")){
                elementTab.click();
            }
        }
        //activeTab = driver.findElement(By.className("Tab_Active"));
        //Assert.assertEquals(activeTab.getText(), "NYSE");

        List<WebElement> dataItems = driver.findElements(By.className("DataItem"));
        List<WebElement> dataValues = driver.findElements(By.className("DataValue"));

        Assert.assertEquals(dataItems.size(), 6);
        Assert.assertEquals(dataValues.size(), 6);

        for (WebElement di: dataItems){
            if (di.getText().isEmpty() == false) {
                System.out.println("--> " +di.getText());
            }
        }

        for (WebElement dv : dataValues) {
            if (dv.getText().isEmpty() == false) {
                System.out.println("--> " + dv.getText());
            }
        }


        Thread.sleep(10000);

    }
    @AfterTest
    public void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}