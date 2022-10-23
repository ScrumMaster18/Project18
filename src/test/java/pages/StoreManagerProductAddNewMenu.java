package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StoreManagerProductAddNewMenu {
    public StoreManagerProductAddNewMenu() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "(//*[contains(text(),'Add New')])[2]")
    public WebElement ProductAddNewButton;//action classı ile uzerine gel

   ////INVENTORY KISMI
    @FindBy(xpath = "//*[text()='Inventory']")
    public WebElement InventoryButton;

    @FindBy(xpath = "(//*[text()='Manage Stock?'])[1]")
    public WebElement InventoryPageManageStockText;

    @FindBy(xpath = "//*[@id='manage_stock']")
    public WebElement InventoryPageManageStockCheckBox;

    @FindBy(xpath = "(//*[text()='Stock Qty'])[1]")
    public WebElement InventoryPageStockQtyText;

    @FindBy(xpath = "//*[@id='stock_qty']")
    public WebElement InventoryPageStockQtyDataBox;

    @FindBy(xpath = "(//*[text()='Allow Backorders?'])[1]")
    public WebElement InventoryPageAllowBackordersText;


    @FindBy(xpath = "//*[@id='backorders']")
    public WebElement InventoryPageAllowBackordersBox;

    @FindBy(xpath = "(//option[text()='Do not Allow'])[1]")
    public WebElement InventoryPageAllowBackordersDoNotAllowButton;

    @FindBy(xpath = "(//option[text()='Allow, but notify customer'])[1]")
    public WebElement InventoryPageAllowBackordersAllowButNotifCustomerButton;

    @FindBy(xpath = "(//option[text()='Allow'])[1]")
    public WebElement InventoryPageAllowBackordersAllowButton;



    //SHİPPİNG KISMI
    @FindBy(xpath = "//*[text()='Shipping']")
    public WebElement ShippinButton;

    @FindBy(xpath = "(//*[text()='Weight (kg)'])[1]")
    public WebElement ShippinButtonWeightText;

    @FindBy(xpath = "//*[@id='weight']")
    public WebElement ShippinButtonWeightBox;

    @FindBy(xpath = "(//*[text()='Dimensions (cm)'])[1]")
    public WebElement ShippinButtonDimensionsText;

    @FindBy(xpath = "//*[@id='length']")
    public WebElement ShippinButtonDimensionsLengthBox;

    @FindBy(xpath = "//*[@id='width']")
    public WebElement ShippinButtonDimensionsWidthBox;

    @FindBy(xpath = "//*[@id='height']")
    public WebElement ShippinButtonDimensionsHeightBox;

    @FindBy(xpath = "(//*[text()='Processing Time'])[1]")
    public WebElement ShippinButtonProcossingTimeText;

    @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']")
    public WebElement ShippinButtonProcessingTimeBox;

   // List<WebElement> ProcessingTimeDropDownList=
           // Driver.getDriver().findElements(By.xpath("//*[@id='_wcfmmp_processing_time']"));



    //ATTRİBUTES KISMI
    @FindBy(xpath = "(//*[text()='Attributes'])[1]")
    public WebElement AttributesButton;

    @FindBy(xpath = "(//*[text()='Color'])[1]")
    public WebElement AttributesButtonColorText;

    @FindBy(xpath = "(//*[@id='attributes_is_active_1'])[1]")
    public WebElement AttributesButtonColorCheckbox;

    @FindBy(xpath = "(//*[text()='Select all'])[1]")
    public WebElement AttributesButtonColorSelectAllButton;



    @FindBy(xpath = "(//*[text()='Size'])[1]")
    public WebElement AttributesButtonSizeText;

    @FindBy(xpath = "(//*[@id='attributes_is_active_2'])[1]")
    public WebElement AttributesButtonSizeCheckbox;








}
