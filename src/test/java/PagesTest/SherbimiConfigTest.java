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
     public void getTableTextAndVerify(){
         System.out.println(page.getTableSherbimiName());
         System.out.println(page.getTableKodiSherbimiTablet());
         System.out.println(page.getInaktiveTable());
         System.out.println(page.getProcesimTable());
         System.out.println(page.getIntegrimiWSTable());
         System.out.println(page.getMendimdhenieTable());
         System.out.println(page.getLlojiSherbimitTable());
         System.out.println(page.getInstitucioniTable());

     }
    @Test(priority = 2,enabled = false)
    public void shtimiIServiseve() throws InterruptedException {


        page.shtoSherbim();
        page.waitForModalTitle();
        page.fillShtoSherbimin("SherbimiTest"+Globals.generateRandom5DigitNumber(),"TTTest","919");
        page.sherbimiFill("Shërbim konsultim të dhënash",true,true);
        page.sherbimiFill("Shërbim me vulë",false,false);
        Assert.assertFalse(page.areProcesimElementsDisplayed(),"Kane dale elementet e sherbimit me procesim kur ne nuk kemi klikuar atje");
        page.sherbimiFill("Shërbim me proçesim","4","Ditë kalendarike",true,true,true,true,true,true);
        Assert.assertTrue(page.areProcesimElementsDisplayed(),"Nuk kane dale elemntet e sherbimit me procesim kur ne kemi klikuar atje");
        page.searchAndClickDokumentSH("Certifikatë familjare","Certifikatë familjare","Ministria e Brendshme");
        page.searchAndClickDokumentSH("Certifikatë personale","Certifikatë personale","Ministria e Brendshme");

        Assert.assertTrue(page.areAllTextsContained(),"Ka mungese nga cfare ke shtuar dhe cfare kane dale");
        // page.ruajButton();
    }
    @Test
    public void delete(){

    }
    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
