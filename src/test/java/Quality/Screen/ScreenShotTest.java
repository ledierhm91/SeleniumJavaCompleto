package Quality.Screen;

import static org.junit.Assert.*;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


//esta clase esta hecha sobre Junit y no con testNG
public class ScreenShotTest {
    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
    //Para incluir en la foto de la pantalla la fecha del día actual.
    public String getDate(){
        DateFormat dateformat=new SimpleDateFormat("dd-MM-yy"); //EL formato en que quiero que me devuelva la fecha
        Date date= new Date();
        return dateformat.format(date);
    }
    @Rule
    public TestRule watcher= new TestWatcher(){
        @Override  //Sobreescribir el metodo file
        protected void failed(Throwable throwable, Description description){   //este metodo recibe un objeto y una descripcion y es el que se ejecuta cuando el Test Falla

        File screenshotfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //nuevo archivo para almacenar la imagen como un archivo
        try {
            FileUtils.copyFile(screenshotfile,new File("error_"+description.getMethodName()+getDate()+".png"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
        @Override
        protected void finished(Description description){
            driver.quit();
    }
    };

    @Test
    public void googleSearchTest(){
       WebElement searchBox=driver.findElement(By.name("q"));
       searchBox.clear();
       searchBox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
       searchBox.submit();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       assertEquals(driver.getTitle(), "Esto ocasionará un error");//aqui debe ir en vez de este mensaje el otro de arriba, pero el objetivo es que el test Falle
}
   }
