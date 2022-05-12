package CourseAppium.myCode.waits;

import CourseAppium.myCode.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waits {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");


        By app = MobileBy.AccessibilityId("App");
        By alertDialogo = MobileBy.AccessibilityId("Alert Dialogs");
        By okDialogo = MobileBy.AccessibilityId("OK Cancel dialog with a message");
        By okButton = By.id("android:id/button1");

        driver.findElement(app).click();
        driver.findElement(alertDialogo).click();

        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(okDialogo)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(okButton)).click();

    }
}
