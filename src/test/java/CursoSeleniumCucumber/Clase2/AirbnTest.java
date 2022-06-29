package CursoSeleniumCucumber.Clase2;

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

public class AirbnTest {

    public WebDriver driver;
    public static String BUDAPEST_CITY = "Budapest";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.airbnb.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void busquedaAlojamientoTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-index='0']")).click();

        //Aca son 2 ejemplo de xpath utilizando el atributo class y luego para la posición tiene dos forma de representarse
        //driver.findElement(By.xpath("//button[@class='ffc0w66 dir dir-ltr'][1]")).click();
        //driver.findElement(By.xpath("(//button[@class='ffc0w66 dir dir-ltr'])[1]")).click();

        //Aca son 2 ejemplo de xpath utilizando Containt y luego si fuera necesario utilizar posición se ve como hacer en el segundo ejemplo
        //driver.findElement(By.xpath("//div[contains(text(),'Cualquier lugar')]")).click();
        //driver.findElement(By.xpath("(//*[contains(text(),'Cualquier lugar')])[1]")).click();

        driver.findElement(By.id("bigsearch-query-location-input")).sendKeys(BUDAPEST_CITY);
        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-split-dates-0']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Siguiente']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@data-testid='datepicker-day-2022-08-15']")).click();
        driver.findElement(By.xpath("//div[@data-testid='datepicker-day-2022-08-30']")).click();
        driver.findElement(By.xpath("//*[@data-testid='structured-search-input-field-guests-button']")).click();

        WebElement aumentarAdultosElement = driver.findElement(By.xpath("(//*[@aria-label='aumentar valor'])[1]"));
        aumentarAdultosElement.click();
        aumentarAdultosElement.click();
        WebElement aumentarNiñosElement = driver.findElement(By.xpath("(//*[@aria-label='aumentar valor'])[2]"));
        aumentarNiñosElement.click();
        driver.findElement(By.cssSelector("span._kaq6tx")).click();

        Thread.sleep(1500);
        WebElement textovalidar = driver.findElement(By.xpath("//span[contains(text(), 'alojamientos')]"));
        boolean encontroTexto = false;
            if (textovalidar.getText().contains("alojamiento") ){
                encontroTexto = true;
            }
        Assert.assertTrue(encontroTexto);

     /*   WebElement h1Element = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(h1Element.getText(), "Estancias en " + BUDAPEST_CITY);
        Assert.assertTrue(h1Element.getText().contains(BUDAPEST_CITY));
        Assert.assertTrue(h1Element.getText().endsWith(BUDAPEST_CITY));

        boolean encontroBudapest = false;
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        for (WebElement h1: h1List){
            if (h1.getText().contains(BUDAPEST_CITY)){
                encontroBudapest = true;
                break;
            }
        }

        Assert.assertTrue(encontroBudapest);
     */
    }
    @AfterMethod
    public void closeDriver() throws InterruptedException {
      Thread.sleep(3000);
      driver.close();
    }
}