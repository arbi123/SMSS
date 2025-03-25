package ConfigPages;

import ConfigPagesElements.InstitucionKonfigElements;
import Globals.Globals;
import Utilities.BaseInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static Globals.Globals.generateRandom5DigitNumber;


public class InstitucioniKofigPage {
    public String emeri;
    public String titull;
    public String pozicionTitull;
    public String institucioniPrind;
    public String kodiNrProtokolli;
    public boolean kryesore;
    public boolean inaktive;
    public boolean gjenerimTemplate;
    public String kodi;
    public String kokaShkr;
    public String fundiShkr;
    public String Njesia;

    WebDriverWait  wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));;

    InstitucionKonfigElements page= new InstitucionKonfigElements();

    public int getEditButtonsSize(){
        return page.editButtons.size();
    }
    public int getDeleteBtnsSize(){
        return page.deleteButtons.size();
    }

    public void clickFirstEditButton() {
        if (!page.editButtons.isEmpty()) {
            page.editButtons.get(0).click();
            wait.until(ExpectedConditions.visibilityOf(page.pageModifikoTitle));
        } else {
            System.out.println("No edit buttons found in the list.");
        }
    }

    public void sortingTest(String sr){
        Select select=new Select(page.shfaqSelect);//10,25,50,100
        select.selectByValue(sr);
    }
    public void searchByValue(String sr){
        page.searchBox.clear();
        page.searchBox.click();
        page.searchBox.sendKeys(sr);
    }
    public String getFirstName(){
        BaseInformation.waitUntilPageLoads();
       return page.getFirstNameText.getText().trim();
    }

    public void institucioniPrid(String institucioni){
        institucioniPrind=institucioni;
        page.institucioniPrindDD.click();
        Actions actions = new Actions(BaseInformation.getDriver());
        page.institucioniPrindDD.click();
        actions.sendKeys(institucioni).sendKeys(Keys.ENTER).perform();
    }
    public void njesiaSelect(String njesia){
        Njesia=njesia;
        Actions actions = new Actions(BaseInformation.getDriver());
        actions.moveToElement(page.njesiaDD).click().sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(njesia).sendKeys(Keys.ENTER).perform();

    }
    public void radioButtons(boolean first, boolean second, boolean third) {
        if (first) {

            page.kryesoreRB.click();
            kryesore=true;
        }
        if (second) {
           page.inAktiveRB.click();
           inaktive=true;
        }
        if (third) {
            page.gjenerimiTempRB.click();
            gjenerimTemplate=true;
        }
    }
    public void emertimiInstitucionit(String str){
        emeri=str;
        page.emertimiInstitucionitTB.clear();
        page.emertimiInstitucionitTB.sendKeys(str);

    }
    public void titullari(String str){
        titull=str;
        page.titullarTB.clear();
        page.titullarTB.sendKeys(str);

    }
    public void pozicionTitull(String str){
        pozicionTitull=str;
        page.pozicioniTitullaritTB.clear();
        page.pozicioniTitullaritTB.sendKeys(str);

    }
    public void nrPortokolli(String str){
        kodiNrProtokolli=str;
        page.nrProtokollitTB.sendKeys(str);
    }
    public void setKodi(String str){
        kodi=str;
        page.kodiTB.sendKeys(str);
    }
    public void setKokaShkr(String str){
        kokaShkr=str;
        page.kokaShkreses.sendKeys(str);
    }
    public void setFundiShkr(String str){
        fundiShkr=str;
        page.fundiShkreses.sendKeys(str);
    }
    public void shtoInstitucionButton(){
        page.shtoInstitucion.click();
        BaseInformation.waitForElementVisible(page.title);
    }
    public void shtoInstitucioninMeNjesi(String njesia) {
        shtoInstitucionButton();
        sendImg("C:\\Users\\Arbi.topi\\Downloads\\Folder\\photo.png");
        emertimiInstitucionit("test" + generateRandom5DigitNumber());
        setKodi("koditest");
        nrPortokolli("str");
        titullari("titull");
        pozicionTitull("pozicionTest");
        institucioniPrid("Agjencia e Kerkimit, Teknologjise dhe Inovacionit");
        radioButtons(true, false, false);
        setKokaShkr("test");
        setFundiShkr("testfund");
        njesiaSelect(njesia);  // Kjo është input nga metoda
        ruajShtiminEInstitucionit();
    }

    public void shtoInstitucionin(){
        shtoInstitucionButton();
        sendImg("C:\\Users\\Arbi.topi\\Downloads\\Folder\\photo.png");
        emertimiInstitucionit("EmeriInstitucionittest"+generateRandom5DigitNumber());
        setKodi("koditest");
        nrPortokolli("str");
        titullari("titull");
        pozicionTitull("pozicionTest");
        institucioniPrid("Agjencia e Kerkimit, Teknologjise dhe Inovacionit");
        radioButtons(true,false,false);
        setKokaShkr("test");
        setFundiShkr("testfund");
        njesiaSelect("Belsh");
        ruajShtiminEInstitucionit();
    }

    public void sendImg(String img){

        waitTillNotReloading();
        page.shtoImazh.sendKeys(img);
    }
    public void ruajShtiminEInstitucionit(){
    BaseInformation.waitUntilPageLoads();
    BaseInformation.waitUntilElementVisible(By.cssSelector("#savebuttonCreate"));
    page.ruajButton.click();
    }

    public boolean isFailMessageDisplayed() {
        try {
            // Wait for the fail message to be visible, if present
            WebElement failMessage = wait.until(ExpectedConditions.visibilityOf(page.failDiv));
            return failMessage.isDisplayed();  // Return true if it's displayed
        } catch (Exception e) {
            return false;  // Return false if not displayed
        }
    }

    public boolean isSuccesMessageDisplayed() {
        try {
            WebElement successDiv = wait.until(ExpectedConditions.visibilityOf(page.succesDiv));

            Thread.sleep(2000);

            return successDiv.isDisplayed();
        } catch (Exception e) {
            return false;  // Return false if the message is not visible
        }
    }
    public void getTexts(){

    }

    public void shtoInstitucionin(
            String imagePath, String emertimi, String kodi, String nrProtokollit,
            String titullar, String pozicioniTitullarit, String institucioni,
            boolean kryesore, boolean inaktive, boolean gjenerimT,
            String kokaShkreses, String fundiShkreses, String njesia) {
        emeri=emertimi;
        page.shtoInstitucion.click();
        BaseInformation.waitForElementVisible(page.title);

        sendImg(imagePath);
        page.emertimiInstitucionitTB.sendKeys(emertimi);
        page.kodiTB.sendKeys(kodi);
        page.nrProtokollitTB.sendKeys(nrProtokollit);
        page.titullarTB.sendKeys(titullar);
        page.pozicioniTitullaritTB.sendKeys(pozicioniTitullarit);

        institucioniPrid(institucioni);
        radioButtons(kryesore, inaktive, gjenerimT);

        page.kokaShkreses.sendKeys(kokaShkreses);
        page.fundiShkreses.sendKeys(fundiShkreses);

        njesiaSelect(njesia);

        ruajShtiminEInstitucionit();
    }
    public void waitTillNotReloading(){
        BaseInformation.waitUntilElementInvisible(By.cssSelector(".loader"));
        BaseInformation.waitUntilElementInvisible(By.cssSelector("#InstitutionsTable_processing"));
    }


    public void verifkimiTableData(){
        System.out.println(getTitullari()+" "+getPozicioniTitullarit()+" "+isCheckBoxInaktiveEnabled());
    }

    public String  getTitullari(){
            return page.titullariTableFirstData.getText().trim();
    }
    public String getPozicioniTitullarit(){
            return page.pozicioniTitullaritTableFirstData.getText().trim();
    }


    public String getEmeriMI(){
      return  page.emertimiInstitucionitTB.getAttribute("value");
    }

    public String getNrProtokollitMI(){
        return page.nrProtokollitTB.getAttribute("value");
    }
    public String getKodiMI(){
        return page.kodiTB.getAttribute("value");
    }
    public String getNrProtokolliMI(){
        return page.nrProtokollitTB.getAttribute("value");
    }
    public String getTitullariMI(){
        return page.titullarTB.getAttribute("value");
    }
    public String getPozicionTitullaritMI(){
        return page.pozicioniTitullaritTB.getAttribute("value");

    }
    public String getInstitucioniPrindMI(){
        return page.insitucioniPrindmi.getText();
    }
    public boolean isKryesoreRBCheckedMI() {
        return page.kryesoreRB.isSelected();  // Returns true if checked, false otherwise
    }

    public boolean isInAktiveRBChecked() {
        return  page.inAktiveRB.isSelected();  // Returns true if checked, false otherwise
    }

    public boolean isGenerateTemplateChecked() {
        return  page.gjenerimiTempRB.isSelected();  // Returns true if checked, false otherwise
    }
    public String kokaEShkresesMI() throws IOException, UnsupportedFlavorException {
        page.kokaShkresesMI.click();
        page.kokaShkresesMI.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        page.kokaShkresesMI.sendKeys(Keys.chord(Keys.CONTROL, "c"));
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);

    }
    public String fundiShkresesMI() throws IOException, UnsupportedFlavorException {
        page.fundiShkresesMI.click();
        page.fundiShkresesMI.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        page.fundiShkresesMI.sendKeys(Keys.chord(Keys.CONTROL, "c"));
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        return (String) clipboard.getData(DataFlavor.stringFlavor);
    }
    public void ruajButtoninMI(){
        page.ruajButtonMI.click();
        waitTillNotReloading();
    }




    public String njesiaMI(){
        Actions actions = new Actions(BaseInformation.getDriver());
        actions.moveToElement(page.njesiaBOX).sendKeys(Keys.PAGE_DOWN).perform();
        BaseInformation.waitUntilElementVisible(By.xpath("//ul[@class='select2-selection__rendered']//li[1]"));
        return page.njesiaMI.getAttribute("title");
    }

    public String emeri1;
    public String titullari1;
    public  String pozicionTitull1;
    public  boolean inaktive1;

    public void modifikimDheRuajtje(String emeri,String titullari,String pozicionTitull,boolean inaktive){
        emeri1=emeri;
        titullari1=titullari;
        pozicionTitull1=pozicionTitull;
        inaktive1=inaktive;
        emertimiInstitucionit(emeri);
        titullari(titullari);
        pozicionTitull(pozicionTitull);
        radioButtons(kryesore,inaktive1,gjenerimTemplate);
        ruajButtoninMI();
    }
    public void modifikimDheRuajtjeAuto() {
        // Krijimi i të dhënave brenda metodës
        String emeri = "Institucioni ABC"+ Globals.generateRandom5DigitNumber();
        String titullari = "Drejtori X";
        String pozicionTitull = "Menaxher";
        boolean inaktive = false;

        // Ruajtja e të dhënave në variabla
        emeri1 = emeri;
        titullari1 = titullari;
        pozicionTitull1 = pozicionTitull;
        inaktive1 = inaktive;

        // Thirrja e metodave me të dhënat e krijuara
        emertimiInstitucionit(emeri);
        titullari(titullari);
        pozicionTitull(pozicionTitull);
        radioButtons(kryesore, inaktive1, gjenerimTemplate);
        ruajButtoninMI();
        BaseInformation.waitUntilPageLoads();
        searchByValue(emeri);
    }
    public boolean isErrorDisplayed(){
        try {
            // Wait for the success message to be visible
            WebElement successDiv = wait.until(ExpectedConditions.visibilityOf(page.errorNotification));

            // Wait for 3 seconds (if needed for it to disappear)
            Thread.sleep(2000);

            // Return true if still displayed after 3 seconds, otherwise false
            return page.errorNotification.isDisplayed();
        } catch (Exception e) {
            return false;  // Return false if the message is not visible
        }
    }


    public boolean isCheckBoxInaktiveEnabled(){
        List<WebElement> checkboxes = page.checkboxes;

        if (!checkboxes.isEmpty()) {
            WebElement firstCheckbox = checkboxes.get(0);  // Get the first checkbox
            return firstCheckbox.isEnabled();  // Returns true if enabled, false if disabled
        } else {
            return false;  // Return false if no checkboxes found
        }

    }
    public void fshirjaEInstitucionit(){
    BaseInformation.waitUntilPageLoads();
    waitTillNotReloading();
    page.deleteButtons.getFirst().click();
    BaseInformation.waitUntilElementClickable(page.konfirmoDelete);
    page.konfirmoDelete.click();
          }

    public void downloadExcel(){
        BaseInformation.waitUntilElementClickable(page.excelButton);
        page.excelButton.click();

    }
    public boolean isDeleteSuccesDisplayed(){
        try {
            WebElement successDiv = wait.until(ExpectedConditions.visibilityOf(page.successDelete));

            // Wait for 3 seconds (if needed for it to disappear)
            Thread.sleep(2000);

            // Return true if still displayed after 3 seconds, otherwise false
            return page.successDelete.isDisplayed();
        } catch (Exception e) {
            return false;  // Return false if the message is not visible
        }
    }


}
