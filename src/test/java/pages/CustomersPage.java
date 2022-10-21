package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CustomersPage {
    public CustomersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//th[@aria-label='Name']")
    public WebElement Name;
    @FindBy (xpath = "//th[@aria-label='Username']")
    public WebElement Username;
    @FindBy (xpath = "//th[@aria-label='Email']")
    public WebElement Email;
    @FindBy (xpath = "//th[@aria-label='Location']")
    public WebElement Location;
    @FindBy (xpath = "//th[@aria-label='Orders']")
    public WebElement Orders;
    @FindBy (xpath = "//th[@aria-label='Money Spent']")
    public WebElement MoneySpent;
    @FindBy (xpath = "//th[@aria-label='Last Order']")
    public WebElement LastOrder;
    @FindBy (xpath = "//th[@aria-label='Actions']")
    public WebElement Actions;
    //@FindBy (xpath = "//th")
    //public List<WebElement> kisiBilgileri;
    @FindBy (xpath = "//span[text()='PDF']")
    public WebElement PDF;
    @FindBy (xpath = "//span[text()='Excel']")
    public WebElement Excel;
    @FindBy (xpath = "//span[text()='CSV']")
    public WebElement CSV;

    @FindBy (xpath = "//span[text()='Add New']")
    public WebElement AddNewCustomer;

    @FindBy (xpath = "//input[@id='user_name']")
    public WebElement AddNewUserName;

    @FindBy (xpath = "//input[@id='wcfm_customer_submit_button']")
    public WebElement AddNewCustomerSubmitButton;

    @FindBy (xpath = "//*[contains(text(),'Customer Successfully Saved.')]")
    public WebElement basariylaKaydedildi;

   // @FindBy (xpath = "//script[@id='wcfm_customers_manage_js-js-extra']")
   // public WebElement basariylaKaydedildi;




}
