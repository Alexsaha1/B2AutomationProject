package com.loop.test.practice.day3;

import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tasks_2 {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app/");

        WebElement usernameField = driver.findElement(By.xpath("//input[@id='input-14']"));
        String reslUsernameField = usernameField.getText();
        if (reslUsernameField.contains("")) {
            System.out.println(usernameField + " Passed");
        } else {
            System.out.println(usernameField + "Failed");
        }

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='input-15']"));
        String resulPasswordField = usernameField.getText();
        if (resulPasswordField.contains("")) {
            System.out.println(passwordField + " Passed");
        } else {
            System.out.println(passwordField + "Failed");
        }

        WebElement loginButton = driver.findElement(By.xpath("//span[@class='v-btn__content']"));
        loginButton.click();

        WebElement userNameOrEmailField = driver.findElement(By.xpath("//div[.='Username or email']"));
        String actualUserNameOrEmailField = userNameOrEmailField.getText();
        if (actualUserNameOrEmailField.contains("Username or email")) {
            System.out.println("Field U N OR Email" + " Passed");
        } else {
            System.out.println("Field U N OR Email" + "Failed");
        }


        driver.quit();

    }
}
