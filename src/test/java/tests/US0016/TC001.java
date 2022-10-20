package tests.US0016;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.StoreManagerPage;
import utilities.Driver;
import utilities.ReusableMethots;

public class TC001 {
    ReusableMethots reusableMethots=new ReusableMethots();
    StoreManagerPage storeManagerPage = new StoreManagerPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test1() throws InterruptedException {
        reusableMethots.login();
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

    }
}
