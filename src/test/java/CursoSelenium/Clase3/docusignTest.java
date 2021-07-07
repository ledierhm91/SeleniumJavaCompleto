package CursoSelenium.Clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class docusignTest {

    //
    private WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    //Ejercicio 1
    @Test
    public void completeDocusignRegistrationForm(){
        WebDriver driver = getDriver("https://go.docusign.com/o/trial");
        driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Alan");
        driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("Smith");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("123123");
        driver.findElement(By.xpath("//*[@name='title']")).sendKeys("QA");
        WebElement industry = driver.findElement(By.xpath("//*[@name='ds_industry']"));
        Select industryDropdown = new Select(industry);
        industryDropdown.selectByVisibleText("Education");
    }

    //Ejercicio 2
    @Test
    public void defaultXpath() {
        WebDriver driver = getDriver("https://go.docusign.com/o/trial");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_First_Name\"]/input")).sendKeys("Alan");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Last_Name\"]/input")).sendKeys("Alan");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Email\"]/input")).sendKeys("alan@test.com");
        driver.findElement(By.cssSelector("#dsFormLabel_Phone")).sendKeys("098365214");
        //driver.findElement(By.cssSelector("*[type='tel']")).sendKeys("098365214");
        //driver.findElement(By.cssSelector("input[type='tel']")).sendKeys("098365214");
    }

    }
