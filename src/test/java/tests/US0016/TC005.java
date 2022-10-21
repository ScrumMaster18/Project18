package tests.US0016;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import utilities.Driver;
import utilities.ReusableMethots;

import java.time.Duration;

public class TC005 {

    ReusableMethots reusableMethots = new ReusableMethots();
    CustomersPage customersPage = new CustomersPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void test1() throws InterruptedException {
        reusableMethots.storManagerSayfasiDogrulama();

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",customersPage.AddNewCustomer);
        jse.executeScript("arguments[0].click();",customersPage.AddNewCustomer);

        customersPage.AddNewUserName.sendKeys("Veli");
        actions.sendKeys(Keys.TAB).sendKeys("veli@gmail.com").
                sendKeys(Keys.TAB).sendKeys("Veli").
                sendKeys(Keys.TAB).sendKeys("Can").perform();
        jse.executeScript("arguments[0].scrollIntoView(true);",customersPage.AddNewCustomerSubmitButton);
        jse.executeScript("arguments[0].click();",customersPage.AddNewCustomerSubmitButton);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(customersPage.basariylaKaydedildi));

        Assert.assertTrue(customersPage.basariylaKaydedildi.isDisplayed());


    }
}