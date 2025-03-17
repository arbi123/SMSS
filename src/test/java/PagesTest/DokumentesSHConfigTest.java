package PagesTest;

import Globals.Globals;
import Pages.DokumentesSHConfigPage;
import Pages.InstitucioniKofigPage;
import Pages.NjesitKonfigPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DokumentesSHConfigTest {
    DokumentesSHConfigPage page;
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new DokumentesSHConfigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.KonfigurimiDokumenteveShoqeruese);
    }
    @Test
    public void shtimiIDokumenteveShoqeruese() throws InterruptedException {
        wait.until(ExpectedConditions.urlToBe(Globals.KonfigurimiDokumenteveShoqeruese));
        Assert.assertEquals(driver.getCurrentUrl(),Globals.KonfigurimiDokumenteveShoqeruese);
        page.shtoSherbimin("testt","Bashkia Maliq");
        Assert.assertEquals(page.dshGetSherbimi(),page.Sherbimi,"Sherbimi nuk eshte i njejte me ate qe beme input");
        Assert.assertEquals(page.dshGetInstitucioni(),page.Institucioni,"Institucioni nuk eshte i njejte me ate qe beme input");
        page.ruajSherbimin();
    }
    @Test
    public void kerkimiDheValidimiIKrijimitTe0Dokumentacionit(){

    }

    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
