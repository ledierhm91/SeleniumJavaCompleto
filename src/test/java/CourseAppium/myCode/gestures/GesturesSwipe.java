package CourseAppium.myCode.gestures;

import CourseAppium.myCode.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GesturesSwipe {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = MobileBy.AccessibilityId("Views");


        TouchAction t = new TouchAction(driver);
        driver.findElement(views).click();

        // Para hacer scroll en la vista  una sola vez con posision
      /*  t.press(PointOption.point(507,1679))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(507,100)).release().perform();*/



        // Para hacer scroll en la vista  3 veces y tomando el tamaño de la pantalla
    /*    Dimension size = driver.manage().window().getSize();

        int startX = size.width /2;
        int endX = startX;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        System.out.println("Size de la pantalla " + size);
        System.out.println("start x " + startX);
        System.out.println("end x " + endX);
        System.out.println("start y " + startY);
        System.out.println("end y " + endY);

        for (int i = 0;i<3;i++){
            t.press(PointOption.point(startX,startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                    .moveTo(PointOption.point(endX,endY)).release().perform();
        }
*/

        // Deslizar la pantalla poniendo un elemento de inicio y uno de fin
        By grid = MobileBy.AccessibilityId("Grid");
        By animation = MobileBy.AccessibilityId("Animation");

        t.press(ElementOption.element(driver.findElement(grid)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(ElementOption.element(driver.findElement(animation))).release().perform();

        t.press(ElementOption.element(driver.findElement(animation))).perform();


    }

}
