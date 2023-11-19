package com.loop.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
// setting up the web driver
        WebDriverManager.chromedriver().setup();

        // create an instance of webdriver
        WebDriver driver = new ChromeDriver();

        // navigate to web page
        driver.get("https://www.loopcamp.io");
 */
public class NavigateToAmazon {
    public static void main(String[] args) throws InterruptedException {
 /*
    navigate to amazon
    maximize
    navigate back
    navigate forward
    refresh
     */
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        Thread.sleep(5000);

        driver.get("https://www.loopcamp.io");
        driver.manage().window().maximize();
        driver.close();

    }
}
