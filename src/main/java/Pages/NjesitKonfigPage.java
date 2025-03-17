package Pages;

import Elements.NjesitKonfigElements;
import Utilities.BaseInformation;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NjesitKonfigPage {
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));;
    NjesitKonfigElements page= new NjesitKonfigElements();
    public String njesiEmeri;
    public boolean inAktiv;

    public void searchbyValue(String value) throws InterruptedException {
        page.serachBox.click();
        page.serachBox.clear();
        page.serachBox.sendKeys(value);
        Thread.sleep(1500);
    }
    public void klikoShtoNjesi(){
        page.shtoUnitButton.click();

    }
    public void shtoNjesi(String value,boolean inaktiv){
        njesiEmeri=value;
        inAktiv=inaktiv;
        page.emriUnitTB.sendKeys(value);
    inaktivOseJo(inaktiv);
    page.ruajButton.click();
    }
    public void inaktivOseJo(boolean inaktiv){
        if(inaktiv){
            page.inaktivCB.click();
        }
    }
    public boolean isShtoNjesiTitleDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(page.shtoUnitTitle));
        return page.shtoUnitTitle.isDisplayed();
    }
    public void clickEditButton(){
        page.editButton.click();
    }
    public void editimNjesie(String njesiEmer,boolean inaktiv){
        page.emriUnitTB.clear();
        njesiEmeri=njesiEmer;
        inAktiv=inaktiv;
        page.emriUnitTB.sendKeys(njesiEmer);
        if(isEditInaktivSelected()==inaktiv){
            return;
        }else
            page.inaktivCB.click();

        page.ruajButton.click();

        BaseInformation.waitUntilPageLoads();
    }

    public String getEditEmeri(){
        return page.emriUnitTB.getAttribute("value");
    }
    public boolean isEditInaktivSelected(){
        return page.inaktivCB.isSelected();
    }
    public void deleteNjesi(String njesi) throws InterruptedException {
        searchbyValue(njesi);
        wait.until(ExpectedConditions.visibilityOf(page.deleteButton));
        page.deleteButton.click();
        wait.until(ExpectedConditions.visibilityOf(page.deleteConfirmButton));
        page.deleteConfirmButton.click();
    }
    public String getEmeriTable(){
        return page.emeriTable.getText();
    }
    public boolean isSuccesNotificationDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(page.succesNotification));
        return page.succesNotification.isDisplayed();
    }
    public boolean isErrorNotificationDisplayed(){
        return page.errorNotification.isDisplayed();
    }
    public boolean isEditTableDisplated(){
        wait.until(ExpectedConditions.visibilityOf(page.editTitle));

        return page.editTitle.isDisplayed();
    }
    public boolean isFshirjaTitleDisplayed(){
        return page.fshirjaTitle.isDisplayed();
    }
}
