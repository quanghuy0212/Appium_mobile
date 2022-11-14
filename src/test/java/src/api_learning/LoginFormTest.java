package src.api_learning;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.driver.DriverFactory;
import src.driver.Platform;

import java.sql.Driver;

public class LoginFormTest {
    public static void main(String[] args) throws InterruptedException {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platform.ANDROID);
        try {
            MobileElement navLogin = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            navLogin.click();
            WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);

            MobileElement emailField = appiumDriver.findElement(MobileBy.AccessibilityId("input-email"));
            MobileElement passwordField = appiumDriver.findElement(MobileBy.AccessibilityId("input-password"));
            MobileElement loginButton = appiumDriver.findElement(MobileBy.AccessibilityId("button-LOGIN"));

            emailField.sendKeys("quanghuy021299@gmail.com");
            passwordField.sendKeys("12345678");
            loginButton.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("android:id/alertTitle")));
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
