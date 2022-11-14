package src;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class Appium {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> driver = null;
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("automationName", "uiautomator2");
            desiredCapabilities.setCapability("udid", "emulator-5554");
            desiredCapabilities.setCapability("appPackage", "com.wdiodemoapp");
            desiredCapabilities.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
            desiredCapabilities.setCapability("newCommandTimeout", 300);

            URL appiumSever = new URL("http://localhost:4723/wd/hub");
            driver = new AndroidDriver<>(appiumSever, desiredCapabilities);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (driver == null) {
            throw new RuntimeException("[ERR] Somehow, we couldn't construct Appium sever url");
        }
//        driver = new AndroidDriver<>(appiumSever, desiredCapabilities);
        Thread.sleep(3000);
    }
}
