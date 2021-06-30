package Examen;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class prueba_netflix {

    WebDriver driver;

/*
    String email;
    public prueba_netflix(String mail){
      email = mail;
    }
*/
    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public String getDate(){
        //DateFormat dateformat=new SimpleDateFormat("HH:mm:ss");
        DateFormat dateformat=new SimpleDateFormat("dd-MM-yy"); //EL formato en que quiero que me devuelva la fecha
        Date date= new Date();
        return dateformat.format(date);
    }
    @Test (priority = 0)
    public void validarTituloTest(){
        String title = driver.getTitle();
        Assert.assertEquals(title, "Netflix Uruguay: Ve series online, ve películas online");
    }
    @Test (priority = 1)
    public void iniciarSesionPageTest(){
        driver.findElement(By.linkText("Iniciar sesión")).click();
        Assert.assertNotEquals(driver.getTitle(), "Netflix Uruguay: Ve series online, ve películas online");

        List<WebElement> listaDeH1s = driver.findElements(By.tagName("h1"));
        boolean texto = false;
        for (WebElement h1 : listaDeH1s){
            System.out.println("H1 -> " + h1.getText());
            if (h1.getText().equals("Inicia sesión")){
                texto = true;
       }
        }
        Assert.assertTrue(texto);
        WebElement texfacebook= driver.findElement(By.xpath("//span[contains(text(),'Iniciar sesión con Facebook')]"));
        Assert.assertEquals(texfacebook.getText(), "Iniciar sesión con Facebook");
    }
    @Test (priority = 2)
    public void loginToNetflixErrorTest() throws InterruptedException {
        driver.findElement(By.linkText("Iniciar sesión")).click();
        driver.findElement(By.id("id_userLoginId")).sendKeys("XXX");
        driver.findElement(By.id("id_password")).sendKeys("holamundo");

        WebElement recuerdame= driver.findElement(By.xpath("//*[@class='login-remember-me-label-text']"));
        recuerdame.click(); //desmarco el Check recuerdame(Desclickear)
        boolean seleccionado = true; //inicializo en true que es cuando el boton esta sin marcar
        if (recuerdame.isSelected()){
            seleccionado = false;   //aqui nunca va a caer pk como se desmarco arriba nunca va ser false la variable
        }
        WebElement boton = driver.findElement(By.xpath("//*[@type='submit']"));
        boton.click();

        Assert.assertTrue(seleccionado); //valido que no este marcado
        WebElement mensajeerror= driver.findElement(By.xpath("//div[contains(text(),'Escribe un email válido.')]"));
        Assert.assertEquals(mensajeerror.getText(), "Escribe un email válido.");
    }

    @Test (priority = 3)
    public void fakeEmailTest() throws InterruptedException {
        Faker faker_data = new Faker();
        String email1 = faker_data.internet().emailAddress();


        driver.findElement(By.id("id_email_hero_fuji")).sendKeys(email1);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signup"));
    }

    @Test ( priority = 4, dataProvider = "mails", dataProviderClass = DataGeneratorExamen.class)
    public void dataProviderEmailTest(String email1){
        driver.findElement(By.id("id_email_hero_fuji")).sendKeys(email1);
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    /*aqui en este metodo es donde se ejecuta el valor que pasa la fabrica por defecto dos veces.
       @Test (priority = 5)
       public void FabricaEmailTest(){
       driver.findElement(By.id("id_email_hero_fuji")).sendKeys(email);
       driver.findElement(By.xpath("//*[@type='submit']")).click();
   }*/

    @Test (priority = 5)
    @Parameters({"tagName"})
    public void printTagsTest(@Optional("h2") String tagName){

        List<WebElement> listaElementos = driver.findElements(By.tagName(tagName));
        if (tagName.equalsIgnoreCase("h1")){
            for (WebElement elementos : listaElementos){
            System.out.println("Los elementos H1 son: " + elementos.getText());
        } }
        else {
                System.out.println("No se encontraron elementos de ese tipo");
        }
    }
    @AfterMethod
    public void closeDriver() throws InterruptedException, IOException {
        TakesScreenshot scr= ((TakesScreenshot)driver);
        File file1= scr.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file1, new File("error_"+getDate()+".png"));
        //FileUtils.copyFile(file1, new File("D:\\Selenium\\Proyectos\\ProyectoEnJavaCurso\\capturas\\test1.PNG"));
        System.out.println("Se toma una captura de pantalla de la prueba");
        Thread.sleep(3000);
        driver.close();
    }

}
