package tests.US0016;

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
