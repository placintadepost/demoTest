package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Helper extends Setup {


    public static void handle(int nr) {

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(nr));

    }

    public static void click(By elementLocation) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement waitClick = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocation));

        waitClick.click();



    }

    public static void waitInvisibility(By by) {

        WebDriverWait wait = new WebDriverWait(driver,20);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

    }

    public static String readText(By elementLocation) {
        waitVisibility(elementLocation);
        return driver.findElement((By) elementLocation).getText();
    }

    public static void writeText(By elementLocation, String text) {

        waitVisibility(elementLocation);
        driver.findElement(elementLocation).sendKeys(text);

    }

    public static void waitToContainText(By elementLocation, String text) {

        WebDriverWait wait = new WebDriverWait(driver,30);

        wait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocation, text));

    }

    public static boolean waitVisibility(By by) {

        WebDriverWait wait = new WebDriverWait(driver,30);

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        return true;

    }

    public static void hover(String elementLocationParent) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        Actions action = new Actions(driver);
        Random random = new Random();

        List<WebElement> elementList = driver.findElements(new ByAll(By.id(elementLocationParent),
                By.className(elementLocationParent),
                By.xpath(elementLocationParent),
                By.cssSelector(elementLocationParent)));

        int index = random.nextInt(elementList.size());

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", elementList.get(index));
        action.moveToElement(elementList.get(index)).build().perform();


        String hoverMessage = elementList.get(index).getAttribute("title");

        if (hoverMessage.contains("Add to Cart")) {

            WebElement waitClick = wait.until(ExpectedConditions.visibilityOf(elementList.get(index)));
            waitClick.click();

        } else {

            hover(elementLocationParent);
        }


    }

    public static void waitForTextChange(By elementLocation) {

        WebDriverWait wait = new WebDriverWait(driver,30);

        String previousText = driver.findElement(elementLocation).getText();

        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(elementLocation, previousText)));

    }

    public static void clear(By elementLocation) {

        waitVisibility(elementLocation);
        driver.findElement(elementLocation).clear();
    }

}
