package SMStest;

import Globals.Globals;
import SMSpages.LoginPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    LoginPage page ;
    private WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        driver = BaseInformation.getDriver();
        page=  new LoginPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void navigateToPage(){
        driver.navigate().to(Globals.smsLoginUrl);
        wait.until(ExpectedConditions.urlToBe(Globals.smsLoginUrl));
        BaseInformation.waitUntilPageLoads();

    }
    @Test(priority = 2)
    public void Login(){
        page.fillEmail("admin@test.com");
        page.fillPassword("Zxasqw1@");
        page.loginButton();
        wait.until(ExpectedConditions.urlToBe(Globals.dashboardUrl));
    }
}
