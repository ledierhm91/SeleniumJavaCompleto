package Quality.Download;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


//En esta clase se establece una conexión con el link de descarga y poder acceder a los datos del HEAD(encabezado) y esta informaciones nos permite saber si la funcionalidad de descarga del fichero trabaja correctamente.
public class CheckDownloadFile {
    WebDriver driver;
    private String downloadfilepath= "/Users/ledier.hernandez/Documents/TestDescarga";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/download");
    }

    @Test
    public void checkDownloadFile() throws IOException {

        String link= driver.findElement(By.xpath("//*[@href='download/some-file.txt']")).getAttribute("href");
        HttpURLConnection httpconnection= (HttpURLConnection) (new URL(link).openConnection()); //crear una conexión http con esa url del link del fichero
        httpconnection.setRequestMethod("HEAD"); //solicitamos el metodo HEAD donde viene la informacion que necesitamos para saber si el fichero es válido
        httpconnection.connect();
        String contentType= httpconnection.getContentType(); //De las informaciones que viene en el metodo HEAD la que necesitamos son el tipo de archivo y tamaño del archivo
        int contentLength= httpconnection.getContentLength();

        System.out.println("Type: " + contentType);
        System.out.println("Type: " + contentLength);

        Assert.assertEquals(contentType, "application/octet-stream"); //Aqui se pone el tipo de archivo que se esté descargando
        Assert.assertNotEquals(contentLength, 0);  //valida que el archivo es valido es mayor que cero.


    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
