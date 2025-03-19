package PagesTest;

import Globals.Globals;
import Pages.DokumentesSHConfigPage;
import Pages.PerdoruesConfigPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PerdoruesConfigTest {
    PerdoruesConfigPage page;
    private WebDriver driver;
    WebDriverWait wait;
    SoftAssert softAssert;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new PerdoruesConfigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        softAssert = new SoftAssert();
    }
    @Test(priority = 1)
    @AssertInfo({
            "Navigojmë te faqja e konfigurimit të përdoruesve",
            "Sigurohemi që URL-ja e hapur është e saktë",
            "Shtojmë një përdorues të ri duke plotësuar të gjitha fushat e formularit",
            "Shtojmë institucionin për përdoruesin",
            "Konfirmojmë që tabela e institucioneve është shfaqur pas zgjedhjes së institucionit dhe njësisë",
            "Ruajmë përdoruesin e ri"
    })
    public void KrijimiPerdoruesiKonfig() throws InterruptedException {
        driver.navigate().to(Globals.perdoruesConfigUrl);
        wait.until(ExpectedConditions.urlToBe(Globals.perdoruesConfigUrl));
        page.shtoPerorues();
        page.fillForm("ArTest","A9992B","03/02/2002","ATest","Btest","atTESET","023121","DOC",
                  "TIRANA","KOMENT",true,false,"Bashkia Tiranë","Drejtoria e Pergjithshme te Taksave dhe Tarifave Vendore"
                    ,"Kordinator");
        page.shtimiInstitucionit();
        Assert.assertTrue(page.isTableDisplayed(),"Nuk ka dale tabela e Institucionit mbas zgjedhjes se insititucionit dhe njesis dhe klikimit te + button");
        page.ruajPerdorues();
    }


    @Test(priority = 2)
    @AssertInfo({
            "Kërkojmë përdoruesin duke përdorur email-in dhe emrin",
            "Verifikojmë që emri i plotë është i saktë në tabelë",
            "Konfirmojmë që email-i përputhet me të dhënat e pritura",
            "Sigurohemi që institucioni dhe njësia janë të sakta në tabelë",
            "Verifikojmë që NID dhe numri i telefonit përputhen me të dhënat e pritura",
            "Kontrollojmë që roli dhe data e krijimit janë të sakta",
            "Sigurohemi që gjendja inaktive është e saktë",
            "Kryejmë të gjitha verifikimet me soft assert"
    })
    public void searchAndVerifyTableData() throws InterruptedException {
    page.searchByEmailAndName();
        softAssert.assertTrue(page.getEmeriIPloteTable().contains(page.emer), "Emri nuk u gjet në tabelë!");
        softAssert.assertEquals(page.getEmailTable(), page.email, "Email-i nuk përputhet!");
        softAssert.assertTrue(page.getInsititucioniDheNjesiaTable().contains(page.institucion), "Institucioni nuk u gjet në tabelë!");
        softAssert.assertTrue(page.getInsititucioniDheNjesiaTable().contains(page.njesia), "Njësia nuk u gjet në tabelë!");
        softAssert.assertEquals(page.getNIDTable(), page.nid, "NID nuk përputhet!");
        softAssert.assertEquals(page.getNrTelefonTable(), page.nrTel, "Numri i telefonit nuk përputhet!");
        softAssert.assertEquals(page.getRoliTable(), page.rolet, "Roli nuk përputhet!");
        softAssert.assertEquals(page.getDataKrijimitTable(), page.getTodayDate(), "Data e krijimit nuk përputhet!");
        softAssert.assertEquals(page.getInaktiveCheckBoxTable(),page.inaktive,"Nuk jan te njejta checkBoxi Inaktiv");
    softAssert.assertAll();
    }

    @Test(priority = 3)
    @AssertInfo({
            "Klikojmë butonin për të edituar të dhënat e përdoruesit",
            "Modifikojmë të dhënat e formularit me vlera të reja",
            "Fshijmë institucionin ekzistues të përdoruesit",
            "Shtojmë një institucion të ri për përdoruesin",
            "Ruajmë ndryshimet e bëra"
    })
    public void editimiITeDhenave() throws InterruptedException {
    page.clickEditButton();
    page.editForm("EditTEST","MeditTEST","editedEmail@gmail.com","A44441B","952222","Bashkia Memaliaj","Qëndror",false,true,"Kryeinspektor");
    page.fshirjaInstitucionit();
    page.shtimiInstitucionit();
    page.ruajPerdorues();
    }
    @Test(priority = 4)
    @AssertInfo({
            "Kërkojmë përdoruesin sipas email-it dhe emrit",
            "Verifikojmë që emri në tabelë përputhet pas editimit",
            "Kontrollojmë përputhshmërinë e email-it pas editimit",
            "Verifikojmë që institucioni dhe njësia janë të sakta pas editimit",
            "Kontrollojmë përputhshmërinë e NID pas editimit",
            "Verifikojmë numrin e telefonit pas editimit",
            "Sigurohemi që roli i përdoruesit është i saktë pas editimit",
            "Konfirmojmë që data e krijimit nuk ka ndryshuar",
            "Kontrollojmë që statusi inaktiv është i njëjtë pas editimit",
            "Verifikojmë që data e fundit e modifikimit përputhet me datën e sotme"
    })
    public void searchAndVerifyEditedTableData() throws InterruptedException {
        page.searchByEmailAndName();
        softAssert.assertTrue(page.getEmeriIPloteTable().contains(page.emer), "Emri nuk u gjet në tabelë! Mbas editimi");
        softAssert.assertEquals(page.getEmailTable(), page.email, "Email-i nuk përputhet! Mbas editimi");
        softAssert.assertTrue(page.getInsititucioniDheNjesiaTable().contains(page.institucion), "Institucioni nuk u gjet në tabelë!Mbas editimi");
        softAssert.assertTrue(page.getInsititucioniDheNjesiaTable().contains(page.njesia), "Njësia nuk u gjet në tabelë!Mbas editimi");
        softAssert.assertEquals(page.getNIDTable(), page.nid, "NID nuk përputhet! Mbas editimi");
        softAssert.assertEquals(page.getNrTelefonTable(), page.nrTel, "Numri i telefonit nuk përputhet!Mbas editimi");
        softAssert.assertEquals(page.getRoliTable(), page.rolet, "Roli nuk përputhet! Mbas editimi");
        softAssert.assertEquals(page.getDataKrijimitTable(), page.getTodayDate(), "Data e krijimit nuk përputhet! Mbas editimi");
        softAssert.assertEquals(page.getInaktiveCheckBoxTable(),page.inaktive,"Nuk jan te njejta checkBoxi Inaktiv Mbas editimi");
        softAssert.assertEquals(page.getDataModifikimiFunditTable(),page.getTodayDate(),"Data modifikimit nuk eshte njelloj me sot");
        softAssert.assertAll();
    }
    @Test(priority = 5)
    @AssertInfo({
            "Kërkojmë përdoruesin sipas email-it dhe emrit",
            "Fshijmë përdoruesin dhe konfirmojmë fshirjen",
            "Rikërkojmë përdoruesin për të verifikuar që është fshirë",
            "Sigurohemi që nuk ka të dhëna me të njëjtin emër dhe email pas fshirjes"
    })
    public void deleteData() throws InterruptedException {
        page.searchByEmailAndName();
        page.fshiPerdorues();
        page.searchByEmailAndName();
        Assert.assertTrue(page.emptyDataTitleIsDisplayed(),"Ka akoma data me te njejtin emer dhe email");
    }

    @Test(priority = 0,dataProviderClass = DataProviders.PerdoruesConfigDataProvider.class,dataProvider = "formData")
    public void TESTEXCEL(String email, String nid, String ditelindja, String emer,
                          String mbimer, String atesi, String nrTel, String puna,
                          String adresa, String koment, boolean inaktive, boolean DKN,
                          String institucion, String njesia, String rolet) throws InterruptedException {

        driver.navigate().to(Globals.perdoruesConfigUrl);
        wait.until(ExpectedConditions.urlToBe(Globals.perdoruesConfigUrl));
        page.shtoPerorues();
        page.fillForm(email, nid, ditelindja, emer, mbimer, atesi, nrTel, puna, adresa, koment, inaktive, DKN, institucion, njesia, rolet);
        page.shtimiInstitucionit();
        Assert.assertTrue(page.isTableDisplayed(),"Nuk ka dale tabela e Institucionit mbas zgjedhjes se insititucionit dhe njesis dhe klikimit te + button");
        page.ruajPerdorues();

        page.searchByEmailAndName();
        page.fshiPerdorues();
        page.searchByEmailAndName();
        Assert.assertTrue(page.emptyDataTitleIsDisplayed(),"Ka akoma data me te njejtin emer dhe email");
        driver.navigate().refresh();

    }


    @AfterClass
    public void quit(){
       driver.close();
    }
}
