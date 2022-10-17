package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TempMail {
    public TempMail(){ PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[@data-clipboard-action='copy']")
    public WebElement tempMailCopyButton;
@FindBy(xpath = "//td[contains(text(),'Email Verification Code')]")
public WebElement verificationCode;
@FindBy (xpath = "//span[@id='email']")
    public WebElement emailAdresi;









}
