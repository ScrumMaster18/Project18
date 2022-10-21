package tests.Us0010;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

import java.io.IOException;
import java.time.Duration;

public class Us0010Tc01 {
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
    public void color() throws InterruptedException, IOException {
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
        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerPage.storeManagerMenuProducts);
        jse.executeScript("arguments[0].click();", storeManagerPage.storeManagerMenuProducts);


        //urun secimi yapılmalı ve tıklanmalı
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(storeManagerProductsPages.ProductMenuFriskesKediMaması.isDisplayed());
        storeManagerProductsPages.ProductMenuFriskesKediMaması.click();

        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        //Attributes secenegi dogrulanmalı tıklanmalı
        Assert.assertTrue(storeManagerProductsPages.AttributesButton.isDisplayed());
        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.AttributesButton);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.AttributesButton);



        String expectedColorText=storeManagerProductsPages.AttributesButtonColorText.getText();
        Assert.assertEquals(storeManagerProductsPages.AttributesButtonColorText.getText(),expectedColorText);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(storeManagerProductsPages.AttributesButtonColorCheckbox.isEnabled());
       if (!storeManagerProductsPages.AttributesButtonColorCheckbox.isSelected()){
           storeManagerProductsPages.AttributesButtonColorCheckbox.isSelected();
       }

       jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.AttributesButtonColorCheckbox);
       jse.executeScript("arguments[0].click();", storeManagerProductsPages.AttributesButtonColorCheckbox);


        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.AttributesButtonColorSelectAllButton);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.AttributesButtonColorSelectAllButton);

        actions.sendKeys(Keys.PAGE_UP).perform();





















    }}
