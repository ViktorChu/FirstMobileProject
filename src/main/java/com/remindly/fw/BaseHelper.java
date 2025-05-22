package com.remindly.fw;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class BaseHelper {

    AppiumDriver driver;
    TouchAction touchAction;

    public BaseHelper(AppiumDriver driver) {
        this.driver = driver;
        touchAction = new TouchAction((PerformsTouchActions) driver);
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            tap(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
        driver.navigate().back(); // системная кнопка back(назад)
    }
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void swipe(double start, double stop){

        Dimension size=driver.manage().window().getSize(); // выбрать Dimention.silenium, в подсказке их 2 Dimention-а

        int x = size.getWidth() / 2;// делим на 2 для свайпа посередине

        int startY = (int) (size.getHeight() * start);
        int stopY = (int) (size.getHeight() * stop);

        touchAction.longPress(PointOption.point(x,startY))
                .moveTo(PointOption.point(x,stopY))
                .release().perform();
    }

    public void swipeInElement(By locator, double start, double stop){
        Dimension size=driver.manage().window().getSize();

        //get activity point
        int startY = (int) (size.height * start);
        int stopY = (int) (size.height * stop);

        //get locator point
        WebElement element = driver.findElement(locator);
        int leftX = element.getLocation().getX();// левая точка
        int rightX = leftX + element.getSize().getWidth(); // правый точка

        int middleX=(leftX+rightX)/2;

        touchAction.longPress(PointOption.point(middleX,startY))
                .moveTo(PointOption.point(middleX,stopY))
                .release().perform();

    }

    public String getString(By locator) {
        return driver.findElement(locator).getText();
    }

    public void tapWithCoordinates(int x, int y){
        touchAction.tap(PointOption.point(x,y))
                .release().perform();
    }
}
