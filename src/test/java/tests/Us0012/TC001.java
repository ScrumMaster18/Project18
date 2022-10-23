package tests.Us0012;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.MyAccountPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethots;

public class TC001 {
    ReusableMethots reusableMethots = new ReusableMethots();
    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    MyAccountPage myAccountPage = new MyAccountPage();
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC001() {
        reusableMethots.login();
        hubcomfyAnaSayfa.signOutButton.click();
        assert myAccountPage.myAccountPageTitle.isDisplayed();
        assert myAccountPage.myAccountPageOrdersIcon.isDisplayed();
        myAccountPage.myAccountPageOrdersIcon.click();

    }
}
