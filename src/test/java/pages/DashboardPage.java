package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class DashboardPage {
    @FindBy(className = "add-cost-button")
    WebElement btnAddCost;
    @FindBy(id="itemName")
    WebElement txtItemName;
    @FindBy(id="amount")
    WebElement txtAmount;
    @FindBy(id="remarks")
    WebElement txtRemarks;
    @FindBy(css = "[type=submit]")
    WebElement btnSubmit;
    WebDriver driver;

    public DashboardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    public void addItems(String itemName, String amount) throws InterruptedException {
        btnAddCost.click();
        txtItemName.sendKeys(itemName);
        txtAmount.sendKeys(amount);
        txtRemarks.sendKeys("Test");
        Utils.scrollDown(driver,500);
        btnSubmit.click();
        Thread.sleep(500);
        driver.switchTo().alert().accept();
    }


}
