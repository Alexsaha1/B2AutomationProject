package com.loop.test.practice.day4;

import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_1_day_4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app/");

        WebElement emailInput =driver.findElement(By.xpath("//input[@type='text']"));
        emailInput.sendKeys("b1g1_client@gmail.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys("Group1");

        WebElement ligInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        ligInButton.click();
        Thread.sleep(5000);
        WebElement continueButton = driver.findElement(By.xpath("//span[contains(text(),'Continue')]/parent::button"));
        continueButton.click();
        WebElement burgerButton = driver.findElement(By.xpath("//i[@class='v-icon notranslate mdi mdi-menu theme--light']"));
        burgerButton.click();

        WebElement menu = driver.findElement(By.xpath("//div[@class='menu mr-2']"));
        menu.isDisplayed();

        if (menu.isDisplayed()) {
            System.out.println("GOOD");
        }else {
            System.out.println("NOT DISPLAYED");
        }

        driver.quit();
    }
}
