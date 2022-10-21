package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.*;

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

    StoreManagerPage storeManagerPage = new StoreManagerPage();
    Actions actions = new Actions(Driver.getDriver());
    CustomersPage customersPage = new CustomersPage();



    public void storManagerSayfasiDogrulama() throws InterruptedException {
    login();
    String expectedTitle = "Hubcomfy Online Shopping";
    String actualTitle = Driver.getDriver().getTitle();
    Assert.assertEquals(actualTitle,expectedTitle);
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    jse.executeScript("arguments[0].scrollIntoView(true);",storeManagerPage.storeManagerMenuMyAccount);
    jse.executeScript("arguments[0].click();",storeManagerPage.storeManagerMenuMyAccount);
    Thread.sleep(3000);
    storeManagerPage.storeManagerMenuMyAccount.click();
    storeManagerPage.StoreManager.click();
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    Thread.sleep(2000);
    storeManagerPage.storeManagerMenuCustomers.click();
    actions.sendKeys(Keys.PAGE_DOWN).perform();

    Assert.assertTrue(customersPage.Name.isDisplayed());
    Assert.assertTrue(customersPage.Username.isDisplayed());
    Assert.assertTrue(customersPage.Email.isDisplayed());
    Assert.assertTrue(customersPage.Location.isDisplayed());
    Assert.assertTrue(customersPage.Orders.isDisplayed());
    Assert.assertTrue(customersPage.MoneySpent.isDisplayed());
    Assert.assertTrue(customersPage.LastOrder.isDisplayed());
    Assert.assertTrue(customersPage.Actions.isDisplayed());
}



}
