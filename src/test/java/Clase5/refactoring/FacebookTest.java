package Clase5.refactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import Clase5.refactoring.DriverUtilities;
import Clase5.refactoring.FacebookRegistrationForm;

import java.util.concurrent.TimeUnit;

public class FacebookTest {
    public String FACEBOOK_URL = "https://www.facebook.com";
    WebDriver driver;

    String nombre = "";
    String apellido= "";
    String email= "ddd@xxx.com";

    public FacebookTest(){
    }

    public FacebookTest(String unNombre, String unApellido, String unEmail){
        nombre = unNombre;
        apellido = unApellido;
        email = unEmail;
    }

    @BeforeClass   //BeforeMethod  pudiera ser también.
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(FACEBOOK_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testing() throws InterruptedException {
        Thread.sleep(4000);

    }

    @Test
    public void facebookRegistrationTest() throws InterruptedException {

        DriverUtilities driverUtility = new DriverUtilities(driver);

        FacebookRegistrationForm registrationForm = new FacebookRegistrationForm(driver);

        System.out.println("---> " + driverUtility.getTitle());

        driverUtility.clickBtn("//*[@ajaxify='/reg/spotlight/']");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("firstname"))));

        registrationForm.fillingForm(nombre, apellido, email);

        /* Estas dos línea son si quiero ejecutar el método(test) sin el Factory desde la misma clase, al igual que como esta declarado
         se puede ejecutar sin el factory
        registrationForm.fillingForm("lolo","lala","ggg@ddd.com");
        registrationForm.fillingFormSinparametros();
        */
        driverUtility.clickBtn("(//*[@type='submit'])[2]");

    }
    
    @AfterClass  //AfterMethod  pudiera ser también.
    public void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }


}
