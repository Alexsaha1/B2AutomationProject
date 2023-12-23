package com.loop.test.utillites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.InputMismatchException;

public class DocuportUtils {

    /**
     * logins to the docuport application

     * @param driver, which initialized in test base
     * @param role, comes from docuport constants
     * @author nadir
     */
    public static void login(WebDriver driver, String role) throws InterruptedException {
        //driver.get("https://beta.docuport.app/");
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement username = Driver.getDriver().findElement(By.xpath("//label[.='Username or email']//following-sibling::input"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        switch (role.toLowerCase()){

     *
     * @param driver, witch initialized in test bade
     * @param role,   comes from docuport constants
     * @auyhor alex
     */
    public static void login(WebDriver driver, String role) throws InterruptedException {
        driver.get("https://beta.docuport.app/");
        WebElement username = driver.findElement(By.xpath("//label[.='Username or email']//following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginBUtton = driver.findElement(By.xpath("//button[@type='submit']"));
        switch (role.toLowerCase()) {

            case "client":
                username.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;

            default: throw new InputMismatchException("There us not such a role: " + role);
        }

        loginButton.click();

        if(role.toLowerCase().equals("client")){
            Thread.sleep(3000);
            WebElement cont = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
            cont.click();
            Thread.sleep(3000);

            default:
                throw new InputMismatchException("There us not such a role: " + role);
        }

        loginBUtton.click();

        if (role.toLowerCase().equals("client")) {
            Thread.sleep(3000);
            WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
            cont.click();

        }
    }

    /**
     * logs out from the application
     * @param driver
     * @author nadir
     */
    public static void logOut(WebDriver driver){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userIcon = Driver.getDriver().findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement logOut = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

     * @author alex
     */
    public static void logOut(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


}
