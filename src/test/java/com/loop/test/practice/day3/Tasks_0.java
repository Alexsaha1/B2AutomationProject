package com.loop.test.practice.day3;

import com.loop.test.utillites.LoopCampConstants;
import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tasks_0 {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://loopcamp.vercel.app/forgot-password.html");

        WebElement forgotPassword = driver.findElement(By.tagName("h2"));
        String actualFagotPassword = forgotPassword.getText();

        if (actualFagotPassword.equals(LoopCampConstants.EXPECTED_TITLE_FORGOT_PASSWORD)) {
            System.out.println(actualFagotPassword + " - Test Passed");
        }else {
            System.out.println(actualFagotPassword + " - Test Failed");
        }

        WebElement labelEmail = driver.findElement(By.cssSelector("#forgot_password > div > div > label"));
        String actualLabelEmail = labelEmail.getText();

        if (actualLabelEmail.equals(LoopCampConstants.EXPECTED_LABEL_EMAIL)){
            System.out.println(actualLabelEmail+ " - Test Passed");
        }else{
            System.out.println(actualLabelEmail + " - Test Failed");
        }

        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("aliaksandr.kur@gmail.com");
        String enteredEmail = emailInput.getAttribute("value");

        if ("aliaksandr.kur@gmail.com".equals(enteredEmail)){
            System.out.println(enteredEmail + " - Test Passed");
        }else{
            System.out.println(enteredEmail + " - Test Failed");
        }

        WebElement retrievePassword = driver.findElement(By.cssSelector("#form_submit > i"));
        String actualRetrievePassword = retrievePassword.getAttribute("textContent");

        if (actualRetrievePassword.equals("Retrieve password")){
            System.out.println(actualRetrievePassword + " - Test Passed");
        }else {
            System.out.println(actualRetrievePassword + " - Test Failed");
        }

        WebElement poweredBy = driver.findElement(By.cssSelector("#page-footer > div > div"));
        String actualPoweredBy = poweredBy.getText();

        if (actualPoweredBy.equals("Powered by LOOPCAMP")){
            System.out.println(actualPoweredBy + " - Test Passed");
        }else {
            System.out.println(actualPoweredBy + " - Test Failed");
        }

        driver.quit();

    }

}
