package CourseAppium.myCode.elementAction;

import CourseAppium.myCode.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

public class ElementBasicAction {

    public static void main (String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        By views = MobileBy.AccessibilityId("Views");
        By textFields = MobileBy.AccessibilityId("TextFields");
        By editText = MobileBy.id("io.appium.android.apis:id/edit");

        driver.findElement(views).click();


        // Codigo del scroll
        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(507, 1679))
                .moveTo(new PointOption().withCoordinates(520, 625))
                .release()
                .perform();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(494, 1713))
                .moveTo(new PointOption().withCoordinates(499, 560))
                .release()
                .perform();

        (new TouchAction(driver))
                .press(new PointOption().withCoordinates(503, 1713))
                .moveTo(new PointOption().withCoordinates(494, 525))
                .release()
                .perform();

        driver.findElement(textFields).click();
        driver.findElement(editText).sendKeys("Clara");
        Thread.sleep(3000);
        driver.findElement(editText).clear();

    }
}
