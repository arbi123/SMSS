package Pages;

import Elements.DitetPushimElements;
import Elements.NjesitKonfigElements;
import Utilities.BaseInformation;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class DitetPushimPage {
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));;
    DitetPushimElements page= new DitetPushimElements();
    Actions actions = new Actions(BaseInformation.getDriver());
    String Data;
    String EmeriFestes;

    public void okDeshtimiListes(){
        if(page.deshtimiListesOK.isDisplayed()){
        page.deshtimiListesOK.click();}
    }
    public void klikoShtoDiteFestash(){
        wait.until(ExpectedConditions.visibilityOf(page.shtoFestaButton));
        page.shtoFestaButton.click();
    }
    public boolean isShtimiFestaveTitleDispalyed(){
        wait.until(ExpectedConditions.visibilityOf(page.shtimiFestaveTitle));
        return  page.shtimiFestaveTitle.isDisplayed();
    }

    public void shtoFesta(String data, String emeriFestes){
        page.emeriFestes.clear();
        page.emeriFestes.sendKeys((emeriFestes));
        EmeriFestes=emeriFestes;
        page.dataEFestes.clear();

        page.dataEFestes.sendKeys(data);
        Data=data;
        actions.sendKeys(Keys.ENTER).perform();
        page.njeOseDisaSherbimeRB.click();

    }

    public String getEmeri(){
    return  page.emeriFestes.getAttribute("value");
    }

    public String getData(){
        return page.dataEFestes.getAttribute("value").replace("/",".");
    }
    public void anulloShtimin(){
        page.anulloShtimiFestave.click();
    }
}
