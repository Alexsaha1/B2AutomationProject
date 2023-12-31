package com.loop.test.practice.day10;

import com.loop.test.utillites.ConfigurationReader;
import com.loop.test.utillites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_2 {
    /*
    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. Dropped anywhere outside of big circle
    5. validate “Try again!” text appears on big circle
     */

    @Test
    public void test_2(){

        Driver.getDriver().get(ConfigurationReader.getProperty("task1_day10"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement any = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'LOOPCAMP')]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle, any).perform();
        WebElement validateSign = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        System.out.println(validateSign.getText());
        String actual = validateSign.getText();
        String expected = "Try again!";
        Assert.assertEquals(actual, expected, " Not match");



    }
}
