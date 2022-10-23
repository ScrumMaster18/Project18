package tests.Us0011;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.MyAccountPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.ReusableMethots;
import utilities.TestBaseRapor;

public class TC001 extends TestBaseRapor {
    ReusableMethots reusableMethots = new ReusableMethots();
    ReusableMethods reusableMethods = new ReusableMethods();
    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    MyAccountPage myAccountPage = new MyAccountPage();
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() throws InterruptedException {
        extentTest=extentReports.createTest("Toptan Gosterme Ayarlarinin Goruntulenmesi","Toptan Urun Gosterme Ayarlari Gosterilebilir");

        reusableMethots.login();
        hubcomfyAnaSayfa.signOutButton.click();
        assert myAccountPage.myAccountPageTitle.isDisplayed();
        myAccountPage.myAccountPageStoreManagerMenu.click();
        assert myAccountPage.storeManagerPageTitle.isDisplayed();
        myAccountPage.storeManagerPageProductsMenu.click();
        myAccountPage.storeManagerPageProductsSubPageAddNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccountPage.storeManagerPageManageProductSubPageToptanUrunGostermeButton);
        jse.executeScript("arguments[0].click();", myAccountPage.storeManagerPageManageProductSubPageToptanUrunGostermeButton);
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccountPage.storeManagerPageManageProductSubPagePieceTypeTitle);
        Thread.sleep(1000);
        assert myAccountPage.storeManagerPageManageProductSubPagePieceTypeTitle.isDisplayed();


    }
}
