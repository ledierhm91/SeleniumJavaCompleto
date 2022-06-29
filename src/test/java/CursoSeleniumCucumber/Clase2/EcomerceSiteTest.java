package CursoSeleniumCucumber.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EcomerceSiteTest {

    public WebDriver driver;
    public static String H1_AUTHENTICATION = "AUTHENTICATION";

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @Test
    public void registrationTest() throws InterruptedException {
        String nombre = "Alan";
        String apellido = "Rodriguez";
        String emailAddress = "seleniumintermedio" + Math.random() + "test@gmail.com";
        System.out.println("---> " + emailAddress);
        Thread.sleep(3000);
        //driver.findElement(By.xpath("(//a[@href='http://automationpractice.com/index.php?controller=my-account'])[1]")).click();
        //driver.findElement(By.xpath("//a[@href = 'http://automationpractice.com/index.php?controller=my-account']")).click();
        driver.findElement(By.linkText("Sign in")).click();
        Assert.assertEquals(driver.getTitle(), "Login - My Store", "Se esperaba otro titlo!!");
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account", "Se esperaba otra URL!!");
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"));

        //Esta es una vida de validar que ese texto este en la página, igual se puede hacer un método y llamar pasandole el TagName y la palabra a validar
        boolean encontrotexto = false;
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        for (WebElement h1: h1List){
            if (h1.getText().contains(H1_AUTHENTICATION)){
                encontrotexto = true;
                break;
            }
        }
        Assert.assertTrue(encontrotexto);
        //Esta es otra via como la de arriba para validar que el texto este pero en este caso solo debe haber en la página un elemnto H1
        //WebElement h1Element = driver.findElement(By.tagName("h1"));
        //Assert.assertEquals(h1Element.getText(), H1_AUTHENTICATION, "Se esperaba el h1: " + H1_AUTHENTICATION);
        driver.findElement(By.id("email_create")).sendKeys(emailAddress);
        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(3000);
        String atributeEmail = driver.findElement(By.id("email")).getAttribute("value");//value es el nombre del atributo que tiene el valor del correo, asi se llama en el código html
        Assert.assertEquals(atributeEmail, emailAddress, "Los emails deberian de coincidir!!!");

        WebElement personalInformationElement = driver.findElement(By.xpath("//h3[contains(text(),'Your personal information')]"));
        Assert.assertEquals(personalInformationElement.getText(), "YOUR PERSONAL INFORMATION", "Error: se esperaba otro titulo h3");

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(nombre);
        driver.findElement(By.id("customer_lastname")).sendKeys(apellido);
        driver.findElement(By.name("passwd")).sendKeys("holamundo");

        WebElement elementoDias = driver.findElement(By.id("days"));
        Select diasSelect = new Select(elementoDias);
        diasSelect.selectByIndex(7);
        WebElement elementoMonth = driver.findElement(By.id("months"));
        Select monthSelect = new Select(elementoMonth);
        monthSelect.selectByIndex(7);
        WebElement yearElement = driver.findElement(By.id("years"));
        Select yearSelector = new Select(yearElement);
        yearSelector.selectByValue("2001");
        driver.findElement(By.id("company")).sendKeys("MyCompany");
        driver.findElement(By.id("address1")).sendKeys("My address Nr1");
        driver.findElement(By.id("address2")).sendKeys("My address Nr2");
        driver.findElement(By.id("city")).sendKeys("New York");
        WebElement stateSelector = driver.findElement(By.id("id_state"));
        Select selectState = new Select(stateSelector);
        selectState.selectByValue("2");
        driver.findElement(By.id("postcode")).sendKeys("10000");
        WebElement countrySelector = driver.findElement(By.id("id_country"));
        Select selectCountry = new Select(countrySelector);
        selectCountry.selectByValue("21");
        driver.findElement(By.id("other")).sendKeys("Additional information");
        driver.findElement(By.id("phone")).sendKeys("123456");
        driver.findElement(By.id("phone_mobile")).sendKeys("123456789");
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys("MyAlias");
        driver.findElement(By.id("submitAccount")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"), "Error: se esperaba my-account en la URL");
        driver.findElement(By.xpath("//span[contains(text(),'My personal information')]")).click();
        Thread.sleep(5000);//Aca abajo hay dos forma de como representar el GetAttribute
        String atributeFirstNameElement = driver.findElement(By.id("firstname")).getAttribute("value");
        WebElement atributeLastNameElement = driver.findElement(By.id("lastname"));
        Assert.assertEquals(atributeFirstNameElement, nombre, "Error: el nombre de la cuenta no es el esperado");
        Assert.assertEquals(atributeLastNameElement.getAttribute("value"), apellido, "Error: el apellido de la cuenta no es el esperado");
    }

    @Test
    public void loginTest() throws InterruptedException {
        double randomNumber = Math.random();
        String nombre = "Alan";
        String apellido = "Rodriguez";
        String password = "holamundo";
        String emailAddress = "seleniumcurso" + randomNumber +"@gmail.com";
        System.out.println("---> " + emailAddress);
        Thread.sleep(3000);
        //driver.findElement(By.xpath("(//a[@href='http://automationpractice.com/index.php?controller=my-account'])[1]")).click();
        //driver.findElement(By.xpath("//a[@href = 'http://automationpractice.com/index.php?controller=my-account']")).click();
        driver.findElement(By.linkText("Sign in")).click();
        Assert.assertEquals(driver.getTitle(), "Login - My Store", "Se esperaba otro titlo!!");
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account", "Se esperaba otra URL!!");
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"));

        //Esta es una vida de validar que ese texto este en la página, igual se puede hacer un método y llamar pasandole el TagName y la palabra a validar
        boolean encontrotexto = false;
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        for (WebElement h1: h1List){
            if (h1.getText().contains(H1_AUTHENTICATION)){
                encontrotexto = true;
                break;
            }
        }
        Assert.assertTrue(encontrotexto);
        //Esta es otra via como la de arriba para validar que el texto este pero en este caso solo debe haber en la página un elemnto H1
        //WebElement h1Element = driver.findElement(By.tagName("h1"));
        //Assert.assertEquals(h1Element.getText(), H1_AUTHENTICATION, "Se esperaba el h1: " + H1_AUTHENTICATION);
        driver.findElement(By.id("email_create")).sendKeys(emailAddress);
        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(3000);
        String atributeEmail = driver.findElement(By.id("email")).getAttribute("value");//value es el nombre del atributo que tiene el valor del correo, asi se llama en el código html
        Assert.assertEquals(atributeEmail, emailAddress, "Los emails deberian de coincidir!!!");

        WebElement personalInformationElement = driver.findElement(By.xpath("//h3[contains(text(),'Your personal information')]"));
        Assert.assertEquals(personalInformationElement.getText(), "YOUR PERSONAL INFORMATION", "Error: se esperaba otro titulo h3");

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(nombre);
        driver.findElement(By.id("customer_lastname")).sendKeys(apellido);
        driver.findElement(By.name("passwd")).sendKeys("holamundo");

        WebElement elementoDias = driver.findElement(By.id("days"));
        Select diasSelect = new Select(elementoDias);
        diasSelect.selectByIndex(7);
        WebElement elementoMonth = driver.findElement(By.id("months"));
        Select monthSelect = new Select(elementoMonth);
        monthSelect.selectByIndex(7);
        WebElement yearElement = driver.findElement(By.id("years"));
        Select yearSelector = new Select(yearElement);
        yearSelector.selectByValue("2001");
        driver.findElement(By.id("company")).sendKeys("MyCompany");
        driver.findElement(By.id("address1")).sendKeys("My address Nr1");
        driver.findElement(By.id("address2")).sendKeys("My address Nr2");
        driver.findElement(By.id("city")).sendKeys("New York");
        WebElement stateSelector = driver.findElement(By.id("id_state"));
        Select selectState = new Select(stateSelector);
        selectState.selectByValue("2");
        driver.findElement(By.id("postcode")).sendKeys("10000");
        WebElement countrySelector = driver.findElement(By.id("id_country"));
        Select selectCountry = new Select(countrySelector);
        selectCountry.selectByValue("21");
        driver.findElement(By.id("other")).sendKeys("Additional information");
        driver.findElement(By.id("phone")).sendKeys("123456");
        driver.findElement(By.id("phone_mobile")).sendKeys("123456789");
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys("MyAlias");
        driver.findElement(By.id("submitAccount")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"), "Error: se esperaba my-account en la URL");
        //log out.....
        driver.findElement(By.cssSelector(".logout")).click();
        driver.findElement(By.id("email")).sendKeys(emailAddress);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.name("SubmitLogin")).click();

        Assert.assertTrue(driver.getTitle().contains("My account"), "Error: se esperaba otro titulo");
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"), "Error: se esperaba my-account en la URL");

        String accountNameElement = driver.findElement(By.className("account")).getText();
        String fullName = nombre + " " + apellido;
        Assert.assertEquals(accountNameElement, fullName, "Error: se esperaba el nombre ingresado en el registro: "+ nombre + " " + apellido);
    }

    @Test
    public void uniqueAccountTest() throws InterruptedException {
        double randomNumber = Math.random();
        String nombre = "Alan";
        String apellido = "Rodriguez";
        String password = "holamundo";
        String emailAddress = "seleniumcurso" + randomNumber +"@gmail.com";
        System.out.println("---> " + emailAddress);
        Thread.sleep(3000);
        //driver.findElement(By.xpath("(//a[@href='http://automationpractice.com/index.php?controller=my-account'])[1]")).click();
        //driver.findElement(By.xpath("//a[@href = 'http://automationpractice.com/index.php?controller=my-account']")).click();
        driver.findElement(By.linkText("Sign in")).click();
        Assert.assertEquals(driver.getTitle(), "Login - My Store", "Se esperaba otro titlo!!");
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account", "Se esperaba otra URL!!");
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"));

        //Esta es una vida de validar que ese texto este en la página, igual se puede hacer un método y llamar pasandole el TagName y la palabra a validar
        boolean encontrotexto = false;
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        for (WebElement h1: h1List){
            if (h1.getText().contains(H1_AUTHENTICATION)){
                encontrotexto = true;
                break;
            }
        }
        Assert.assertTrue(encontrotexto);
        //Esta es otra via como la de arriba para validar que el texto este pero en este caso solo debe haber en la página un elemnto H1
        //WebElement h1Element = driver.findElement(By.tagName("h1"));
        //Assert.assertEquals(h1Element.getText(), H1_AUTHENTICATION, "Se esperaba el h1: " + H1_AUTHENTICATION);
        driver.findElement(By.id("email_create")).sendKeys(emailAddress);
        driver.findElement(By.id("SubmitCreate")).click();

        Thread.sleep(3000);
        String atributeEmail = driver.findElement(By.id("email")).getAttribute("value");//value es el nombre del atributo que tiene el valor del correo, asi se llama en el código html
        Assert.assertEquals(atributeEmail, emailAddress, "Los emails deberian de coincidir!!!");

        WebElement personalInformationElement = driver.findElement(By.xpath("//h3[contains(text(),'Your personal information')]"));
        Assert.assertEquals(personalInformationElement.getText(), "YOUR PERSONAL INFORMATION", "Error: se esperaba otro titulo h3");

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(nombre);
        driver.findElement(By.id("customer_lastname")).sendKeys(apellido);
        driver.findElement(By.name("passwd")).sendKeys("holamundo");

        WebElement elementoDias = driver.findElement(By.id("days"));
        Select diasSelect = new Select(elementoDias);
        diasSelect.selectByIndex(7);
        WebElement elementoMonth = driver.findElement(By.id("months"));
        Select monthSelect = new Select(elementoMonth);
        monthSelect.selectByIndex(7);
        WebElement yearElement = driver.findElement(By.id("years"));
        Select yearSelector = new Select(yearElement);
        yearSelector.selectByValue("2001");
        driver.findElement(By.id("company")).sendKeys("MyCompany");
        driver.findElement(By.id("address1")).sendKeys("My address Nr1");
        driver.findElement(By.id("address2")).sendKeys("My address Nr2");
        driver.findElement(By.id("city")).sendKeys("New York");
        WebElement stateSelector = driver.findElement(By.id("id_state"));
        Select selectState = new Select(stateSelector);
        selectState.selectByValue("2");
        driver.findElement(By.id("postcode")).sendKeys("10000");
        WebElement countrySelector = driver.findElement(By.id("id_country"));
        Select selectCountry = new Select(countrySelector);
        selectCountry.selectByValue("21");
        driver.findElement(By.id("other")).sendKeys("Additional information");
        driver.findElement(By.id("phone")).sendKeys("123456");
        driver.findElement(By.id("phone_mobile")).sendKeys("123456789");
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys("MyAlias");
        driver.findElement(By.id("submitAccount")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("my-account"), "Error: se esperaba my-account en la URL");

        //log out.....
        driver.findElement(By.cssSelector(".logout")).click();
        driver.findElement(By.id("email_create")).sendKeys(emailAddress);
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(3500);
        //get the error
        String errorElement = driver.findElement(By.id("create_account_error")).getText();
        Assert.assertTrue(errorElement.contains("An account using this email address has already been registered."), "Error: el mensaje de error no es el esperado");

        /*Otra vida de hacer la validacion de un mensaje cuando el texto no lo devuelve y hay que tomarlo de otro atributo del mismo elemnto
        WebElement errorElement = driver.findElement(By.id("create_account_error"));
        WebElement emailErrorElement = errorElement.findElement(By.tagName("li"));
        Assert.assertTrue(emailErrorElement.getText().contains("An account using this email address has already been registered."), "Error: el mensaje de error no es el esperado");*/
    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}