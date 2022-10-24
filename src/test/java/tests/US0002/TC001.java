package tests.US0002;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.MyAccountPage;
import pages.StoreManagerPage;
import pages.VendorRegistrationPage;
import utilities.*;

public class TC001 {

    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    MyAccountPage myAccountPage = new MyAccountPage();


    @Test
    public void testCase01() {

        Driver.getDriver().get(ConfigReader.getProperty("hubComfyUrl"));
        myAccountPage.registerButton.click();
        Assert.assertTrue(myAccountPage.becomeAVendorButton.isDisplayed());
        myAccountPage.registerIcindekiSignInButton.click();
        myAccountPage.signInPageUserNameBox.sendKeys("batch81.project18@gmail.com");
        myAccountPage.signInPagePasswordBox.sendKeys("Project_18..");
        myAccountPage.signInPageSignInButton.click();
        myAccountPage.signOut.click();
        Assert.assertTrue(myAccountPage.myAccountPageTitle.isDisplayed());
        Driver.closeDriver();
    }
}
