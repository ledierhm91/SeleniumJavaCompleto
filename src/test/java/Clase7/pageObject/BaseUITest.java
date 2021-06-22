package Clase7.pageObject;

import org.openqa.selenium.WebDriver;

public class BaseUITest {

    public WebDriver driver;

    public String getTitleTest(){
        return driver.getTitle();
    }

    public String getCurrentUrlTest(){
        return driver.getCurrentUrl();
    }
}
