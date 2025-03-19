package Pages;

import Elements.SherbimiConfigElements;
import Utilities.BaseInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SherbimiConfigPage {
    SherbimiConfigElements page = new SherbimiConfigElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));;

    public void shtoSherbim(){
        wait.until(ExpectedConditions.elementToBeClickable(page.shtoSherbimButton));
        page.shtoSherbimButton.click();
    }
    p
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

}
