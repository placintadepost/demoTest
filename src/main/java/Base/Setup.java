package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

public class Setup {

    public static WebDriver driver;
    public static String homePage = "https://eu.wahoofitness.com/";
    public static ChromeOptions options = new ChromeOptions();

    @BeforeSuite
    @Parameters({"browserName"})
    public static WebDriver startBrowser(String browserName) {

        System.out.println("Browser name is: " + browserName);

        if (browserName.equalsIgnoreCase("chrome")) {

            System.out.println(System.getProperty("user.dir"));
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            options.addArguments("src\\main\\resources\\ChromeProfile");
            options.addArguments("--disable-notifications");
            options.addExtensions(new File("src/main/resources/Extensions/extension_3_3_8_0.crx"));
            driver = new ChromeDriver(options);

            installAdBlockWait();

        } else if (browserName.equalsIgnoreCase("firefox")) {

            System.out.println(System.getProperty("user.dir"));
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
            FirefoxProfile fxProfile = new FirefoxProfile();
            fxProfile.setPreference("permissions.default.desktop-notification", 1);
            FirefoxOptions options = new FirefoxOptions().setProfile(fxProfile);
            driver = new FirefoxDriver(options);


        }

        driver.manage().window().maximize();
        return driver;
    }

    public static void installAdBlockWait() {

        String title = driver.getTitle();
        if (title.contains("Thank you for installing AdGuard!")) {
            driver.close();
            Helper.handle(0);

        }

    }

    @AfterSuite
    public void methodTearDown() {

        driver.quit();

    }

}
