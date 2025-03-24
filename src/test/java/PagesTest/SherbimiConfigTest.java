package PagesTest;

import DataProviders.LlojiSherbimitDataProvider;
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



    @Test(priority = 2)
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
    @Test(priority = 5)
    public void editojmeSherbiminMeTeDhenaTeReja() throws InterruptedException {
        page.fillShtoSherbimin("SherbimiEditedTest"+Globals.generateRandom5DigitNumber(),"Instituti i Ndërtimit","EditedkodiSH"+Globals.generateRandom5DigitNumber());
         page.sherbimiFill("Shërbim me vulë",false,false);
         page.ruajSherbimin();
        Thread.sleep(3000);
    }
    @Test(priority = 6)
    public void kerkimiISherbimitTeEdituar() throws InterruptedException {
        page.searchTableEmerSherbimi(page.emeriSherbimit);

    }
    @Test(priority = 7)
    public void verifikimiISherbimitTeEdituarTeTabela(){
        softAssert.assertEquals(page.getTableSherbimiName(),page.emeriSherbimit,"Nuk eshte i njejte emeri i sherbimit te tabela");
        softAssert.assertEquals(page.getTableKodiSherbimi(),page.KodiSherbimit,"Nuk eshte i njejte kodi i sherbimit te tabela");
        softAssert.assertEquals(page.getInstitucioniTable(),page.Institucioni,"Nuk eshte i njejte institucioni tek tabela");
        softAssert.assertEquals(page.getMendimdhenieTable(),page.mendimdhenie,"Nuk eshte i njejte checkboxi i mendimdhenies tek tabela");
        softAssert.assertEquals(page.getProcesimTable(),page.procesimSQDNE,"Nuk eshte i njejte checkboxi i Procesim në SQDNE");
        softAssert.assertEquals(page.getIntegrimiWSTable(),page.integrimMeWS,"Nuk eshte i njejte checkboxi i Integrim Me Web service");
        softAssert.assertEquals(page.getInaktiveTable(),page.Inaktive,"Nuk eshte i njejte checkboxi i inaktive tek tabela");
        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void kerkojmeDheFshimSherbimin(){

        page.fshirjaESherbimit();
    }
//    @Test
//    public void verifikimiIFshirjesSeSherbimit(){
//
//    }
    @Test(priority = 1)
    public void filtrimiTesting() throws InterruptedException {
        page.searchByFiltrat(page.Institucioni,page.,page.KodiSherbimit); //it dont work
        page.sortTable(); //kjo nuk eshte bug se behet tabela unresponisve
    }

    @Test(dataProviderClass = LlojiSherbimitDataProvider.class,dataProvider = "excelData",priority = 2)
    @AssertInfo({
            "Kërkojmë në tabelë nje shërbim ",
            "Klikojmë butonin e editimit për të modifikuar shërbimin",
            "Vendosim opsionet e checkbox-eve sipas vlerave të dhëna nga data provider Vlerat jane 1.Per mendimdhenie 2.Per integrim me WS 3.Procesim ne SQDNE,4.Pa monitorim",
            "Ruajmë shërbimin dhe presim për përditësimin e të dhënave",
            "Verifikojmë që lloji i shërbimit në tabelë përputhet me rezultatin e pritur",
            "Verifikojmë që të gjitha checkbox-et në tabelë përputhen me vlerat e futura"
    })
    public void verifikimiLLojiSherbimit(boolean mendimdhenie,boolean integrimWS,boolean procesimSQDNE,boolean monitorim,String ExpectedResilt) throws InterruptedException {
        SoftAssert softAssert1 = new SoftAssert();  // <--- new SoftAssert *per test invocation*
        driver.navigate().refresh();
        driver.navigate().to(Globals.SherbimetConfigUrl);
        page.searchTableEmerSherbimi("Sherbim test11");
        page.editButton();
        page.setAllCheckboxes(integrimWS,mendimdhenie,false,false,procesimSQDNE,monitorim);
        page.ruajSherbimin();
        Thread.sleep(2000);
        softAssert1.assertEquals(page.getLlojiSherbimitTable(),ExpectedResilt,"Nuk doli sherbimi qe prisnim tek tabela doli: "+page.getLlojiSherbimitTable()+" Prisnim: "+ExpectedResilt);
        softAssert1.assertEquals(page.getMendimdhenieTable(),page.mendimdhenie,"Nuk eshte i njejte checkboxi i mendimdhenies tek tabela");
        softAssert1.assertEquals(page.getProcesimTable(),page.procesimSQDNE,"Nuk eshte i njejte checkboxi i Procesim në SQDNE");
        softAssert1.assertEquals(page.getIntegrimiWSTable(),page.integrimMeWS,"Nuk eshte i njejte checkboxi i Integrim Me Web service");
        softAssert1.assertEquals(page.getInaktiveTable(),page.Inaktive,"Nuk eshte i njejte checkboxi i inaktive tek tabela");
        softAssert1.assertAll();
        Thread.sleep(500);
    }
    @Test(dataProvider = )
    public void findTableData(){
       page.searchByFiltrat("Kthim përgjigje nga Backend");
       Assert.assertEquals(page.getLLojiSherbimitFilter(),"String","");
    }
    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    //jobs not finished! jobs finished? ion think so
}
