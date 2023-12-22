package com.loop.test.practice.day3;

import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tasks_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com");
        System.out.println(driver.getTitle());

        WebElement search = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        search.sendKeys("wooden spoon");
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        Thread.sleep(1000);
        WebElement searchField = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        String displaysSearchField =searchField.getAttribute("value");
        if (displaysSearchField.contains("spoon")){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
        WebElement ima = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query' and @value='"+displaysSearchField+"']"));
        if (ima.isDisplayed()){
            System.out.println("Passed");
            System.out.println(ima.getAttribute("value"));
        } else {
            System.out.println("Failed");
        }
        System.out.println("--------------------------------------------------------");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


//        driver.quit();



    }
}
