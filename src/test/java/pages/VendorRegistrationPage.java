package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VendorRegistrationPage {
    public VendorRegistrationPage(){ PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement vendorRegistrationEmail;
@FindBy(xpath = "//input[@id='passoword']")
public WebElement vendorRegistrationPassword;

    @FindBy (xpath = "//input[@name='wcfm_email_verified_input']")
public WebElement vendorVerificationCode;

    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement vendorRegistrationConfirmPassword;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement vendorRegistrationRegisterButonu;
@FindBy(xpath = "//*[@class='wcfm-message wcfm-success']")
    public WebElement getVendorRegistrationOnayMesaji;






}
