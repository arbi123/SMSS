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

public class SherbimiConfigPage {
    SherbimiConfigElements page = new SherbimiConfigElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));;

    public void shtoSherbim() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(page.shtoSherbimButton));
        Thread.sleep(500);
        page.shtoSherbimButton.click();
    }
    public void emeriSherbimit(){
        wait.until(ExpectedConditions.visibilityOf(page.sherbimiSS));
        page.sherbimiSS.clear();
        page.sherbimiSS.sendKeys("");
    }
    public void institucioniPick(String institucioni){
        for(WebElement item:page.institucioniOptionsSS){
            if (item.getText().contains(institucioni)) {
                item.click();
                break;
            }
        }
    }


    public void klikoCheckBox() throws InterruptedException {
        Thread.sleep(1500);
        page.integrimWSCheckBoxSS.click();
    }
    public void shtimiIdokumentitMeSherbimDheInstitucion(String expectedTd2, String expectedTd3) throws InterruptedException {
        String xpath = "//tr[td[2][normalize-space(text())='" + expectedTd2 + "'] " +
                "and td[3][normalize-space(text())='" + expectedTd3 + "']]//span[@title='Selekto']";
        WebElement spanButton = BaseInformation.getDriver().findElement(By.xpath(xpath));
        Thread.sleep(1500);
        spanButton.click();
    }
    public void kodiSherbimit(){
        wait.until(ExpectedConditions.visibilityOf(page.kodiSherbimitSS));
        page.kodiSherbimitSS.clear();
        page.kodiSherbimitSS.sendKeys("");
    }
        public void llojiISherbimit(String value){
        Select select = new Select(page.selectLLojiSherbimitSS);
        select.selectByValue(value);
    }
    public void setAllCheckboxes(boolean wsIntegration, boolean mendimDhenie, boolean inaktive, boolean canDelete, boolean procesim, boolean paMonitorim) throws InterruptedException {
        Thread.sleep(1500);
        setCheckBoxState(page.integrimWSCheckBoxSS, wsIntegration);
        setCheckBoxState(page.mendimDhenieCheckBoxSS, mendimDhenie);
        setCheckBoxState(page.inaktiveCheckBoxSS, inaktive);
        setCheckBoxState(page.canDeleteCheckBoxSS, canDelete);
        setCheckBoxState(page.procesimCheckBoxSS, procesim);
        setCheckBoxState(page.paMonitorimCheckBoxSS, paMonitorim);
    }
    public void setInaktiveAndCanDelete(boolean inaktive, boolean canDelete) {
        setCheckBoxState(page.inaktiveCheckBoxSS, inaktive);
        setCheckBoxState(page.canDeleteCheckBoxSS, canDelete);
    }
    public void sherbimMeProcesim(String afati,String llojiAfatit){
        wait.until(ExpectedConditions.visibilityOf(page.afatiPergjigjesSS));
        page.afatiPergjigjesSS.clear();
        page.afatiPergjigjesSS.sendKeys(afati);
        Select select = new Select(page.selectLlojiAfatitSS);
        select.selectByValue(llojiAfatit);

    }
    private void setCheckBoxState(WebElement spanElement, boolean desiredState) {
        // From the <span>, locate the preceding sibling <input> to check its actual 'selected' state.
        WebElement inputElement = spanElement.findElement(By.xpath("./preceding-sibling::input"));
        boolean currentlySelected = inputElement.isSelected();

        // If the current state doesn't match the desired state, click the <span> to toggle.
        if (currentlySelected != desiredState) {
            spanElement.click();
        }
    }
}
