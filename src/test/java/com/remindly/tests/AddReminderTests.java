package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReminderTests extends TestBase{

    @Test
    public void addReminderTitlePositiveTest(){
        app.getRemindly().tapOnAddReminder();
        app.getRemindly().enterTitle("Holiday");
        app.getRemindly().saveReminder();

        Assert.assertTrue(app.getMainScreen().isReminderPresent().contains("Holiday"));

    }

    @Test
    public void addReminderDatePositiveTest(){
        app.getRemindly().tapOnAddReminder();
        app.getRemindly().enterTitle("Holiday");
/*        app.getRemindly().tapOnDateField();
        app.getRemindly().swipeToMonth("future",3,"AUG");
        app.getRemindly().selectDate();
        app.getRemindly().tapToYear();
        app.getRemindly().swipeToYear();
        app.getRemindly().tapOnOk();*/
        app.getRemindly().saveReminder();

//        Assert.assertTrue(app.getMainScreen().isReminderDatePresent().contains("Holiday"));

    }
}

/*
date - тап на дату
date_picker_month - месяц
date_picker_year
android.widget.TextView - класс
ok


*/
