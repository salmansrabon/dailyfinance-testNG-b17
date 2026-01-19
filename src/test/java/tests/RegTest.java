package tests;

import com.github.javafaker.Faker;
import config.Setup;
import config.UserModel;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegPage;
import services.GmailService;
import utils.Utils;

import java.io.IOException;

public class RegTest extends Setup {
    @Test (priority = 1, description = "User reg only mandatory fields", groups = "smoke")
    public void userRegistration() throws IOException, ParseException, InterruptedException {
        RegPage regPage=new RegPage(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String email="salmansrabon+"+firstName+"@gmail.com";
        String password="1234";
        String phoneNumber="0150"+ Utils.generateRandomNumber(1000000,9999999);
        driver.findElement(By.partialLinkText("Register")).click();
        UserModel userModel=new UserModel();
        userModel.setFirstname(firstName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhonenumber(phoneNumber);
        regPage.doReg(userModel);
        Utils.saveJSONData(userModel);

        Thread.sleep(5000);
        GmailService gs=new GmailService();
        String regEmailActual= gs.readEmail();
        System.out.println(regEmailActual);
        String regEmailExpected="Welcome to our platform";
        Assert.assertTrue(regEmailActual.contains(regEmailExpected));
    }
    //@Test (priority = 2, description = "User reg with all fields")
    public void fullUserRegistration() throws IOException, ParseException, InterruptedException {
        RegPage regPage=new RegPage(driver);
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email="salmansrabon+"+firstName+"@gmail.com";
        String password="1234";
        String phoneNumber="0150"+ Utils.generateRandomNumber(1000000,9999999);
        String address="Dhaka";
        driver.findElement(By.partialLinkText("Register")).click();
        UserModel userModel=new UserModel();
        userModel.setFirstname(firstName);
        userModel.setLastname(lastName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhonenumber(phoneNumber);
        userModel.setAddress(address);
        regPage.doReg(userModel);
        Utils.saveJSONData(userModel);
    }

}
