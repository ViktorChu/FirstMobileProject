package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class RemindlyHelper extends BaseHelper{

    public RemindlyHelper(AppiumDriver driver) {
        super(driver);
    }

    public void tapOnAddReminder() {
        tap(By.id("add_reminder"));
    }

    public void enterTitle(String title) {
        type(By.id("reminder_title"),title);
    }

    public void saveReminder() {
        tap(By.id("save_reminder"));
    }

    public void tapOnHamburgerMenu() {
        tap(By.className("android.widget.ImageView"));
    }

    public void tapOnLicenses() {
        tap(By.className("android.widget.LinearLayout"));
    }
}
