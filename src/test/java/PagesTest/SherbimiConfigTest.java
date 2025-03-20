package PagesTest;

import Globals.Globals;
import Pages.DokumentesSHConfigPage;
import Pages.SherbimiConfigPage;
import Utilities.BaseInformation;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
        page.sherbimiFill("Shërbim konsultim të dhënash",true,true);
        Assert.assertFalse(page.areProcesimElementsDisplayed(),"Kane dale elementet e sherbimit me procesim kur ne nuk kemi klikuar atje");
        page.sherbimiFill("Shërbim me proçesim","4","Ditë kalendarike",true,true,true,true,true,true);
        Assert.assertTrue(page.areProcesimElementsDisplayed(),"Nuk kane dale elemntet e sherbimit me procesim kur ne kemi klikuar atje");
        page.shtimiIdokumentitMeSherbimDheInstitucion("Certifikatë familjare","Ministria e Brendshme");
       // page.ruajButton();
    }
    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
