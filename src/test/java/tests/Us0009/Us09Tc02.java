package tests.Us0009;

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

import java.time.Duration;
import java.util.List;

public class Us09Tc02 {
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
    public void teslimatSüresi() throws InterruptedException {
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

        //shippng secenegi dogrulanmalı tıklanmalı
        Assert.assertTrue(storeManagerProductsPages.ShippinButton.isDisplayed());
        jse.executeScript("arguments[0].scrollIntoView(true);", storeManagerProductsPages.ShippinButton);
        jse.executeScript("arguments[0].click();", storeManagerProductsPages.ShippinButton);

        String expectedProcossingTimeText=storeManagerProductsPages.ShippinButtonProcossingTimeText.getText();
        Assert.assertEquals(storeManagerProductsPages.ShippinButtonProcossingTimeText.getText(),expectedProcossingTimeText);
        Assert.assertTrue(storeManagerProductsPages.ShippinButtonProcessingTimeBox.isEnabled());


        WebElement procossingTimeBoxDD =Driver.getDriver().findElement(By.xpath("//*[@id='_wcfmmp_processing_time']"));
        Select select = new Select(procossingTimeBoxDD);
        List<WebElement> ShippinButtonProcessingTimeBoxList= Driver.getDriver().findElements(By.xpath("//*[@id='_wcfmmp_processing_time']//option"));
        ShippinButtonProcessingTimeBoxList.forEach(t-> System.out.println(t.getText()));
        Thread.sleep(3000);


        select.selectByVisibleText("Ready to ship in...");
       Thread.sleep(3000);
      select.selectByVisibleText("1 business day");
      Thread.sleep(2000);
      select.selectByVisibleText("1-2 business days");
      Thread.sleep(2000);
      select.selectByVisibleText("1-3 business days");
      Thread.sleep(2000);
      select.selectByVisibleText("3-5 business days");
      Thread.sleep(2000);
      select.selectByVisibleText("1-2 weeks");
      Thread.sleep(2000);
      select.selectByVisibleText("2-3 weeks");
      Thread.sleep(2000);
      select.selectByVisibleText("3-4 weeks");
      Thread.sleep(2000);
      select.selectByVisibleText("4-6 weeks");
      Thread.sleep(2000);
      select.selectByVisibleText("6-8 weeks");
      Thread.sleep(2000);

        jse.executeScript("arguments[0].scrollIntoView(true);",storeManagerProductsPages.ProductSubmitButton);
        jse.executeScript("arguments[0].click();",storeManagerProductsPages.ProductSubmitButton);
        wait.until(ExpectedConditions.visibilityOf(storeManagerProductsPages.ProductSuccessfullyPublishedMessage));
        Assert.assertTrue(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.isDisplayed());
        System.out.println(storeManagerProductsPages.ProductSuccessfullyPublishedMessage.getText());










    }
}
