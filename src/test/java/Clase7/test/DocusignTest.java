package Clase7.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Clase7.pageObject.Docusign.DocusignLandingPage;
import Clase7.pageObject.Docusign.DocusignRegistrationPage;

public class DocusignTest extends BaseTest {

    @BeforeMethod
    public void setupDocusignTest(){
        driver.get("https://www.docusign.com.es/");
    }

    @Test
    public void docusignRegistrationTest(){
        // Page Object Pattern
        DocusignLandingPage docusignLandingPage = new DocusignLandingPage(driver);

        String titulo = docusignLandingPage.getTitleTest();
        String url = docusignLandingPage.getCurrentUrlTest();

        Assert.assertEquals(titulo, "DocuSign | Líder de la industria de firma electrónica");
        Assert.assertEquals(url, "https://www.docusign.com.es/");

        DocusignRegistrationPage docusignRegistrationPage = docusignLandingPage.clickPruebaGratuitaBtn();

        Assert.assertEquals(docusignRegistrationPage.getTitleTest(), "Prueba gratuita de DocuSign");
        Assert.assertEquals(docusignRegistrationPage.getCurrentUrlTest(), "https://go.docusign.com.es/o/trial/");

        docusignRegistrationPage.fillingRegistrationFields();
        docusignRegistrationPage.clickOnComenzarBtn();
    }
    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
