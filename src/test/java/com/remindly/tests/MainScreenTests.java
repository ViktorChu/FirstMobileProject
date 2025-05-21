package com.remindly.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MainScreenTests extends TestBase{
    @Test
    public void appLaunchTest(){
        //verify text is displayed
        Assert.assertTrue(app.getMainScreen().isNoReminderTextPresent());
    }

    @Test
    public void lisencesTest(){
        app.getRemindly().tapOnHamburgerMenu(); // локатор class name - android.widget.ImageView
        app.getRemindly().tapOnLicenses(); // локатор class name - android.widget.LinearLayout
//
        Assert.assertTrue(app.getMainScreen().isLicensesPresent().contains("NOTICES"));  //локатор id - licenses_text_view
    }
}
