package WorkFlowTest;

import Globals.Globals;
import Pages.DokumentesSHConfigPage;
import Pages.InstitucioniKofigPage;
import Pages.NjesitKonfigPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class NjesiInstitucionDocShoqeruara {
    NjesitKonfigPage njesiPage;
    InstitucioniKofigPage insitucionPage;
    DokumentesSHConfigPage dokumenteShPage;
    private WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        njesiPage= new NjesitKonfigPage();
        insitucionPage= new InstitucioniKofigPage();
        dokumenteShPage= new DokumentesSHConfigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test(priority = 1)
    public void navigimiTekNjesiKonfig(){
        driver.navigate().to(Globals.NjesitConfigURL);
        Assert.assertEquals(driver.getCurrentUrl(), Globals.NjesitConfigURL,"Nuk ke naviguar ne faqen e njesive te konfigurimit");
    }
    @Test(priority = 2)
    public void krijimiINjesis(){
        njesiPage.klikoShtoNjesi();
        Assert.assertTrue(njesiPage.isShtoNjesiTitleDisplayed(),"Nuk eshte hapur shto njesi ose nuk ka dale titulli");
        njesiPage.shtoNjesi("test"+Globals.generateRandom5DigitNumber(),false);
    }
    @Test(priority = 3)
    public void verifikimiINjesisSeKrijuar() throws InterruptedException {
        njesiPage.searchbyValue(njesiPage.njesiEmeri);
        Assert.assertEquals(njesiPage.getEmeriTable(),njesiPage.njesiEmeri,"Nuk jane emerat te njejte");
        njesiPage.clickEditButton();
        Assert.assertTrue(njesiPage.isEditTableDisplated(),"Nuk eshte hapur edit Table ose kemi naviguar ne faqe tjeter");
        Assert.assertEquals(njesiPage.getEditEmeri(),njesiPage.njesiEmeri,"Nuk jane emerat e njejte prisnim: "+njesiPage.njesiEmeri+" Na doli : "+njesiPage.getEditEmeri());
        Assert.assertEquals(njesiPage.isEditInaktivSelected(),njesiPage.inAktiv,"Prisnim qe butoni inaktiv te ishte : "+njesiPage.inAktiv+" Na doli: "+njesiPage.isEditInaktivSelected());
    }
    @Test(priority = 4)
    public void navigimiTekInstitucioni(){
        driver.navigate().to(Globals.institucionConfigURL);
        BaseInformation.waitUntilPageLoads();
        Assert.assertEquals(driver.getCurrentUrl(), Globals.institucionConfigURL,"Nuk ke naviguar ne faqen e Institucioneve te konfigurimit");
        insitucionPage.waitTillNotReloading();
    }
    @Test(priority = 5)
    public void krijimiIInstitucionitMeNjesinEKrijuar(){
        insitucionPage.shtoInstitucioninMeNjesi(njesiPage.njesiEmeri);
        Assert.assertTrue(insitucionPage.isSuccesMessageDisplayed(),"Nuk Doli mesazhi i suksesit");

    }
    @Test(priority = 6)
    public void verifikimiIInstitucionit() throws InterruptedException {
        insitucionPage.waitTillNotReloading();
        insitucionPage.searchByValue(insitucionPage.emeri);
        Thread.sleep(2000);
        softAssert.assertEquals(insitucionPage.getFirstName(),insitucionPage.emeri,"Emerat nuk jane te njejte ose nuk ekziston");
        softAssert.assertEquals(insitucionPage.getTitullari(),insitucionPage.titull,"Nuk eshte i njejte texti i titullarit");
        softAssert.assertEquals(insitucionPage.getPozicioniTitullarit(),insitucionPage.pozicionTitull,"Nuk eshte i njejte texti i Pozicionit te titullarit");
        softAssert.assertEquals(insitucionPage.isCheckBoxInaktiveEnabled(),insitucionPage.inaktive,"Nuk jan te njejta ChcekBox sic i regjistruam");
        softAssert.assertTrue(insitucionPage.getEditButtonsSize()>0,"Nuk ka dale asnje Edit Button mbas kerkimit te te dhenavae");
        softAssert.assertTrue(insitucionPage.getDeleteBtnsSize()>0,"Nuk ka dale asnje DeleteButton mbas kerkimit te te dhenave");
        softAssert.assertAll();

    }
    @Test(priority = 7)
    public void navigimiTekDokumenteShoqeruese() {
        driver.navigate().to(Globals.KonfigurimiDokumenteveShoqeruese);
        wait.until(ExpectedConditions.urlToBe(Globals.KonfigurimiDokumenteveShoqeruese));
        Assert.assertEquals(driver.getCurrentUrl(),Globals.KonfigurimiDokumenteveShoqeruese);

    }
    @Test(priority = 8)
    public void krijimiIDokumenteveShoqerueseMeInstitucioninEKrijuar() throws InterruptedException {
        dokumenteShPage.shtoSherbimin("SherbimiDOCSHtestt"+Globals.generateRandom5DigitNumber(),insitucionPage.emeri);// unique name cuz its required
        Assert.assertEquals(dokumenteShPage.dshGetSherbimi(),dokumenteShPage.Sherbimi,"Sherbimi nuk eshte i njejte me ate qe beme input");
        Assert.assertEquals(dokumenteShPage.dshGetInstitucioni(),dokumenteShPage.Institucioni,"Institucioni nuk eshte i njejte me ate qe beme input");
        dokumenteShPage.ruajSherbimin();
        Assert.assertTrue(dokumenteShPage.isSuccessMessageDisplayed(),"Nuk u krye saktesisht krijimi i sherbimit");
    }
    @Test(priority = 9)
    public void verifikimiIDokumentitSH_TeKrijuar() throws InterruptedException {
        dokumenteShPage.searchByValue(dokumenteShPage.Sherbimi);
        Assert.assertEquals(dokumenteShPage.getSherbimiTable(),dokumenteShPage.Sherbimi,"Sherbimi nuk eshte i njejte si tek tabela e rezultateve mas kerkimit");
        Assert.assertEquals(dokumenteShPage.getInstitucioniTable(),dokumenteShPage.Institucioni,"Institucioni nuk eshte i njejte si tek tabela e rezultateve mas kerkimit");
    }



}
