package Quality.Download;

import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

//Clase para descargar archivo en una carpeta(patch).
public class download_file {

    WebDriver driver;
    private String downloadfilepath= "C:\\Users\\Admin\\Desktop\\TestDescarga";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        HashMap<String, Object> chromePrefs= new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadfilepath);

        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.get("http://the-internet.herokuapp.com/download");

    }

    //Aqui se hace una descarga en una carpeta vacia
    @Test
    public void downloadFile() throws InterruptedException {
       driver.findElement(By.xpath("//*[@href='download/some-file.txt']")).click();
       Thread.sleep(2000);
       File folder= new File(downloadfilepath);
       File [] lisofFiles =folder.listFiles();  //En este arreglo se va guardar todos los archivos que se descargaron en la carpeta que declaramos y se hace para verificar si la carpeta esta vacía o si se guardo el archico que descargamos.
       Assert.assertTrue(lisofFiles.length>0, "File not download correctly");

    }
    //Este test es cuando en la carpera que se va descargar el archivo hay mas archivo y por lo tanto hay que validar que se descargo uno más.
    @Test
    public void downloadFileMultiple() throws InterruptedException {
        File folder= new File(downloadfilepath);
        File [] lisofFilesantes =folder.listFiles();
        System.out.println("La cantidad de archivos antes de la descarga es " + lisofFilesantes.length);

        driver.findElement(By.xpath("//*[@href='download/some-file.txt']")).click();
        Thread.sleep(2000);

        File [] lisofFilesdespues =folder.listFiles();  //En este arreglo se va guardar todos los archivos que se descargaron en la carpeta que declaramos después de la descarga.
        Assert.assertTrue(lisofFilesdespues.length>lisofFilesantes.length, "File not download correctly");
        System.out.println("La cantidad de archivos antes de la descarga es " + lisofFilesdespues.length);
    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
