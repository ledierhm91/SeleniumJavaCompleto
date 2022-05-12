package CourseAppium.myCode.findElement;

import CourseAppium.myCode.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

import java.util.List;

public class AndroidUiAutomator {

    public static void main(String[] args) throws Exception{
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        MobileElement myElement = (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"Content\")");
        System.out.println(myElement.getText() + " Finding by text=Name");

        myElement = (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")");
        System.out.println(myElement.getText() + " Finding by className");

        myElement = (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiSelector().description(\"Graphics\")");
        System.out.println(myElement.getText() + " Finding by descripcion= TagName");

       List<MobileElement> myListElements = (List<MobileElement>) ((FindsByAndroidUIAutomator) driver).findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")");
       for (int i=0; i< myListElements.size(); i++){
           System.out.println(myListElements.get(i).getText() + " Finding by resourceId");
       }

    }
}
