package tests.Us0003;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.MyAccountPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC004 {

    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    MyAccountPage myAccountPage = new MyAccountPage();

    @Test
    public void testCase04() {

        Driver.getDriver().get(ConfigReader.getProperty("hubComfyUrl"));
        myAccountPage.signInButton.click();
        myAccountPage.signInPageUserNameBox.sendKeys("batch81.project18@gmail.com");
        myAccountPage.signInPagePasswordBox.sendKeys("Project_18..");
        myAccountPage.signInPageSignInButton.click();
        myAccountPage.signOut.click();
        myAccountPage.shopPageCartButton.click();
        Assert.assertTrue(myAccountPage.shoppingCartCheckoutButton.isDisplayed());
        myAccountPage.shoppingCartCheckoutButton.click();
        myAccountPage.checkoutPageFirstNameBox.sendKeys("Scrum");
        myAccountPage.checkoutPageLastNameBox.sendKeys("Master");
        myAccountPage.checkoutPageCountryDropDownMenu.sendKeys("Unıted States");
        myAccountPage.checkoutPageAddressBox.sendKeys("Kültür Mah. 3874. Sokak");
        myAccountPage.checkoutPageTownCityBox.sendKeys("Antalya");
        myAccountPage.checkoutPageStateCountryBox.sendKeys("Alaska");
        myAccountPage.checkoutPageZipBox.sendKeys("07100");
        myAccountPage.checkoutPagePhoneBox.sendKeys("05537418596");
        myAccountPage.checkoutPageEmailBox.sendKeys("batch81.project18@gmail.com");
        Driver.closeDriver();
    }
}
