package tests.Us0009;

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

public class Us09Tc01 extends TestBaseRapor {

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
    public void kiloBoyutBelirleme() {
        extentTest=extentReports.createTest("Kilo Testi","Kilo Kontrol Edilir");
        //user basarılı bir sekilde giriş yapabilmeli
        reusableMethots.login();
        extentTest.info("Login olundu");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click()", hubcomfyAnaSayfa.homePageMyAccountButton);

        //My Account butonu dogrulanmalı ve tıklanmalı
        Assert.assertTrue(hubcomfyAnaSayfa.homePageMyAccountButton.isDisplayed());
        hubcomfyAnaSayfa.homePageMyAccountButton.click();
        extentTest.info("My Account a gidildi");

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
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

    //shippng secenegi dogrulanmalı tıklanmalı
        Assert.assertTrue(storeManagerProductsPages.ShippinButton.isDisplayed());
        jse.executeScript("arguments[0].scrollIntoView(true);",storeManagerProductsPages.ShippinButton);
        jse.executeScript("arguments[0].click();",storeManagerProductsPages.ShippinButton);


        Assert.assertTrue(storeManagerProductsPages.ShippinButtonWeightText.isDisplayed());
        storeManagerProductsPages.ShippinButtonDimensionsWidthBox.sendKeys("15");

        Assert.assertTrue(storeManagerProductsPages.ShippinButtonDimensionsText.isDisplayed());
        storeManagerProductsPages.ShippinButtonDimensionsLengthBox.clear();
        storeManagerProductsPages.ShippinButtonDimensionsLengthBox.sendKeys("20");
        storeManagerProductsPages.ShippinButtonDimensionsWidthBox.clear();
        storeManagerProductsPages.ShippinButtonDimensionsWidthBox.sendKeys("10");
        storeManagerProductsPages.ShippinButtonDimensionsHeightBox.clear();
        storeManagerProductsPages.ShippinButtonDimensionsHeightBox.sendKeys("15");

        jse.executeScript("arguments[0].scrollIntoView(true);",storeManagerProductsPages.ProductSubmitButton);
        jse.executeScript("arguments[0].click();",storeManagerProductsPages.ProductSubmitButton);
        wait.until(ExpectedConditions.visibilityOf(storeManagerProductsPages.ProductSuccessfullyPublishedMessage));
        Assert.assertTrue(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.isDisplayed());
        System.out.println(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.getText());

        extentTest.pass("kilo sonucları görüntülendi");





    }
}
