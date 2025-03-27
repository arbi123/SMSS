package StatistikaPagesTest;

import ConfigPagesTest.AssertInfo;
import DataProviders.MinistriteFilterDP;
import Globals.Globals;
import StatistikaPages.StatistikaAplikimeshPage;
import StatistikaPages.StatistikaNderInstitucionPage;
import Utilities.BaseInformation;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class StatistikaNderInstitucionTest {
    StatistikaNderInstitucionPage page;
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new StatistikaNderInstitucionPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.SQDNELoginURL);
        Cookie cookie = new Cookie("jwt","eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiJmZWVkMTJiNi1jY2NlLTQ3YTItODIzMS1iZTQ3YjQ0Nzk1ODIiLCJJZCI6ImZlZWQxMmI2LWNjY2UtNDdhMi04MjMxLWJlNDdiNDQ3OTU4MiIsIkZ1bGxOYW1lIjoiQWRtaW5pc3RyYXRvciBTUURORSIsIkVtYWlsIjoiZG9hbGQuaGFrYUBzb2Z0c29sdXRpb24uYWwiLCJVc2VyTmFtZSI6ImFkbWluLnNxZG5lIiwiQ2FuQWNjZXNzQWxsU2VydmljZXNJbkluc3RpdHV0aW9uIjp0cnVlLCJSb2xlcyI6WyJTaGthcmtpbSBleGNlbCByYXBvcnRlIiwiU3BlY2lhbGlzdCBTUURORSBOZW5zaGtydWVzIiwiQXV0b3JpenVhciBWdWxvcyBEb2t1bWVudGEiLCJTcGVjaWFsaXN0IFNRRE5FIiwiQWRtaW5pc3RyYXRvciBBS1NISSJdLCJQZXJtaXNzaW9ucyI6W3siTmFtZSI6IktyeWVmYXFqYSIsIkNvZGUiOiJIT00iLCJUeXBlIjoiV0FUQ0gifSx7Ik5hbWUiOiJLb25maWd1cmltIHNow6tyYmltaSIsIkNvZGUiOiJDU0VSIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiTGlzdGEgZSBhcGxpa2ltZXZlIHTDqyByZWFsaXp1YXJhIiwiQ29kZSI6IkxBUExSIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiU2jDq3JiaW1lIG1lIHZ1bMOrIiwiQ29kZSI6IlNWIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiUmFwb3J0IHDDq3JtYmxlZGjDq3MiLCJDb2RlIjoiUlBQIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiU3RhdGlzdGlrYSBhcGxpa2ltZXNoIG7DqyBlLUFsYmFuaWEiLCJDb2RlIjoiU0FFIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiTW9kaWZpa2ltZSBBcGxpa2ltZXNoIiwiQ29kZSI6IkFQTFJFRyIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlJhcG9ydGltZSIsIkNvZGUiOiJSUCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlNoZXJiaW1ldCBtw6sgdMOrIHDDq3Jkb3J1cmEiLCJDb2RlIjoiU01QIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiQXBsaWtpbWUgUmlzaHDDq3JuZGFyamUiLCJDb2RlIjoiQVBMUklTSCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IktvbmZpZ3VyaW0gaW5zdGl0dWNpb25pIiwiQ29kZSI6IkNJTlMiLCJUeXBlIjoiV0FUQ0gifSx7Ik5hbWUiOiJBcGxpa2ltZSBzaXBhcyBzaMOrcmJpbWV2ZSIsIkNvZGUiOiJBUExTIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiU3RhdGlzdGlrYSBrw6tya2VzYXZlIG5kw6tyaW5zdGl0dWNpb25hbGUiLCJDb2RlIjoiU0tJIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiU3RhdGlzdGlrYSB0w6sgcMOrcmdqaXRoc2htZSIsIkNvZGUiOiJTUCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IktvbmZpZ3VyaW0gZGl0w6t2ZSBwdXNoaW0iLCJDb2RlIjoiQ0hPTCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlJpc2hww6tybmRhcmplIiwiQ29kZSI6IlJTSCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IkFwbGlraW1ldCIsIkNvZGUiOiJBUEwiLCJUeXBlIjoiV0FUQ0gifSx7Ik5hbWUiOiJLb25maWd1cmltIHDDq3Jkb3J1ZXNpIiwiQ29kZSI6IkNVU1IiLCJUeXBlIjoiV0FUQ0gifSx7Ik5hbWUiOiJWbGVyw6tzaW1ldCBlIHNow6tyYmltZXZlIiwiQ29kZSI6IlZTSCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlZsZXLDq3NpbWV0IG1lc2F0YXJlIHTDqyBzaMOrcmJpbWV2ZSIsIkNvZGUiOiJWTVNIIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiQXBsaWtpbWUgc2lwYXMgcHVub25qw6tzdmUiLCJDb2RlIjoiQVBMUCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IktvbmZpZ3VyaW0gd29ya2Zsb3ciLCJDb2RlIjoiQ1dLRiIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IktvbmZpZ3VyaW0gb3JnYW5pZ3JhbWUiLCJDb2RlIjoiQ09SRyIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlN0YXRpc3Rpa2EgYXBsaWtpbWVzaCB0w6sgcnJlZ2ppc3RydWFyYSIsIkNvZGUiOiJTQVIiLCJUeXBlIjoiV0FUQ0gifSx7Ik5hbWUiOiJEYXNoYm9hcmQgU3RhdGlzdGlrYSIsIkNvZGUiOiJEUyIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlN0YXRpc3Rpa2EgbsOrIGxpZGhqZSBtZSBrdGhpbWluIGUgcMOrcmdqaWdqZXMiLCJDb2RlIjoiU0xLUCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IktvbmZpZ3VyaW0gZG9rdW1lbnRpIiwiQ29kZSI6IkNET0MiLCJUeXBlIjoiV0FUQ0gifV0sIkluc3RpdHV0aW9uVW5pdEFjY2VzcyI6eyJJbnN0aXR1dGlvbklkIjoiOGIzY2VkMGMtODdjMS00MTA5LWI0OTYtMzA3MWI0MjcxOTk0IiwiUGFyZW50SW5zdGl0dXRpb25JZCI6IjAwMDAwMDAwLTAwMDAtMDAwMC0wMDAwLTAwMDAwMDAwMDAwMCIsIkluc3RpdHV0aW9uTmFtZSI6Ik1pbmlzdHJpYSBlIEluZnJhc3RydWt0dXLDq3MgZGhlIEVuZXJnamlzw6siLCJVbml0SWRzQWNjZXNzIjpbImVjYTNkMmE0LWEwMzgtNDg1Zi1iNmJiLTc4OGZjMGMyOGUyMSJdLCJQYXJlbnRJbnN0aXR1dGlvbk5hbWUiOiIifSwibmJmIjoxNzQyODkyMzY1LCJleHAiOjE3NDI5MjgzNjUsImlhdCI6MTc0Mjg5MjM2NSwiaXNzIjoiU3FkbmUuU2VydmVyIiwiYXVkIjoiU3FkbmUuQ2xpZW50In0.fh8AnI1aj3a2YlVBnvxaE3zdZs5VqvTO-dcnBsP29_SgHus6kHKDKEhxlnd3EchAW45AYK1ypeXMcG2Aepi7EA");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
    @Test(priority = 0)
    public void navigoTekFaqja() throws InterruptedException {
        driver.navigate().to(Globals.statistikaNderInstitucionURL);
        wait.until(ExpectedConditions.urlToBe(Globals.statistikaNderInstitucionURL));
        Assert.assertEquals(driver.getCurrentUrl(),Globals.statistikaNderInstitucionURL);
        page.waitUntilNoTableReaload();
    }
//    @Test(priority = 1)
//    public void zgjidhMinistrindheInstitucioniDergues() throws InterruptedException {
//        page.selektoDaten("21/01/2025","23/03/2025");
//        page.selectMinistriaDerguese("Ministria e Drejtësisë");
//        page.selectInstitucioniDergues("Dhoma Kombëtare e Noterëve");
//        page.selektoBrendaAfatit();
//
//
//    }
//    @Test(priority = 2)
//    public void selectMinsitriaDheInstitucionetPrites(){
//        page.selectMinistriaPritese("Ministria e Brendshme");
//        page.selectInstitucionePritese("Drejtoria e Përgjithshme e Gjendjes Civile (DPGJC)");
//        page.selectKthimPergjigje("Po");
//        page.selektoJashtAfatit();
//    }
    @Test(priority = 3)
    @AssertInfo({
            "Testimi i funksionalitetit të zgjedhjes së institucionit dërgues",
            "Verifikimi i saktësisë së filtrit të ministrisë dërguese",
            "Konfirmimi që të gjitha rezultatet përputhen me institucionin e zgjedhur",
            "Kontrolli i përputhjes së çdo elementi në tabelë me institucionin dërgues",
            "Sigurimi i saktë i rezultateve pas përzgjedhjes dhe shfaqjes së të dhënave",
            "Vlerësimi gjithëpërfshirës i filtrimit të institucioneve"
    })
    public void selektimiDheVerifikimiIinstitucionitDergues(){
        String ministriaDerguese="Ministria e Drejtësisë";
        String institucioniDergues="Dhoma Kombëtare e Noterëve";
        page.selectMinistriaDerguese(ministriaDerguese);
        page.selectInstitucioniDergues(institucioniDergues);
        page.shfaqeTeDhena("100");
        for (String item: page.institucioniDergues()){
            Assert.assertEquals(item,institucioniDergues,"Nuk jan te njejte institucionet");
        }
    }
    @Test(priority = 4)
    @AssertInfo({
            "Testimi i funksionalitetit të filtrimit me kthim përgjigje",
            "Verifikimi i saktësisë së filtrit të kthimit të përgjigjes",
            "Konfirmimi që të gjitha rezultatet përputhen me statusin specifik",
            "Kontrolli i përputhjes së çdo elementi në tabelë me statusin e shërbimit",
            "Sigurimi i saktë i lidhjeve midis kthimit të përgjigjes dhe statusit",
            "Vlerësimi gjithëpërfshirës i filtrimit dhe statuseve përkatëse"
    })
    public void kthimPergjigjePoDheVerifikim(){
        String kthimPergjigje="Po";
        page.selectKthimPergjigje(kthimPergjigje);
        for (String item: page.statusi()){
            Assert.assertEquals(item,"Lëvuar Shërbimi","Nuk jan te njejte statuset");
        }
    }
    @Test(priority = 5,dataProvider = "ministriaTypes",dataProviderClass = MinistriteFilterDP.class)
    @AssertInfo({
            "Testimi i funksionalitetit të zgjedhjes së ministrisë dërguese",
            "Verifikimi i saktësisë së institucioneve pas përzgjedhjes së ministrisë",
            "Konfirmimi që institucioni dërgues përputhet me ministrinë e zgjedhur",
            "Kontrolli i ndërveprimit midis ministrisë dhe institucioneve përkatëse",
            "Sigurimi i saktë i filtrit të institucioneve bazuar në ministrinë",
            "Vlerësimi i mekanizmit të përditësimit të institucioneve pas përzgjedhjes"
    })
    public void selectMinistriaDergueseVerifyInstitucionetOptions(String ministri){

        page.selectMinistriaDerguese(ministri);
        Assert.assertEquals(page.strongInstitucionDergusText(),ministri,"Kur selektuam ministrin perkatese nuk na doli institucionet te cilat i perkasin asaj minstrie");
    }
    @Test(priority = 6,dataProvider = "ministriaTypes",dataProviderClass = MinistriteFilterDP.class)
    @AssertInfo({
            "Testimi i funksionalitetit të zgjedhjes së ministrisë dërguese",
            "Verifikimi i saktësisë së institucioneve pas përzgjedhjes së ministrisë",
            "Konfirmimi që institucioni dërgues përputhet me ministrinë e zgjedhur",
            "Kontrolli i ndërveprimit midis ministrisë dhe institucioneve përkatëse",
            "Sigurimi i saktë i filtrit të institucioneve bazuar në ministrinë",
            "Vlerësimi i mekanizmit të përditësimit të institucioneve pas përzgjedhjes"
    })
    public void selectMinistriaPriteseVerifyInstitucionetOptions(String ministri){
        page.pastroFiltrat();
        page.selectMinistriaPritese(ministri);
        Assert.assertEquals(page.strongInstitucionPritesText(),ministri);
    }
    @Test(priority = 7)
    @AssertInfo({
            "Testimi i funksionalitetit të kërkimit me numër kërkese",
            "Verifikimi i saktësisë së të gjitha detajeve pas kërkimit",
            "Konfirmimi i përputhjes së numrit të kërkesës",
            "Kontrolli i institucionit dërgues dhe pritës",
            "Sigurimi i saktë i datës së kërkesës",
            "Vlerësimi gjithëpërfshirës i detajeve të kërkesës specifike",
            "Kontrollimi i statusit dhe përgjegjësit të kërkesës"
    })
    public void kerkimiDheVerifikimiMeNrKerkese() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        String nrKerkeses="SQDNE280220250036";
        page.pastroFiltrat();
        page.nrKerkeses(nrKerkeses);
        softAssert.assertEquals(page.getNrKerkeses(),nrKerkeses,"");
        softAssert.assertEquals(page.getInstitucionDergues(),"Instituti i Sigurimeve Shoqërore (ISSH)");
        softAssert.assertTrue(page.getInstitucionPrites().contains("- Agjencia Kombëtare e Mjedisit"),"");
        softAssert.assertTrue(page.getDataKerkeses().contains("- 28/02/2025"),"");
        softAssert.assertTrue(page.getKerkesa().contains("- AMBU"),"");
        softAssert.assertEquals(page.getPergjegjesi(),"Valbona Koci");
        softAssert.assertEquals(page.getKthimPergjigje(),"28/02/2025");
        softAssert.assertEquals(page.getStatusi(),"Aplikuar për dokumentacion shoqërues");
        softAssert.assertAll();
    }

   @Test(priority = 7)
   @AssertInfo({
           "Testimi i dukshmërisë së opsioneve të filtrave",
           "Verifikimi i qëndrueshmërisë së strukturës së filtrave",
           "Konfirmimi i ruajtjes së opsioneve ekzistuese",
           "Kontrolli i ndryshimeve në opsionet e filtrave",
           "Sigurimi i saktë i qëndrueshmërisë së elementeve të filtrave",
           "Vlerësimi i mundshëm i modifikimeve në funksionalitetin e filtrave"
   })
   public void vizibilitetiIOpsioneveSeFiltrave() throws InterruptedException {
        page.clickTeTabelaButton();
        Thread.sleep(1500);
        Assert.fail("Jane hequr disa filtra dhe eshte shtuar nje tek Opsionet E Filtrave");
   }
   @Test(priority = 8)
   @AssertInfo({
           "Testimi i funksionalitetit të filtrit të datës",
           "Verifikimi i saktësisë së kërkimit me interval kohor specifik",
           "Konfirmimi që të gjitha datat e rezultateve janë brenda intervalit të përcaktuar",
           "Kontrolli i përputhjes së rezultateve me kriteret e datës",
           "Sigurimi i saktë i filtrit nga data fillestare deri në datën përfundimtare",
           "Vlerësimi gjithëpërfshirës i rezultateve të filtruara sipas datës"
   })
   public void filtrimiMeDate() throws InterruptedException {
       page.shfaqeTeDhena("10");
       page.clickTeTabelaButton();
       page.pastroFiltrat();
       page.selektoDaten("24/02/2025","26/02/2025");
       page.clickLastPage();
       Thread.sleep(5000);
       page.getAllDataKerkesesNderInstit();
       page.getAfatiKthimPergjigje();
   }

    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

}
