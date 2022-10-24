package tests.Us0002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.MyAccountPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC003 {


    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Test
    public void testCase03() {

        Driver.getDriver().get(ConfigReader.getProperty("hubComfyUrl"));
        myAccountPage.registerButton.click();
        Assert.assertTrue(myAccountPage.becomeAVendorButton.isDisplayed());
        myAccountPage.registerIcindekiSignInButton.click();
        myAccountPage.signInPageUserNameBox.sendKeys("batch81.project18@gmail.com");
        myAccountPage.signInPagePasswordBox.sendKeys("Project_18..");
        myAccountPage.signInPageSignInButton.click();
        myAccountPage.signOut.click();
        Assert.assertTrue(myAccountPage.myAccountPageDashBoardStoreManagerMenu.isDisplayed());
        Assert.assertTrue(myAccountPage.myAccountPageDashBoardOrdersMenu.isDisplayed());
        Assert.assertTrue(myAccountPage.myAccountPageDashBoardAddressesMenu.isDisplayed());
        Driver.closeDriver();
    }
}
