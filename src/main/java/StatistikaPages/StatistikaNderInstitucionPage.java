package StatistikaPages;

import StatistikaPagesElements.StatistikaNderInstitucionElements;
import Utilities.BaseInformation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StatistikaNderInstitucionPage {
    StatistikaNderInstitucionElements page = new StatistikaNderInstitucionElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(100));
    Actions actions = new Actions(BaseInformation.getDriver());
    public void waitUntilNoTableReaload(){
        wait.until(ExpectedConditions.invisibilityOf(page.loader));
        wait.until(ExpectedConditions.invisibilityOf(page.divLoader));
        wait.until(ExpectedConditions.invisibilityOf(page.loaderTable));
    }
    public void selektoDaten(String dataFillimit,String dataMbarimit) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(page.nisjaEdatesTB));
        page.nisjaEdatesTB.clear();
        page.nisjaEdatesTB.click();
        page.nisjaEdatesTB.sendKeys(dataFillimit);
        page.fundiEdatesTB.clear();
        page.fundiEdatesTB.click();
        page.fundiEdatesTB.sendKeys(dataMbarimit);
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        waitUntilNoTableReaload();
    }
    public void selectMinistriaDerguese(String value){
        actions.sendKeys(Keys.TAB).perform();
        wait.until(ExpectedConditions.elementToBeClickable(page.ministriaDergueseDD));
        page.ministriaDergueseDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.minsitriaOptions.get(0)));
        for(WebElement item: page.minsitriaOptions){
            String Text = item.getText();
            if(Text.contains(value)){
                item.click();
                break;
            }
        }
        waitUntilNoTableReaload();
    }
    public void selectInstitucioniDergues(String value){
        actions.sendKeys(Keys.TAB).perform();
        wait.until(ExpectedConditions.elementToBeClickable(page.institucionetDergueseDD));
        page.institucionetDergueseDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.institucionetDergueseOptions.get(0)));
        for(WebElement item: page.institucionetDergueseOptions){
            String Text = item.getText();
            if(Text.contains(value)){
                item.click();
                break;
            }
        }
        waitUntilNoTableReaload();
    }
    public void selectMinistriaPritese(String value){
        actions.sendKeys(Keys.TAB).perform();
        wait.until(ExpectedConditions.elementToBeClickable(page.ministriaPriteseDD));
        page.ministriaPriteseDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.minsitriaOptions.get(0)));
        for(WebElement item: page.minsitriaOptions){
            String Text = item.getText();
            if(Text.contains(value)){
                item.click();
                break;
            }
        }
        waitUntilNoTableReaload();
    }
    public void selectInstitucionePritese(String value){
        actions.sendKeys(Keys.TAB).perform();
        wait.until(ExpectedConditions.elementToBeClickable(page.institucionetPriteseDD));
        page.institucionetPriteseDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.institucionetDergueseOptions.get(0)));
        for(WebElement item: page.institucionetDergueseOptions){
            String Text = item.getText();
            if(Text.contains(value)){
                item.click();
                break;
            }
        }
        waitUntilNoTableReaload();
    }
    public void selectKthimPergjigje(String value){
        actions.scrollByAmount(0,100);
        actions.sendKeys(Keys.TAB).perform();
        wait.until(ExpectedConditions.elementToBeClickable(page.selectKthimPergjigje));
        page.selectKthimPergjigje.click();
        wait.until(ExpectedConditions.visibilityOf(page.kthimPergjigjeOptions.get(0)));
        for(WebElement item: page.kthimPergjigjeOptions){
            String Text = item.getText();
            if(Text.contains(value)){
                item.click();
                break;
            }
        }
        waitUntilNoTableReaload();
    }

    public void shfaqeTeDhena(String value){
        Select select =new Select(page.shfaqTableData);
        select.selectByValue(value);
        waitUntilNoTableReaload();
    }

    public void selektoBrendaAfatit(){
        page.brendaAfatitRB.click();
    }
    public void selektoJashtAfatit(){
        page.jashtAfatitRB.click();
    }
    public void pastroFiltrat(){
        wait.until(ExpectedConditions.elementToBeClickable(page.pastroFiltratButton));
        page.pastroFiltratButton.click();
    }
    public void nrKerkeses(String value) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(page.nrIAplikimit));
        page.nrIAplikimit.clear();
        page.nrIAplikimit.sendKeys(value);
        actions.sendKeys(Keys.ENTER).perform();
        wait.until(ExpectedConditions.textToBe(By.xpath("//tbody/tr/td[2]"),"SQDNE280220250036"));
        Thread.sleep(2000);
    }
    public List<String> institucioniDergues(){
        List<String> listText = new ArrayList<>();
        for(WebElement in: page.InstitucioniDerguesTableC){
            String text = in.getText();
            listText.add(text);
        }
        return listText;
    }
    public String strongInstitucionDergusText(){
        actions.sendKeys(Keys.TAB).perform();
        wait.until(ExpectedConditions.elementToBeClickable(page.institucionetDergueseDD));
        page.institucionetDergueseDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.institucionOptionsStrong));
        return page.institucionOptionsStrong.getText();
    }
    public String strongInstitucionPritesText(){
        actions.sendKeys(Keys.TAB).perform();
        wait.until(ExpectedConditions.elementToBeClickable(page.institucionetPriteseDD));
        page.institucionetPriteseDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.institucionOptionsStrong));
        return page.institucionOptionsStrong.getText();
    }
    public List<String> statusi(){
        List<String> listText = new ArrayList<>();
        for(WebElement in: page.statusiTableC){
            String text = in.getText();
            listText.add(text);
        }
        return listText;
    }

    public List<String> getAllDataKerkesesNderInstit(){
        List<String> listText = new ArrayList<>();
        for(WebElement in: page.dataKerkeses){
            String text = in.getText().replaceAll("[^0-9/]", "").trim();
            System.out.println(text);
            listText.add(text);
        }
        return listText;
    }
    public List<String> getAfatiKthimPergjigje(){
        List<String> listText = new ArrayList<>();
        for(WebElement in: page.afatiPerKthim){
            String text = in.getText().replaceAll("[^0-9/]", "").trim();

            listText.add(text);
        }
        return listText;
    }

    public String getNrKerkeses() {
        return page.nrKerkeses1.getText();
    }

    public String getInstitucionDergues() {
        return page.institucionDergues1.getText();
    }

    public String getInstitucionPrites() {
        return page.institucionPrites1.getText();
    }

    public String getDataKerkeses() {
        return page.dataKerkeses1.getText();
    }

    public String getKerkesa() {
        return page.kerkesa1.getText();
    }

    public String getPergjegjesi() {
        return page.pergjegjesi1.getText();
    }

    public String getKthimPergjigje() {
        return page.kthimPergjigje1.getText();
    }

    public String getStatusi() {
        return page.statusi1.getText();
    }
    public void clickTeTabelaButton() {
        page.tabelaButton.click();
    }
    public void zoomOUT(){
        JavascriptExecutor js = (JavascriptExecutor) BaseInformation.getDriver();
        js.executeScript("document.body.style.zoom='50%'");
    }
    public void clickLastPage() throws InterruptedException {
        zoomOUT();
        wait.until(ExpectedConditions.elementToBeClickable(page.lastPage));
        page.lastPage.click();
    }
}
