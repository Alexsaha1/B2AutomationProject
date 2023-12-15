package com.loop.test.practice.self;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Prosto {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver chromeDriver = new ChromeDriver();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
        WebDriver driver = chromeDriver;
        driver.manage().window().maximize();

        driver.get("https://www.itseasy.com/");
        driver.getTitle();
        System.out.println("Web Title = " + driver.getTitle());



//            WebElement itsEasySign = driver.findElement(By.xpath(""));

        WebElement PP = driver.findElement(By.xpath("//a[@href='/photoappweb/passportPhoto/']"));
        PP.click();

        WebElement PS = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-block btn-main js-photo-app-web-navigator']"));
        PS.click();
        Thread.sleep(3000);
        WebElement lGs = driver.findElement(By.xpath("//div[@class='col-12 col-md-4']"));       //  ---> ????
        lGs.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText() + " - Alert text");
        alert.accept();







        //driver.quit();
    }
}
