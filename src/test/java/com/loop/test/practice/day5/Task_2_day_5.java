package com.loop.test.practice.day5;

import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Task_2_day_5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.etsy.com/");
        WebElement searchField = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        searchField.sendKeys("rings");

        WebElement enterButton = driver.findElement(By.xpath("//button[@type='submit' and @value='Search']"));
        enterButton.click();

        WebElement estimatedArrival = driver.findElement(By.xpath("//main[@id='content']//*[contains(text(),'Estimated Arrival')]/span"));
        System.out.println("Estimaited arrival shows = " + estimatedArrival.getText());
        estimatedArrival.click();

        WebElement radioButtonAnyTime = driver.findElement(By.xpath("//label[@for='edd-any-radio-input-tf']"));
        System.out.println("Radio button Any time is selected - " + radioButtonAnyTime.getText() + " " + radioButtonAnyTime.isSelected());

        WebElement radioButtonCustomDate = driver.findElement(By.xpath("//label[@for='edd-custom-radio-input-tf']"));
        System.out.println("Radio button Custom date is selected - " + radioButtonCustomDate.getText() + " " + radioButtonCustomDate.isSelected());
        System.out.println("Radio button Custom date is enabled  - " + radioButtonCustomDate.getText() + " " + radioButtonCustomDate.isEnabled());
        radioButtonCustomDate.click();

        WebElement selectCustomDateButton = driver.findElement(By.xpath("//select[@id='edd_select_tf']"));
        Select select = new Select(selectCustomDateButton);

        select.selectByVisibleText("By Dec 17");

        WebElement estimatedArrival1 = driver.findElement(By.xpath("//main[@id='content']//*[contains(text(),'Estimated Arrival')]/span"));
        System.out.println("Estimaited arrival shows = " + estimatedArrival1.getText());



        driver.quit();
    }
}
