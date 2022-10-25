package tests.Us0001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.VendorRegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethots;
import utilities.TestBaseRapor;

public class US001 extends TestBaseRapor {
    HubcomfyAnaSayfa hubcomfyAnaSayfa = new HubcomfyAnaSayfa();
    VendorRegistrationPage vendorRegistrationPage = new VendorRegistrationPage();
    String HubComfyWindowHandle;
    ReusableMethots reusableMethots = new ReusableMethots();



    @Test
    public void openAccount() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("hubComfyUrl"));
        hubcomfyAnaSayfa.anasayfaRegiterButonu.click();
        hubcomfyAnaSayfa.anasayfaPopUpBecameVendor.click();
        HubComfyWindowHandle = Driver.getDriver().getWindowHandle();
        reusableMethots.emailAdresi();
        Driver.getDriver().switchTo().window(HubComfyWindowHandle);
        vendorRegistrationPage.vendorRegistrationEmail.sendKeys(reusableMethots.email);
        vendorRegistrationPage.vendorRegistrationPassword.sendKeys(ConfigReader.getProperty("validPassword"));
        Driver.getDriver().switchTo().window(reusableMethots.tempMailWindowHandle);
        reusableMethots.verificationCode();
        Driver.getDriver().switchTo().window(HubComfyWindowHandle);
        vendorRegistrationPage.vendorVerificationCode.sendKeys(reusableMethots.verificationCode);
        vendorRegistrationPage.vendorRegistrationConfirmPassword.sendKeys(ConfigReader.getProperty("validPassword"));
        vendorRegistrationPage.vendorRegistrationRegisterButonu.click();
        Assert.assertTrue(vendorRegistrationPage.getVendorRegistrationOnayMesaji.isDisplayed());
    }
    @Test
    public void login(){
        extentTest=extentReports.createTest("Login Testi","Login Oldugu Kontrol Edilir");
        reusableMethots.login();
        extentTest.info("Basırılı bir sekilde login olundu");
        extentTest.pass("Reportlar görüntülendi");


    }
}
