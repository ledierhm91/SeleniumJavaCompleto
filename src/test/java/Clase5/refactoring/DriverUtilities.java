package Clase5.refactoring;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DriverUtilities {

    WebDriver driver;

    public DriverUtilities(WebDriver remoteDriver){
        driver = remoteDriver;
    }


    public void clickBtn(String aXpathExpression){
        driver.findElement(By.xpath(aXpathExpression)).click();
    }

    public String getTitle(){
        return driver.getTitle();
    }



}
