package Pages;

import Base.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductPage extends Helper {


    //product page
    public static By parentMenuItem = By.className(" parent");
    public static By productItem = By.className("item");

    public static By closeBtn = By.id("btn-minicart-close");
    public static By coverup = By.className("coverup");


    // sidebar

    public static By sideBarRemoveBtn = By.cssSelector("a[title=\"Remove item\"]");
    public static By miniBarTitle = By.xpath("//*[contains(text(),'Your Cart')]");
    public static By miniCartMessage = By.className("minicart-messages");


    //delete modal
    public static By modalRvmMessage = By.id("modal-content-22");
    public static By confirmItemDeletionBtn = By.className("action-accept");



    public static void getTwoItems() throws InterruptedException {

        hover("button-hover");

        waitVisibility(miniBarTitle);

        click(coverup);

        waitInvisibility(coverup);

        Thread.sleep(1500);

        hover("button-hover");

        waitVisibility(miniBarTitle);

        click(sideBarRemoveBtn);

        click(confirmItemDeletionBtn);

        waitToContainText(miniCartMessage, "Item was removed successfully");

    }




}
