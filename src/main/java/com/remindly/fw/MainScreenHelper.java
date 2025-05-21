package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainScreenHelper extends BaseHelper{

    public MainScreenHelper(AppiumDriver driver) {
        super(driver);
    }

    public boolean isNoReminderTextPresent() {
        return isElementPresent(By.id("add_reminder"));
    }

    public void confirm() {
        tap(By.id("android:id/button1"));
    }

    public String isReminderPresent() {
        return driver.findElement(By.id("recycle_title")).getText();
    }

    public String isLicensesPresent() {
        return driver.findElement(By.id("licenses_text_view")).getText();
    }
}
