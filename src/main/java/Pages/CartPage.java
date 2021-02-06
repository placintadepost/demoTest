package Pages;

import Base.Helper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CartPage extends Helper {

    //checkout page
    public static By quantityField = By.cssSelector("input[class=\"input-text qty\"]");
    public static By cartPrice = By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr[1]/td[4]/span/span/span");
    public static By updateCartBtn = By.cssSelector("button[name=\"update_cart_action\"]");
    public static By viewAndEditCart = By.className("viewcart");

    public static void deleteAndEnterCheckout() throws InterruptedException {

        click(viewAndEditCart);

        String previousPrice = readText(cartPrice);

        clear(quantityField);

        writeText(quantityField, "5");

        click(updateCartBtn);

        Assert.assertFalse(previousPrice.matches(readText(cartPrice)));
    }
}
