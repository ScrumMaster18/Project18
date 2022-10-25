package tests.us0020;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethots;
import utilities.TestBaseRapor;

import java.time.Duration;

public class Us0020 extends TestBaseRapor {

    ReusableMethots reusableMethots = new ReusableMethots();
    WebDriver driver;
    Actions actions = new Actions(Driver.getDriver());
    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    StoreManagerPage storeManagerPage = new StoreManagerPage();




    @Test
    public void productreviews () {

        extentTest=extentReports.createTest("Product Reviews Testi","Product Reviews Listesi Kontrol Edilir");

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
        storeManagerPage.storeManagerMenuReviews.click();
        extentTest.info("Reviews menüsüne girildi");

        storeManagerPage.productReviews.click();
        extentTest.info("Product reviews listesine girildi");

        Assert.assertEquals(storeManagerPage.reviwesauthor.getText(),"tlh\n" +
                "mnebipwpbwiyxfocsp@tmmwj.com");
        extentTest.info("Author doğrulandı");

        Assert.assertEquals(storeManagerPage.reviewscomment.getText(),"sadasdasdasdasdasd");
        extentTest.info("Comment doğrulandı");

        Assert.assertEquals(storeManagerPage.reviewsrate.getAttribute("title"),"Rated 2 out of 5");
        extentTest.info("Rate doğrulandı");

        Assert.assertEquals(storeManagerPage.reviewsdate.getText(),"15 October 2022 02:04");
        extentTest.info("Date doğrulandı");

        extentTest.pass("Product reviews listesi görüntülendi");

    }
}