package com.loop.test.practice.day5;

import com.loop.test.utillites.DocuportConstants;
import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task_3_day_5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app");
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-14']"));
        userName.sendKeys(DocuportConstants.USERNAME_ADVISOR);

        WebElement passwordAdvisor = driver.findElement(By.xpath("//input[@id='input-15']"));
        passwordAdvisor.sendKeys(DocuportConstants.ADVISOR_PASSWORD);

        WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        logInButton.click();

        Thread.sleep(3000);
        WebElement receivedDocuments = driver.findElement(By.xpath("//h2[contains(text(),'Received ')]"));
        receivedDocuments.click();

        Thread.sleep(3000);
        WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
        searchButton.click();

        Thread.sleep(3000);
        WebElement statusField = driver.findElement(By.xpath("//div[@aria-owns='list-337']"));
        statusField.click();

        WebElement inProgress = driver.findElement(By.xpath("//div[contains(text(),'In progress')]"));
        inProgress.click();

        WebElement statusField2 = driver.findElement(By.xpath("//label[@for='input-337']/following-sibling::div"));
        System.out.println(statusField2.getText());
        driver.quit();




    }
}
