package com.loop.test.practice.day5;

import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_1_day_5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");

        WebElement dropDown = driver.findElement(By.xpath("//option[contains(text(),'Please')]"));
        dropDown.isDisplayed();
        if (dropDown.isDisplayed()){
            System.out.println(dropDown.getText() + " = selected by default.");
        } else {
            System.out.println(dropDown + " Not selected by default.");
        }
        WebElement dropDownButton = driver.findElement(By.xpath("//select[@id='dropdown']"));
        dropDownButton.click();

        WebElement option1 = dropDownButton.findElement(By.xpath("//option[@value='1']"));
        option1.click();

        WebElement option1Displayed = driver.findElement(By.xpath("//option[contains(text(),'Option 1')]"));
        option1Displayed.isDisplayed();
        if (option1Displayed.isDisplayed()){
            System.out.println(option1Displayed.getText() + " = Option 1 is Displayed");
        } else {
            System.out.println(option1Displayed + " = Not Displayed Option 1");
        }
        WebElement dropDownButton2 = driver.findElement(By.xpath("//option[contains(text(),'Option 1')]"));
        Thread.sleep(3000);
        dropDownButton2.click();
        WebElement option2 = driver.findElement(By.xpath("//option[@value='2']"));
        option2.click();

        option2.isDisplayed();
        if (option2.isDisplayed()){
            System.out.println(option2.getText() + " = Option 2");
        }else {
            System.out.println(option2.getText() + " = Not Displayed Option 2");
        }

        WebElement dropDownList = dropDown.findElement(By.xpath("//h3[contains(text(),'Dropdown List')]"));
        dropDownList.isDisplayed();
        if (dropDown.isDisplayed()){
            System.out.println(dropDownList.getText() + " =  is Displayed");
        }else {
            System.out.println(dropDownList.getText() + " =  Not Displayed");
        }
        driver.quit();



    }
}
