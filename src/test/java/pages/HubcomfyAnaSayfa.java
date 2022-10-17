package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HubcomfyAnaSayfa {
    public HubcomfyAnaSayfa(){ PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath="//a[@class='register inline-type']")
    public WebElement anasayfaRegiterButonu;
@FindBy(xpath= "(//a[@href='https://hubcomfy.com/vendor-register/'])[2]")
    public WebElement anasayfaPopUpBecameVendor;



@FindBy(id = "user_emaile")
    public WebElement vendorRegistrationEmail;








}
