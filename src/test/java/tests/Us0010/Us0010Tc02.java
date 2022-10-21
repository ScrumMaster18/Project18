package tests.Us0010;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Us0010Tc02 {
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
    public void size() throws InterruptedException, IOException {
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


        String expectedSizeText = storeManagerProductsPages.AttributesButtonSizeText.getText();
        Assert.assertEquals(storeManagerProductsPages.AttributesButtonSizeText.getText(), expectedSizeText);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertTrue(storeManagerProductsPages.AttributesButtonSizeCheckbox.isEnabled());
        if (!storeManagerProductsPages.AttributesButtonSizeCheckbox.isSelected()) {
            storeManagerProductsPages.AttributesButtonSizeCheckbox.isSelected();
        }

        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.AttributesButtonSizeCheckbox);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.AttributesButtonSizeCheckbox);


        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.AttributesButtonSizeSelectAllButton);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.AttributesButtonSizeSelectAllButton);

        actions.sendKeys(Keys.PAGE_UP).perform();

        WebElement sizeBox= Driver.getDriver().findElement(By.xpath("//select[@id='attributes_value_2']"));
        Select select = new Select(sizeBox);
        List<WebElement> sizeBoxList=Driver.getDriver().findElements(By.xpath("//select[@id='attributes_value_2']//option"));
        sizeBoxList.forEach(t-> System.out.println(t.getText()));




       // WebElement sizeSelectAll=Driver.getDriver().findElement(By.xpath("//*[@class='select2-selection__rendered'])[3]"));
       // ReusableMethods.getScreenshotWebElement("sizeBox", sizeSelectAll);

    }}



