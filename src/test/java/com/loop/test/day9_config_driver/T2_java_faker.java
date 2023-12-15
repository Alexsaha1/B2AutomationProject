package com.loop.test.day9_config_driver;

import org.testng.annotations.Test;
import com.github.javafaker.Faker;
public class T2_java_faker {
    @Test
    public void java_faker(){
        Faker faker = new Faker();
        System.out.println(faker.name().fullName());
        System.out.println(faker.numerify("240-302-1410"));
        System.out.println(faker.letterify("?????"));
        System.out.println(faker.bothify("##??##?"));
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.finance().creditCard());
        System.out.println(faker.chuckNorris().fact());
    }
}
