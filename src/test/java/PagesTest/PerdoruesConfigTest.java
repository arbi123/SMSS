package PagesTest;

import Globals.Globals;
import Pages.DokumentesSHConfigPage;
import Pages.PerdoruesConfigPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class PerdoruesConfigTest {
    PerdoruesConfigPage page;
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new PerdoruesConfigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void test(){
        driver.navigate().to(Globals.perdoruesConfigUrl);
        wait.until(ExpectedConditions.urlToBe(Globals.perdoruesConfigUrl));
          page.shtoPerorues();
          page.selectInstitucion("Bashkia Tiran");
          page.selectNjesia("Drejtoria");
          page.selectRolet("Admin");

    }
    @AfterClass
    public void quit(){

    }
}
