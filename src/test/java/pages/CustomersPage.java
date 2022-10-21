package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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


    // <<<===REFUND MENU ELEMENTLERI ===>>>

    @FindBy (xpath = "//th[@aria-label='Request ID']")
    public WebElement RefundMenuRequestID;
    @FindBy (xpath = "//th[@aria-label='Order ID']")
    public WebElement RefundMenuOrderID;
    @FindBy (xpath = "//th[@aria-label='Amount']")
    public WebElement RefundMenuAmount;
    @FindBy (xpath = "//th[@aria-label='Type']")
    public WebElement RefundMenuType;
    @FindBy (xpath = "//th[@aria-label='Reason']")
    public WebElement RefundMenuReason;
    @FindBy (xpath = "//h2[text()='Refund Requests']")
    public WebElement RefundMenuRefundRequestsSayfasi;



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
    @FindBy (xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-refund-requests']")
    public WebElement AddNewRefund;
    @FindBy (xpath = "//input[@id='user_name']")
    public WebElement AddNewUserName;
    @FindBy (xpath = "//input[@id='wcfm_customer_submit_button']")
    public WebElement AddNewCustomerSubmitButton;
    @FindBy (xpath = "//*[contains(text(),'Customer Successfully Saved.')]")
    public WebElement basariylaKaydedildi;
    @FindBy (xpath = "(//*[@class='wcfmfa fa-edit text_tip'])[2]")
    public WebElement EditCustomer;
    @FindBy (xpath = "//*[@id='bfirst_name']")
    public WebElement BillingFirstName;
    @FindBy (xpath = "//*[@id='select2-bcountry-container']")
    public WebElement BillingCountryDropDown;

    @FindBy (xpath = "//*[@id='bcity']")
    public WebElement BillingCityTown;
    @FindBy (xpath = "//*[@id='bzip']")
    public WebElement BillingPostcodeZip;
    @FindBy (xpath = "//input[@class='select2-search__field']")
    public WebElement BillingCountryDropDownSearchBox;
    @FindBy (xpath = "//span[@title='Turkey']")
    public WebElement BillingCountryDropDownTurkey;
    @FindBy (xpath = "//option[@value='TR11']")
    public WebElement BillingStateCountyDropDownBilecik;
    @FindBy (xpath = "//select[@id='bstate']")
    public WebElement BillingStateCountyDropDown;
    @FindBy (xpath = "//*[@id='wcfm_customer_submit_button']")
    public WebElement BillinhgMenuSubmit;


    // <<<=== SHIPPING MENU ELEMENTOR ===>>>

    @FindBy (xpath = "//input[@id='same_as_billing']")
    public WebElement ShippingMenuSameasBilling;
    @FindBy (xpath = "//input[@id='sfirst_name']")
    public WebElement ShippingMenuFirstName;
    @FindBy (xpath = "//*[@id='select2-scountry-container']")
    public WebElement ShippingMenuCountryDropDown;
    @FindBy (xpath = "//*[@id='scity']")
    public WebElement ShippingMenuCityTown;
    @FindBy (xpath = "//*[@id='szip']")
    public WebElement ShippingMenuPostcodeZip;
    @FindBy (xpath = "//select[@id='sstate']")
    public WebElement ShippingMenuStateCountyDropDown;
    @FindBy (xpath = "//option[@value='TR16']")
    public WebElement ShippingMenuStateCountyDropDownBursa;






}
