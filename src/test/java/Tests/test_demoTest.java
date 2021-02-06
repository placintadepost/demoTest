package Tests;

import Pages.CheckoutPage;
import Pages.ProductPage;
import org.testng.annotations.Test;

import static Pages.CartPage.deleteAndEnterCheckout;
import static Pages.CheckoutPage.enterCheckoutDetails;
import static Pages.CheckoutPage.fillOutCheckoutForm;
import static Pages.MainPage.enterMainPage;

public class test_demoTest extends ProductPage {

    @Test
    public void demoTest() throws InterruptedException {

        enterMainPage();

        getTwoItems();

        deleteAndEnterCheckout();

        enterCheckoutDetails();

        fillOutCheckoutForm();


    }


}
