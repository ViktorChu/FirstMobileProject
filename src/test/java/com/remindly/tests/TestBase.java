package com.remindly.tests;

import com.remindly.fw.AppManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class TestBase {
    protected AppManager app = new AppManager();


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        app.init();
        app.getMainScreen().confirm();
    }

    @AfterMethod(enabled = false)
    public void tearDown(){
        app.stop();
    }

}

/*{
        "platformName": "Android",
        "automationName": "UIAutomator2",
        "platformVersion": "10",
        "deviceName": "mob",
        "appPackage": "com.blanyal.remindly",
        "appActivity": "com.blanyal.remindme.MainActivity"
        }*/
