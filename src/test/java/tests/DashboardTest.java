package tests;

import config.Setup;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utils.Utils;

import java.io.IOException;

public class DashboardTest extends Setup {
    @BeforeTest
    public void login() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        JSONObject userObj= Utils.readJSONData("./src/test/resources/Users.json");
        loginPage.doLogin(userObj.get("email").toString(),userObj.get("password").toString());
    }
    @Test(priority = 1, description = "Add new item")
    public void addItems() throws InterruptedException {
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.addItems("Item "+Utils.generateRandomNumber(1,100),String.valueOf(Utils.generateRandomNumber(10,100)));
    }
}
