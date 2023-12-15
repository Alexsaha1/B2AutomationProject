package com.loop.test.practice.day5;

import com.loop.test.utillites.DocuportConstants;
import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_day_5_testNG {
    WebDriver driver;
    String expected;
    String actual;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void dropDownMethod(){
        driver.close();
    }
    @Test(priority = 1)
    public void dropDownList() throws InterruptedException {
        // Go to http://the-internet.herokuapp.com/checkboxes

        driver.get("http://the-internet.herokuapp.com/dropdown");

        //  validate "Please select an option" is selected by default

        WebElement dropDown = driver.findElement(By.xpath("//option[contains(text(),'Please')]"));
        expected = "Please select an option";
        actual = dropDown.getText();
        System.out.println("Actual = " + actual + " | " + "Expected = " + expected);
        Assert.assertEquals(actual, expected);

        //  Choose option 1 and validate that it is selected

        WebElement dropDownButton = driver.findElement(By.xpath("//select[@id='dropdown']"));
        dropDownButton.click();

        WebElement option1 = dropDownButton.findElement(By.xpath("//option[@value='1']"));
        option1.click();

        WebElement option1Displayed = driver.findElement(By.xpath("//option[contains(text(),'Option 1')]"));
        expected = "Option 1";
        actual = option1Displayed.getText();
        System.out.println("Actual = " + actual + " | " + "Expected = " + expected);
        Assert.assertEquals(actual, expected);

        //  Choose option 2 and validate that it is selected

        WebElement dropDownButton2 = driver.findElement(By.xpath("//option[contains(text(),'Option 1')]"));
        Thread.sleep(3000);
        dropDownButton2.click();
        WebElement option2 = driver.findElement(By.xpath("//option[@value='2']"));
        Thread.sleep(3000);
        option2.click();
        Thread.sleep(3000);
        WebElement dropDownField = driver.findElement(By.xpath("//option[@value='2']"));
        expected = "Option 2";
        actual = dropDownField.getText();
        System.out.println("Actual = " + actual + " | " + "Expected = " + expected);
        Assert.assertEquals(actual, expected);

        //  Validate dropdown name is "Dropdown List"

        WebElement dropDownList = dropDown.findElement(By.xpath("//h3[contains(text(),'Dropdown List')]"));
        expected = "Dropdown List";
        actual = dropDownList.getText();
        System.out.println("Actual = " + actual + " | " + "Expected = " + expected);
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 2)
    public void etsy(){
        //  go to https://www.etsy.com/

        driver.get("https://www.etsy.com/");

        //  search for rings

        WebElement searchField = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        searchField.sendKeys("rings");

        WebElement enterButton = driver.findElement(By.xpath("//button[@type='submit' and @value='Search']"));
        enterButton.click();

        //  validate that Estimated Arrival shows any time

        WebElement estimatedArrival = driver.findElement(By.xpath("//main[@id='content']//*[contains(text(),'Estimated Arrival')]/span"));
        actual = "Any time";
        expected = estimatedArrival.getText();
        System.out.println("Actual = " + actual + " | " + "Expected = " + expected);
        Assert.assertEquals(actual, expected);

        //  click Estimated Arrival dropdown
        estimatedArrival.click();

        //  click Select custom date

        WebElement radioButtonCustomDate = driver.findElement(By.xpath("//label[@for='edd-custom-radio-input-tf']"));
        radioButtonCustomDate.click();

        //  choose "By Dec 17" from dropdown

        WebElement selectCustomDateButton = driver.findElement(By.xpath("//select[@id='edd_select_tf']"));
        Select select = new Select(selectCustomDateButton);
        select.selectByVisibleText("By Dec 17");

        //  validate Estimated Arrival shows may 30

        WebElement estimatedArrival1 = driver.findElement(By.xpath("//main[@id='content']//*[contains(text(),'Estimated Arrival')]/span"));
        actual = "By Dec 17";
        expected = estimatedArrival.getText();
        System.out.println("Actual = " + actual + " | " + "Expected = " + expected);
        Assert.assertEquals(actual, expected);

    }
    @Test(priority = 3)
    public void docuportApp() throws InterruptedException {
        //  login as an advisor

        driver.get("https://beta.docuport.app");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-14']"));
        userName.sendKeys(DocuportConstants.USERNAME_ADVISOR);

        WebElement passwordAdvisor = driver.findElement(By.xpath("//input[@id='input-15']"));
        passwordAdvisor.sendKeys(DocuportConstants.ADVISOR_PASSWORD);

        WebElement logInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        logInButton.click();
        Thread.sleep(3000);

        //  go to received document

        WebElement receivedDocuments = driver.findElement(By.xpath("//h2[contains(text(),'Received ')]"));
        receivedDocuments.click();
        Thread.sleep(3000);

        //  click search

        WebElement searchButton = driver.findElement(By.xpath("//span[contains(text(),'Search')]"));
        searchButton.click();
        Thread.sleep(3000);

        //  click status dropdown

        WebElement statusField = driver.findElement(By.xpath("//div[@aria-owns='list-337']"));
        statusField.click();
        Thread.sleep(3000);

        //  choose in progress

        WebElement inProgress = driver.findElement(By.xpath("//div[contains(text(),'In progress')]"));
        inProgress.click();
        Thread.sleep(3000);
        WebElement statusField2 = driver.findElement(By.xpath("//label[@for='input-337']/following-sibling::div"));
        actual = "In progress";
        expected = statusField2.getText();
        System.out.println("Actual = " + actual + " | " + "Expected = " + expected);
        Assert.assertEquals(actual, expected);


    }
}
