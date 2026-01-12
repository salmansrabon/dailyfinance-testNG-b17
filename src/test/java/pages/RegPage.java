package pages;

import config.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegPage {
    @FindBy(id = "firstName")
    WebElement txtFirstName;
    @FindBy(id="lastName")
    WebElement txtLastName;
    @FindBy(id="email")
    WebElement txtEmail;
    @FindBy(id="password")
    WebElement txtPassword;
    @FindBy(id = "phoneNumber")
    WebElement txtPhoneNumber;
    @FindBy(id="address")
    WebElement txtAddress;
    @FindBy(css = "[type=radio]")
    List<WebElement> rbGender;
    @FindBy(css = "[type=checkbox]")
    WebElement chkAgreement;
    @FindBy(id="register")
    WebElement btnRegister;

    public RegPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doReg(UserModel userModel){
        txtFirstName.sendKeys(userModel.getFirstname());
        txtLastName.sendKeys(userModel.getLastname()==null?"":userModel.getLastname());
        txtEmail.sendKeys(userModel.getEmail());
        txtPassword.sendKeys(userModel.getPassword());
        txtPhoneNumber.sendKeys(userModel.getPhonenumber());
        txtAddress.sendKeys(userModel.getAddress()==null?"":userModel.getAddress());
        rbGender.get(0).click();
        chkAgreement.click();
        btnRegister.click();
    }
}
