package CursoSeleniumCucumber.Clase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvancedWebElements {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void getInvalidElementTest() {
        System.out.println("Este es el test 1 " + driver.getTitle());
        WebElement elementoH90 = driver.findElement(By.tagName("h90"));
        System.out.println("---> " + elementoH90.getText());
    }


    @Test
    public void getInvalidListTest() {
        System.out.println("Este es el test 1 " + driver.getTitle());
        List<WebElement> elementosH90 = driver.findElements(By.tagName("h5"));

        //Los 4 Assert hacen lo mismo, solo que son diferentes formas de representar que el Test solo continue si la lista tiene elementos(no es vacia) sino ahi mismo rompe.
        Assert.assertNotEquals(elementosH90.size(), 0, "Error: la lista no tiene elementos!!");
        // isEmpty() es FALSE si la lista tiene elementos
        // isEmpty() es TRUE si la NO tiene elementos
        Assert.assertFalse(elementosH90.isEmpty(), "Error: la lista esta vacia!!");
        Assert.assertFalse(elementosH90.isEmpty() == true, "Error: la lista esta vacia!!");
        Assert.assertTrue(elementosH90.isEmpty() == false, "Error: la lista esta vacia!!");


        for (WebElement e : elementosH90) {
            System.out.println("---> " + e.getText());
        }

        List<WebElement> elementosXpath = driver.findElements(By.xpath("//*[@href='/tqerminos']"));
    }


    @Test
    public void getH2sTest() {
        System.out.println("Este es el test 1 " + driver.getTitle());
        List<WebElement> listaH2s = driver.findElements(By.tagName("h2"));

        Assert.assertNotEquals(listaH2s.size(), 0, "Error: la lista no tiene elementos!!");
        //bandera booleana..
        boolean encontreElemento = false;

        for (WebElement h2 : listaH2s) {
            System.out.println("---> H2:  " + h2.getText());
            if (h2.getText().equals("Disfruta donde quieras. Cancela cuando quieras.") == true){
                encontreElemento = true;
                break;
            }
        }

        Assert.assertTrue(encontreElemento, "Error: el elemento no se encontró");


        WebElement primerH1 = driver.findElement(By.tagName("h1"));
        System.out.println(primerH1.getText());
        System.out.println(primerH1.getAttribute("data-uia"));//El atributo puede ser cualquiera como color de un asiento, o alguna caracteristica de ese elemento que este definido en el elemento en el codigo HTML
    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}