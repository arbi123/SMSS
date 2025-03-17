package PagesTest;

import Globals.Globals;
import Pages.DitetPushimPage;
import Pages.DokumentesSHConfigPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class DitetPushimTest {

    DitetPushimPage page;
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new DitetPushimPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.DitetPushimUrl);
    }
    @Test(dataProviderClass = DataProviders.ExcelDataProvider.class, dataProvider = "festatData")
    public void shtoDitetEFestave(String date, String event){
        System.out.println("Data: " + date + " | Ngjarja: " + event);

    page.klikoShtoDiteFestash();
    page.
    }
}
