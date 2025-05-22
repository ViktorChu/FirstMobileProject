package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RemindlyHelper extends BaseHelper {

    public RemindlyHelper(AppiumDriver driver) {
        super(driver);
    }

    public void tapOnAddReminder() {
        tap(By.id("add_reminder"));
    }

    public void enterTitle(String title) {
        type(By.id("reminder_title"), title);
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

    public void tapOnDateField() {
        tap(By.id("date"));
    }

    public void swipeToMonth(String period, int number, String month) {
        pause(500);

        if (!getSelectedMoth().equals(month)) {
            for (int i = 0; i < number; i++) {
                if (period.equals("future")) {
                    swipe(0.8, 0.4);
                } else if (period.equals("past")) {
                    swipe(0.5, 0.9);
                }
            }
        }
    }

    private String getSelectedMoth() {
        return getString(By.id("date_picker_month"));
    }

    public void selectDate(int index) {
        List<WebElement> days = driver.findElements(By.className("android.view.View"));
        days.get(index).click();

    }

    public void tapToYear() {
        tap(By.id("date_picker_year"));
    }

    public void swipeToYear(String period, String year) {
        pause(500);

        if (!getSelectedYear().equals(year)) {
            if (period.equals("future")) {
                swipeUntilNeededYear(year, 0.6, 0.5);
            } else if (period.equals("past")) {
                swipeUntilNeededYear(year, 0.5, 0.6);
            }
        }
        tap(By.id("month_text_view"));
    }

    private void swipeUntilNeededYear(String year, double start, double stop) {
        while (!getYear().equals(year)){
            swipeInElement(By.className("android.widget.ListView"),start,stop);
        }
        getYear();
    }

    private String getYear() {
        return getString(By.id("month_text_view"));
    }

    private String getSelectedYear() {
        return getString(By.id("date_picker_year"));
    }


    public void tapOnOk() {
        tap(By.id("ok"));
    }

    public void selectTime(String timeOfDay, int xHour, int yHour, int xMin, int yMin) {
        pause(2000);
        if (timeOfDay.equals("AM")){
            tapWithCoordinates(280,1327);
        }else if (timeOfDay.equals("PM")){
            tapWithCoordinates(800,1330);
        }

        pause(1000);
        tapWithCoordinates(xHour,yHour);
        tapWithCoordinates(xMin,yMin);
    }

    public void tapOnRepeatSwitch() {

        tap(By.id("repeat_switch"));
    }

    public void tapOnRepetitionInterval() {
        tap(By.id("RepeatNo"));
    }

    public void enterRepeatQuantity(String numberOfRepeat) {
        type(By.className("android.widget.EditText"),numberOfRepeat);
        tap(By.id("android:id/button1"));
    }
}
