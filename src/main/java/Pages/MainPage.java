package Pages;

import Base.Helper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MainPage extends Helper {

    public static By cookieAcceptBtn = By.id("onetrust-accept-btn-handler");
    public static By mainMenuItemShop = By.className("cat");

    public static void enterMainPage() throws InterruptedException {

        driver.get(homePage);

        Assert.assertEquals(driver.getTitle(), "Indoor Bike Trainers, GPS Bike Computers, Cycling Sensors & Heart Rate Monitors | Wahoo Fitness EU");

        click(cookieAcceptBtn);

        Thread.sleep(1500);

        click(mainMenuItemShop);

    }
}
