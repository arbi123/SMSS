package Pages;

import Elements.DitetPushimElements;
import Elements.PerdoruesConfigElements;
import Utilities.BaseInformation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PerdoruesConfigPage {
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));;
    PerdoruesConfigElements page= new PerdoruesConfigElements();
    Actions actions = new Actions(BaseInformation.getDriver());
    public void shtoPerorues(){
        wait.until(ExpectedConditions.elementToBeClickable(page.addUserConfigButton));
        page.addUserConfigButton.click();
    }
    public String email;
    public String nid;
    public String ditelindja;
    public String emer;
    public String mbimer;
    public String atesi;
    public String nrTel;
    public String puna;
    public String adresa;
    public String koment;
    public boolean inaktive;
    public boolean DKN;
    public String institucion;
    public String njesia;
    public String rolet;



    public void setEmail(String value){
        wait.until(ExpectedConditions.elementToBeClickable(page.emailiUC));
        page.emailiUC.clear();
        page.emailiUC.sendKeys(value);
    }
    public void setNID(String value){
        page.NID_UC.clear();
        page.NID_UC.sendKeys(value);
    }
    public void setDitelindja(String data){
        page.dataUC.click();
        page.dataUC.clear();
        page.dataUC.sendKeys(data); // 22/02/2023
        actions.sendKeys(Keys.ENTER).perform();
    }
    public void setEmer(String value){
        page.emeriUC.clear();
        page.emeriUC.sendKeys(value);
    }
    public void setMbimer(String value){
        page.mbiemerUC.clear();
        page.mbiemerUC.sendKeys(value);
    }
    public void setAtesi(String value){
        page.atesiUC.clear();
        page.atesiUC.sendKeys(value);
    }
    public void setNrTel(String value){
        page.nrTelUC.clear();
        page.nrTelUC.sendKeys(value);
    }
    public void setPuna(String value){
        page.pozicioniPunesUC.clear();
        page.pozicioniPunesUC.sendKeys(value);
    }
    public void setAdresa(String value){
        page.adresaUC.clear();
        page.adresaUC.sendKeys(value);
    }
    public void setKoment(String value){
        page.komentUC.clear();
        page.komentUC.sendKeys(value);
    }
    public void setCheckboxes(boolean inaktive,boolean DKN){
        if(inaktive){
            if(!page.inaktiveUC.isSelected()){
                page.inaktiveUC.click();
            }

        }
        if(!inaktive){
            if(page.inaktiveUC.isSelected())
            {page.inaktiveUC.click();
            }}
        if(DKN){
            if(!page.dergonKerkeseUC.isSelected()){
                page.dergonKerkeseUC.click();
            }
        }
        if(!DKN){
            if(page.dergonKerkeseUC.isSelected()){
                page.dergonKerkeseUC.click();
            }
        }
    }
    public void  selectInstitucion(String value){
        wait.until(ExpectedConditions.visibilityOf(page.institucioniUC));
        actions.scrollToElement(page.institucioniUC).perform();

        page.institucioniUC.click();
        wait.until(ExpectedConditions.visibilityOf(page.options.getFirst()));
        for(WebElement in : page.options){
            String text = in.getText();
            if(text.contains(value)){
                in.click();
                break;
            }

        }
    }
    public void selectNjesia(String value) throws InterruptedException {
        Thread.sleep(500);
        wait.until(ExpectedConditions.elementToBeClickable(page.njesiaUC));
        page.njesiaUC.click();
        for(WebElement in : page.options){
            String text = in.getText();
            if(text.contains(value)){
                in.click();
                break;
            }
        }
    }
    public void shtimiInstitucionit(){
        page.shtoInstitucion.click();
    }

    public boolean isTableDisplayed(){
        return page.tableUC.isDisplayed()&&page.fshiInstitucionUC.getFirst().isDisplayed();
    }

    public void selectRolet(String value) throws InterruptedException {
        Thread.sleep(500);
        page.rolet.getFirst().click();
        for(WebElement in : page.options){
            String text = in.getText();
            if(text.contains(value)){
                in.click();
                break;
            }
        }
    }
    public void ruajPerdorues(){
        page.ruajPerdorues.click();
    }

    public void fillForm(String email,
                         String nid,
                         String ditelindja,
                         String emer,
                         String mbimer,
                         String atesi,
                         String nrTel,
                         String puna,
                         String adresa,
                         String koment,
                         boolean inaktive,
                         boolean DKN,
                         String institucion,
                         String njesia,
                         String rolet) throws InterruptedException {
        this.email = email;
        this.nid = nid;
        this.ditelindja = ditelindja;
        this.emer = emer;
        this.mbimer = mbimer;
        this.atesi = atesi;
        this.nrTel = nrTel;
        this.puna = puna;
        this.adresa = adresa;
        this.koment = koment;
        this.inaktive = inaktive;
        this.DKN = DKN;
        this.institucion = institucion;
        this.njesia = njesia;
        this.rolet = rolet;

        setEmail(email);
        setNID(nid);
        setDitelindja(ditelindja);
        setEmer(emer);
        setMbimer(mbimer);
        setAtesi(atesi);
        setNrTel(nrTel);
        setPuna(puna);
        setAdresa(adresa);
        setKoment(koment);
        setCheckboxes(inaktive, DKN);
        selectInstitucion(institucion);
        selectNjesia(njesia);
        selectRolet(rolet);
    }

}
