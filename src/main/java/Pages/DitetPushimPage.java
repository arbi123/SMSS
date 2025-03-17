package Pages;

import Elements.DitetPushimElements;
import Elements.NjesitKonfigElements;
import Utilities.BaseInformation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DitetPushimPage {
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));;
    DitetPushimElements page= new DitetPushimElements();

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
        page.dataEFestes.clear();

        page.dataEFestes.sendKeys(data);

    }
    public void anulloShtimin(){
        page.anulloShtimiFestave.click();
    }
}
