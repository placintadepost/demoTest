package Pages;

import Base.Helper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckoutPage extends Helper {

    public static By checkoutBtn = By.cssSelector("button[data-role=\"proceed-to-checkout\"]");
    public static By customerEmailError = By.id("customer-email-error");
    public static By shippingExpressRadioBtn = By.cssSelector("input[name=\"ko_unique_2\"]");
    public static By totalPrice = By.xpath("//*[@id=\"checkout\"]/div[4]/div[3]/div/div/div[1]/div/div/table/tbody/tr[5]/td/strong/span");
    public static By placeOrderBtn = By.xpath("//*[@id=\"checkout\"]/div[4]/div[3]/div/div/div[6]/div/div/button");

    ///

    public static By email = By.id("customer-email");
    public static By fName = By.cssSelector("input[name=\"firstname\"]");
    public static By lName = By.cssSelector("input[name=\"lastname\"]");
    public static By address = By.cssSelector("input[name=\"street[0]\"]");
    public static By city = By.cssSelector("input[name=\"city\"]");
    public static By phoneNumber = By.cssSelector("input[name=\"telephone\"]");
    public static By zipCode = By.cssSelector("input[name=\"postcode\"]");

    public static By cardNumberField = By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input");
    public static By cardMMYY = By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[2]/span/span/input");
    public static By CVC = By.xpath("//*[@id=\"root\"]/form/div/div[2]/span[3]/span/span/input");




    public static void enterCheckoutDetails() throws InterruptedException {

        click(checkoutBtn);

        waitVisibility(totalPrice);

        Thread.sleep(1000);

        click(placeOrderBtn);

        Assert.assertTrue(driver.findElement(customerEmailError).isDisplayed());

        String previousPrice = readText(totalPrice);

        click(shippingExpressRadioBtn);

        Thread.sleep(1500);

        Assert.assertFalse(previousPrice.matches(readText(totalPrice)));


    }

    public static void fillOutCheckoutForm() throws InterruptedException {

        writeText(email, "someone@whocares.com");
        writeText(fName, "Test");
        writeText(lName, "Tester");
        writeText(address, "Comandante Izarduy 67, Barcelona  08940");
        writeText(city, "Barcelona");
        writeText(phoneNumber, "5555555555");

        clear(zipCode);
        writeText(zipCode, "08940");


    }
}
