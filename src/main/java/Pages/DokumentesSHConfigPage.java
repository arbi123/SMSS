package Pages;

import Elements.DokumentesSHConfigElements;
import Elements.InstitucionKonfigElements;
import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DokumentesSHConfigPage {
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));;

    DokumentesSHConfigElements page= new DokumentesSHConfigElements();
    public String Sherbimi;
    public String Institucioni;
    public void shtoSherbimin(String sherbimi,String institucioni) throws InterruptedException { // supozohet te jet unique
        page.shtoServicButton.click();
        wait.until(ExpectedConditions.visibilityOf(page.dshtitulliShtimit));
        page.dshEmeriISherbimit.sendKeys(sherbimi);
        page.dshInstitucioniDD.click();
        Sherbimi=sherbimi;
        wait.until(ExpectedConditions.visibilityOf(page.listaInstitucioneve.get(0)));
        searchAndClick(institucioni);
        Institucioni=institucioni;
    }

    public void ruajSherbimin(){
        wait.until(ExpectedConditions.visibilityOf(page.ruajButton));
        page.ruajButton.click();
    }
    public void searchAndClick(String target){

        for (WebElement item : page.listaInstitucioneve) {
            if (item.getText().contains(target)) {
                item.click();
                break;
            }
    }
}
public String dshGetSherbimi(){
    return  page.dshEmeriISherbimit.getAttribute("value");
}
public String dshGetInstitucioni(){
        return page.dshInstitucioniDD.getAttribute("value");
}


}
