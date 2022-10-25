package tests.Us0008;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.StoreManagerPage;
import pages.StoreManagerProductAddNewMenu;
import pages.StoreManagerProductsPages;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.ReusableMethots;
import utilities.TestBaseRapor;

import java.time.Duration;


public class Us08Tc01 extends TestBaseRapor {

    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    ReusableMethots reusableMethots = new ReusableMethots();
    ReusableMethods reusableMethods = new ReusableMethods();
    Actions actions = new Actions(Driver.getDriver());
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    StoreManagerProductAddNewMenu storeManagerProductAddNewMenu = new StoreManagerProductAddNewMenu();
    WebDriver driver;
    StoreManagerProductsPages storeManagerProductsPages = new StoreManagerProductsPages();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void stockBelirlemeTesti() throws InterruptedException {
        //Urun miktarı ve stock belirlenmeli
        extentTest=extentReports.createTest("Stok Belirleme Testi","Kilo Datası Kontrol Edilir");
        //user basarılı bir sekilde giriş yapabilmeli
        reusableMethots.login();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click()", hubcomfyAnaSayfa.homePageMyAccountButton);

        extentTest.info("Basırılı bir sekilde login olundu");

        //My Account butonu dogrulanmalı ve tıklanmalı
        Assert.assertTrue(hubcomfyAnaSayfa.homePageMyAccountButton.isDisplayed());
        hubcomfyAnaSayfa.homePageMyAccountButton.click();

        extentTest.info("My Account Buttonu görünür ve tıklandı");

        //store manager dogrulanmalı tıklanmalı
        Assert.assertTrue(hubcomfyAnaSayfa.myAccountPageStoreManagerMenu.isDisplayed());
        hubcomfyAnaSayfa.myAccountPageStoreManagerMenu.click();

        extentTest.info("Store Manager görünür ve tıklandı");

        //product menu dogrulanmalı ve tıklanmalı
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(storeManagerPage.storeManagerMenuProducts.isDisplayed());
        jse.executeScript("arguments[0].scrollIntoView(true);",storeManagerPage.storeManagerMenuProducts);
        jse.executeScript("arguments[0].click();",storeManagerPage.storeManagerMenuProducts);

        extentTest.info("Product menusu görünür ve tıklandı");


        //urun secimi yapılmalı ve tıklanmalı
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(storeManagerProductsPages.ProductMenuFriskesKediMaması.isDisplayed());
        storeManagerProductsPages.ProductMenuFriskesKediMaması.click();

        extentTest.info("Ürünler görünür ve secim yapıldı");

        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        //ınventor secenegi dogrular tıklar
        String expectedInventoryText = storeManagerProductsPages.InventoryButton.getText();
        Assert.assertEquals(storeManagerProductsPages.InventoryButton.getText(), expectedInventoryText);

        jse.executeScript("arguments[0].scrollIntoView(true);",storeManagerProductsPages.InventoryButton);
        jse.executeScript("arguments[0].click();",storeManagerProductsPages.InventoryButton);

        extentTest.info("Inventory görünür ve tıklandı");



        //manage stock checkbox u erişilebilir olmalı secili degilse secilmeli
        Assert.assertTrue(storeManagerProductsPages.InventoryPageManageStockCheckBox.isEnabled());
        if (!storeManagerProductsPages.InventoryPageManageStockCheckBox.isSelected()) {
            storeManagerProductsPages.InventoryPageManageStockCheckBox.isSelected();
        }

        extentTest.info("Manager Stock erişilebilir ve CheckBox secildi");

        //stock qty dodrulanmalı
        String expectedInventoryPageStockQtyText = storeManagerProductsPages.InventoryPageStockQtyText.getText();
        Assert.assertEquals(storeManagerProductsPages.InventoryPageStockQtyText.getText(), expectedInventoryPageStockQtyText);
        Assert.assertTrue(storeManagerProductAddNewMenu.InventoryPageStockQtyDataBox.isEnabled());
        storeManagerProductsPages.InventoryPageStockQtyDataBox.clear();
        Thread.sleep(1000);

        extentTest.info("Stock Qty dogrulandı ve tıklandı");

        //stock qty 0 dan buyuk bir sayı girer
        storeManagerProductsPages.InventoryPageStockQtyDataBox.sendKeys("22");
        Thread.sleep(1000);

        extentTest.info("Stock Qty Box a pozitif bir deger gönderildi");
        //bos bir alana tıklanması lazım onun için yazıldı
        storeManagerProductsPages.InventoryPageStockQtyText.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //sumbit butonu dogrular  tıklar

        jse.executeScript("arguments[0].scrollIntoView(true);",storeManagerProductsPages.ProductSubmitButton);
        jse.executeScript("arguments[0].click();",storeManagerProductsPages.ProductSubmitButton);

        extentTest.info("Sumbit Butonu görünür ve tıklandı");


        //dogrulama mesajı görünür olmalı
        wait.until(ExpectedConditions.visibilityOf(storeManagerProductsPages.ProductSuccessfullyPublishedMessage));
        Assert.assertTrue(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.isDisplayed());
        System.out.println(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.getText());

        extentTest.info("Dogrulama mesajı görünür ve tıklandı");

    }
}
