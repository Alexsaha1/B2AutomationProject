package com.loop.test.practice.day6;

import com.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_1_day_6 extends TestBase {
    /*
    1. go to https://demoqa.com/alerts
2. click - click button to see alert
3. handle alert
4. click - On button click, alert will appear after 5 seconds
5. handle alert
6. click - On button click, confirm box will appear
7. click ok and validate - You selected Ok
8. after that do it again this time cancel and validate - You selected Cancel
9. click - On button click, prompt box will appear
10. enter "Loop Academy" and validate You entered Loop Academy
     */


    @Test
    public void task1_day6() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");  // 1
        WebElement clickButtonToSeeAlerts = driver.findElement(By.xpath("//button[@id='alertButton']"));
        clickButtonToSeeAlerts.click();           //  2
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();                          //  3

        WebElement onButtonClickAlertWillAppearAfter5Second = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        onButtonClickAlertWillAppearAfter5Second.click();  //  4
        Thread.sleep(5000);
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();                          //  5

        WebElement onButtonClickConformBoxWillAppear = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        onButtonClickConformBoxWillAppear.click();  //  6
        Alert alert3 = driver.switchTo().alert();
        alert3.accept();                            //  7

        WebElement onButtonClickConformBoxWillAppear2 = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        onButtonClickConformBoxWillAppear2.click();  //  8
        Alert alert3a = driver.switchTo().alert();
        alert3a.dismiss();                            //  8

        WebElement youSelectedCancel = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        String expected = "You selected Cancel";
        String actual = youSelectedCancel.getText();
        Assert.assertEquals(actual, expected, "TestFailed");  //  8

        WebElement onButtonClickPromptBoxWillApper = driver.findElement(By.xpath("//button[@id='promtButton']"));
        onButtonClickPromptBoxWillApper.click();  //  9
        Alert alert4 = driver.switchTo().alert();
        alert4.sendKeys("Loop Academy");  //  10
        alert4.accept();

        WebElement youEnteredLoopAcademy = driver.findElement(By.xpath("//span[@id='promptResult']"));
        String expected2 = "You entered Loop Academy";
        String actual2 = youEnteredLoopAcademy.getText();
        Assert.assertEquals(actual2, expected2, "TestFailed");

    }
}
