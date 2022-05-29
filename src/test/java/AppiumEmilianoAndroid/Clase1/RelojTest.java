package AppiumEmilianoAndroid.Clase1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class RelojTest {

    public static AndroidDriver driver;

    public static void main(String args[]) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("udid", "RF8R60DRBYY");
        //caps.setCapability("udid", "emulator-5554");
        caps.setCapability("appPackage", "com.sec.android.app.clockpackage");
        caps.setCapability("appActivity", "com.sec.android.app.clockpackage.ClockPackage");

        //caps.setCapability("appPackage", "com.android.contacts");
        //caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);


    }

}
