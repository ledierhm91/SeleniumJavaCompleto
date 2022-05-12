package CourseAppium.teacherCode;

import CourseAppium.myCode.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AndroidFindElements {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        MobileElement myElement = (MobileElement) driver.findElementByAccessibilityId("Accessibility");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementsById("android:id/text1").get(1);
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementsByClassName("android.widget.TextView").get(2);
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Accessibility\"]");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByXPath("//*[@text=\"Accessibility\"]");
        System.out.println(myElement.getText());

        myElement = (MobileElement) driver.findElementByTagName("Accessibility");
        System.out.println(myElement.getText());

    }
}
