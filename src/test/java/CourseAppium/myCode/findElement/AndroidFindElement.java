package CourseAppium.myCode.findElement;

import CourseAppium.myCode.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AndroidFindElement {

    public static void main(String[] args) throws Exception {

        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementsById("android:id/text1").get(1);
        System.out.println(myElement.getText() + " Test");

        myElement = (MobileElement) driver.findElementByClassName("android.widget.TextView");
        System.out.println(myElement.getText() + "Class");

        myElement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"App\"]");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByName("Content");
        System.out.println(myElement.getText() + "Name");

        myElement = (MobileElement) driver.findElementByTagName("Graphics");
        System.out.println(myElement.getText() + "Tag name");


    }


}

