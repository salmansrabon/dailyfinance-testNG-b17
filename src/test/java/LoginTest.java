import org.testng.annotations.Test;

public class LoginTest extends Setup {
    @Test
    public void  userLogin(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.doLogin("salmansrabon+555@gmail.com","1234");
    }
}
