package tests.US0017;

import org.testng.annotations.Test;
import pages.CustomersPage;
import utilities.ReusableMethots;

public class TC001 {
    ReusableMethots reusableMethots = new ReusableMethots();
    CustomersPage customersPage = new CustomersPage();

    @Test
    public void test1() throws InterruptedException {
        reusableMethots.storManagerSayfasiDogrulama();

    }
}
