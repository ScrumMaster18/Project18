package utilities;

import org.openqa.selenium.WindowType;
import pages.HubcomfyAnaSayfa;
import pages.TempMail;
import pages.VendorRegistrationPage;

public class ReusableMethots {

HubcomfyAnaSayfa hubcomfyAnaSayfa=new HubcomfyAnaSayfa();
    TempMail tempMail = new TempMail();
    public String email;
    public String verificationCode;

    public String tempMailWindowHandle;




    public String emailAdresi() {

        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get("https://www.minuteinbox.com/");
        email = tempMail.emailAdresi.getText();
        tempMailWindowHandle = Driver.getDriver().getWindowHandle();
        System.out.println(email);
        this.email = email;
        return email;
    }

    public String verificationCode() {
        verificationCode = tempMail.verificationCode.getText().replaceAll("\\D", "");
        return verificationCode;

    }
public void login(){
     Driver.getDriver().get(ConfigReader.getProperty("hubComfyUrl"));
        hubcomfyAnaSayfa.signInButonu.click();
        hubcomfyAnaSayfa.signInPopUpEmail.sendKeys(ConfigReader.getProperty("user"));
hubcomfyAnaSayfa.signInPopUpPassword.sendKeys(ConfigReader.getProperty("password"));
hubcomfyAnaSayfa.signInPopUpSignInButonu.click();

}



}
