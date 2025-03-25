package ConfigPagesTest;

import DataProviders.FileterLlojetDataProvider;
import DataProviders.LlojiSherbimitDataProvider;
import Globals.Globals;
import ConfigPages.SherbimiConfigPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
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
    @AssertInfo({
            "Presim derisa URL-ja të jetë e njëjtë me konfigurimin e shërbimeve",
            "Verifikojmë që URL-ja aktuale e faqes përputhet me URL-në e pritur"
    })
    public void navigimiNeSherbimetService(){
        wait.until(ExpectedConditions.urlToBe(Globals.SherbimetConfigUrl));
        Assert.assertEquals(driver.getCurrentUrl(),Globals.SherbimetConfigUrl);
    }



    @Test(priority = 2)
    @AssertInfo({
            "Kryhet shtimi i një shërbimi të ri me një emër unik dhe kod unik",
            "Verifikohet që elementet e procesimit të shfaqen pasi aktivizohet opsioni 'Shërbim me proçesim'",
            "Shtohen dhe lidhen dokumentet e nevojshme për shërbimin e krijuar",
            "Pasi ruhet shërbimi, duhet të konfirmohet që është ruajtur me sukses"
    })

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
    @AssertInfo({
            "Kërkimi i shërbimit të sapokrijuar në search box dhe konfirmimi që ekziston në tabelë",
            "Verifikohet që emri i shërbimit në tabelë përputhet me atë të krijuar",
            "Verifikohet që kodi i shërbimit në tabelë është i njëjtë me atë të krijuar",
            "Verifikohet që institucioni i shërbimit përputhet me të dhënat e krijuara",
            "Verifikohen checkbox-et e mendimdhënies, procesimit, integrimit me Web Service dhe statusit inaktiv"
    })
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
    @AssertInfo({
            "Klikohet butoni Edit dhe verifikohet shërbimi i profilit me atë të krijuar",
            "Verifikohet që emri i shërbimit në ekranin e modifikimit përputhet me atë të krijuar",
            "Verifikohet institucioni, kodi dhe lloji i shërbimit në ekranin e modifikimit",
            "Verifikohet që butonat 'Inaktive' dhe 'Mund të Fshije' janë të saktë",
            "Nëse shërbimi është me përpunim, verifikohen elementët e tij",
            "Kontrollohet nëse fushat e procesimit shfaqen vetëm kur duhet",
            "Verifikohen të gjitha dokumentet e lidhura me shërbimin për të siguruar që nuk ka mungesa"
    })
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
    @AssertInfo({
            "Plotësohet formulari për modifikimin e shërbimit me të dhëna të reja",
            "Verifikohet që emri i ri i shërbimit është korrekt",
            "Verifikohet që institucioni i ri është ruajtur siç pritet",
            "Verifikohet që kodi i ri i shërbimit është ruajtur saktë",
            "Modifikohet lloji i shërbimit dhe verifikohet që përditësimi ka ndodhur me sukses",
            "Ruhet shërbimi dhe sigurohet që nuk ka gabime gjatë ruajtjes"
    })
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
    @AssertInfo({
            "Verifikohet që emri i shërbimit i edituar është korrekt në tabelë",
            "Sigurohet që kodi i shërbimit i edituar përputhet me atë të ruajtur",
            "Institucioni i shërbimit duhet të jetë i njëjtë me atë të edituar",
            "Verifikohet checkbox-i i mendimdhenies në tabelë",
            "Konfirmohet që opsioni 'Procesim në SQDNE' është i saktë pas editimit",
            "Sigurohet që opsioni 'Integrim Me Web Service' përputhet me të dhënat e edituara",
            "Verifikohet që statusi i inaktivitetit është i saktë pas përditësimit",
            "Ekzekutohet assertAll() për të siguruar që të gjitha verifikimet janë kryer me sukses"
    })
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
    @AssertInfo({
            "Sigurohet që shërbimi i fshirë nuk ekziston më në tabelë",
            "Verifikohet që nuk ka të dhëna për shërbimin e fshirë pas operacionit",
            "Konfirmohet që operacioni i fshirjes është i suksesshëm dhe shërbimi është zhdukur"
    })
    public void kerkojmeDheFshimSherbimin(){
        page.fshirjaESherbimit();
    }


    @Test(dataProviderClass = LlojiSherbimitDataProvider.class,dataProvider = "excelData",priority = 9)
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
        Thread.sleep(1500);
        softAssert1.assertEquals(page.getLlojiSherbimitTable(),ExpectedResilt,"Nuk doli sherbimi qe prisnim tek tabela doli: "+page.getLlojiSherbimitTable()+" Prisnim: "+ExpectedResilt);
        softAssert1.assertEquals(page.getMendimdhenieTable(),page.mendimdhenie,"Nuk eshte i njejte checkboxi i mendimdhenies tek tabela");
        softAssert1.assertEquals(page.getProcesimTable(),page.procesimSQDNE,"Nuk eshte i njejte checkboxi i Procesim në SQDNE");
        softAssert1.assertEquals(page.getIntegrimiWSTable(),page.integrimMeWS,"Nuk eshte i njejte checkboxi i Integrim Me Web service");
        softAssert1.assertEquals(page.getInaktiveTable(),page.Inaktive,"Nuk eshte i njejte checkboxi i inaktive tek tabela");
        softAssert1.assertAll();
        Thread.sleep(500);
    }
    @Test(dataProvider = "serviceTypes", dataProviderClass = FileterLlojetDataProvider.class,priority = 10)
    @AssertInfo({
            "Testim i funksionalitetit të filtrimit të llojeve të shërbimeve",
            "Verifikimi i mekanizmit të kërkimit dhe filtrimit për lloje specifike shërbimesh",
            "Konfirmimi i përputhjes së filtrit me hyrjen e përdoruesit",
            "Sigurimi që të dhënat e tabelës pasqyrojnë saktë llojin e shërbimit të zgjedhur",
            "Kontrollimi që rezultatet e filtruara përmbajnë vetëm llojin e specifikuar të shërbimit",
            "Vlerësimi i sjelljes së filtrit për inpute të ndryshme të llojeve të shërbimeve"
    })
    public void findTableData(String value,String ExpectedValue) throws InterruptedException {
        SoftAssert softassert = new SoftAssert();
        driver.navigate().refresh();
        page.searchLlojiSHerbimit(value);

        softassert.assertEquals(page.getLLojiSherbimitFilter(), value, "Nuk eshte i zgjedhur lloji i sherbimit qe deshiruam tek filtrat: " + value);
        if (page.isThereAnyData()) {
            Assert.fail("Filtrimi qe beme nuk ka te dhena ose nuk eshte i sakte");
        }
        for (String in : page.llojiElements()) {
            softassert.assertEquals(in, ExpectedValue, "Llojji i sherbimit te shfaqura tek tabela nuk jane nje lloj si lloji qe kerkuam");
        }
        softassert.assertAll();
        // do it for both inpit plus expected and fix the bugs and add the otherfilters methods ways
        //there isa  bug kur selekton doc shoq kthim pergjigje nga backend del i njejti lloj per 2 sherbime
    }

    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
