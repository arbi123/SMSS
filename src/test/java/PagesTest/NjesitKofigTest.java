package PagesTest;

import Elements.NjesitKonfigElements;
import Globals.Globals;
import Pages.InstitucioniKofigPage;
import Pages.NjesitKonfigPage;
import Utilities.BaseInformation;
import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class NjesitKofigTest {

    NjesitKonfigPage page;
    private WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new NjesitKonfigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.NjesitConfigURL);
    }

    @Test(priority = 1)
    public void shtoNjesi(){
        Assert.assertEquals(driver.getCurrentUrl(), Globals.NjesitConfigURL,"Nuk ke naviguar ne faqen e njesive te konfigurimit");
        page.klikoShtoNjesi();
        Assert.assertTrue(page.isShtoNjesiTitleDisplayed(),"Nuk eshte hapur shto njesi ose nuk ka dale titulli");
        page.shtoNjesi("test"+Globals.generateRandom5DigitNumber(),false);
    }
    @Test(priority = 2)
    public void editimNjesie() throws InterruptedException {
        page.searchbyValue(page.njesiEmeri);
        Assert.assertEquals(page.getEmeriTable(),page.njesiEmeri,"Nuk jane emerat te njejte");
        page.clickEditButton();
        Assert.assertTrue(page.isEditTableDisplated(),"Nuk eshte hapur edit Table ose kemi naviguar ne faqe tjeter");
        Assert.assertEquals(page.getEditEmeri(),page.njesiEmeri,"Nuk jane emerat e njejte prisnim: "+page.njesiEmeri+" Na doli : "+page.getEditEmeri());
        Assert.assertEquals(page.isEditInaktivSelected(),page.inAktiv,"Prisnim qe butoni inaktiv te ishte : "+page.inAktiv+" Na doli: "+page.isEditInaktivSelected());
    page.editimNjesie("editTest"+Globals.generateRandom5DigitNumber(),true);
        Assert.assertEquals(page.getEmeriTable(),page.njesiEmeri,"Nuk jane emerat te njejte");

    }
    @Test(priority = 3)
    public void fshirjaENjesis() throws InterruptedException {
      page.deleteNjesi(page.njesiEmeri);
      page.de

    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

}
