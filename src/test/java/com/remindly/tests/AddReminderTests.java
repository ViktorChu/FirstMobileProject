package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReminderTests extends TestBase {

    @Test
    public void addReminderTitlePositiveTest() {
        app.getRemindly().tapOnAddReminder();
        app.getRemindly().enterTitle("Holiday");
        app.getRemindly().saveReminder();

        Assert.assertTrue(app.getMainScreen().isReminderPresent().contains("Holiday"));

    }

    @Test
    public void addReminderTimePositiveTest() {
        app.getRemindly().tapOnAddReminder();
        app.getRemindly().enterTitle("Holiday");
        app.getRemindly().selectTime("PM", 544, 1208, 544, 660); //координаты кнопок АМ 280,1327, РМ 800,1330, в методе координаты времени 6:00
        app.getRemindly().tapOnOk();
        app.getRemindly().saveReminder();

        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("18:00"));

    }

    @Test
    public void addReminderDatePositiveTest() {
        app.getRemindly().tapOnAddReminder();
        app.getRemindly().enterTitle("Holiday");
        app.getRemindly().tapOnDateField();
        app.getRemindly().swipeToMonth("future", 3, "AUG"); //date_picker_month
        app.getRemindly().selectDate(0);
        app.getRemindly().tapToYear(); //date_picker_year
        app.getRemindly().swipeToYear("future", "2027"); // android.widget.TextView - класс
        app.getRemindly().tapOnOk();
        app.getRemindly().saveReminder();

        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("1/8/2027")); // recycle_date_time,

    }

    @Test
    public void addReminderRepeatOffTest() {
        app.getRemindly().tapOnAddReminder();
        app.getRemindly().enterTitle("Repeat Off");
        app.getRemindly().tapOnRepeatSwitch(); // id - repeat_switch
        app.getRemindly().saveReminder();

        Assert.assertTrue(app.getMainScreen().isReminderPresent().contains("Repeat Off"));
    }

    @Test
    public void addReminderRepeatitionInterval(){
        app.getRemindly().tapOnAddReminder();
        app.getRemindly().enterTitle("Repetition Interval");
        app.getRemindly().tapOnRepetitionInterval(); // id - RepeatNo
        app.getRemindly().enterRepeatQuantity("3");// className android.widget.EditText, id OK - android:id/button1

        app.getRemindly().saveReminder();

        Assert.assertTrue(app.getMainScreen().isRepeatPresent().contains("Every 3"));  // id - set_repeat_no
    }
}


