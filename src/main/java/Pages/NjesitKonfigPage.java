package Pages;

import Elements.NjesitKonfigElements;
import Utilities.BaseInformation;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NjesitKonfigPage {
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));;
    NjesitKonfigElements page= new NjesitKonfigElements();
    public String njesiEmeri;

    public void searchbyValue(String value){
        page.serachBox.click();
        page.serachBox.sendKeys(value);
    }
    public void klikoShtoNjesi(){
        page.shtoUnitButton.click();

    }
    public void shtoNjesi(String value,boolean inaktiv){
        njesiEmeri=value;
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

    public String getEditEmeri(){
        return page.emriUnitTB.getText();
    }
    public boolean isEditInaktivSelected(){
        return page.inaktivCB.isSelected();
    }
    public void deleteNjesi(String njesi){
        searchbyValue(njesi);
        page.deleteButton.click();
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
}
