package tests.US0017;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import utilities.Driver;
import utilities.ReusableMethots;

import java.time.Duration;

public class TC001 {
    ReusableMethots reusableMethots = new ReusableMethots();
    CustomersPage customersPage = new CustomersPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test1() throws InterruptedException {
        reusableMethots.storManagerSayfasiDogrulama();
        customersPage.EditCustomer.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        customersPage.BillingFirstName.sendKeys("Veli");
        actions.sendKeys(Keys.TAB).sendKeys("Can").sendKeys(Keys.TAB).sendKeys("Veli Nakliyat").
                sendKeys(Keys.TAB).sendKeys("2283401111").sendKeys(Keys.TAB).
                sendKeys("Cumhuriyet Mah.").sendKeys(Keys.TAB).sendKeys("Cumhuriyet Mah. Güzel Sk.").
                sendKeys(Keys.PAGE_DOWN).perform();

        customersPage.BillingCountryDropDown.click();
        customersPage.BillingCountryDropDownSearchBox.click();
        customersPage.BillingCountryDropDownSearchBox.sendKeys("Turkey");
        customersPage.BillingCountryDropDownSearchBox.sendKeys(Keys.ENTER);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        customersPage.BillingCityTown.sendKeys("Bilecik");
        Thread.sleep(3000);
        customersPage.BillingStateCountyDropDown.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(customersPage.BillingStateCountyDropDownBilecik));
        customersPage.BillingStateCountyDropDownBilecik.click();

        customersPage.BillingPostcodeZip.sendKeys("11100");
        customersPage.BillinhgMenuSubmit.click();
        wait.until(ExpectedConditions.visibilityOf(customersPage.basariylaKaydedildi));

        Assert.assertTrue(customersPage.basariylaKaydedildi.isDisplayed());

    }
}
