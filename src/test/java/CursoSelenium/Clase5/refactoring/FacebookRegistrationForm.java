package CursoSelenium.Clase5.refactoring;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class FacebookRegistrationForm {

    WebDriver driver;

    public FacebookRegistrationForm(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void fillingForm(String nombre, String apellido, String email){
        driver.findElement(By.name("firstname")).sendKeys(nombre);
        driver.findElement(By.name("lastname")).sendKeys(apellido);
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);
        driver.findElement(By.xpath("//*[@name='sex'][@value='-1']")).click();


    }
    public void fillingFormSinparametros(){
        driver.findElement(By.name("firstname")).sendKeys("juan");
        driver.findElement(By.name("lastname")).sendKeys("Lopez");
        driver.findElement(By.name("reg_email__")).sendKeys("lolo@hhh.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("lolo@hhh.com");
        driver.findElement(By.xpath("//*[@name='sex'][@value='-1']")).click();


    }

    public void fillingFormFaker(){
        Faker faker_data = new Faker();
        String nombre = faker_data.name().firstName();
        String apellido = faker_data.name().lastName();
        String email = faker_data.internet().emailAddress();
        driver.findElement(By.name("firstname")).sendKeys(nombre);
        driver.findElement(By.name("lastname")).sendKeys(apellido);
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);
        driver.findElement(By.xpath("//*[@name='sex'][@value='-1']")).click();

    }


    public void fillingFormDataProvider(String nombre1, String apellido1, String mail1, String mail2){
        driver.findElement(By.name("firstname")).sendKeys(nombre1);
        driver.findElement(By.name("lastname")).sendKeys(apellido1);
        driver.findElement(By.name("reg_email__")).sendKeys(mail1);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(mail2);
        driver.findElement(By.xpath("//*[@name='sex'][@value='-1']")).click();

    }
}
