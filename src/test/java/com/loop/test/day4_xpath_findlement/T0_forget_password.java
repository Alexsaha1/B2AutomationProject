package com.loop.test.day4_xpath_findlement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T0_forget_password {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        // create driver object
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app/login");

        WebElement forgetPasswordLink = driver.findElement(By.cssSelector("a[href='/reset-password']"));
        forgetPasswordLink.click();
Thread.sleep(5000);
        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class='login-layout__form']>h1"));
        System.out.println("forgetPasswordHeading = " + forgetPasswordHeading.getText());




    }
}
