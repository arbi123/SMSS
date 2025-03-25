package StatistikaPagesTest;

import ConfigPages.SherbimiConfigPage;
import DataProviders.LlojiStatuseveDP;
import DataProviders.MinistriteFilterDP;
import Globals.Globals;
import StatistikaPages.StatistikaAplikimeshPage;
import Utilities.BaseInformation;
import com.beust.ah.A;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class StatistikaAplikimeshTest {
    StatistikaAplikimeshPage page;
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new StatistikaAplikimeshPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.SQDNELoginURL);
        Cookie cookie = new Cookie("jwt","eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJuYW1laWQiOiJmZWVkMTJiNi1jY2NlLTQ3YTItODIzMS1iZTQ3YjQ0Nzk1ODIiLCJJZCI6ImZlZWQxMmI2LWNjY2UtNDdhMi04MjMxLWJlNDdiNDQ3OTU4MiIsIkZ1bGxOYW1lIjoiQWRtaW5pc3RyYXRvciBTUURORSIsIkVtYWlsIjoiZG9hbGQuaGFrYUBzb2Z0c29sdXRpb24uYWwiLCJVc2VyTmFtZSI6ImFkbWluLnNxZG5lIiwiQ2FuQWNjZXNzQWxsU2VydmljZXNJbkluc3RpdHV0aW9uIjp0cnVlLCJSb2xlcyI6WyJTaGthcmtpbSBleGNlbCByYXBvcnRlIiwiU3BlY2lhbGlzdCBTUURORSBOZW5zaGtydWVzIiwiQXV0b3JpenVhciBWdWxvcyBEb2t1bWVudGEiLCJTcGVjaWFsaXN0IFNRRE5FIiwiQWRtaW5pc3RyYXRvciBBS1NISSJdLCJQZXJtaXNzaW9ucyI6W3siTmFtZSI6IktyeWVmYXFqYSIsIkNvZGUiOiJIT00iLCJUeXBlIjoiV0FUQ0gifSx7Ik5hbWUiOiJLb25maWd1cmltIHNow6tyYmltaSIsIkNvZGUiOiJDU0VSIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiTGlzdGEgZSBhcGxpa2ltZXZlIHTDqyByZWFsaXp1YXJhIiwiQ29kZSI6IkxBUExSIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiU2jDq3JiaW1lIG1lIHZ1bMOrIiwiQ29kZSI6IlNWIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiUmFwb3J0IHDDq3JtYmxlZGjDq3MiLCJDb2RlIjoiUlBQIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiU3RhdGlzdGlrYSBhcGxpa2ltZXNoIG7DqyBlLUFsYmFuaWEiLCJDb2RlIjoiU0FFIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiTW9kaWZpa2ltZSBBcGxpa2ltZXNoIiwiQ29kZSI6IkFQTFJFRyIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlJhcG9ydGltZSIsIkNvZGUiOiJSUCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlNoZXJiaW1ldCBtw6sgdMOrIHDDq3Jkb3J1cmEiLCJDb2RlIjoiU01QIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiQXBsaWtpbWUgUmlzaHDDq3JuZGFyamUiLCJDb2RlIjoiQVBMUklTSCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IktvbmZpZ3VyaW0gaW5zdGl0dWNpb25pIiwiQ29kZSI6IkNJTlMiLCJUeXBlIjoiV0FUQ0gifSx7Ik5hbWUiOiJBcGxpa2ltZSBzaXBhcyBzaMOrcmJpbWV2ZSIsIkNvZGUiOiJBUExTIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiU3RhdGlzdGlrYSBrw6tya2VzYXZlIG5kw6tyaW5zdGl0dWNpb25hbGUiLCJDb2RlIjoiU0tJIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiU3RhdGlzdGlrYSB0w6sgcMOrcmdqaXRoc2htZSIsIkNvZGUiOiJTUCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IktvbmZpZ3VyaW0gZGl0w6t2ZSBwdXNoaW0iLCJDb2RlIjoiQ0hPTCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlJpc2hww6tybmRhcmplIiwiQ29kZSI6IlJTSCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IkFwbGlraW1ldCIsIkNvZGUiOiJBUEwiLCJUeXBlIjoiV0FUQ0gifSx7Ik5hbWUiOiJLb25maWd1cmltIHDDq3Jkb3J1ZXNpIiwiQ29kZSI6IkNVU1IiLCJUeXBlIjoiV0FUQ0gifSx7Ik5hbWUiOiJWbGVyw6tzaW1ldCBlIHNow6tyYmltZXZlIiwiQ29kZSI6IlZTSCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlZsZXLDq3NpbWV0IG1lc2F0YXJlIHTDqyBzaMOrcmJpbWV2ZSIsIkNvZGUiOiJWTVNIIiwiVHlwZSI6IldBVENIIn0seyJOYW1lIjoiQXBsaWtpbWUgc2lwYXMgcHVub25qw6tzdmUiLCJDb2RlIjoiQVBMUCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IktvbmZpZ3VyaW0gd29ya2Zsb3ciLCJDb2RlIjoiQ1dLRiIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IktvbmZpZ3VyaW0gb3JnYW5pZ3JhbWUiLCJDb2RlIjoiQ09SRyIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlN0YXRpc3Rpa2EgYXBsaWtpbWVzaCB0w6sgcnJlZ2ppc3RydWFyYSIsIkNvZGUiOiJTQVIiLCJUeXBlIjoiV0FUQ0gifSx7Ik5hbWUiOiJEYXNoYm9hcmQgU3RhdGlzdGlrYSIsIkNvZGUiOiJEUyIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IlN0YXRpc3Rpa2EgbsOrIGxpZGhqZSBtZSBrdGhpbWluIGUgcMOrcmdqaWdqZXMiLCJDb2RlIjoiU0xLUCIsIlR5cGUiOiJXQVRDSCJ9LHsiTmFtZSI6IktvbmZpZ3VyaW0gZG9rdW1lbnRpIiwiQ29kZSI6IkNET0MiLCJUeXBlIjoiV0FUQ0gifV0sIkluc3RpdHV0aW9uVW5pdEFjY2VzcyI6eyJJbnN0aXR1dGlvbklkIjoiOGIzY2VkMGMtODdjMS00MTA5LWI0OTYtMzA3MWI0MjcxOTk0IiwiUGFyZW50SW5zdGl0dXRpb25JZCI6IjAwMDAwMDAwLTAwMDAtMDAwMC0wMDAwLTAwMDAwMDAwMDAwMCIsIkluc3RpdHV0aW9uTmFtZSI6Ik1pbmlzdHJpYSBlIEluZnJhc3RydWt0dXLDq3MgZGhlIEVuZXJnamlzw6siLCJVbml0SWRzQWNjZXNzIjpbImVjYTNkMmE0LWEwMzgtNDg1Zi1iNmJiLTc4OGZjMGMyOGUyMSJdLCJQYXJlbnRJbnN0aXR1dGlvbk5hbWUiOiIifSwibmJmIjoxNzQyODkyMzY1LCJleHAiOjE3NDI5MjgzNjUsImlhdCI6MTc0Mjg5MjM2NSwiaXNzIjoiU3FkbmUuU2VydmVyIiwiYXVkIjoiU3FkbmUuQ2xpZW50In0.fh8AnI1aj3a2YlVBnvxaE3zdZs5VqvTO-dcnBsP29_SgHus6kHKDKEhxlnd3EchAW45AYK1ypeXMcG2Aepi7EA");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

    }
    @Test(priority = 0)
    public void navigoTekFaqja(){
        driver.navigate().to(Globals.statistikaAplkimeshURL);
        wait.until(ExpectedConditions.urlToBe(Globals.statistikaAplkimeshURL));
        Assert.assertEquals(driver.getCurrentUrl(),Globals.statistikaAplkimeshURL);
         page.waitUntilNoTableReaload();
    }

    @Test(priority = 1)
    public void testimiIShfaqRezultatePerFaqe(){
        page.shfaqeTeDhena("10");
        Assert.assertEquals(page.tableSize(),10,"");
        page.shfaqeTeDhena("25");
        Assert.assertEquals(page.tableSize(),25,"");
        page.shfaqeTeDhena("50");
        Assert.assertEquals(page.tableSize(),50,"");
        page.shfaqeTeDhena("100");
        Assert.assertEquals(page.tableSize(),100,"");
        page.shfaqeTeDhena("10");
        Assert.assertEquals(page.tableSize(),10,"");
    }

    @Test(priority = 2,enabled = false)
    public void testimiIKerkimitMeNRAplikimi(){
        SoftAssert softAssert = new SoftAssert();
        page.nrAplikimit("OSHEE-TEST-2025-1");
        softAssert.assertEquals(page.getInstitucionitTABLE(),"Operatori i Shpërndarjes së Energjisë Elektrike (OSHEE)");
        softAssert.assertEquals(page.getNrAplikimitTable(),"OSHEE-TEST-2025-1");
        softAssert.assertEquals(page.getSherbimiTable(),"Vërtetim Debie OSHEE");
        softAssert.assertEquals(page.getNiptID(),"K00329058K");
        softAssert.assertEquals(page.getStatusTABLE(),"Regjistruar aplikimi në E-Albania");
        softAssert.assertAll();
        page.clearNraplikimit();


    }
    @Test(priority = 3,dataProvider = "statusTypes",dataProviderClass = LlojiStatuseveDP.class,enabled = false)
    public void FiltrimiMeStatusinDheVerifikimi(String value) throws InterruptedException {
        SoftAssert softAssert= new SoftAssert();
        page.selectStatusi(value);
          Thread.sleep(3000);
        if(page.isTableEmpty()){
            page.clearStatus();
            Thread.sleep(2000);
            Assert.fail("Ska problem vetem mbas kerkimit nuk kishte te dhena tek tabela");
        }else{
        for(String item: page.statusiTable()){
            softAssert.assertEquals(value,item,"Ka te dhena ne tabele qe nuk i perputhen filtrimit me statusin");
        }}
        page.clearStatus();
        softAssert.assertAll();//dont work
    }
    @Test(priority = 3,dataProviderClass = MinistriteFilterDP.class,dataProvider = "ministriaTypes")
    public void ministriaAndInstitucionetFiltrim(String value) throws InterruptedException {

        page.selectMinistria(value);
        Thread.sleep(3000);
        page.clickInsitucionet();
        Thread.sleep(3000);
        Assert.assertEquals(page.strongInstitucionText(),value,"Nuk jan te njejta");
    }
    @Test(priority = 2)
    public void filtrimiIDatesSearching() throws InterruptedException {
        String dataFillimit ="22/01/2025";
        String dataMbarimit = "24/01/2025";
        page.selektoDaten(dataFillimit,dataMbarimit);
        List<String> datatAplikimit = page.datatEaplikimit();
        List<String> datatPerfundimit = page.datatEPerfundimit();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            // Konverto datat e inputuara në Date për kufizimet
            Date fillimInput = sdf.parse(dataFillimit);
            Date mbarimInput = sdf.parse(dataMbarimit);

            // Loop për secilin rresht të datave të aplikimit
            for (int i = 0; i < datatAplikimit.size(); i++) {
                String dataAplikimitText = datatAplikimit.get(i).trim();
                Date dataAplikimitDate = sdf.parse(dataAplikimitText);

                // Verifikon që data e aplikimit është midis datave të inputuara (ose e barabartë me to)
                Assert.assertTrue(
                        (dataAplikimitDate.equals(fillimInput) || dataAplikimitDate.after(fillimInput)) &&
                                (dataAplikimitDate.equals(mbarimInput) || dataAplikimitDate.before(mbarimInput)),
                        "Rreshti " + (i+1) + ": Data e aplikimit (" + dataAplikimitText +
                                ") nuk është brenda intervalit [" + dataFillimit + " - " + dataMbarimit + "]."
                );
            }
        } catch (ParseException e) {
            Assert.fail("Gabim gjatë parsimit të datave: " + e.getMessage());
        }


    }

    @Test(priority = 4)
    public void pastrimiFiltrave() throws InterruptedException {
        page.pastroFiltrat();
        page.selectTipi("Aplikim për dokumentacion shoqërues");
        page.nrAplikimit("LC-6446-03-2025");
        page.selectMinistria("Bashkia");
        page.selectInstitucionet("Bashkia Tiranë");
        page.pastroFiltrat();
        Assert.assertEquals(page.getTipiValue(),"Të Gjithë","Tipi duhet te ishte Të Gjithë kur pastruam filtrat");
        Assert.assertEquals(page.getNRaplikimitValue(),"","Nr Aplikimit duhet te ishte bosh kur pastruam filtrat");
        Assert.assertEquals(page.getMinistriaValue(),"Të Gjithë","Ministria duhet te ishte Të Gjithë kur pastruam filtrat");
        Assert.assertEquals(page.getInsitucionetValue(),"Të Gjithë","Institucioni duhet te ishte boTë Gjithësh kur pastruam filtrat");

    }
//    @Test(priority = 2,enabled = false)
//    public void testimiIpastrimitTeFiltrave(){
//        page.nrAplikimit("999");
//        page.pastroFiltrat();
//        Assert.assertEquals(page.getNRaplikimitValue(),"","Nr Aplikimit duhet te ishte bosh kur pastruam filtrat");
//    }


    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
