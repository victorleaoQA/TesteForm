import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new FirefoxDriver();

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.driver", Utils.FIREFOX_DRIVER_LOCATION);
    }

    @Test(testName = "Submit a WebForm")
    public static void submitForm() throws InterruptedException {
        driver.get(Utils.BASE_URL);
        driver.getTitle();
        WebForm webForm = new WebForm(driver);
        webForm.enterFirstName();
        webForm.enterLastName();
        webForm.pressSubmitButton();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webForm.verifyAlertSuccess();
    }


    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
