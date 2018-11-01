package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BaseDriverClass {
    public  static WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public BaseDriverClass() {
        //Provide the chrome driver path here
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
        driver = setDriver();
    }
    //Getter method
    public static WebDriver getDriver() {
        return setDriver();
    }
    //Setter method
    private static WebDriver setDriver() {
        if (driver == null) {

            driver = new ChromeDriver();

        }

        return driver;
    }

    public static void fluentlyWaitUntilElementIsVisible(WebElement element) {
        (new FluentWait(driver)).withTimeout(30L, TimeUnit.SECONDS).pollingEvery(1L, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilPageLoad() {
        driver.manage().timeouts().pageLoadTimeout(10L, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    @BeforeSuite
    public void setUp() {
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(driver, 30L);
    }
}



