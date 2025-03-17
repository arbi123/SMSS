package PagesTest;

import Globals.Globals;
import Pages.DokumentesSHConfigPage;
import Pages.InstitucioniKofigPage;
import Pages.NjesitKonfigPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DokumentesSHConfigTest {
    DokumentesSHConfigPage page;
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new DokumentesSHConfigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.KonfigurimiDokumenteveShoqeruese);
    }
    @Test(priority = 1)
    public void shtimiIDokumenteveShoqeruese() throws InterruptedException {
        wait.until(ExpectedConditions.urlToBe(Globals.KonfigurimiDokumenteveShoqeruese));
        Assert.assertEquals(driver.getCurrentUrl(),Globals.KonfigurimiDokumenteveShoqeruese);
        page.shtoSherbimin("testt"+Globals.generateRandom5DigitNumber(),"Bashkia Maliq");// unique name cuz its required
        Assert.assertEquals(page.dshGetSherbimi(),page.Sherbimi,"Sherbimi nuk eshte i njejte me ate qe beme input");
        Assert.assertEquals(page.dshGetInstitucioni(),page.Institucioni,"Institucioni nuk eshte i njejte me ate qe beme input");
        page.ruajSherbimin();
        Assert.assertTrue(page.isSuccessMessageDisplayed(),"Nuk u krye saktesisht krijimi i sherbimit");
    }
    @Test(priority = 2)
    public void kerkimiDheValidimiIKrijimitTe0Dokumentacionit() throws InterruptedException {
    page.searchByValue(page.Sherbimi);
    Assert.assertEquals(page.getSherbimiTable(),page.Sherbimi,"Sherbimi nuk eshte i njejte si tek tabela e rezultateve mas kerkimit");
    Assert.assertEquals(page.getInstitucioniTable(),page.Institucioni,"Institucioni nuk eshte i njejte si tek tabela e rezultateve mas kerkimit");
    }
    @Test(priority =3)
    public void editimiISherbimit() {
        page.clickEditSherbimi();
        page.ruajSherbimin();
        page.editAndFillSherbimi("");
        Assert.assertTrue(page.errorSherbimiTB(),"Error nuk duhet ta Pranonte sherbimin bosh");
        page.editAndFillSherbimi("Test"+Globals.generateRandom5DigitNumber());
        page.clearInstitucioni();
        page.ruajSherbimin();
       Assert.assertTrue(page.errorInstitucioniTB(),"Nuk ka dale error mbasi kemi tentuar ta ruajm pa insittucion");
       page.editAndFill("editedTest"+Globals.generateRandom5DigitNumber(),"Bashkia Maliq");
       page.ruajSherbimin();

    }
    @Test
    public void deleteSherbim(){
        page.searchByValue(page.Sherbimi);
        page.deleteSherbimi();
        Assert.assertTrue(page.isDeleteTitleDisplayed(),"Nuk ka dale boxi per ta konfirmuar Deleten ");
        page.dele
    }

    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
