package Clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

public class groupTests {

    String URL = "https://www.google.com";
    public WebDriver driver;

    @Test(groups = { "pasado", "fallado" })

    @BeforeTest
    public void beforeMethodTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }
    @Test(groups = { "pasado" })
    public void pasadoTest1(){
        System.out.println("---> Esto es el primer test pasado!!");
    }
    @Test(groups = { "pasado" })
    public void pasadoTest2(){
        System.out.println("---> Esto es segundo test pasado!!");
    }
    @Test(groups = { "pasado" })
    public void pasadoTest3(){
        System.out.println("---> Esto es el tercer test pasado!!");
    }
    @Test(groups = { "fallado" })
    public void falladpoTest1(){
        System.out.println("---> Esto es el primer test fallado!!");
    }
    @Test(groups = { "fallado" })
    public void falladpoTest2(){
        System.out.println("---> Esto es el segundo test fallado!!");
    }
    @Test(groups = { "fallado" })
    public void falladpoTest3(){
        System.out.println("---> Esto es el tercer test fallado!!");
    }
    @AfterTest
    public void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
