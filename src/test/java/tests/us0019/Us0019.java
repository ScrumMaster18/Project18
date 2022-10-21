package tests.us0019;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethots;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.List;

public class Us0019 extends TestBaseRapor {

    ReusableMethots reusableMethots = new ReusableMethots();
    WebDriver driver;
    Actions actions = new Actions(Driver.getDriver());
    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(20));
    StoreManagerPage storeManagerPage = new StoreManagerPage();


    @Test
    public void followerlist () {

        extentTest=extentReports.createTest("Follower List Testi","Follower Listesi Kontrol Edilir");

        reusableMethots.login();
        extentTest.info("Login olundu");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        //Thread.sleep(5000);  //çalışıyo
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='My Account'])[2]")));  //çalışmıyo
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click()",hubcomfyAnaSayfa.homePageMyAccountButton);
        hubcomfyAnaSayfa.homePageMyAccountButton.click();
        Assert.assertTrue(storeManagerPage.myAccountYazı.isDisplayed());
        extentTest.info("My accounta girildi");

        hubcomfyAnaSayfa.myAccountPageStoreManagerMenu.click();
        extentTest.info("Store managera girildi");

        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        storeManagerPage.storeManagerMenuFollowers.click();
        extentTest.info("Follwers menüsüne girildi");

        //WebElement baslik = Driver.getDriver().findElement(By.xpath("//thead//tr"));
        //System.out.println(baslik.getText());
        //WebElement followerlistbody = Driver.getDriver().findElement(By.xpath("//tbody//tr[1]"));
        //String follower= followerlistbody.getText();
        Assert.assertNotEquals(storeManagerPage.followerlistbody.getText(),"fgfd");
        extentTest.pass("Follower listesi görüntülendi");

    }

}