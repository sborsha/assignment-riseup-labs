package pages;

import config.UserModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegistrationPage {
  //  @FindBy(tagName = "a")
    @FindBy(css = "a[href='/register']")
    public WebElement btnRegister;
    @FindBy(id = "firstName")
    WebElement txtFirstname;
    @FindBy(id = "lastName")
    WebElement txtLastname;
    @FindBy(id="email")
    WebElement txtEmail;
    @FindBy(id="password")
    WebElement txtPassword;
    @FindBy(id="phoneNumber")
    WebElement txtPhoneNumber;
    @FindBy(id="address")
    WebElement txtAddress;
    @FindBy(css = "[type=radio]")
    List<WebElement> rbGender;
    @FindBy(css = "[type=checkbox]")
    WebElement chkAcceptTerms;
    @FindBy(id="register")
    public WebElement btnSubmitReg;

    public RegistrationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doRegistration(UserModel userModel){
        txtFirstname.sendKeys(userModel.getFirstname());
        txtLastname.sendKeys(userModel.getLastname());
        txtEmail.sendKeys(userModel.getEmail());
        txtPassword.sendKeys(userModel.getPassword());
        txtPhoneNumber.sendKeys(userModel.getPhonenumber());
        txtAddress.sendKeys(userModel.getAddress());
        rbGender.get(1).click();
        chkAcceptTerms.click();
        btnSubmitReg.click();

    }
}
