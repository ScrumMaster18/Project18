package tests.Us0001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HubcomfyAnaSayfa;
import pages.TempMail;
import pages.VendorRegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US001 {
    HubcomfyAnaSayfa hubcomfyAnaSayfa=new HubcomfyAnaSayfa();
VendorRegistrationPage vendorRegistrationPage=new VendorRegistrationPage();
TempMail tempMail=new TempMail();
    String email;
String verificationCode;
String HubComfyWindowHandle;
String tempMailWindowHandle;
    @Test
    public void pozitifLoginTest() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("hubComfyUrl"));
hubcomfyAnaSayfa.anasayfaRegiterButonu.click();
Thread.sleep(2000);
hubcomfyAnaSayfa.anasayfaPopUpBecameVendor.click();
HubComfyWindowHandle=Driver.getDriver().getWindowHandle();
        emailAdresi();
Driver.getDriver().switchTo().window(HubComfyWindowHandle);
vendorRegistrationPage.vendorRegistrationEmail.sendKeys(email);
vendorRegistrationPage.vendorRegistrationPassword.sendKeys(ConfigReader.getProperty("validPassword"));
        Driver.getDriver().switchTo().window(tempMailWindowHandle);
verificationCode();
        Driver.getDriver().switchTo().window(HubComfyWindowHandle);
vendorRegistrationPage.vendorVerificationCode.sendKeys(verificationCode);
     //   Driver.closeDriver();

    }

public String emailAdresi(){

    Driver.getDriver().switchTo().newWindow(WindowType.TAB).get("https://www.minuteinbox.com/");
email=tempMail.emailAdresi.getText();
    tempMailWindowHandle=Driver.getDriver().getWindowHandle();
    System.out.println(email);
    this.email=email;
        return email;
}
public String  verificationCode(){
verificationCode=tempMail.verificationCode.getText().replaceAll("\\D","");
        //verificationCode=Integer.parseInt(str);
return verificationCode;

}

}
