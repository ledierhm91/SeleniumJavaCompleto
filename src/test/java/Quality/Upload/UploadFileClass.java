package Quality.Upload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

//Clase es para adjuntar un archivo a la web
public class UploadFileClass {

    WebDriver driver;
    private String uploadFileSubir="C:\\Users\\Admin\\Desktop\\TestDescarga\\subir.txt";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    @Test
    public void downloadFile() throws InterruptedException {
        File file=new File(uploadFileSubir);
        String patch=file.getAbsolutePath(); //Donde se guarda el patch absoluto de ese archivo
        driver.findElement(By.xpath("//*[@id='file-upload']")).sendKeys(patch);

        WebElement button= driver.findElement(By.xpath("//*[@id='file-submit']"));
        button.click();
        String text=driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(text, "subir.txt");
    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
