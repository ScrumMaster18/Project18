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
  //  @FindBy(xpath = "//span[contains(text(),'Followers')]")
   // public WebElement storeManagerMenuFollowerps;
    //@FindBy(xpath = "//span[contains(text(),'Reviews')]")
   // public WebElement storeManagerMenuReviews;





}
