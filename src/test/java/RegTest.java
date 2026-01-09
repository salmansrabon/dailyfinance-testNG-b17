import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RegTest extends Setup {
    @Test
    public void userRegistration(){
        RegPage regPage=new RegPage(driver);
        String firstName="Test User";
        String email="salmansrabon+555@gmail.com";
        String password="1234";
        String phoneNumber="01504478746";
        driver.findElement(By.partialLinkText("Register")).click();
        regPage.doReg(firstName,email,password,phoneNumber);
    }

}
