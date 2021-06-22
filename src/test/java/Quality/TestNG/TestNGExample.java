package Quality.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGExample {
    WebDriver driver;
    By searchBoxLocator= By.id("search_query_top");
    By resulttaLocator= By.cssSelector("span.heading-counter");


    @BeforeClass
    public void beforeClass(){

    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().maximize();
}
    @Test
    public void SearchBlouse(){
    WebElement searchbox= driver.findElement(searchBoxLocator);
    searchbox.clear();
    searchbox.sendKeys("blouse");
    searchbox.submit();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(resulttaLocator));

    System.out.println("El numero de resultado es: " + driver.findElement(resulttaLocator).getText());

    Assert.assertTrue(driver.findElement(resulttaLocator).isDisplayed(),"El número de los resultados no se encuentra");

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
