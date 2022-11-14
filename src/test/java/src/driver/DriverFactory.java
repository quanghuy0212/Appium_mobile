package src.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static src.driver.MobileCapabilityTypeEx.APP_ACTIVITY;
import static src.driver.MobileCapabilityTypeEx.APP_PACKAGE;

public class DriverFactory implements MobileCapabilityType {
    public static AppiumDriver<MobileElement> getDriver(Platform platform) throws InterruptedException {
        AppiumDriver<MobileElement> driver ;

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(AUTOMATION_NAME, "uiautomator2");
        desiredCapabilities.setCapability(UDID, "emulator-5554");
        desiredCapabilities.setCapability(APP_PACKAGE, "com.wdiodemoapp");
        desiredCapabilities.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");
        desiredCapabilities.setCapability("newCommandTimeout", 300);
        URL appiumSever = null;
        try {
            appiumSever = new URL("http://localhost:4723/wd/hub");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (appiumSever == null) {
            throw new RuntimeException("[ERR] Somehow, we couldn't construct Appium sever url");
        }
        switch (platform) {
            case ANDROID:
                driver = new AndroidDriver<>(appiumSever, desiredCapabilities);
                break;
            case IOS:
                driver = new IOSDriver<>(appiumSever, desiredCapabilities);
            default:
                throw new IllegalArgumentException("Platform type can't be null");
        }

        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
//        driver.quit();
        return driver;
    }
}
