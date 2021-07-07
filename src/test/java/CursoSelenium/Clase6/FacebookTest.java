package CursoSelenium.Clase6;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class FacebookTest {


    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "paises", dataProviderClass = DataGenerator.class)
    public void testOfDataProviders(String capital, String pais){
        System.out.println("La capital de " + pais + " es " + capital);
    }

    @Test(dataProvider = "loginData", dataProviderClass = DataGenerator.class)
    public void registrationTest(String name, String lastname, String city, int phone){

        System.out.println(name + " - " + lastname + " " + city + "  " + phone);
        //driver.findElement(By.xpath("//*[@placeholder='Email address']")).sendKeys(name);
        //driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys(lastname);
        //driver.findElement(By.xpath("//*[@placeholder='City']")).sendKeys(city);
        //driver.findElement(By.name("button")).click();
    }

    @Test(dataProvider = "emails", dataProviderClass = DataGenerator.class)
    public void facebookTest(String anEmail, String status){

        // si el email es correcto...
        // validar el mensaje de exito!!
        if (status.equals("valid")){
            // localizo el mensaje de existo y agrego un assert!! :)
            System.out.println("El email es correcto!! "+ anEmail);
        }

        //si el email es incorrecto
        //buscar el error: "Email is not valid"
        if (status.equals("invalid")){
            //busco el mnsaje "Email is not valid"...
            System.out.println("El email es incorrecto " + anEmail);
        }

    }

    @Test
    public void facebookTestFaker(){

        Faker faker_data = new Faker();
        String name = faker_data.name().firstName();
        String lastName = faker_data.name().lastName();
        String email = faker_data.internet().emailAddress();

        System.out.println("---> " + name + " " + lastName + "  " + email);
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @AfterTest
    public void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }


}
