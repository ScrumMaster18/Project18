package tests.Us0008;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
import java.util.List;

public class Us08Tc02 extends TestBaseRapor {

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
    public void backordersTesti() throws InterruptedException {
        extentTest = extentReports.createTest("Backorder Testi", "Backorder Secenekleri Kontrol Edilir");
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
        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerPage.storeManagerMenuProducts);
        jse.executeScript("arguments[0].click();", storeManagerPage.storeManagerMenuProducts);

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

        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.InventoryButton);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.InventoryButton);

        extentTest.info("Inventory görünür ve tıklandı");


        //manage stock checkbox u erişilebilir olmalı secili degilse secilmeli
        Assert.assertTrue(storeManagerProductsPages.InventoryPageManageStockCheckBox.isEnabled());
        if (!storeManagerProductsPages.InventoryPageManageStockCheckBox.isSelected()) {
            storeManagerProductsPages.InventoryPageManageStockCheckBox.isSelected();
        }

        extentTest.info("Manager Stock erişilebilir ve CheckBox secildi");

        //Backorder secenegi görünür olmalı ve secim yapılabilmeli
        String expectedAllowBackordersText = storeManagerProductsPages.InventoryPageAllowBackordersText.getText();
        System.out.println(expectedAllowBackordersText);
        Assert.assertEquals(storeManagerProductsPages.InventoryPageAllowBackordersText.getText(), expectedAllowBackordersText);
        Assert.assertTrue(storeManagerProductsPages.InventoryPageAllowBackordersBox.isEnabled());

        extentTest.info("Allow Backorders görünür ve AllowBackOrders erişilebilirdir");

        //drapdown seceneklerini dogrular
        WebElement AllowBackordesDrapDawn = Driver.getDriver().findElement(By.xpath("//select[@id='backorders']"));
        Select select = new Select(AllowBackordesDrapDawn);
        List<WebElement> AllowBackordesDrapDawnList = Driver.getDriver().findElements(By.xpath("//select[@id='backorders']//option"));
        AllowBackordesDrapDawnList.forEach(t -> System.out.println(t.getText()));

        //do not Allow secenegine erişilebilir olmalıdır ve tıklanır
        select.selectByVisibleText("Do not Allow");
        Thread.sleep(2000);

        extentTest.info("Do Not Allow secenegi görünür ve erişilebilirdir");


        //do not Allow secenegine erişilebilir olmalıdır ve tıklanır
        select.selectByVisibleText("Allow, but notify customer");
        Thread.sleep(2000);

        extentTest.info("Allow, but notify customer secenegi görünür ve erişilebilirdir");

        //Allow secenegine erişilebilir olmalıdır ve tıklanır
        select.selectByVisibleText("Allow");

        extentTest.info("Allow secenegi görünür ve erişilebilirdir");


        //sumbit butonu dogrular  tıklar
        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.ProductSubmitButton);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.ProductSubmitButton);

        extentTest.info("Sumbit Butonu görünür ve tıklandı");

        //Dogrulama mesajı görünür olmalıdır
        wait.until(ExpectedConditions.visibilityOf(storeManagerProductsPages.ProductSuccessfullyPublishedMessage));
        Assert.assertTrue(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.isDisplayed());
        System.out.println(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.getText());

        extentTest.info("Dogrulama mesajı görünür ve tıklandı");


    }
}
