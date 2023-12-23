package com.loop.test.practice.utillites2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DevthetaUtils {
    /**
     * logins to the devtheta.vision.itseasy application
     * @param driver
     * @author alex
     */

    public static void login(WebDriver driver){
        driver.get("https://devtheta.vision.itseasy.nyc/user");
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement pin = driver.findElement(By.xpath("//input[@name='pin']"));
        WebElement signInButton = driver.findElement(By.xpath("//input[@name='login']"));

        userName.sendKeys(DevthetaVisionConstants.USERNAME);
        password.sendKeys(DevthetaVisionConstants.PASSWORD);
        pin.sendKeys(DevthetaVisionConstants.PIN);
        signInButton.click();

    }


}
