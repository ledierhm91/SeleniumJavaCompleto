package CourseAppium.myCode.gestures;

import CourseAppium.myCode.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GesturesPressAndLongPress {

    public static void main (String[] args) throws Exception{
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By app = MobileBy.AccessibilityId("App");
        By alertDialogo = MobileBy.AccessibilityId("Alert Dialogs");
        By dialogOption = By.id("io.appium.android.apis:id/two_buttons");

        TouchAction t = new TouchAction(driver);

        // Press --Solo mantiene presionado el elemento
        t.press(ElementOption.element(driver.findElement(app))).perform();

        // Realease --  presiona el elemento y hace la accion del tap
        t.press(ElementOption.element(driver.findElement(app))).release().perform();

        //Longpress  --- si queremos decirle que espere un tiempo antes de hacer la accion tap
        t.longPress(ElementOption.element(driver.findElement(alertDialogo))).release().perform();

        //Longpress usando el WaitAction--- si queremos decirle que espere un tiempo en especifico antes de hacer la accion tap
        t.longPress(ElementOption.element(driver.findElement(dialogOption)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000))).release().perform();




    }
}
