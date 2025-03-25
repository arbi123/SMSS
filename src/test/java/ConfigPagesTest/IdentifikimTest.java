package ConfigPagesTest;

import Globals.Globals;
import ConfigPages.IdentifikimPage;
import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IdentifikimTest {
    private  WebDriver driver;
    IdentifikimPage page;


    @BeforeClass
    public void setUp() {
        driver = BaseInformation.getDriver();
        page=new IdentifikimPage();
    }

    @Test
    public void login() throws InterruptedException {
        driver.get(Globals.loginUrl);
        page.validLogin();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(),Globals.homenUrl,"Nuk navigoi tek url e duhur: "+driver.getCurrentUrl());

    }

}
