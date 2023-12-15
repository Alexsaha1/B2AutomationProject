package com.loop.test.practice.day7;

import com.loop.test.base.TestBase;
import com.loop.test.utillites.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class Task_2 extends TestBase {
    /*
       1. go to https://loopcamp.vercel.app/
    2. click "Multiple Windows" link
    3. Validate "Powered by Loopcamp" is displayed
    4. Validate title is "Windows"
    5. Click - click here
    6. Switch to new window and validate title
     */

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/");
        WebElement multipleWindows = driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]"));
        multipleWindows.click();
        WebElement poweredBy = driver.findElement(By.xpath("//div[contains(text(),'Powered by ')]"));
        WebElement loopCamp = driver.findElement(By.xpath("//a[contains(text(),'LOOPCAMP')]"));
        System.out.println(loopCamp.isDisplayed() + " - "+ loopCamp.getText() + "\n" + poweredBy.isDisplayed() + " - " + poweredBy.getText());

        System.out.println("Title - " + driver.getTitle());

        WebElement clickHere = driver.findElement(By.xpath("//a[@href='windows/new.html']"));
        System.out.println(clickHere.isDisplayed() + " - " + clickHere.getText());
        clickHere.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String each : windowHandles) {
            System.out.println("each window's handle = " + each);
            driver.switchTo().window(each);
        }

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("------------------------------------------------------");

        WebElement newWindow = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
        System.out.println(newWindow.isDisplayed() + " - " + newWindow.getText());
        BrowserUtils.switchWindowAndValidate(driver, "https://loopcamp.vercel.app/windows.html", "Windows");


        WebElement clickHere2 = driver.findElement(By.xpath("//a[@href='windows/new.html']"));
        System.out.println(clickHere2.isDisplayed() + " - " + clickHere2.getText());
        clickHere2.click();

        Set<String> windowHandles2 = driver.getWindowHandles();

        for (String each : windowHandles2) {
            System.out.println("each window's handle = " + each);
            driver.switchTo().window(each);
        }

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("------------------------------------------------------");

        BrowserUtils.switchWindowAndValidate(driver, "https://loopcamp.vercel.app/windows.html", "Windows");
        driver.close();

    }

}
