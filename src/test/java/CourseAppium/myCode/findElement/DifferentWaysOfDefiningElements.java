package CourseAppium.myCode.findElement;

import CourseAppium.myCode.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentWaysOfDefiningElements {
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility\"]") private static    MobileElement myElement3;

    @AndroidFindBy (id = "android:id/text1")
    @iOSXCUITFindBy(id = "android:id/text1")
    private static MobileElement myElement5;

    public DifferentWaysOfDefiningElements(AppiumDriver driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        //@FindBy
        DifferentWaysOfDefiningElements differentWayOfDefiningElements = new DifferentWaysOfDefiningElements(driver);
        System.out.println(myElement3.getText() + " using the @FindBy");

        //@AndroidFindBy, @iOSXCUITFindBy
        System.out.println(myElement5.getText() + " Using the @AndroidFindBy, @iOSXCUITFindBy");

        //By
        By myElement4 = By.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(driver.findElement(myElement4).getText() + " Using the By");

        //MobileBy
        By myElement2 = MobileBy.AccessibilityId("Accessibility");
        System.out.println(driver.findElement(myElement2).getText() + " Using the WebElement");


        //MobileElement
        MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement.getText() + "Using the MobileElement");

        //WebElement
        WebElement myElement1 = driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement1.getText() + "Using the WebElement");


        driver.findElement(myElement2).click();
        //myElement.click();
    }
}


// MobileElement, WebElement, By, MobileBy, @FindBy, @AndroidFindBy, @iOSXCUITFindBy