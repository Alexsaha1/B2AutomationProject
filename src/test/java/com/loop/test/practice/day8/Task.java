package com.loop.test.practice.day8;
import com.github.javafaker.Faker;
import com.loop.test.utillites.ConfigurationReader;
import com.loop.test.utillites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v118.dom.DOM;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import java.text.SimpleDateFormat;

import static org.testng.Assert.assertEquals;
public class Task {

    @Test
    public void goToUrl() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("task1"));

        Faker faker = new Faker();
        String firstName = "";
        firstName = faker.name().firstName();  // expected getting from java faker
        WebElement firstNameEliment = Driver.getDriver().findElement(By.name("firstname"));
        firstNameEliment.sendKeys(firstName);
        System.out.println(firstNameEliment.getAttribute("value"));  // actual getting from browser
        assertEquals(firstNameEliment.getAttribute("value"), firstName, "Not find - " + firstNameEliment);  //  actual  | expected  | message

        String lastName = "";
        lastName = faker.name().lastName();
        WebElement lastNameElimetn = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastNameElimetn.sendKeys(lastName);
        System.out.println(lastNameElimetn.getAttribute("value"));
        assertEquals(lastNameElimetn.getAttribute("value"), lastName, " Not find - " + lastNameElimetn);

        String username = faker.regexify("[a-z]{8}");
        WebElement userNameEliment = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userNameEliment.sendKeys(username);
        System.out.println(userNameEliment.getAttribute("value"));
        assertEquals(userNameEliment.getAttribute("value"), username, "Not find - " + lastNameElimetn);

        String email = faker.internet().emailAddress();
        WebElement emailElement = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        emailElement.sendKeys(email);
        System.out.println(emailElement.getAttribute("value"));
        assertEquals(emailElement.getAttribute("value"), email, "Not find - " + emailElement);

        String password = faker.internet().password();
        WebElement passwordElement = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        passwordElement.sendKeys(password);
        System.out.println(passwordElement.getAttribute("value"));
        assertEquals(passwordElement.getAttribute("value"), password, "Not find - " + passwordElement);

        String phone = faker.numerify("###-###-####");
        WebElement phoneNumElement = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumElement.sendKeys(phone);
        System.out.println(phoneNumElement.getAttribute("value"));
        assertEquals(phoneNumElement.getAttribute("value"), phone, "Not find - " + phoneNumElement);

        WebElement gender = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'Gender')]/following-sibling::div"));
        System.out.println(gender.isSelected());

        WebElement radioMale = Driver.getDriver().findElement(By.xpath("//div[@class='radio'][1]//*"));
        radioMale.click();

        SimpleDateFormat sdt = new SimpleDateFormat("MM/dd/yyyy");
        String randomDofB = sdt.format(faker.date().birthday());
        WebElement dayOfBirthElement = Driver.getDriver().findElement(By.xpath("//*[@name='birthday']"));
        dayOfBirthElement.sendKeys(randomDofB);
        System.out.println(dayOfBirthElement.getAttribute("value"));
        assertEquals(dayOfBirthElement.getAttribute("value"), randomDofB," Not find - " + dayOfBirthElement);

        WebElement department = Driver.getDriver().findElement(By.xpath("//*[@name='department']"));
        department.click();

        WebElement select = Driver.getDriver().findElement(By.xpath("//select[@name='department']/option[@value='AO']"));
        select.click();

        WebElement jobTitle = Driver.getDriver().findElement(By.xpath("//Select[@name='job_title']"));
        jobTitle.click();

        WebElement selectJobTitle = Driver.getDriver().findElement(By.xpath("//Select[@name='job_title']/option[@value='sdet']"));
        selectJobTitle.click();

        WebElement languages = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        languages.click();

        WebElement singUp = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'Sign up')]"));
        singUp.click();
    }
}
