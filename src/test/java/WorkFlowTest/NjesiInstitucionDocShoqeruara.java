package WorkFlowTest;

import Globals.Globals;
import Pages.DokumentesSHConfigPage;
import Pages.InstitucioniKofigPage;
import Pages.NjesitKonfigPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class NjesiInstitucionDocShoqeruara {
    NjesitKonfigPage njesiPage;
    InstitucioniKofigPage insitucionPage;
    DokumentesSHConfigPage dokumenteShPage;
    private WebDriver driver;
    WebDriverWait wait;
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
    @Test
    public void verifikimiIInstitucionit(){

    }
    @Test
    public void navigimiTekDokumenteShoqeruese(){

    }
    @Test
    public void krijimiIDokumenteveShoqerueseMeInstitucioninEKrijuar(){

    }
    @Test
    public void verifikimiIDokumentitSH_TeKrijuar(){

    }



}
