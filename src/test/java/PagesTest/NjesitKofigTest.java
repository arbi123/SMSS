package PagesTest;

import Elements.NjesitKonfigElements;
import Globals.Globals;
import Pages.InstitucioniKofigPage;
import Pages.NjesitKonfigPage;
import Utilities.BaseInformation;
import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class NjesitKofigTest {

    NjesitKonfigPage page;
    private WebDriver driver;
    WebDriverWait wait;
    public String institucioniEmer;
    InstitucioniKofigPage page1= new InstitucioniKofigPage();


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new NjesitKonfigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.NjesitConfigURL);
    }

    @Test(priority = 1,groups = {"smoke", "regression"})
    public void shtoNjesi(){
        driver.navigate().to(Globals.NjesitConfigURL);

        Assert.assertEquals(driver.getCurrentUrl(), Globals.NjesitConfigURL,"Nuk ke naviguar ne faqen e njesive te konfigurimit");
        page.klikoShtoNjesi();
        Assert.assertTrue(page.isShtoNjesiTitleDisplayed(),"Nuk eshte hapur shto njesi ose nuk ka dale titulli");
        page.shtoNjesi("test"+Globals.generateRandom5DigitNumber(),false);
    }
    @Test(priority = 2,groups = {"smoke", "regression"})
    public void editimNjesie() throws InterruptedException {
        page.searchbyValue(page.njesiEmeri);
        Assert.assertEquals(page.getEmeriTable(),page.njesiEmeri,"Nuk jane emerat te njejte");
        page.clickEditButton();
        Assert.assertTrue(page.isEditTableDisplated(),"Nuk eshte hapur edit Table ose kemi naviguar ne faqe tjeter");
        Assert.assertEquals(page.getEditEmeri(),page.njesiEmeri,"Nuk jane emerat e njejte prisnim: "+page.njesiEmeri+" Na doli : "+page.getEditEmeri());
        Assert.assertEquals(page.isEditInaktivSelected(),page.inAktiv,"Prisnim qe butoni inaktiv te ishte : "+page.inAktiv+" Na doli: "+page.isEditInaktivSelected());
        page.editimNjesie("editTest"+Globals.generateRandom5DigitNumber(),false);
        page.searchbyValue(page.njesiEmeri);
        Assert.assertEquals(page.getEmeriTable(),page.njesiEmeri,"Nuk jane emerat te njejte mbas editimit");

    }

    @Test(priority = 3,groups = {"smoke"})
    public void fshirjaENjesis() throws InterruptedException {
        page.deleteNjesi(page.njesiEmeri);
     Assert.assertTrue(page.isFshirjaTitleDisplayed(),"Nuk ka dale titulli i fshirjes");
     page.conifrmDeleteNjesi();
     Assert.assertTrue(page.isSuccesNotificationDisplayed());
    }


    @Test(priority = 4,groups = {"regression"})
    public void verifikimiTekInstitucionet(){
        institucioniEmer="testInst"+Globals.generateRandom5DigitNumber();
        driver.navigate().to(Globals.institucionConfigURL);
        BaseInformation.waitUntilPageLoads();
        page1.shtoInstitucionButton();
        page1.sendImg("C:\\Users\\Arbi.topi\\Downloads\\Folder\\photo.png");
        page1.emertimiInstitucionit(institucioniEmer);
        page1.njesiaSelect(page.njesiEmeri);
        page1.ruajShtiminEInstitucionit();
        Assert.assertTrue(page1.isSuccesMessageDisplayed(),"Nuk Doli mesazhi i suksesit kur provuam te shtojme institucion mbas njesive");
        page1.waitTillNotReloading();
        page1.searchByValue(institucioniEmer);
        page1.waitTillNotReloading();
    }

    @Test(priority = 5,groups = {"regression"})
    public void testingNjesiaisCorrect() {
        page1.clickFirstEditButton();
        Assert.assertEquals(page1.getEmeriMI(),institucioniEmer,"Nuk kan emertime te njejta");
        Assert.assertEquals(page1.njesiaMI(),page.njesiEmeri,"Njesite nuk jan te njejta mbasi krijimit ne Institucion");
    }



    @AfterClass
    public void quit(){
        driver.close();
    }

}
