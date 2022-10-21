package tests.US0016;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomersPage;
import utilities.ReusableMethots;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TC004 {



    ReusableMethots reusableMethots = new ReusableMethots();
    CustomersPage customersPage = new CustomersPage();

    @Test
    public void test1() throws InterruptedException {
        reusableMethots.storManagerSayfasiDogrulama();
        customersPage.CSV.click();

        String dosyaYolu ="C:\\Users\\MONSTER\\Downloads";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

}