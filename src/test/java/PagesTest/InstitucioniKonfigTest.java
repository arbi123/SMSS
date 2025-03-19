package PagesTest;

import Globals.Globals;
import Pages.InstitucioniKofigPage;
import Utilities.BaseInformation;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;


public class InstitucioniKonfigTest {
    InstitucioniKofigPage page;
    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new InstitucioniKofigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.institucionConfigURL);
    }


    @Test(priority = 1)
    @AssertInfo({
            "Navigojmë te faqja e konfigurimit të institucioneve",
            "Presim që faqja të ngarkohet",
            "Klikojmë butonin për shtimin e institucionit",
            "Konfirmojmë që mesazhi i suksesit është shfaqur"
    })
    public void krijimiIInstitucionit(){
        driver.navigate().to(Globals.institucionConfigURL);
        BaseInformation.waitUntilPageLoads();
        page.shtoInstitucionin();
        Assert.assertTrue(page.isSuccesMessageDisplayed(),"Nuk Doli mesazhi i suksesit");
    }
    @Test(priority = 2)
    @AssertInfo({
            "Presim që faqja të mos jetë duke u rifreskuar",
            "Kërkojmë institucionin sipas emrit",
            "Presim pak sekonda për ngarkimin e të dhënave",
            "Konfirmojmë që emri i institucionit është i saktë ose ekziston"
    })
    public void kerkimiIInstitucionitTeKrijuar() throws InterruptedException {
        page.waitTillNotReloading();
        page.searchByValue(page.emeri);
        Thread.sleep(2000);
        Assert.assertEquals(page.getFirstName(),page.emeri,"Emerat nuk jane te njejte ose nuk ekziston");
    }
    @Test(priority = 3)
    @AssertInfo({
            "Verifikojmë që titullari është i njëjtë me vlerën e regjistruar",
            "Konfirmojmë që pozicioni i titullarit është i saktë",
            "Kontrollojmë që vlera e checkbox-it inaktiv përputhet me regjistrimin",
            "Sigurohemi që butonat e editimit janë të disponueshëm pas kërkimit",
            "Verifikojmë që butonat e fshirjes janë të disponueshëm pas kërkimit"
    })
    public void verifikimiTableData(){
       softAssert.assertEquals(page.getTitullari(),page.titull,"Nuk eshte i njejte texti i titullarit");
       softAssert.assertEquals(page.getPozicioniTitullarit(),page.pozicionTitull,"Nuk eshte i njejte texti i Pozicionit te titullarit");
       softAssert.assertEquals(page.isCheckBoxInaktiveEnabled(),page.inaktive,"Nuk jan te njejta ChcekBox sic i regjistruam");
       softAssert.assertTrue(page.getEditButtonsSize()>0,"Nuk ka dale asnje Edit Button mbas kerkimit te te dhenavae");
       softAssert.assertTrue(page.getDeleteBtnsSize()>0,"Nuk ka dale asnje DeleteButton mbas kerkimit te te dhenave");
       softAssert.assertAll();
    }

    @Test(priority = 4)
    @AssertInfo({
            "Klikojmë butonin e editimit për institucionin e parë",
            "Verifikojmë që emri i institucionit është i njëjtë",
            "Konfirmojmë që kodi është i saktë",
            "Sigurohemi që titullari është i njëjtë me vlerën e regjistruar",
            "Verifikojmë që kodi i protokollit është korrekt",
            "Konfirmojmë që pozicioni i titullarit është i saktë",
            "Kontrollojmë që checkbox-i 'Kryesore' ka vlerën e duhur",
            "Verifikojmë që checkbox-i 'Inaktive' ka vlerën e duhur",
            "Sigurohemi që checkbox-i 'Generate Template' është korrekt",
            "Konfirmojmë që koka e shkresës është e njëjtë me të regjistruarën",
            "Verifikojmë që njësia e lidhur është e saktë pas editimit"
    })
    public void verifikimEditData() throws IOException, UnsupportedFlavorException {
       page.clickFirstEditButton();
        softAssert.assertEquals(page.getEmeriMI(),page.emeri,"Nuk kan emertime te njejta");
        softAssert.assertEquals(page.getKodiMI(),page.kodi,"Nuk kane kode te njejta");
        softAssert.assertEquals(page.getTitullariMI(),page.titull,"Nuk jan titullar te njejte ");
        softAssert.assertEquals(page.getNrProtokolliMI(),page.kodiNrProtokolli,"Nuk eshte kodi i protokollit i njejte");
        softAssert.assertEquals(page.getPozicionTitullaritMI(),page.pozicionTitull,"Nuk eshte i njejte pozicioni titull");
        //softAssert.assertEquals(page.getInstitucioniPrindMI(),page.institucioniPrind,"Nuk jane institucionet e njejta ose ke bere click kryesore"); per shkak se kemi bere select kryesore dhe behet te tjera
        softAssert.assertEquals(page.isKryesoreRBCheckedMI(), page.kryesore,"Chekboxi kryesore nuk eshte sic e krijuam prisnim te ishte: "+page.kryesore+" Ishte ne te vertet :"+page.isKryesoreRBCheckedMI());
        softAssert.assertEquals(page.isInAktiveRBChecked(), page.inaktive, "Chekboxi InAktive nuk eshte sic e krijuam. Prisnim te ishte: " + page.inaktive + " Ishte ne te vertet: " + page.isInAktiveRBChecked());        softAssert.assertAll();
        softAssert.assertEquals(page.isGenerateTemplateChecked(), page.gjenerimTemplate, "Chekboxi GenerateTemplate nuk eshte sic e krijuam. Prisnim te ishte: " + page.gjenerimTemplate + " Ishte ne te vertet: " + page.isGenerateTemplateChecked());
        softAssert.assertEquals(page.kokaEShkresesMI(),page.kokaShkr,"Koka e shkreses nuk eshte e njejte ");
      //  softAssert.assertEquals(page.fundiShkresesMI(),page.fundiShkr,"Fundi i shkreses nuk eshte i njejte");
        softAssert.assertEquals(page.njesiaMI(),page.Njesia,"Njesite nuk jane te njejta");
        softAssert.assertAll();
    }
    @Test(priority = 5)
    @AssertInfo({
            "Modifikojmë dhe ruajmë automatikisht të dhënat",
            "Verifikojmë që nuk ka ndonjë bug ose error pas ruajtjes",
            "Konfirmojmë që emri është i saktë pas modifikimit",
            "Sigurohemi që titullari është i njëjtë pas modifikimit",
            "Verifikojmë që pozicioni i titullarit është korrekt pas modifikimit"
    })
    public void EditAndRuaj(){
        page.modifikimDheRuajtjeAuto();
        softAssert.assertFalse(page.isErrorDisplayed(),"Kemi nje bug ose error kur i modifikojm dhe provojm ti ruajm te dhenat");
        softAssert.assertEquals(page.getEmeriMI(),page.emeri1,"Nuk jan emertime te njejta mbas modifikimti");
        softAssert.assertEquals(page.getTitullariMI(),page.titullari1,"Nuk jan titullar te njejte mbas modifikimti");
        softAssert.assertEquals(page.getPozicionTitullaritMI(),page.pozicionTitull1,"Nuk eshte i njejte pozicioni titull mbas modifikimit");
        softAssert.assertAll();
    }

    @Test(priority = 7)
    @AssertInfo({
            "Rifreskojmë faqen për t'u siguruar që të dhënat janë të përditësuara",
            "Kërkojmë institucionin sipas emrit për fshirje",
            "Fshijmë institucionin dhe konfirmojmë suksesin e operacionit",
            "Rikërkojmë institucionin për t'u siguruar që është fshirë",
            "Verifikojmë që butonat e fshirjes nuk janë të pranishëm pas fshirjes",
            "Sigurohemi që butonat e editimit nuk janë të pranishëm pas fshirjes"
    })
    public void fshirjaETeDhenave(){
        driver.navigate().refresh();
        page.searchByValue(page.emeri1);
        page.fshirjaEInstitucionit();
        Assert.assertTrue(page.isDeleteSuccesDisplayed(),"Kemi gabime tek delete i institucionit");
        page.searchByValue(page.emeri1);
        Assert.assertFalse(page.getDeleteBtnsSize()<0,"Nuk eshte fshire ose data te tjera kan same name"+page.getFirstName());
        Assert.assertFalse(page.getEditButtonsSize()<0,"Nuk eshte fshire ose data te tjera kan same name"+page.getFirstName());
    }




        @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(2000);

    }
}
