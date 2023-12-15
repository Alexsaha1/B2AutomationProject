package com.loop.test.practice.self;

import com.loop.test.utillites.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ItaEasy {
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
    public void itsEasy() throws InterruptedException {
        driver.get("https://www.itseasy.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement selectNationality = driver.findElement(By.xpath("//span[@title='Select Nationality']"));
        System.out.println("Select Nationality drop Down field contains -> " + selectNationality.getText());
        selectNationality.click();
        Thread.sleep(3000);
        try {
            WebElement selectUsa = driver.findElement(By.xpath("//option[@value='USA']"));
            selectUsa.click();
            System.out.println(selectUsa.getText() + " = Test Ok");
        } catch (Exception e){
            System.out.println("Not");
        }
        WebElement selectStateOfResidence = driver.findElement(By.xpath("//span[contains(text(),'Select State of Residence')]"));
        selectStateOfResidence.click();

        try {
            WebElement state = driver.findElement(By.xpath("//span[contains(text(),'Maryland')]"));
            state.click();
            System.out.println(state.getText() + " = Click OK");
        } catch (Exception e){
            System.out.println("Click Not Ok");
        }

        try {
            WebElement serviceNeeded = driver.findElement(By.xpath("//span[contains(text(),'Service(s) Needed')]"));
            System.out.println(serviceNeeded.getText() + "= Good!");
            serviceNeeded.click();
            System.out.println(serviceNeeded.getText() + " = Click Ok");
        } catch (EnumConstantNotPresentException exception){
            System.out.println("Click Not Ok");
        }

//        try {
//            WebElement usPassport = driver.findElement(By.xpath(""));
//            usPassport.click();
//            System.out.println(usPassport.getText() + " = Click Ok");
//        } catch (Exception e){
//            System.out.println("Click Not Ok");
//        }
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(15));


        WebElement makeSelectionsAbove = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Make Selections Above')]"));

        makeSelectionsAbove.click();
        Thread.sleep(1000);
        //WebElement msg = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//form/div[@class='form-row justify-content-center']/div)[3]/span[@class='select2 select2-container select2-container--bootstrap4 select2-container--below select2-container--focus']")));
        WebElement test = driver.findElement(By.xpath("(//form/div[@class='form-row justify-content-center']/div)[3]/span[@class='select2 select2-container select2-container--bootstrap4 select2-container--below select2-container--focus']"));


        System.out.println(test.getText());


    }
}
