package tests;

import com.github.javafaker.Faker;
import config.Setup;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.RegPage;
import utils.Utils;

import java.io.IOException;

public class RegTest extends Setup {
    @Test
    public void userRegistration() throws IOException, ParseException {
        RegPage regPage=new RegPage(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String email="salmansrabon+"+firstName+"@gmail.com";
        String password="1234";
        String phoneNumber="0150"+ Utils.generateRandomNumber(1000000,9999999);
        driver.findElement(By.partialLinkText("Register")).click();
        regPage.doReg(firstName,email,password,phoneNumber);
        Utils.saveJSONData(firstName,email,password,phoneNumber);
    }

}
