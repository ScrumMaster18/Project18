package tests.us0021;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.StoreManagerPage;
import utilities.*;

import java.io.IOException;
import java.time.Duration;

public class Us0021 extends TestBaseRapor {

    ReusableMethots reusableMethots = new ReusableMethots();
    ReusableMethods reusableMethods = new ReusableMethods();
    WebDriver driver;
    Actions actions = new Actions(Driver.getDriver());
    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    StoreManagerPage storeManagerPage = new StoreManagerPage();


    @Test
    public void reports() throws IOException, InterruptedException {

        extentTest=extentReports.createTest("Reports Testi","Reportlar Kontrol Edilir");

        reusableMethots.login();
        extentTest.info("Login olundu");

        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click()", hubcomfyAnaSayfa.homePageMyAccountButton);
        hubcomfyAnaSayfa.homePageMyAccountButton.click();
        Assert.assertTrue(storeManagerPage.myAccountYazı.isDisplayed());
        extentTest.info("My accounta girildi");

        hubcomfyAnaSayfa.myAccountPageStoreManagerMenu.click();
        extentTest.info("Store managera girildi");

        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        storeManagerPage.storeManagerMenuReports.click();
        extentTest.info("Reports menüsüne girildi");

        storeManagerPage.reportsyear.click();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);
        ReusableMethods.getScreenshot("Year");
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        extentTest.info("Year reports grafiği kontrol edildi");

        storeManagerPage.reportslastmonth.click();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);
        ReusableMethods.getScreenshot("Last Month");
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        extentTest.info("Last month reports grafiği kontrol edildi");

        storeManagerPage.reportsthismonth.click();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);
        ReusableMethods.getScreenshot("This Month");
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        extentTest.info("This month reports grafiği kontrol edildi");

        storeManagerPage.reportslast7days.click();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);
        ReusableMethods.getScreenshot("Last 7 Days");
        actions.sendKeys(Keys.PAGE_UP).build().perform();
        extentTest.info("Last 7 days reports grafiği kontrol edildi");

        storeManagerPage.customdatebox.click();
        storeManagerPage.customdate1.click();
        storeManagerPage.customdate2.click();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(2000);
        ReusableMethods.getScreenshot("Custom date range reports grafiği kontrol edildi");
        extentTest.info("Custom date range reports grafiği kontrol edildi");

        Driver.quitDriver();

        extentTest.pass("Reportlar görüntülendi");


    }
}