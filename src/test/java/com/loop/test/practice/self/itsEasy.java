package com.loop.test.practice.self;

import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class itsEasy {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.devtheta.itseasy.nyc/");
        System.out.println("ItsEasy Title = " + driver.getTitle());

        WebElement sign = driver.findElement(By.xpath("//section//*[contains(text(),'Need a Passport, Travel Visa, or Immigration Consultation?')]"));
        if (sign.isDisplayed()){
            System.out.println("Passed");
            System.out.println(sign.getText());
        }
        WebElement selectNationality = driver.findElement(By.xpath("//span[@role='textbox']"));
        selectNationality.click();

        WebElement unitedStates = driver.findElement(By.xpath("//option[@value='USA']"));
        unitedStates.click();
        if (unitedStates.isDisplayed()){
            System.out.println("Passed");
            System.out.println(unitedStates.getText());
        }

        WebElement selectState = driver.findElement(By.xpath("//select[@name='statechoice']"));
        selectState.click();


    }
}
