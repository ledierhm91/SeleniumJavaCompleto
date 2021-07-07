package CursoSelenium.Clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class spotifyTestng {
    String URL = "https://www.spotify.com";
    public WebDriver driver;

    private static final String Email_Error = "Es necesario que introduzcas tu correo electrónico.";
    private static final String Confirma_Email_Error = "Es necesario que confirmes tu correo electrónico.";
    private static final String Pass_Error = "Debes introducir una contraseña.";
    private static final String Perfil_Error = "Introduce un nombre para tu perfil.";
    private static final String Dia_Error = "Indica un día del mes válido.";
    private static final String Mes_Error = "Selecciona tu mes de nacimiento.";
    private static final String Anno_Error = "Indica un año válido.";
    private static final String Sexo_Error = "Selecciona tu sexo.";
    private static final String Robot_Error = "Confirma que no eres un robot.";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (priority = 0)
    public void verifySpotifyTitle(){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Escuchar es todo - Spotify");
    }

    //Utilizar xpath con caminos absolutos para acceder al botón de Registrar
    //Validar que la url actual, contenga signup
    @Test (priority = 1)
    public void verifySignupUrlTest(){
        //driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/nav/ul/li[5]/a")).click();
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signup"));
    }

    /*
    Crear un método llamado invalidEmailTest
    Ingresar a spotify y hacer click en Registrarse
    Completar el email con un email inválido: “test.com”
    Validar que se despliegue el error: “La dirección de email que proporcionaste no es válida.”

     */

    @Test (priority = 2)
    public void invalidEmailTest(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.name("email")).sendKeys("test.com");
        driver.findElement(By.name("confirm")).sendKeys("test.com");
        //   Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com
        WebElement emailErrorMsg = driver.findElement(By.xpath("//span[contains(text(),'Este correo electrónico no es válido.')]"));
        Assert.assertEquals(emailErrorMsg.getText(), "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com" );
    }

    //Este correo electrónico ya está conectado a una cuenta.

    @Test (priority = 3)
    public void validateExistingEmail() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("confirm")).sendKeys("test@test.com");
        Thread.sleep(3000);

        WebElement duplicateEmailErrorMsg = driver.findElement(By.xpath("//span[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]"));
        Assert.assertEquals(duplicateEmailErrorMsg.getText(), "Este correo electrónico ya está conectado a una cuenta. Inicia sesión." );

    }

    @Test (priority = 4)
    public void validatemensaje() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("confirm")).sendKeys("test@test.com");
        Thread.sleep(3000);

        WebElement boton= driver.findElement(By.xpath("//*[@type='submit']"));
        boton.click();

        WebElement duplicateEmailErrorMsg = driver.findElement(By.xpath("//span[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]"));
        Assert.assertEquals(duplicateEmailErrorMsg.getText(), "Este correo electrónico ya está conectado a una cuenta. Inicia sesión." );

        WebElement mensajeerror = driver.findElement(By.xpath("//div[contains(text(),'Debes introducir')]"));
        //System.out.println("Mensaje " + mensajeerror.getText());
        Assert.assertEquals(mensajeerror.getText(), "Debes introducir una contraseña." );

    }
    @Test (priority = 5)
    public void CheckErrorMensages() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement emailmensage = driver.findElement(By.xpath("//span[contains(text(),'Es necesario que introduzcas tu correo electrónico.')]"));
        WebElement emailmensageconfirmar = driver.findElement(By.xpath("//div[contains(text(),'Es necesario que confirmes tu correo electrónico.')]"));
        WebElement contrasenna = driver.findElement(By.xpath("//div[contains(text(),'Debes introducir una contraseña.')]"));
        WebElement perfilmensage = driver.findElement(By.xpath("//div[contains(text(),'Introduce un nombre para tu perfil.')]"));
        WebElement mensagedia = driver.findElement(By.xpath("//div[contains(text(),'Indica un día del mes válido.')]"));
        WebElement mensajemes = driver.findElement(By.xpath("//div[contains(text(),'Selecciona tu mes de nacimiento.')]"));
        WebElement mensajeanno = driver.findElement(By.xpath("//div[contains(text(),'Indica un año válido.')]"));
        WebElement mensajesexo = driver.findElement(By.xpath("//div[contains(text(),'Selecciona tu sexo.')]"));
        WebElement mensajerobot = driver.findElement(By.xpath("//div[contains(text(),'Confirma que no eres un robot.')]"));

        Assert.assertEquals(emailmensage.getText(), Email_Error);
        Assert.assertEquals(emailmensageconfirmar.getText(), Confirma_Email_Error);
        Assert.assertEquals(contrasenna.getText(), Pass_Error);
        Assert.assertEquals(perfilmensage.getText(), Perfil_Error);
        Assert.assertEquals(mensagedia.getText(), Dia_Error);
        Assert.assertEquals(mensajemes.getText(), Mes_Error);
        Assert.assertEquals(mensajeanno.getText(), Anno_Error);
        Assert.assertEquals(mensajesexo.getText(), Sexo_Error);
        Assert.assertEquals(mensajerobot.getText(), Robot_Error);

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Se ha terminado de ejecutar un test...");
        driver.close();
    }
}
