package com.loop.test.practice.self;

import com.loop.test.base.TestBase;
import com.loop.test.practice.utillites2.DevthetaUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Dovtheta_vision extends TestBase {
    @Test
    public void dev() {
        DevthetaUtils.login(driver);

        WebElement photoApp = driver.findElement(By.xpath("//p[contains(text(),'PhotoApp')]"));
        photoApp.click();
        WebElement photoAdmen = driver.findElement(By.xpath("//p[contains(text(),'PhotoAdmeen')]"));
        photoAdmen.click();





    }

}
