package tests;

import config.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class AdminLogin extends Setup {
    @Test
    public void adminLogin() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        //loginPage.doLogin("admin@test.com","admin123");
        loginPage.doLogin(System.getProperty("email"),System.getProperty("password"));

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("total-count")));
        System.out.println(driver.findElement(By.className("total-count")).getText());
    }
}
