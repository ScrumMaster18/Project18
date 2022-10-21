package tests.US0017;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import utilities.Driver;
import utilities.ReusableMethots;

import java.time.Duration;

public class TC002 {

    ReusableMethots reusableMethots = new ReusableMethots();
    CustomersPage customersPage = new CustomersPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test1() throws InterruptedException {
        reusableMethots.storManagerSayfasiDogrulama();
        customersPage.EditCustomer.click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",customersPage.ShippingMenuSameasBilling);
        jse.executeScript("arguments[0].click();",customersPage.ShippingMenuSameasBilling);
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Assert.assertEquals(customersPage.BillingFirstName.getText(),customersPage.ShippingMenuFirstName.getText());

        customersPage.BillinhgMenuSubmit.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(customersPage.basariylaKaydedildi));

        Assert.assertTrue(customersPage.basariylaKaydedildi.isDisplayed());

    }

}
