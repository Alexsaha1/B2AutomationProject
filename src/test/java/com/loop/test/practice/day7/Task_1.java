package com.loop.test.practice.day7;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_1 extends TestBase {

    /*
    go to https://loopcamp.vercel.app/nested-frames.html
    validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"

     */

    @Test
    public void left(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]"));
        System.out.println(left.getText() + " - actualLeft");
        String actualLeft = left.getText();
        Assert.assertEquals(actualLeft.trim(), "LEFT", "not");

    }

    @Test
    public void right(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]"));
        System.out.println(right.getText() + " - actualRight");
        String actualRight = right.getText();
        Assert.assertEquals(actualRight.trim(), "RIGHT");

    }

    @Test
    public void middle(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//*[contains(text(),'MIDDLE')]"));
        System.out.println(middle.getText() + " - actualMiddle");
        String actualMiddle = middle.getText();
        Assert.assertEquals(actualMiddle.trim(), "MIDDLE");

    }

    @Test
    public void bottom(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.switchTo().frame("frame-bottom");
        WebElement bottom = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]"));
        System.out.println(bottom.getText() + " - actualBottom");
        String actualBottom = bottom.getText();
        Assert.assertEquals(actualBottom.trim(), "BOTTOM");

    }

}
