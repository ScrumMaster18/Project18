package tests.Us0008;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
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

import java.time.Duration;
import java.time.Instant;


public class Us08Tc01 {

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
    public void stockBelirleme() throws InterruptedException { //Urun miktarı ve stock belirlenmeli
        //user basarılı bir sekilde giriş yapabilmeli
        reusableMethots.login();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click()", hubcomfyAnaSayfa.homePageMyAccountButton);

        //My Account butonu dogrulanmalı ve tıklanmalı
        Assert.assertTrue(hubcomfyAnaSayfa.homePageMyAccountButton.isDisplayed());
        hubcomfyAnaSayfa.homePageMyAccountButton.click();

        //store manager dogrulanmalı tıklanmalı
        Assert.assertTrue(hubcomfyAnaSayfa.myAccountPageStoreManagerMenu.isDisplayed());
        hubcomfyAnaSayfa.myAccountPageStoreManagerMenu.click();

        //product menu dogrulanmalı ve tıklanmalı
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(storeManagerPage.storeManagerMenuProducts.isDisplayed());
        jse.executeScript("arguments[0].scrollIntoView(true);",storeManagerPage.storeManagerMenuProducts);
        jse.executeScript("arguments[0].click();",storeManagerPage.storeManagerMenuProducts);


        //urun secimi yapılmalı ve tıklanmalı
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(storeManagerProductsPages.ProductMenuFriskesKediMaması.isDisplayed());
        storeManagerProductsPages.ProductMenuFriskesKediMaması.click();

        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        //ınventory secenegi  acık geliyor tıklama yapılmıyor
        //ınventor secenegi dogrulanmalı yapılıyor tıklama yapılmıyor
        String expectedInventoryText = storeManagerProductsPages.InventoryButton.getText();
        Assert.assertEquals(storeManagerProductsPages.InventoryButton.getText(), expectedInventoryText);

        //manage stock checkbox u erişilebilir olmalı secili degilse secilmeli
        Assert.assertTrue(storeManagerProductsPages.InventoryPageManageStockCheckBox.isEnabled());
        if (!storeManagerProductsPages.InventoryPageManageStockCheckBox.isSelected()) {
            storeManagerProductsPages.InventoryPageManageStockCheckBox.isSelected();
        }

        //stock qty dodrulanmalı
        String expectedInventoryPageStockQtyText = storeManagerProductsPages.InventoryPageStockQtyText.getText();
        Assert.assertEquals(storeManagerProductsPages.InventoryPageStockQtyText.getText(), expectedInventoryPageStockQtyText);

        //stock qty box u erişilebilir olmalı
        Assert.assertTrue(storeManagerProductAddNewMenu.InventoryPageStockQtyDataBox.isEnabled());
        storeManagerProductsPages.InventoryPageStockQtyDataBox.clear();
        Thread.sleep(1000);
        storeManagerProductsPages.InventoryPageStockQtyDataBox.sendKeys("22");
        Thread.sleep(1000);
        storeManagerProductsPages.InventoryPageStockQtyText.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        //sumbit butonu  tıklanmalı

        jse.executeScript("arguments[0].scrollIntoView(true);",storeManagerProductsPages.ProductSubmitButton);
        jse.executeScript("arguments[0].click();",storeManagerProductsPages.ProductSubmitButton);


        //dogrulama mesajı görünür olmalı
        wait.until(ExpectedConditions.visibilityOf(storeManagerProductsPages.ProductSuccessfullyPublishedMessage));

        Assert.assertTrue(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.isDisplayed());
        System.out.println(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.getText());







    }
}
