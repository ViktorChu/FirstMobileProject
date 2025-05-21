package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppManager {
    AppiumDriver driver;
    DesiredCapabilities capabilities;
    MainScreenHelper mainScreen;
    RemindlyHelper remindly;

    public void init() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName","mob");
//        capabilities.setCapability("automationName","UIAutomator2");
        capabilities.setCapability("appPackage", "com.blanyal.remindly");
        capabilities.setCapability("appActivity", "com.blanyal.remindme.MainActivity");
        capabilities.setCapability("app","C:/mobil/remindly.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        mainScreen = new MainScreenHelper(driver);
        remindly = new RemindlyHelper(driver);
    }

    public MainScreenHelper getMainScreen() {
        return mainScreen;
    }

    public RemindlyHelper getRemindly() {
        return remindly;
    }

    public void stop() {
        driver.quit();
    }
}
