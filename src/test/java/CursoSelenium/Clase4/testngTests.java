package CursoSelenium.Clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

public class testngTests {

    String URL = "https://www.google.com";
    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("-> esto es before suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("-> esto es before test");
    }

    @BeforeClass
    public void beforeClassTest(){
        System.out.println("--> esto es before class");
    }

    @BeforeMethod
    public void beforeMethodTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
    }

    //El @Optional("button") se utiliza si se quiere ejecutar el métodos desde la clase y se le pasa entonces el valor que quiere que tenga el parámetro
    // pero si se quecuta desde el xml el valor es el que viene definido allá y no hace falta entonces poner el @Optional("button")
    @Test
    @Parameters({"tagName"})
    public void primerTest(@Optional("button") String tag){
        System.out.println("---> Esto es un test!! " + tag);

        List<WebElement> listaElementos = driver.findElements(By.tagName(tag));
        System.out.println("la cantidad de elementos son: " + listaElementos.size());
    }

    @Test
    public void segundoTest(){
        System.out.println("---> Esto es otro test!!");
    }

    @AfterMethod
    public void afterMethodTest(){
        System.out.println("Se ha terminado de ejecutar un test...");
        driver.close();
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("--> After class test");
    }

    @AfterTest
    public void afterTestMethod(){
        System.out.println("--> After test");
    }

    @AfterSuite
    public void afterSuiteMethod(){
        System.out.println("--> After suite");
    }
}
