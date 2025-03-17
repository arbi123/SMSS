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
        return page.dshInstitucioniDD.getAttribute("title");
}
public void searchByValue(String value){
        wait.until(ExpectedConditions.elementToBeClickable(page.searchBox));
        page.searchBox.clear();
        page.searchBox.sendKeys(value);
        BaseInformation.waitUntilPageLoads();
}
public boolean isSuccessMessageDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(page.successAlert));
       return page.successAlert.isDisplayed();
}
public boolean isErrorDisplayed(){
        return page.errorAlert.isDisplayed();
}

public String getSherbimiTable() throws InterruptedException {
    Thread.sleep(500);
    wait.until(ExpectedConditions.visibilityOf(page.sherbimiTable1));
        return page.sherbimiTable1.getText();
}

public String getInstitucioniTable() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(page.insitucioniTable1));
        return page.insitucioniTable1.getText();
    }

    public void deleteSherbimi(){
        wait.until(ExpectedConditions.elementToBeClickable(page.deleteTable1));
        page.deleteTable1.click();
    }
    public void clickEditSherbimi(){
        wait.until(ExpectedConditions.elementToBeClickable(page.editTable1));
        page.editTable1.click();
    }
    public void editAndFill(String sherbimi,String institucioni){
        page.dshEmeriISherbimit.clear();
        page.dshEmeriISherbimit.sendKeys(sherbimi);
        Sherbimi=sherbimi;
        page.dshInstitucioniDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.listaInstitucioneve.get(0)));
        searchAndClick(institucioni);
        Institucioni=institucioni;
    }
    public void editAndFillSherbimi(String sherbimi){
        page.dshEmeriISherbimit.clear();
        page.dshEmeriISherbimit.sendKeys(sherbimi);
        Sherbimi=sherbimi;
    }
    public void editAndFillInstitucioni(String institucioni){
        wait.until(ExpectedConditions.visibilityOf(page.listaInstitucioneve.get(0)));
        searchAndClick(institucioni);
        Institucioni=institucioni;
    }

       public void clearInstitucioni(){
        wait.until(ExpectedConditions.elementToBeClickable(page.institucioniClearButton));
        page.institucioniClearButton.click();
       }
    public boolean errorSherbimiTB(){
        return page.sherbimiErrorTB.isDisplayed();
    }
    public boolean errorInstitucioniTB(){
        return page.institucionErrorTB.isDisplayed();
    }


}
