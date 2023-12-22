package com.loop.test.practice.day3;

import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tasks_3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement gmail = driver.findElement(By.xpath("//a[text()='Gmail']"));
        gmail.click();

        WebElement gmailSign = driver.findElement(By.xpath("//span[@class='mobile-before-hero-only']"));
        String actualGmailSign = gmailSign.getText();
        if (actualGmailSign.contains("Gmail")){
            System.out.println("Gmail Passed");
        }else {
            System.out.println("Gmail Failed");
        }

        driver.navigate().back();

        WebElement gmailSign2 = driver.findElement(By.xpath("//a[text()='Gmail']"));
        String actualGmailSign2 = gmailSign2.getText();
        if (actualGmailSign2.contains("Gmail")){
            System.out.println("Gmail Passed");
        }else {
            System.out.println("Gmail Failed");
        }

        driver.quit();

    }
}
