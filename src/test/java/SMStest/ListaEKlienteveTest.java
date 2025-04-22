package SMStest;

import Globals.Globals;
import SMSpages.ListaEKlientevePage;
import SMSpages.LoginPage;
import Utilities.BaseInformation;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ListaEKlienteveTest {
    WebDriver driver;
    WebDriverWait wait;
    ListaEKlientevePage page;

    @BeforeClass
    public void setUp(){
        driver = BaseInformation.getDriver();
        page=  new ListaEKlientevePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Test
    public void navigoTeFaqjaEKlineteve(){
        driver.navigate().to(Globals.klientetUrl);
        wait.until(ExpectedConditions.urlToBe(Globals.klientetUrl));
        BaseInformation.waitUntilPageLoads();
    }
    @Test(priority = 2)
    public void shtoKlient() throws InterruptedException {
        Thread.sleep(1000);
        page.clickshtoButton();
        page.fillNipt("K"+Globals.generateRandom5DigitNumber()+"222J");
        page.fillEmri("Emritest");
        page.fillKodi("koditest"+Globals.generateRandom5DigitNumber());
        page.fillAdresa("testAdres");
        page.fillPershkrimi("testPershkrim");
        page.ruajButton();
    }

    @Test(priority = 3)
    public void editoKlientin() throws InterruptedException {
        Thread.sleep(2000);
        page.searchWithNipt(page.NIPT);
        Thread.sleep(1000);
        Assert.assertEquals(page.getNIPT(),page.NIPT);
        Assert.assertEquals(page.getKodi(),page.kodi);
        Assert.assertEquals(page.getAdresa(),page.Adresa);
        Assert.assertEquals(page.getEmri(),page.EmriSubjektit);
        Assert.assertEquals(page.getPershkrimi(),page.Pershkrimi);
        page.clickEditButton();
        page.fillNipt("K"+Globals.generateRandom5DigitNumber()+"222J");
        page.fillAdresa("ttttttttttttttttttttttttttt");
        page.ruajButton();



    }
    @Test(priority = 4)
    public void deleteKlientin() throws InterruptedException {
        page.searchWithNipt(page.NIPT);
        Thread.sleep(2000);
        page.clickDeleteButton();
        page.konfirmoFshirjen();
        Thread.sleep(2000);
        page.searchWithNipt(page.NIPT);
        Assert.assertTrue(page.nukUgjetenKliente(),"Nuk ishte fshire akoma");
    }

    @AfterClass
    public void quit(){
        driver.quit();
    }
}
