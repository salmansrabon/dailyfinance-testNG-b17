package tests;

import config.Setup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class LoginTest extends Setup {
    @Test
    public void  userLogin() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("salmansrabon+555@gmail.com","1234");
        String headerText= driver.findElement(By.tagName("h2")).getText();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.className("search-input")).isDisplayed(),"not found");
        softAssert.assertTrue(driver.findElements(By.tagName("span")).get(1).getText().contains("No cost"),"1. No text found");
        softAssert.assertTrue(headerText.contains("User Daily Costs .."), ".");

        softAssert.assertAll();

//        Assert.assertTrue(headerText.contains("User Daily Costs .."), "Not found the text");
//        Assert.assertTrue(driver.findElement(By.className("search-input")).isDisplayed(),"not found");

        //Soft assertion executes all the assertions, Hard assertion if fail, then do not continue next assertions/*
    }
}
