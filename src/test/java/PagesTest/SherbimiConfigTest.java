package PagesTest;

import Globals.Globals;
import Pages.DokumentesSHConfigPage;
import Pages.SherbimiConfigPage;
import Utilities.BaseInformation;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SherbimiConfigTest {

    SherbimiConfigPage page;
    private WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new SherbimiConfigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.SherbimetConfigUrl);
        softAssert=  new SoftAssert();
    }
    @Test
    public void navigimiNeSherbimetService(){
        wait.until(ExpectedConditions.urlToBe(Globals.SherbimetConfigUrl));
        Assert.assertEquals(driver.getCurrentUrl(),Globals.SherbimetConfigUrl);
    }
     @Test(priority = 2,enabled = false)
     public void getTableTextAndVerify(){
         System.out.println(page.getTableSherbimiName());
         System.out.println(page.getTableKodiSherbimi());
         System.out.println(page.getInaktiveTable());
         System.out.println(page.getProcesimTable());
         System.out.println(page.getIntegrimiWSTable());
         System.out.println(page.getMendimdhenieTable());
         System.out.println(page.getLlojiSherbimitTable());
         System.out.println(page.getInstitucioniTable());

     }
//    @Test(priority = 2,enabled = false)
//    public void shtimiIServiseve() throws InterruptedException {
//
//
//        page.shtoSherbim();
//        page.waitForModalTitle();
//        page.fillShtoSherbimin("SherbimiTest"+Globals.generateRandom5DigitNumber(),"TTTest","919");
//        page.sherbimiFill("Shërbim konsultim të dhënash",true,true);
//        page.sherbimiFill("Shërbim me vulë",false,false);
//        Assert.assertFalse(page.areProcesimElementsDisplayed(),"Kane dale elementet e sherbimit me procesim kur ne nuk kemi klikuar atje");
//        page.sherbimiFill("Shërbim me proçesim","4","Ditë kalendarike",true,true,true,true,true,true);
//        Assert.assertTrue(page.areProcesimElementsDisplayed(),"Nuk kane dale elemntet e sherbimit me procesim kur ne kemi klikuar atje");
//        page.searchAndClickDokumentSH("Certifikatë familjare","Certifikatë familjare","Ministria e Brendshme");
//        page.searchAndClickDokumentSH("Certifikatë personale","Certifikatë personale","Ministria e Brendshme");
//
//        Assert.assertTrue(page.areAllDocSHTextsContained(),"Ka mungese nga cfare ke shtuar dhe cfare kane dale");
//        // page.ruajSherbimin();
//    }

//    @Test
//    public void editimiISherbimitTeKrijuar() throws InterruptedException {
//        page.searchTableEmerSherbimi("testttt");
//        page.editButton();
//        System.out.println(page.getEmeriSherbimitMS());
//        System.out.println(page.getInstitucioniMS());
//        System.out.println(page.getKodiSherbimitMS());
//        System.out.println(page.getLlojiSherbimitMS());
//        System.out.println(page.getInaktiveMS());
//        System.out.println(page.getFshijeDSHMS());
//    }
//    @Test(priority = 2)
//    public void searchBox() throws InterruptedException {
//        //page.searchByFiltrat("Bashkia klos","Shërbim me vulë","221"); it dont work
//        //page.sortTable(); kjo nuk eshte bug se behet tabela unresponisve
//    }

    @Test(priority = 1)
    public void KrijimiISherbimit() throws InterruptedException {
        page.shtoSherbim();
        page.waitForModalTitle();
        page.fillShtoSherbimin("SherbimiTest"+Globals.generateRandom5DigitNumber(),"Gjykata e Rrethit Gjyqësor","kodiSH"+Globals.generateRandom5DigitNumber());
        page.sherbimiFill("Shërbim me proçesim","4","Ditë kalendarike",true,true,true,true,true,true);
        Assert.assertTrue(page.areProcesimElementsDisplayed(),"Nuk kane dale elemntet e sherbimit me procesim kur ne kemi klikuar atje");
        page.searchAndClickDokumentSH("Certifikatë familjare","Certifikatë familjare","Ministria e Brendshme");
        page.searchAndClickDokumentSH("Certifikatë personale","Certifikatë personale","Ministria e Brendshme");
        page.ruajSherbimin();
    }
    @Test(priority = 2)
    public void kerkimiISherbimitTeKrijuarTeSearchBox() throws InterruptedException {
        page.searchTableEmerSherbimi(page.emeriSherbimit);
    }
    @Test(priority = 3)
    public void verifikimiISherbimitTeTabela(){
        softAssert.assertEquals(page.getTableSherbimiName(),page.emeriSherbimit,"Nuk eshte i njejte emeri i sherbimit te tabela");
        softAssert.assertEquals(page.getTableKodiSherbimi(),page.KodiSherbimit,"Nuk eshte i njejte kodi i sherbimit te tabela");
        softAssert.assertEquals(page.getInstitucioniTable(),page.Institucioni,"Nuk eshte i njejte institucioni tek tabela");
        softAssert.assertEquals(page.getMendimdhenieTable(),page.mendimdhenie,"Nuk eshte i njejte checkboxi i mendimdhenies tek tabela");
        softAssert.assertEquals(page.getProcesimTable(),page.procesimSQDNE,"Nuk eshte i njejte checkboxi i Procesim në SQDNE");
        softAssert.assertEquals(page.getIntegrimiWSTable(),page.integrimMeWS,"Nuk eshte i njejte checkboxi i Integrim Me Web service");
        softAssert.assertEquals(page.getInaktiveTable(),page.Inaktive,"Nuk eshte i njejte checkboxi i inaktive tek tabela");
        softAssert.assertAll();
    }
    @Test(priority = 4)
    public void klikojmeEditDheVerifikojmSherbiminTeProfili() throws InterruptedException {
        page.editButton();
        softAssert.assertEquals(page.getEmeriSherbimitMS(),page.emeriSherbimit,"Emeri Sherbimit eshte i ndrryshem tek modifiko sherbimin nga ai qe ke krijuar");
        softAssert.assertEquals(page.getInstitucioniMS(),page.Institucioni,"Institucioni eshte i ndrryshem tek modifiko sherbimin nga ai qe ke krijuar");
        softAssert.assertEquals(page.getKodiSherbimitMS(),page.KodiSherbimit,"Kodi i sherbimit eshte i ndrryshem tek modifiko sherbimin nga ai qe ke krijuar");
        softAssert.assertEquals(page.getLlojiSherbimitMS(),page.LlojiSherbimit,"Lloji i sherbimit esht i ndrryshem te modifiko sherbimin nga ai qe ke krijuar");
        softAssert.assertTrue(page.areInaktiveandDeletedDisplayed());
        softAssert.assertEquals(page.getInaktiveMS(),page.Inaktive,"Buttoni Inaktive eshte i ndrryshem te faqja modifkimit nga ai qe ke krijuar");
        softAssert.assertEquals(page.getFshijeDSHMS(),page.fshijeDSH,"Buttoni i Mund te fshije eshte i ndrryshem te faqja modifkimit nga ai qe ke krijuar");
        // kur esht sherbim me procesim behen check dhe kto posht
        if(page.getLlojiSherbimitMS().contains("proçesim")){
            softAssert.assertTrue(page.areProcesimElementsDisplayed(),"Nuk kane dale fushat e procesimit kur ne kemi selektuar ate");
            softAssert.assertEquals(page.getAfatiPergjigjesMS(),page.afatiPergjigjes,"Afati pergjigjes eshte i ndrryshem tek modifiko sherbimin nga ai qe ke krijuar");
            softAssert.assertEquals(page.getLlojiAfatitMS(),page.llojiAfatit,"Lloji i afatit eshte i ndrryshem tek modifiko sherbimin nga ai qe ke krijuar");
            softAssert.assertEquals(page.getMendimdhenieMS(),page.mendimdhenie,"Per mendimdhenie eshte i ndrryshem tek modifiko sherbimin nga ai qe ke krijuar");
            softAssert.assertEquals(page.getIntegrimWSMS(),page.integrimMeWS,"Per intergrim me WS eshte i ndrryshem tek modifiko sherbimin nga ai qe ke krijuar");
            softAssert.assertEquals(page.getProcesimSQDNEMS(),page.procesimSQDNE,"Procesim ne SQDNE eshte i ndrryshem tek modifiko sherbimin nga ai qe ke krijuar");
            softAssert.assertEquals(page.getPaMonitorimMS(),page.PaMonitorim,"Pa monitorim eshte i ndrryshem tek modifiko sherbimin nga ai qe ke krijuar");
        }else{
            softAssert.assertFalse(page.areProcesimElementsDisplayed(),"Kane dale elementet e sherbimit me procesim kur nuk kemi selektuar ate");
        }
        softAssert.assertTrue(page.areAllDocSHTextsContained(),"Ka mungese nga cfare ke shtuar TE dokumentat dhe cfare kane dale te faqja e modifikimit");
        softAssert.assertAll();
    }
//    @Test
//    public void editojmeSherbiminMeTeDhenaTeReja(){
//
//    }
//    @Test
//    public void kerkimiISherbimitTeEdituar(){
//
//    }
//    @Test
//    public void verifikimiISherbimitTeEdituarTeTabela(){
//
//    }
//    @Test
//    public void klikojmeEditDheVerifikojmSherbiminEEdituarTeProfili(){
//
//    }
//    @Test
//    public void kerkojmeDheFshimSherbimin(){
//
//    }
//    @Test
//    public void verifikimiIFshirjesSeSherbimit(){
//
//    }
    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
