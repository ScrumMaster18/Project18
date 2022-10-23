package tests.Us0010;

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

import java.io.IOException;
import java.time.Duration;

public class Us0010Tc02 extends TestBaseRapor {
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

        extentTest = extentReports.createTest("Size Testi", "Sizelar Erişilebilirdir");

        //user basarılı bir sekilde giriş yapabilmeli
        reusableMethots.login();
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click()", hubcomfyAnaSayfa.homePageMyAccountButton);

        extentTest.info("Basarılı bir sekilde giriş yapıldı");

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
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        //Attributes secenegi dogrulanmalı tıklanmalı
        Assert.assertTrue(storeManagerProductsPages.AttributesButton.isDisplayed());
        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.AttributesButton);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.AttributesButton);

        extentTest.info("Attributes görünür ve tıklandı");




        //Size secenegi görünür ve checkbox secilebilir olmalıdır
        String expectedSizeText = storeManagerProductsPages.AttributesButtonSizeText.getText();
        Assert.assertEquals(storeManagerProductsPages.AttributesButtonSizeText.getText(), expectedSizeText);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(storeManagerProductsPages.AttributesButtonSizeCheckbox.isEnabled());
        if (!storeManagerProductsPages.AttributesButtonSizeCheckbox.isSelected()) {
            storeManagerProductsPages.AttributesButtonSizeCheckbox.isSelected();
        }
        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.AttributesButtonSizeCheckbox);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.AttributesButtonSizeCheckbox);

        extentTest.info("Size secenegi görünür ve erişilebilirdir");


        //SelectAll Button erişilebilir olmalı ve tüm sizleri secebilmelidir
        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.AttributesButtonSizeSelectAllButton);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.AttributesButtonSizeSelectAllButton);
        actions.sendKeys(Keys.PAGE_UP).perform();

        extentTest.info("SelectAll secenegi görünür ve erişilebilirdir");


        //Size olmayan secenekler ss ile belgelenip bu test fail olarak raporlanmalıdır ama nasıl??

        //Sumbit Button dogrulanmalı tıklanmalı
        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.ProductSubmitButton);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.ProductSubmitButton);

        extentTest.info("Sumbit görünür ve tıklanabilir");

        //Dogrulama mesajı görünür olmalı
        wait.until(ExpectedConditions.visibilityOf(storeManagerProductsPages.ProductSuccessfullyPublishedMessage));
        Assert.assertTrue(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.isDisplayed());
        System.out.println(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.getText());

        extentTest.pass("Dogrulama mesajı görüntülendi");






        // WebElement sizeSelectAll=Driver.getDriver().findElement(By.xpath("//*[@class='select2-selection__rendered'])[3]"));
        // ReusableMethods.getScreenshotWebElement("sizeBox", sizeSelectAll);

    }}



