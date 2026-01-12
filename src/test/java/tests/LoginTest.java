package tests;

import config.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import utils.Utils;


import java.io.IOException;

public class LoginTest extends Setup {
    @Test(priority = 1, description = "Verify that user can not login with wrong creds")
    public void userLoginWithWrongCreds(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("salmansrabon+555@gmail.com","123456");
        String validationErrorActual=driver.findElement(By.tagName("p")).getText();
        String validationErrorExpected="Invalid email or password";
        Assert.assertTrue(validationErrorActual.contains(validationErrorExpected));
        clearData();
    }
    @Test(priority = 2, description = "Verify that user can login with correct credential")
    public void  userLogin() throws InterruptedException, IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        JSONObject userObj= Utils.readJSONData("./src/test/resources/Users.json");
        //loginPage.doLogin("salmansrabon+555@gmail.com","1234");
        loginPage.doLogin(userObj.get("email").toString(),userObj.get("password").toString());
        String headerText= driver.findElement(By.tagName("h2")).getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.className("search-input")).isDisplayed(),"not found");
        //softAssert.assertTrue(driver.findElements(By.tagName("span")).get(1).getText().contains("No cost"),"1. No text found");
        //softAssert.assertTrue(headerText.contains("User Daily Costs .."), ".");
        softAssert.assertAll();

//        Assert.assertTrue(headerText.contains("User Daily Costs .."), "Not found the text");
//        Assert.assertTrue(driver.findElement(By.className("search-input")).isDisplayed(),"not found");

        //Soft assertion executes all the assertions, Hard assertion if fail, then do not continue next assertions/*
    }
    public void clearData(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.txtEmail.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
        loginPage.txtPassword.sendKeys(Keys.CONTROL+"a",Keys.BACK_SPACE);
    }
}
