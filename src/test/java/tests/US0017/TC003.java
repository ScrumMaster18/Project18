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

public class TC003 {

    ReusableMethots reusableMethots = new ReusableMethots();
    CustomersPage customersPage = new CustomersPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test1() throws InterruptedException {
        reusableMethots.storManagerSayfasiDogrulama();
        customersPage.EditCustomer.click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", customersPage.ShippingMenuSameasBilling);
        jse.executeScript("arguments[0].click();", customersPage.ShippingMenuSameasBilling);
        Thread.sleep(3000);

        wait.until(ExpectedConditions.visibilityOf(customersPage.ShippingMenuFirstName));
        customersPage.ShippingMenuFirstName.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        customersPage.ShippingMenuFirstName.sendKeys("Ahmet");
        actions.sendKeys(Keys.TAB).sendKeys("Candan").sendKeys(Keys.TAB).sendKeys("Ahmet Nakliyat").
                sendKeys(Keys.TAB).sendKeys("Tepebaşı mah.").sendKeys(Keys.TAB).
                sendKeys("Tepebaşı mah. Uzun sk.").
                sendKeys(Keys.PAGE_DOWN).perform();
        customersPage.ShippingMenuCityTown.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        customersPage.ShippingMenuCityTown.sendKeys("Bursa");
        customersPage.ShippingMenuStateCountyDropDown.click();

        wait.until(ExpectedConditions.visibilityOf(customersPage.ShippingMenuStateCountyDropDownBursa));
        customersPage.ShippingMenuStateCountyDropDownBursa.click();
        customersPage.ShippingMenuPostcodeZip.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        customersPage.ShippingMenuPostcodeZip.sendKeys("16100");
        customersPage.BillinhgMenuSubmit.click();
         wait.until(ExpectedConditions.visibilityOf(customersPage.basariylaKaydedildi));

        Assert.assertTrue(customersPage.basariylaKaydedildi.isDisplayed());

    }
}
