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
    public void test() throws InterruptedException {
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
    public void searchAndVerifyTableData() throws InterruptedException {

    page.searchByEmailAndName();
        softAssert.assertTrue(page.getEmeriIPloteTable().contains(page.emer), "Emri nuk u gjet në tabelë!");
        softAssert.assertEquals(page.getEmailTable(), page.email, "Email-i nuk përputhet!");
        softAssert.assertTrue(page.getInsititucioniDheNjesiaTable().contains(page.institucion), "Institucioni nuk u gjet në tabelë!");
        softAssert.assertTrue(page.getInsititucioniDheNjesiaTable().contains(page.njesia), "Njësia nuk u gjet në tabelë!");
        softAssert.assertEquals(page.getNIDTable(), page.nid, "NID nuk përputhet!");
      //  softAssert.assertEquals(page.getNrTelefonTable(), page.nrTel, "Numri i telefonit nuk përputhet!");
        softAssert.assertEquals(page.getRoliTable(), page.rolet, "Roli nuk përputhet!");
        softAssert.assertEquals(page.getDataKrijimitTable(), page.getTodayDate(), "Data e krijimit nuk përputhet!");
        softAssert.assertEquals(page.getInaktiveCheckBoxTable(),page.inaktive,"Nuk jan te njejta checkBoxi Inaktiv");
    softAssert.assertAll();
    }
    @Test(priority = 3)
    public void editimiITeDhenave() throws InterruptedException {
    page.clickEditButton();
    page.editForm("EditTEST","MeditTEST","editedEmail@gmail.com","A44441B","952222","Bashkia Memaliaj","Qëndror",false,true,"Kryeinspektor");
    page.fshirjaInstitucionit();
    page.shtimiInstitucionit();
    page.ruajPerdorues();
    }
    @Test(priority = 4)
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
        softAssert.assertAll();
    }
    @Test(priority = 5)
    public void deleteData() throws InterruptedException {
        page.fshiPerdorues();
        page.searchByEmailAndName();
        Assert.assertTrue(page.emptyDataTitleIsDisplayed(),"Ka akoma data me te njejtin emer dhe email");
    }



    @AfterClass
    public void quit(){
//        driver.quit();

    }
}
