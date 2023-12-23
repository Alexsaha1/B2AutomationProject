package com.loop.test.practice;

import com.github.javafaker.Faker;
import com.loop.test.utillites.ConfigurationReader;
import com.loop.test.utillites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class day8 {
    @Test
    public void goToUrl(){
        Driver.getDriver().get(ConfigurationReader.getProperty("task1"));

        Faker faker = new Faker();
        String firstName = "";
        firstName = faker.name().firstName();  // expected getting from java faker
        WebElement firstNameEliment = Driver.getDriver().findElement(By.name("firstname"));
        firstNameEliment.sendKeys(firstName);
        firstNameEliment.getAttribute("value");  // actual getting from browser
        assertEquals(firstNameEliment.getAttribute("value"), firstName, "Not work");  //  actual  | expected  | message

    }
}
