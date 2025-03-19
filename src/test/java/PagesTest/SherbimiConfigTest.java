package PagesTest;

import Globals.Globals;
import Pages.DokumentesSHConfigPage;
import Pages.SherbimiConfigPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SherbimiConfigTest {

    SherbimiConfigPage page;
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new SherbimiConfigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.SherbimetConfigUrl);
    }
    @Test(priority = 1)
    public void navigimiNeSherbimetService(){
        wait.until(ExpectedConditions.urlToBe(Globals.SherbimetConfigUrl));
        Assert.assertEquals(driver.getCurrentUrl(),Globals.SherbimetConfigUrl);
    }
    @Test(priority = 2)
    public void shtimiIServiseve() throws InterruptedException {
        page.shtoSherbim();
        page.setAllCheckboxes(true,true,true,true,true,true);
        page.shtimiIdokumentitMeSherbimDheInstitucion("Certifikatë familjare","Ministria e Brendshme");
    }
}
