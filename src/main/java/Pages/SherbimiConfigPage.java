package Pages;

import Elements.SherbimiConfigElements;
import Utilities.BaseInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
// kemi marre per baze vetem 1 dokument shoqerues
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
    public List<String> DokumentSH=new ArrayList<String>();
    public String llojiSherbimitTable;


    public void searchByFiltrat(String institucioni,String llojiSherbimit,String kodiSherbimit) throws InterruptedException {
    searchInstitucioni(institucioni);
    Thread.sleep(1500);
    searchLlojiSHerbimit(llojiSherbimit);
    searchByKodiSherbimit(kodiSherbimit);

    }
    public void searchInstitucioni(String value){
        wait.until(ExpectedConditions.visibilityOf(page.institucioniDDFilter));
        page.institucioniDDFilter.click();
        for(WebElement item: page.institucionDDFilter){
            String textItem = item.getText();
            if(textItem.contains(value)){
                item.click();
                break;
            }
        }
    }
    public void searchByKodiSherbimit(String value){
        wait.until(ExpectedConditions.visibilityOf(page.kodiSherbimitFilter));
        page.kodiSherbimitFilter.clear();
        page.kodiSherbimitFilter.sendKeys(value);
        Actions actions = new Actions(BaseInformation.getDriver());
        actions.sendKeys(Keys.ENTER).perform();
    }
    public void searchLlojiSHerbimit(String value) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(page.llojiSherbimitFilter));
        page.llojiSherbimitFilter.clear();
        page.llojiSherbimitFilter.click();
        Thread.sleep(2000);
        for(WebElement item: page.llojiSherbimitFilterOptions){
            String textItem= item.getText();
            if(textItem.contains(value)){
                item.click();
                break;
            }
        }
        Thread.sleep(1500);
    }
    public void sortTable(){
        wait.until(ExpectedConditions.elementToBeClickable(page.sortFromTheNewest));
        page.sortFromTheNewest.click();
    }

    public void waitForModalTitle() {
        wait.until(ExpectedConditions.visibilityOf(page.shtoSherbimTitle));
    }
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
    public void institucioniPick(String institucioni) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(page.instiucioniSSbutton));
        page.instiucioniSSbutton.click();
        Thread.sleep(1000);

        for(WebElement item:page.institucioniOptionsSS){
            String textItem= item.getText();
            if (textItem.contains(institucioni)) {
                Institucioni=institucioni;
                item.click();
                break;
            }
        }
    }


    public void shtimiIdokumentitMeSherbimDheInstitucion(String DSHerbimi, String institucioni) throws InterruptedException {
        String xpath = "//tr[td[2][normalize-space(text())='" + DSHerbimi + "'] " +
                "and td[3][normalize-space(text())='" + institucioni + "']]//span[@title='Selekto']";
        WebElement spanButton = BaseInformation.getDriver().findElement(By.xpath(xpath));
        Thread.sleep(1500);
        spanButton.click();

        DokumentSH.add(DSHerbimi);
    }
    public void searchDSH(String value) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(page.dokumenteSHsearchBoxSS));
        page.dokumenteSHsearchBoxSS.click();
        page.dokumenteSHsearchBoxSS.clear();
        page.dokumenteSHsearchBoxSS.sendKeys(value);
        Thread.sleep(1500);

    }
    public void searchAndClickDokumentSH(String searchSherbimi,String sherbimi,String institucioni) throws InterruptedException {
        searchDSH(searchSherbimi);
        shtimiIdokumentitMeSherbimDheInstitucion(sherbimi,institucioni);
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
    public void ruajSherbimin(){
        wait.until(ExpectedConditions.elementToBeClickable(page.ruajButton));
        page.ruajButton.click();
    }
    public void fillShtoSherbimin(String sherbimi,String institucioni,String kodiSherbimit) throws InterruptedException {
        emeriSherbimit(sherbimi);
        institucioniPick(institucioni);
        kodiSherbimit(kodiSherbimit);
        mendimdhenie=false;
        procesimSQDNE=false;
        integrimMeWS=false;
        PaMonitorim=false;
    }
    public int dokumenteSHsize(){
        return page.dokumentetEzgjedhura.size();
    }
    public boolean areInaktiveandDeletedDisplayed(){
        return page.inaktiveCheckBoxSS.isDisplayed()&&page.canDeleteCheckBoxSS.isDisplayed();
    }
    public String getTableSherbimiName(){
        wait.until(ExpectedConditions.visibilityOf(page.tableSherbimi1));
       return page.tableSherbimi1.getText();
    }
    public String getInstitucioniTable(){
        return page.tableInstitucioni1.getText();
    }
    public String getLlojiSherbimitTable(){
        return page.tableLlojiSherbimit.getText();
    }
    public String getTableKodiSherbimi(){
        return page.tableKodi1.getText();
    }
    public boolean getInaktiveTable(){
        return page.tableInaktive.isSelected();
    }
    public boolean getProcesimTable(){
        return page.tableProcesimSQDNE.isSelected();
    }
    public boolean getIntegrimiWSTable(){
        return page.tableIntergrimWS.isSelected();
    }
    public boolean getMendimdhenieTable(){
        return page.tableMendimDhenie.isSelected();
    }

    public boolean areAllDocSHTextsContained() throws InterruptedException {
        List<String> actualTexts = new ArrayList<>();

        for (WebElement element : page.docSHtextetEzgjedhura) {
            actualTexts.add(element.getText().trim());
        }

        return new HashSet<>(DokumentSH).containsAll(actualTexts);
    }
    public boolean areProcesimElementsDisplayed(){
        return page.afatiPergjigjesSS.isDisplayed()
                &&  page.selectLlojiAfatitSS.isDisplayed()
                &&  page.mendimDhenieCheckBoxSS.isDisplayed()
                &&  page.integrimWSCheckBoxSS.isDisplayed()
                &&  page.procesimCheckBoxSS.isDisplayed()
                &&  page.paMonitorimCheckBoxSS.isDisplayed();
    }

    public void waitForModifikoSherbiminTitle() {
        wait.until(ExpectedConditions.visibilityOf(page.modifikoTitle));
    }
    public void editButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(page.editTableButton));
        wait.until(ExpectedConditions.elementToBeClickable(page.editTableButton));
        page.editTableButton.click();
        waitForModifikoSherbiminTitle();
        Thread.sleep(2000);
    }
    public String getEmeriSherbimitMS(){
        return page.sherbimiSS.getAttribute("value");
    }
    public String getInstitucioniMS() {
        String text = page.instiucioniSSbutton.getText();
        return text.replaceAll("[^\\p{L}\\p{N}\\s]", "").trim();
    }
    public String getKodiSherbimitMS(){
        return page.kodiSherbimitSS.getAttribute("value");
    }
    public String getLlojiSherbimitMS(){
        Select select = new Select(page.selectLLojiSherbimitSS);
        return select.getFirstSelectedOption().getText();
    }
    public boolean getInaktiveMS(){
    return  page.inaktiveCheckBoxMS.isSelected();
    }
    public boolean getFshijeDSHMS() {
        return page.canDeleteCheckBoxMS.isSelected();
    }
    public String getAfatiPergjigjesMS(){
        return page.afatiPergjigjesSS.getAttribute("value");
    }
    public String getLlojiAfatitMS(){
        Select select = new Select(page.selectLlojiAfatitSS);
        return select.getFirstSelectedOption().getText();
    }
    public boolean getMendimdhenieMS(){
        return page.mendimDhenieCheckBoxMS.isSelected();
    }
    public boolean getIntegrimWSMS(){
        return page.integrimWSCheckBoxMS.isSelected();
    }
    public boolean getProcesimSQDNEMS(){
        return page.procesimCheckBoxMS.isSelected();
    }
    public boolean getPaMonitorimMS(){
        return page.paMonitorimCheckBoxMS.isSelected();
    }
    public void searchTableEmerSherbimi(String value) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(page.searchBox));
        wait.until(ExpectedConditions.visibilityOf(page.searchBox));
        Thread.sleep(1500);
        page.searchBox.clear();
        page.searchBox.sendKeys(value);
        Thread.sleep(1500);
    }
    public void fshirjaESherbimit(){
        wait.until(ExpectedConditions.elementToBeClickable(page.deleteTableButton));
        page.deleteTableButton.click();
        wait.until(ExpectedConditions.visibilityOf(page.deleteTitle));
        wait.until(ExpectedConditions.elementToBeClickable(page.confirmDeleteTableButton));
        page.confirmDeleteTableButton.click();
    }
    public String getLLojiSherbimitFilter(){
        return page.llojiSherbimitText.getText().replaceAll("[^\\p{L}\\p{N}\\s]", "").trim();
    }
    public List<String> llojiElements(){
        List<String> llojetTable = new ArrayList<>();
        for(WebElement item: page.llojiSherbimitElements){
            String text = item.getText().replaceAll("[^\\p{L}\\p{N}\\s]", "").trim();
            llojetTable.add(text);
        }
        return llojetTable;
    }
    public boolean isThereAnyData(){
        return page.llojiSherbimitElements.isEmpty();
    }


    //dhe cekimi i Doc SH perdorim te njejten metod
}
