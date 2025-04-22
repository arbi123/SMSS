package SMSpages;

import SMSelements.ListaEKlienteve;
import Utilities.BaseInformation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ListaEKlientevePage {
    ListaEKlienteve page= new ListaEKlienteve();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(20));
    Actions actions = new Actions(BaseInformation.getDriver());

    public String NIPT;
    public String kodi;
    public String EmriSubjektit;
    public String Adresa;
    public String Pershkrimi;

    public void clickshtoButton(){
        wait.until(ExpectedConditions.elementToBeClickable(page.shtoButton));
        page.shtoButton.click();
    }
    public void fillNipt(String sr){
        page.niptTB.clear();
        page.niptTB.sendKeys(sr);
        NIPT=sr;
    }
    public void fillKodi(String sc){
        page.kodiTB.clear();
        page.kodiTB.sendKeys(sc);
        kodi=sc;
    }
    public void fillEmri(String tr){
        page.emriTB.clear();
        page.emriTB.sendKeys(tr);
        EmriSubjektit=tr;
    }
    public void fillAdresa(String adresa){
        page.adressaTB.clear();
        page.adressaTB.sendKeys(adresa);
        Adresa=adresa;
    }
    public void fillPershkrimi(String sr){
        page.pershkrim.clear();
        page.pershkrim.sendKeys(sr);
        Pershkrimi=sr;
    }

    public void ruajButton(){
        wait.until(ExpectedConditions.elementToBeClickable(page.ruajButton));
        page.ruajButton.click();
    }
    public void searchWithNipt(String text){
        page.niptTableSB.sendKeys(text);
        actions.sendKeys(Keys.ENTER);
    }
    public void searchWithKodi(String kodi){
        page.kodiTableSB.sendKeys(kodi);
        page.kodiTableSB.sendKeys(Keys.ENTER);
    }
    public void searchWithEmri(String emri){
        page.emriTableSB.sendKeys(emri);
        page.emriTableSB.sendKeys(Keys.ENTER);
    }
    public void searhwithData(String data){
        page.dataTableSB.sendKeys(data);
        page.dataTableSB.sendKeys(Keys.ENTER);

    }
    public void searhwithAddress(String add){
        page.dataTableSB.sendKeys(add);
        page.dataTableSB.sendKeys(Keys.ENTER);

    }

    public String getNIPT(){
        return page.niptTextTABLE.getText();
    }
    public String getKodi(){
        return page.kodiTextTABLE.getText();
    }
    public String getAdresa(){
        return page.adresaTextTABLE.getText();
    }
    public String getEmri(){
        return page.emriTextTABLE.getText();
    }
    public String getPershkrimi(){
        return page.pershrkimiTextTABLE.getText();
    }
    public void clickEditButton(){
        page.editButton.click();
    }
    public void clickDeleteButton(){
        page.deleteButton.click();
        wait.until(ExpectedConditions.visibilityOf(page.poButton));
    }
    public void konfirmoFshirjen(){
        page.poButton.click();
    }
    public boolean nukUgjetenKliente(){
       return page.skaKliente.isDisplayed();
    }
}
