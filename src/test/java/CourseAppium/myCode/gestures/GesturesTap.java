package CourseAppium.myCode.gestures;

import CourseAppium.myCode.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GesturesTap {

    public static void main (String[] args) throws Exception{
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By app = MobileBy.AccessibilityId("App");
        By dialogOption = By.id("io.appium.android.apis:id/two_buttons");
        By okButton = By.id("android:id/button1");

        // Se crea el objeto para usar los gestos
        TouchAction t= new TouchAction(driver);

        // Hace tap al elemento buscado
      t.tap(ElementOption.element(driver.findElement(app))).perform();

        // hace tap al elemento buscando por su cordenada
        t.tap(PointOption.point(190,719)).perform();

        //
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElement(dialogOption)))).perform();

        WebDriverWait wait = new WebDriverWait(driver,10);
        t.tap(TapOptions.tapOptions().withElement(ElementOption.element(wait.until(ExpectedConditions.visibilityOfElementLocated(okButton))))).perform();



    }
}

//TAP, PRESS, LONGPRESS, WAITACTION, RELEASE, PERFORM, MOVETO
