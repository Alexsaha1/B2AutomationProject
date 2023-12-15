package com.loop.test.practice.day6;

import com.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Task_2_day_6 extends TestBase {
    /*
    1. go to https://demoqa.com/nestedframes
2. Validate "Child Iframe" text
3. Validate "Parent Iframe" text
4. Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."

     */

    @Test
    public void Task_2_day_6(){
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
        WebElement aaa = driver.findElement(By.xpath("//p[contains(text(),'Child Iframe')]"));
        System.out.println(aaa.getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        WebElement bbb = driver.findElement(By.xpath("//*[contains(text(),'Parent frame')]"));
        System.out.println(bbb.getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());


        //  driver.switchTo().frame("//p[contains(text(),'Child Iframe')]");

//        WebElement textChildIframe = driver.findElement(By.xpath("//p[contains(text(),'Child Iframe')]"));
//        System.out.println(textChildIframe.getText());


    }
}
