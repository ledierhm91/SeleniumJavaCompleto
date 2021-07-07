package CursoSelenium.Clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ejercicio2 {

    private WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    //ejercicio 1
    @Test
    public void forgotAccountTest(){
        WebDriver driver = getDriver("https://www.facebook.com");
        System.out.println("Antes Título: " +driver.getTitle());
        System.out.println("Antes URL: " +driver.getCurrentUrl());

        //Assert.assertEquals(driver.getTitle(), "Facebook - Entrar o registrarse", "Se esperaba otro título" );
        Assert.assertEquals(driver.getTitle(), "Facebook - Inicia sesión o regístrate", "Se esperaba otro título" );
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/", "Se esperaba otra url");

        //driver.findElement(By.linkText("¿Has olvidado la contraseña?")).click();
        driver.findElement(By.linkText("¿Olvidaste tu contraseña?")).click();
        System.out.println("Después Título: " +driver.getTitle());
        System.out.println("Después URL: " +driver.getCurrentUrl());

        //Assert.assertEquals(driver.getTitle(), "¿Has olvidado la contraseña? | No puedo entrar | Facebook","Se deberia estar en la sección de Olvidaste tu contraseña");
        Assert.assertEquals(driver.getTitle(), "¿Olvidaste tu contraseña? | No puedo iniciar sesión | Facebook","Se deberia estar en la sección de Olvidaste tu contraseña");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.facebook.com/", "Se deberia estar en otra url");
        driver.close();
    }

    //ejercicio 2
    @Test
    public void forgotPartialLinkTest(){
        WebDriver driver = getDriver("https://www.facebook.com");
        System.out.println("Titulo Antes: " + driver.getTitle());
        //driver.findElement(By.partialLinkText("olvidado")).click();
        driver.findElement(By.partialLinkText("Olvidaste")).click();
        System.out.println("Titulo Despúes: " + driver.getTitle());
        //Assert.assertEquals(driver.getTitle(), "¿Has olvidado la contraseña? | No puedo entrar | Facebook","Se deberia estar en la sección de Olvidaste tu contraseña");
        Assert.assertEquals(driver.getTitle(), "¿Olvidaste tu contraseña? | No puedo iniciar sesión | Facebook","Se deberia estar en la sección de Olvidaste tu contraseña");
        driver.close();
    }

    //ejercicio 3
    @Test
    public void salesforceTest(){
        WebDriver driver = getDriver("https://login.salesforce.com/");
        System.out.println("Titulo: " + driver.getTitle());
        //driver.findElement(By.linkText("Utilizar dominio personalizado")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Use Custom Domain")).click();
        driver.findElement(By.name("mydomain")).sendKeys("as");
        driver.findElement(By.id("mydomainContinue")).click();
        driver.findElement(By.id("okta-signin-username")).sendKeys("test@test.com");
        driver.close();
    }



    //ejercicio 4 y 6
    @Test
    public void registrationTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com");

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("Juan");
        driver.findElement(By.name("lastname")).sendKeys("Lopez");
        driver.findElement(By.name("reg_email__")).sendKeys("juanlopez@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("juanlopez@gmail.com");
        driver.findElement(By.id("password_step_input")).sendKeys("locoloco");

        WebElement dias = driver.findElement(By.id("day"));
        Select comboDias = new Select(dias);
        comboDias.selectByValue("25");

        WebElement meses = driver.findElement(By.id("month"));
        Select comboMeses = new Select(meses);
        comboMeses.selectByVisibleText("dic");

        WebElement anno = driver.findElement(By.id("year"));
        Select comboanno = new Select(anno);
        //comboanno.selectByIndex(30);
        //comboanno.selectByValue("1990");
        comboanno.selectByVisibleText("1990");

        WebElement gendermasculino=driver.findElement(By.xpath("//*[@name='sex'][@value='2']"));
        if(gendermasculino.isSelected() == false){
            gendermasculino.click();
        }
        //driver.findElement(By.name("websubmit")).click();

        WebElement boton=driver.findElement(By.name("websubmit"));
        boton.click();
        driver.close();
    }

    //ejercicio 7
    @Test
    public void ComboBoxTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com");

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(3000);
        WebElement meses= driver.findElement(By.name("birthday_month"));
        Select combomes= new Select(meses);

        List<WebElement> opciones = combomes.getOptions();
        Assert.assertNotEquals(0, opciones.size());

        combomes.selectByVisibleText("ene");
        Thread.sleep(3000);
        combomes.selectByVisibleText("feb");
        Thread.sleep(3000);
        combomes.selectByVisibleText("mar");

        boolean encontrar= false;
        for(WebElement opt : opciones){
            System.out.println("El mes es: " + opt.getText());
            if(opt.getText().contentEquals("jun")){
                encontrar = true;
                break;
            }
        }
        //System.out.println("No se encontro el mes introducido");
        Assert.assertTrue(encontrar);
        driver.close();
    }
    //ejercicio 8
    @Test
    public void Completarregistro() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com");

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("Juan");
        driver.findElement(By.name("lastname")).sendKeys("Lopez");
        driver.findElement(By.name("reg_email__")).sendKeys("juanlopez@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("juanlopez@gmail.com");
        driver.findElement(By.id("password_step_input")).sendKeys("locoloco");
        Setbirthdate(driver, "2", "ene", "1991");
        driver.close();
    }

    //ejercicio 8 método privado
    private void Setbirthdate (WebDriver driver, String dia, String mes, String ano)  {

        WebElement dias = driver.findElement(By.id("day"));
        Select comboDias = new Select(dias);
        comboDias.selectByValue(dia);

        WebElement meses = driver.findElement(By.id("month"));
        Select comboMeses = new Select(meses);
        comboMeses.selectByVisibleText(mes);

        WebElement anno = driver.findElement(By.id("year"));
        Select comboanno = new Select(anno);
        //comboanno.selectByIndex(30);
        //comboanno.selectByValue("1990");
        comboanno.selectByVisibleText(ano);

    }
}
