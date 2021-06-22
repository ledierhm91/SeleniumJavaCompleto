package Clase7.pageObject.Docusign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Clase7.pageObject.BaseUITest;

public class DocusignLandingPage extends BaseUITest {

    public DocusignLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public DocusignRegistrationPage clickPruebaGratuitaBtn(){
        driver.findElement(By.xpath("//*[@href='https://go.docusign.com.es/o/trial/']")).click();
        return new DocusignRegistrationPage(driver);
    }

}
