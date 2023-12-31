package com.loop.test.practice.day10;

import com.loop.test.utillites.ConfigurationReader;
import com.loop.test.utillites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_1 {
    /*
    1. Open a chrome browser
    2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
    3. Click and hold small circle
    4. Move it on top of the big circle
    5. validate “Now drop…” text appears on big circ
    */

    @Test
    public void task_1(){

        Driver.getDriver().get(ConfigurationReader.getProperty("task1_day10"));
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(smallCircle, bigCircle).perform();
        WebElement validateSign = Driver.getDriver().findElement(By.xpath("//div[@id='droptarget']"));
        System.out.println(validateSign.getText());
        String actual = validateSign.getText();
        String expected = "You did great!";
        Assert.assertEquals(actual, expected, " Not match");


    }
}
