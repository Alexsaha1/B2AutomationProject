package com.loop.test.practice.self;

import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ItsEasy3 {
    WebDriver driver;
    String expected;
    String actual;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void TearDown(){
//        driver.close();
    }

    @Test
    public void itsEasy(){
        driver.get("https://www.devtheta.itseasy.nyc/photoappweb/passportPhoto/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Actions actions = new Actions(driver);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,600)", "");
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        WebElement digitalDelivery = driver.findElement(By.linkText("Digital Delivery"));
        actions.moveToElement(digitalDelivery).build().perform();
        digitalDelivery.click();

        WebElement letsGetStarted = driver.findElement(By.xpath("//input[@name='pageReferer']"));

        letsGetStarted.click();

    }
}
