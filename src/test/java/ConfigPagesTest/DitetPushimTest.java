package ConfigPagesTest;

import Globals.Globals;
import ConfigPages.DitetPushimPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class DitetPushimTest {

    DitetPushimPage page;
    private WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new DitetPushimPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Globals.DitetPushimUrl);
    }
    @Test(priority = 1)
    public void confirmButton(){
        page.okDeshtimiListes();

    }
    @Test(dataProviderClass = DataProviders.ExcelDataProvider.class, dataProvider = "festatData",priority = 2)
    public void shtoDitetEFestave(String date, String event){
        System.out.println("Data: " + date + " | Ngjarja: " + event);
    page.klikoShtoDiteFestash();
    Assert.assertTrue(page.isShtimiFestaveTitleDispalyed(),"Nuk ka dale titulli akoma");
    page.shtoFesta(date,event);
    Assert.assertEquals(page.getData(),date,"Datat nuk jane njelloj. Prisnim : "+date+" Ishte: "+page.getData());
    Assert.assertEquals(page.getEmeri(),event,"Festa nuk jane njelloj. Prisnim : "+event+" Ishte: "+page.getEmeri());
    page.anulloShtimin();
    }
    @AfterClass
    public void quit(){
        driver.close();
    }
}
