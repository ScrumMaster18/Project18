package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page {
    public Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //US13
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement ilk_sing_in_button;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement email_box;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement sifre_box;

    @FindBy(xpath = "//*[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement ikinci_sing_in_button;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement ilk_sing_out_button;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement stor_manager_button;

    @FindBy(xpath = "(//*[@class='text'])[6]")
    public WebElement cponus_button;

    @FindBy(xpath = "//*[text()='Add New']")
    public WebElement add_new_button;


    @FindBy(xpath = "//*[@class='wcfm-text wcfm_ele']")
    public WebElement code_box;

    @FindBy(xpath = "//*[@class='wcfm-textarea wcfm_ele']")
    public WebElement description_box;

    @FindBy(xpath = "//*[@class='wcfm-select wcfm_ele']")
    public WebElement discount_Type_drop_down;

    @FindBy(xpath = "//*[@id='coupon_amount']")
    public WebElement coupon_amount_box;

    @FindBy(xpath = "//*[@id='expiry_date']")
    public WebElement expiry_date_box;

    @FindBy(xpath = "(//*[@class='ui-state-default'])[10]")
    public WebElement gecerli_tarih;

    @FindBy(xpath = "//*[@id='free_shipping']")
    public WebElement free_shipping_chekbox;

    @FindBy(xpath = "//*[@id='show_on_store']")
    public WebElement show_on_store_chekbox;


    //US14

    @FindBy(xpath = "//*[@id='minimum_amount']")
    public WebElement min_spend_box;

    @FindBy(xpath = "//*[@id='maximum_amount']")
    public WebElement max_spend_box;


    @FindBy(xpath = "//*[@id='individual_use']")
    public WebElement individual_use_only_chekbox;


    @FindBy(xpath = "//*[@id='exclude_sale_items']")
    public WebElement exclude_sale_items_chekbox;

    @FindBy(xpath = "(//*[@class='select2-search__field'])[4]")
    public WebElement exclude_categories_dropdown;

    //US15

    @FindBy(xpath = "//*[@id='coupons_manage_limit']")
    public WebElement limit_ekleme_bolumu;

    @FindBy(xpath = "//*[@id='usage_limit']")
    public WebElement usage_limit_per_coupon_box;

    @FindBy(xpath = "//*[@id='limit_usage_to_x_items']")
    public WebElement limit_usage_to_x_items_box;

    @FindBy(xpath = "//*[@id='usage_limit_per_user']")
    public WebElement usage_limit_per_user_box;


    @FindBy(xpath = "//*[@id='wcfm_coupon_manager_submit_button']")
    public WebElement kupon_kaydetme_buttonu;

    @FindBy(xpath = "//*[text()='Coupon Successfully Saved.']")
    public WebElement kpon_basariyla_kaydedildi_yazisi;
}
