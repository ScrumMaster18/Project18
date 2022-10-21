package tests.US0018;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethots;

public class TC001 {

    ReusableMethots reusableMethots=new ReusableMethots();
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    CustomersPage customersPage = new CustomersPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test1() throws InterruptedException {

        reusableMethots.login();
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
        customersPage.AddNewRefund.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        String expectedTitle2 = "Refund Requests";
        String actualTitle2 = customersPage.RefundMenuRefundRequestsSayfasi.getText();
        Assert.assertEquals(expectedTitle2,actualTitle2);
        customersPage.RefundMenuRequestID.isDisplayed();

    }
}
