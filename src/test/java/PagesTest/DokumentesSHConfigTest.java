package PagesTest;

import Globals.Globals;
import Pages.DokumentesSHConfigPage;
import Utilities.BaseInformation;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
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
    @AssertInfo({
            "Navigojmë te faqja e konfigurimit të dokumenteve shoqërues",
            "Konfirmojmë që URL është e saktë për konfigurimin e dokumenteve shoqërues",
            "Shtojmë një shërbim me emër unik dhe emër institucioni",
            "Verifikojmë që shërbimi dhe institucioni janë të njëjta me ato që kemi futur",
            "Ruajmë shërbimin dhe konfirmojmë suksesin e krijimit",
            "Sigurohemi që mesazhi i suksesit është shfaqur pas ruajtjes"
    })
    public void shtimiIDokumenteveShoqeruese() throws InterruptedException {
        driver.navigate().to(Globals.KonfigurimiDokumenteveShoqeruese);
        wait.until(ExpectedConditions.urlToBe(Globals.KonfigurimiDokumenteveShoqeruese));
        Assert.assertEquals(driver.getCurrentUrl(),Globals.KonfigurimiDokumenteveShoqeruese);
        page.shtoSherbimin("testt"+Globals.generateRandom5DigitNumber(),"Bashkia Maliq");// unique name cuz its required
        Assert.assertEquals(page.dshGetSherbimi(),page.Sherbimi,"Sherbimi nuk eshte i njejte me ate qe beme input");
        Assert.assertEquals(page.dshGetInstitucioni(),page.Institucioni,"Institucioni nuk eshte i njejte me ate qe beme input");
        page.ruajSherbimin();
        Assert.assertTrue(page.isSuccessMessageDisplayed(),"Nuk u krye saktesisht krijimi i sherbimit");
    }
    @Test(priority = 2)
    @AssertInfo({
            "Kërkojmë shërbimin në tabelën e rezultateve",
            "Verifikojmë që shërbimi i gjetur është i njëjtë me atë që kemi kërkuar",
            "Konfirmojmë që institucioni i gjetur është i njëjtë me atë që kemi kërkuar"
    })
    public void kerkimiDheValidimiIKrijimitTe0Dokumentacionit() throws InterruptedException {
    page.searchByValue(page.Sherbimi);
    Assert.assertEquals(page.getSherbimiTable(),page.Sherbimi,"Sherbimi nuk eshte i njejte si tek tabela e rezultateve mas kerkimit");
    Assert.assertEquals(page.getInstitucioniTable(),page.Institucioni,"Institucioni nuk eshte i njejte si tek tabela e rezultateve mas kerkimit");
    }

    @Test(priority =3)
    @AssertInfo({
            "Klikojmë butonin për të edituar shërbimin",
            "Ruajmë shërbimin pas editimit të parë",
            "Sigurohemi që shërbimi bosh shkakton një gabim",
            "Editojmë dhe mbushim shërbimin me një emër të vlefshëm",
            "Verifikojmë që nuk mund të ruajmë shërbimin pa një institucion",
            "Editojmë dhe ruajmë shërbimin me një emër të saktë dhe institucion"
    })    public void editimiISherbimit() {
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
    @Test(priority = 4)
    @AssertInfo({
            "Kërkojmë shërbimin për fshirje",
            "Klikojmë për të fshirë shërbimin dhe konfirmojmë fshirjen",
            "Konfirmojmë që kutia e konfirmimit të fshirjes është shfaqur",
            "Verifikojmë që shërbimi është fshirë pas konfirmimit të fshirjes",
            "Sigurohemi që tabela është bosh dhe nuk ka të dhëna të mbetura"
    })
    public void deleteSherbim() throws InterruptedException {
        page.searchByValue(page.Sherbimi);
        page.deleteSherbimi();
        Assert.assertTrue(page.isDeleteTitleDisplayed(),"Nuk ka dale boxi per ta konfirmuar Deleten");
        page.konfirmDelete();
        page.searchByValue(page.Sherbimi);
        Assert.assertTrue(page.isTableEmpty(),"Ka akoma te dhena ,nuk jane fshire ose kane te njejtat emra+");

    }
    @Test(priority = 5)
    @AssertInfo({
            "Rifreskojmë faqen për t'u siguruar që të dhënat janë të përditësuara",
            "Shtojmë një shërbim me të dhëna të pasakta (HTML injeksion)",
            "Ruajmë shërbimin dhe verifikojmë që është shfaqur gabimi për të dhënat e pasakta",
            "Sigurohemi që nuk është lejuar injektimi i skriptit HTML"
    })
    public void testimiMeInvalidData() throws InterruptedException {
        String htmlAlert="<script>alert('M4rdukwasH3re')</script>";
        driver.navigate().refresh();
        page.shtoSherbimin(htmlAlert,"Bashkia Maliq");
        page.ruajSherbimin();
        Assert.assertTrue(page.errorSherbimiTB(),"Nuk doli errori pra e ka injektuar skriptin html");
    }

    @AfterClass
    public void quit() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }
}
