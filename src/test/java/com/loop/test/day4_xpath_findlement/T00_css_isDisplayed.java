package com.loop.test.day4_xpath_findlement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T00_css_isDisplayed {
    /*
   http://the-internet.herokuapp.com/forgot_password
    */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/forgot_password");

        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));

        System.out.println(forgetPasswordHeading.isDisplayed());

        if(forgetPasswordHeading.isDisplayed()){
            System.out.println("Forget password heading is displayed");
        } else {
            System.out.println("Forget password heading is NOT displayed");
        }




    }
}
