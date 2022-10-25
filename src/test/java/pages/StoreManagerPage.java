package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StoreManagerPage {
    public WebElement myAccountYazı;

    public StoreManagerPage() {
        PageFactory.initElements(Driver.getDriver(), this);    }

    @FindBy(xpath = "(//*[@class='text'])[4]")
    public WebElement storeManagerMenuProducts;
    @FindBy(xpath = "//span[contains(text(),'Orders')]")
    public WebElement storeManagerMenuOrders;
    @FindBy(xpath = "//span[contains(text(),'Coupons')]")
    public WebElement storeManagerMenuCoupons;
    @FindBy(xpath = "//span[contains(text(),'Customers')]")
    public WebElement storeManagerMenuCustomers;
    @FindBy(xpath = "//span[contains(text(),'Refund')]")
    public WebElement storeManagerMenuRefund;
   // @FindBy(xpath = "//span[contains(text(),'Payments')]")  2 tane var
    public WebElement storeManagerMenuPayments;
    @FindBy(xpath = "//span[contains(text(),'Followers')]")
    public WebElement storeManagerMenuFollowers;
//    @FindBy(xpath = "//span[contains(text(),'Chat Box')]")
    public WebElement storeManagerMenuChatBox;
    @FindBy(xpath = "//span[contains(text(),'Reviews')]")
    public WebElement storeManagerMenuReviews;
    @FindBy(xpath = "//span[contains(text(),'Reports')]")
    public WebElement storeManagerMenuReports;

    @FindBy(xpath = "//h2[@class='page-title']")
    public WebElement myAccountYazıı;

    @FindBy(xpath = "//a[@href='https://hubcomfy.com/store-manager/product-reviews/']")
    public WebElement productReviews;

    @FindBy(xpath = "(//div[@class='wcfmmp-author-meta'])[1]")
    public WebElement reviwesauthor;

    @FindBy(xpath = "(//div[@class='wcfmmp-comments-content'])[1]")
    public WebElement reviewscomment;

    @FindBy(xpath = "//div[@title='Rated 2 out of 5']")
    public WebElement reviewsrate;

    @FindBy(xpath = "//tbody//tr[1]//td[6]")
    public WebElement reviewsdate;

    @FindBy(xpath = "//iframe[@class='chartjs-hidden-iframe']")
    public WebElement iframe;

    @FindBy(xpath = "//body[@data-rsssl='1']")
    public WebElement signin;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement followerlistbody;

    @FindBy(xpath = "//a[@href='/store-manager/reports-sales-by-date/?range=year']")
    public WebElement reportsyear;

    @FindBy(xpath = "//a[@href='/store-manager/reports-sales-by-date/?range=last_month']")
    public WebElement reportslastmonth;

    @FindBy(xpath = "//a[@href='/store-manager/reports-sales-by-date/?range=month']")
    public WebElement reportsthismonth;

    @FindBy(xpath = "//a[@href='/store-manager/reports-sales-by-date/?range=7day']")
    public WebElement reportslast7days;

    @FindBy(xpath = "//input[@name='wcfm-date-range']")
    public WebElement customdatebox;

    @FindBy(xpath = "//div[@id='poststuff']")
    public WebElement chart;

    @FindBy(xpath = "(//tbody//tr[3]//td[5])[1]")
    public WebElement customdate1;

    @FindBy(xpath = "(//tbody//tr[4]//td[7])[1]")
    public WebElement customdate2;






}
