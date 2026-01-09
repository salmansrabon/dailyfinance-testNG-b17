import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegPage {
    @FindBy(id = "firstName")
    WebElement txtFirstName;
    @FindBy(id="email")
    WebElement txtEmail;
    @FindBy(id="password")
    WebElement txtPassword;
    @FindBy(id = "phoneNumber")
    WebElement txtPhoneNumber;
    @FindBy(css = "[type=radio]")
    List<WebElement> rbGender;
    @FindBy(css = "[type=checkbox]")
    WebElement chkAgreement;
    @FindBy(id="register")
    WebElement btnRegister;

    public RegPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doReg(String firstName, String email, String password, String phoneNumber ){
        txtFirstName.sendKeys(firstName);
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        txtPhoneNumber.sendKeys(phoneNumber);
        rbGender.get(0).click();
        chkAgreement.click();
        btnRegister.click();
    }
}
