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

import java.time.Duration;

public class PerdoruesConfigTest {
    PerdoruesConfigPage page;
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new PerdoruesConfigPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void test() throws InterruptedException {
        driver.navigate().to(Globals.perdoruesConfigUrl);
        wait.until(ExpectedConditions.urlToBe(Globals.perdoruesConfigUrl));
          page.shtoPerorues();
          page.setEmail("arbi@gmail.com");
          page.setNID("A999999B");
          page.setDitelindja("22/05/2002");
          page.setEmer("ArTest");
          page.setMbimer("MbTEST");
          page.setAtesi("FATHtest");
          page.setNrTel("3333333");
          page.setPuna("Doktor");
          page.setAdresa("Tirane");
          page.setKoment("hello koment test");
          page.setCheckboxes(true,false);
          page.selectInstitucion("Bashkia Tiran");
          page.selectNjesia("Drejtoria");
          page.selectRolet("Administrator SHQD Kryesore");

          page.shtimiInstitucionit();
        Assert.assertTrue(page.isTableDisplayed(),"Nuk ka dale tabela e Institucionit mbas zgjedhjes se insititucionit dhe njesis dhe klikimit te + button");

        page.ruajPerdorues();
    }



    @AfterClass
    public void quit(){
//        driver.quit();

    }
}
