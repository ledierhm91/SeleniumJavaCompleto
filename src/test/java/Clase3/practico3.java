package Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class practico3 {

    private WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    public void testing() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@ajaxify='/reg/spotlight/']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@value='1'][@name='sex']")).click();
        WebElement mensaje = driver.findElement(By.xpath("//*[contains(text(),'Es rápido y fácil.')]"));
        System.out.println("El texto es: " + mensaje.getText());
        Assert.assertEquals(mensaje.getText(), "Es rápido y fácil.");


    }

}
