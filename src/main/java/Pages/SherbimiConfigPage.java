package Pages;

import Elements.SherbimiConfigElements;
import Utilities.BaseInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SherbimiConfigPage {
    SherbimiConfigElements page = new SherbimiConfigElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));
    public String emeriSherbimit;
    public String Institucioni;
    public String KodiSherbimit;
    public String LlojiSherbimit;
    public String afatiPergjigjes;
    public String llojiAfatit;
    public boolean Inaktive;
    public boolean fshijeDSH;
    public boolean mendimdhenie;
    public boolean integrimMeWS;
    public boolean procesimSQDNE;
    public boolean PaMonitorim;
    public List<String> DokumentSH;



    public void shtoSherbim() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(page.shtoSherbimButton));
        Thread.sleep(500);
        page.shtoSherbimButton.click();
    }
    public void emeriSherbimit(String value){
        wait.until(ExpectedConditions.visibilityOf(page.sherbimiSS));
        page.sherbimiSS.clear();
        page.sherbimiSS.sendKeys(value);
        emeriSherbimit=value;
    }
    public void institucioniPick(String institucioni){
        for(WebElement item:page.institucioniOptionsSS){
            if (item.getText().contains(institucioni)) {
                Institucioni=institucioni;
                item.click();
                break;
            }
        }
    }


    public void klikoCheckBox() throws InterruptedException {
        Thread.sleep(1500);
        page.integrimWSCheckBoxSS.click();
    }
    public void shtimiIdokumentitMeSherbimDheInstitucion(String DSHerbimi, String institucioni) throws InterruptedException {
        String xpath = "//tr[td[2][normalize-space(text())='" + DSHerbimi + "'] " +
                "and td[3][normalize-space(text())='" + institucioni + "']]//span[@title='Selekto']";
        WebElement spanButton = BaseInformation.getDriver().findElement(By.xpath(xpath));
        Thread.sleep(1500);
        spanButton.click();
        DokumentSH.add(DSHerbimi);
    }
    public void searchDSH(String value){
        wait.until(ExpectedConditions.elementToBeClickable(page.dokumenteSHsearchBoxSS));
        page.dokumenteSHsearchBoxSS.click();
        page.dokumenteSHsearchBoxSS.clear();
        page.dokumenteSHsearchBoxSS.sendKeys(value);

    }
    public void kodiSherbimit(String value){
        wait.until(ExpectedConditions.visibilityOf(page.kodiSherbimitSS));
        page.kodiSherbimitSS.clear();
        page.kodiSherbimitSS.sendKeys(value);
        KodiSherbimit=value;
    }
        public void llojiISherbimit(String value) throws InterruptedException {
            Thread.sleep(2000);
            Select select = new Select(page.selectLLojiSherbimitSS);
        select.selectByVisibleText(value);
        LlojiSherbimit=value;

        }
    public void llojiIAfatit(String value) throws InterruptedException {
        Thread.sleep(2000);
        Select select= new Select(page.selectLlojiAfatitSS);
        select.selectByVisibleText(value);
        llojiAfatit=value;
    }
    public void setAllCheckboxes(boolean wsIntegration, boolean mendimDhenie, boolean inaktive, boolean canDelete, boolean procesim, boolean paMonitorim) throws InterruptedException {
        Thread.sleep(1500);
        setCheckBoxState(page.integrimWSCheckBoxSS, wsIntegration);
        setCheckBoxState(page.mendimDhenieCheckBoxSS, mendimDhenie);
        setCheckBoxState(page.inaktiveCheckBoxSS, inaktive);
        setCheckBoxState(page.canDeleteCheckBoxSS, canDelete);
        setCheckBoxState(page.procesimCheckBoxSS, procesim);
        setCheckBoxState(page.paMonitorimCheckBoxSS, paMonitorim);
        integrimMeWS=wsIntegration;
        mendimdhenie=mendimDhenie;
        Inaktive=inaktive;
        fshijeDSH=canDelete;
        procesimSQDNE=procesim;
        PaMonitorim = paMonitorim;
    }
    public void setInaktiveAndCanDelete(boolean inaktive, boolean canDelete) {
        setCheckBoxState(page.inaktiveCheckBoxSS, inaktive);
        setCheckBoxState(page.canDeleteCheckBoxSS, canDelete);
        Inaktive=inaktive;
        fshijeDSH=canDelete;
    }
    public void sherbimMeProcesim(String afati,String llojiAfatit){
        wait.until(ExpectedConditions.visibilityOf(page.afatiPergjigjesSS));
        page.afatiPergjigjesSS.clear();
        page.afatiPergjigjesSS.sendKeys(afati);
        Select select = new Select(page.selectLlojiAfatitSS);
        select.selectByValue(llojiAfatit);
    }
    public void afatiPergjigjes(String value){
        wait.until(ExpectedConditions.visibilityOf(page.afatiPergjigjesSS));
        page.afatiPergjigjesSS.clear();
        page.afatiPergjigjesSS.sendKeys(value);
        afatiPergjigjes=value;
    }
    public void sherbimiFill(String llojiSherbimit,String afatiPergjigjes,String llojiAfatit,boolean wsIntegration, boolean mendimDhenie, boolean inaktive, boolean canDelete, boolean procesim, boolean paMonitorim) throws InterruptedException {
        llojiISherbimit(llojiSherbimit);

        if(llojiSherbimit.contains("Shërbim me proçesim")){
            afatiPergjigjes(afatiPergjigjes);
            llojiIAfatit(llojiAfatit);
            setAllCheckboxes(wsIntegration,mendimDhenie,inaktive,canDelete,procesim,paMonitorim);
        }
    }

    public void sherbimiFill(String llojiSherbimit,boolean inaktive,boolean mundTeFshije) throws InterruptedException {
        llojiISherbimit(llojiSherbimit);
        setInaktiveAndCanDelete(inaktive,mundTeFshije);
    }


    public void setCheckBoxState(WebElement spanElement, boolean desiredState) {
        WebElement inputElement = spanElement.findElement(By.xpath("./preceding-sibling::input"));
        boolean currentlySelected = inputElement.isSelected();

        if (currentlySelected != desiredState) {
            spanElement.click();
        }
    }
    public void ruajButton(){
        wait.until(ExpectedConditions.elementToBeClickable(page.ruajButton));
        page.ruajButton.click();
    }
    public void fillShtoSherbimin(String sherbimi,String institucioni,String kodiSherbimit,String llojiSherbimit
    ,boolean wsIntegration, boolean mendimDhenie, boolean inaktive, boolean canDelete, boolean procesim, boolean paMonitorim
    ,String afatiPergjigjes,String llojiAfatit){
        emeriSherbimit(sherbimi);
        institucioniPick(institucioni);
        kodiSherbimit(kodiSherbimit);

    }
    public boolean areProcesimElementsDisplayed(){
        return page.afatiPergjigjesSS.isDisplayed()
                &&  page.selectLlojiAfatitSS.isDisplayed()
                &&  page.mendimDhenieCheckBoxSS.isDisplayed()
                &&  page.integrimWSCheckBoxSS.isDisplayed()
                &&  page.procesimCheckBoxSS.isDisplayed()
                &&  page.paMonitorimCheckBoxSS.isDisplayed();
    }

}
