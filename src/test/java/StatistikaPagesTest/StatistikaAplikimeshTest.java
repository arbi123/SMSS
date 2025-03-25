package StatistikaPagesTest;

import ConfigPages.SherbimiConfigPage;
import Globals.Globals;
import StatistikaPages.StatistikaAplikimeshPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class StatistikaAplikimeshTest {
    StatistikaAplikimeshPage page;
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new StatistikaAplikimeshPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.SherbimetConfigUrl);
    }
}
