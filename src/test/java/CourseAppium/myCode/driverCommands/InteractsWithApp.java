package CourseAppium.myCode.driverCommands;

import CourseAppium.myCode.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import org.openqa.selenium.By;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class InteractsWithApp {

    public static void main(String[] args) throws Exception{
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.isAppInstalled("io.appium.android.apis"));

        // Se verifica si la app esta instalada -- si no esta se instala
        if (!driver.isAppInstalled("io.appium.android.apis")){
            String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator
                    + "resources" + File.separator + "ApiDemos-debug.apk";
                    driver.installApp(appUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());

        }

        // Codigo para abrir la app, se le pasa el package
        driver.activateApp("io.appium.android.apis");

        By views = MobileBy.AccessibilityId("Views");
        driver.findElement(views).click();
        Thread.sleep(5000);
        driver.terminateApp("io.appium.android.apis");



    }
}
