package com.loop.test.practice.day3;

import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tasks_1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://beta.docuport.app/");

        WebElement emailInput = driver.findElement(By.id("input-14"));
        emailInput.sendKeys("b1g1_client@gmail.com");
        String enteredEmail = emailInput.getAttribute("value"); // Changed "type" to "value"

        if ("b1g1_client@gmail.com".equals(enteredEmail)){
            System.out.println(enteredEmail + " - Test Passed");
        }else{
            System.out.println(enteredEmail + " - Test Failed");
        }

        WebElement passwordInput = driver.findElement(By.cssSelector("#input-15"));
        passwordInput.sendKeys("Group1");
        String enteredPassword = passwordInput.getAttribute("value");

        if (enteredPassword.equals(enteredPassword)){
            System.out.println(enteredPassword + " - Test Passed");
        }else{
            System.out.println(enteredPassword + " - Test Failed");
        }
        WebElement button = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div/section/div/div[2]/div/div/form/div/div[4]/button"));
        button.click();
        Thread.sleep (5000);
        WebElement buttonContinue = driver.findElement(By.xpath("//span[contains(text(),'Continue')]/parent::button"));
        buttonContinue.click();

        WebElement logInSign = driver.findElement(By.xpath("//span[contains(text(),'Batch1 Group1')]"));
        String displaysLoginSign = logInSign.getText();
        if (displaysLoginSign.contains("Batch1 Group1")){
            System.out.println(displaysLoginSign + "Test Passed");
        }else {
            System.out.println(displaysLoginSign + "Failed");
        }
        WebElement profileButton = driver.findElement(By.xpath("//button[@type='button' and @class='pa-0 v-btn v-btn--rounded v-btn--text theme--light v-size--default gray--text']"));
        profileButton.click();

        WebElement logOutButton = driver.findElement(By.xpath("//div[@id='list-item-152']"));
        logOutButton.click();
        Thread.sleep (2000);
        WebElement loginPage = driver.findElement(By.xpath("//h1[contains(text(),'Login')]"));
        String verifyLoginPage = loginPage.getText();
        if (verifyLoginPage.contains("Login")){
            System.out.println(verifyLoginPage + "Test Passed");
        }else {
            System.out.println(verifyLoginPage + "Failed");
        }

        driver.quit();

    }
}
