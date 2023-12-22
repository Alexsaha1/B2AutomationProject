package com.loop.test.practice.day4;

import com.loop.test.utillites.DocuportConstants;
import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task_2_day_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app/");

        WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']"));
        emailInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-15"));
        passwordInput.sendKeys("Group1");

        WebElement ligInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        ligInButton.click();

        Thread.sleep(3000);

        List<WebElement> hrefValues = driver.findElements(By.xpath("//a"));
        for (WebElement each: hrefValues) {
            System.out.println(each.getAttribute("href"));
            System.out.println(each.getText());
        }
        System.out.println("hrefValues.size() = " + hrefValues.size());


        driver.quit();



    }
}
