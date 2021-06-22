package Clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class spotifyTags {

    public  String URL = "https://www.spotify.com/uy";
    public  WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(URL);
    }
    @Test
    @Parameters({"specificTag"})
    public void primerTest(@Optional("h1") String tagName){

        List<WebElement> listaElementos = driver.findElements(By.tagName(tagName));

        if (tagName.equalsIgnoreCase("h1")){
        System.out.println("Se mostraran los h1");
        }
        else if (tagName.equalsIgnoreCase("h2")){
            System.out.println("Se mostraran los h2");
        }
        else if (tagName.equalsIgnoreCase("h3")){
            System.out.println("Se mostraran los h3");
        }
        if (listaElementos.size() < 0){
            System.out.println("No se encontraron elementos");
        }
        else {
            for (WebElement e: listaElementos){
                System.out.println("El texto de cada elemento es: " + e.getText());
            }
        }
    }

}
