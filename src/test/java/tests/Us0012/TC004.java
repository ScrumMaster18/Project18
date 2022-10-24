package tests.Us0012;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.MyAccountPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethots;

public class TC004 {
    ReusableMethots reusableMethots = new ReusableMethots();
    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    MyAccountPage myAccountPage = new MyAccountPage();
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC001() throws InterruptedException {
        reusableMethots.login();
        hubcomfyAnaSayfa.signOutButton.click();
        assert myAccountPage.myAccountPageTitle.isDisplayed();
        assert myAccountPage.myAccountPageAccountDetailsIcon.isDisplayed();
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccountPage.myAccountPageAccountDetailsIcon);
        jse.executeScript("arguments[0].click();", myAccountPage.myAccountPageAccountDetailsIcon);
        assert myAccountPage.myAccountPageAccountDetailsSubPageFirstNameText.isDisplayed();
        assert myAccountPage.myAccountPageAccountDetailsSubPageLastNameText.isDisplayed();
        assert myAccountPage.myAccountPageAccountDetailsSubPageDisplayNameText.isDisplayed();
        assert myAccountPage.myAccountPageAccountDetailsSubPageEmailText.isDisplayed();
        assert myAccountPage.myAccountPageAccountDetailsSubPageBiografyText.isDisplayed();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.getDriver().switchTo().frame(myAccountPage.myAccountPageAccountDetailsSubPageIframe);
        myAccountPage.myAccountPageAccountDetailsSubPageBiografyBox.sendKeys("There is a new some details");
        Driver.getDriver().switchTo().defaultContent();
        jse.executeScript("arguments[0].scrollIntoView(true);", myAccountPage.myAccountPageAccountDetailsSubPageSaveChangesButton);
        jse.executeScript("arguments[0].click();", myAccountPage.myAccountPageAccountDetailsSubPageSaveChangesButton);
        Thread.sleep(1000);
        assert myAccountPage.myAccountPageAccountDetailsSubPageSuccessChangesText.isDisplayed();


    }

}
