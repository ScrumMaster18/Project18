package tests.Us0003;

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
        myAccountPage.signInButton.click();
        myAccountPage.signInPageUserNameBox.sendKeys("batch81.project18@gmail.com");
        myAccountPage.signInPagePasswordBox.sendKeys("Project_18..");
        myAccountPage.signInPageSignInButton.click();
        myAccountPage.signOut.click();
        Assert.assertTrue(myAccountPage.myAccountPageOrdersIcon.isDisplayed());
        myAccountPage.myAccountPageOrdersIcon.click();
        Assert.assertTrue(myAccountPage.myAccountPageOrdersSubPageBrowseProductsButton.isDisplayed());
        myAccountPage.myAccountPageOrdersSubPageBrowseProductsButton.click();
        myAccountPage.shopPageFirstProductForCart.click();
        myAccountPage.shopPageSecondProductForCart.click();
        myAccountPage.shopPageThirdProductForCart.click();
        myAccountPage.shopPageFourthProductForCart.click();
        myAccountPage.shopPageFifthProductForCart.click();
        myAccountPage.shopPageCartButton.click();
        Assert.assertTrue(myAccountPage.shoppingCartCheckoutButton.isDisplayed());
        myAccountPage.shoppingCartCheckoutButton.click();
        Driver.closeDriver();
    }
}
