package StatistikaPages;

import StatistikaPagesElements.StatistikaAplikimeshElements;
import Utilities.BaseInformation;
import com.beust.ah.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StatistikaAplikimeshPage {
    StatistikaAplikimeshElements page = new StatistikaAplikimeshElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(30));
    Actions actions = new Actions(BaseInformation.getDriver());

    public void waitUntilNoTableReaload(){
        wait.until(ExpectedConditions.invisibilityOf(page.loader));
        wait.until(ExpectedConditions.invisibilityOf(page.loaderTable));
    }
    public void selectTipi(String value){
        wait.until(ExpectedConditions.elementToBeClickable(page.tipiDD));
        page.tipiDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.tipiOptions.getFirst()));
        for(WebElement item: page.tipiOptions){
            String Text = item.getText();
            if(Text.contains(value)){
                item.click();
                break;
            }
        }
        waitUntilNoTableReaload();
    }
    public void selektoDaten(String dataFillimit,String dataMbarimit){
        wait.until(ExpectedConditions.elementToBeClickable(page.nisjaEdatesTB));
        page.nisjaEdatesTB.clear();
        page.nisjaEdatesTB.sendKeys(dataFillimit);
        page.fundiEdatesTB.clear();
        page.fundiEdatesTB.sendKeys(dataMbarimit);
    }
    public void nrAplikimit(String value){
        page.nrIAplikimit.clear();
        page.nrIAplikimit.sendKeys(value);
        actions.sendKeys(Keys.ENTER).perform();
        waitUntilNoTableReaload();
    }
    public void selectMinistria(String value){
        wait.until(ExpectedConditions.elementToBeClickable(page.ministriaDD));
        page.ministriaDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.minsitriaOptions.getFirst()));
        for(WebElement item: page.minsitriaOptions){
            String Text = item.getText();
            if(Text.contains(value)){
                item.click();
                break;
            }
        }
        waitUntilNoTableReaload();
    }
    public void selectInstitucionet(String value){
        wait.until(ExpectedConditions.elementToBeClickable(page.institucionetDD));
        page.institucionetDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.institucionetOptions.getFirst()));
        for(WebElement item: page.institucionetOptions){
            String Text = item.getText();
            if(Text.contains(value)){
                item.click();
                break;
            }
        }
        waitUntilNoTableReaload();
    }
    public void selectInstitucioniPrites(String value){
        wait.until(ExpectedConditions.elementToBeClickable(page.institucionetPriteseDD));
        page.institucionetPriteseDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.institucionetOptions.getFirst()));
        for(WebElement item: page.institucionetOptions){
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
    public void selectSherbimtet(String value){
        wait.until(ExpectedConditions.elementToBeClickable(page.sherbimetDD));
        page.sherbimetDD.click();
        wait.until(ExpectedConditions.visibilityOf(page.sherbimetOptions.getFirst()));
        for(WebElement item: page.sherbimetOptions){
            String Text = item.getText();
            if(Text.contains(value)){
                item.click();
                break;
            }
        }
        waitUntilNoTableReaload();
    }
    public void selectStatusi(String value) throws InterruptedException {
        actions.scrollToElement(page.statusiDD).perform();
        waitUntilNoTableReaload();
        wait.until(ExpectedConditions.elementToBeClickable(page.statusiDD));
        page.statusiDD.click();
        for(WebElement item: page.statusiOptions){
            String Text = item.getText();
            if(Text.contains(value)){
                item.click();
                break;
            }
        }
        waitUntilNoTableReaload();
        Thread.sleep(2000);
    }
    public void clearStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(page.clearButtonX));
        page.clearButtonX.click();
    }












    public List<String> statusiTable(){
        waitUntilNoTableReaload();
        List<String> list = new ArrayList<>();
        for (WebElement item: page.statusiTable){
            String text = item.getText();
            list.add(text);
        }
        return list;
    }
    public List<String> sherbimiTable(){
        waitUntilNoTableReaload();
        List<String> list = new ArrayList<>();
        for (WebElement item: page.sherbimetTable){
            String text = item.getText();
            list.add(text);
        }
        return list;
    }
    public List<String> institucioniTable(){
        waitUntilNoTableReaload();
        List<String> list = new ArrayList<>();
        for (WebElement item: page.institucionetTable){
            String text = item.getText();
            list.add(text);
        }
        return list;
    }

    public boolean isTableEmpty() throws InterruptedException {
        waitUntilNoTableReaload();
        Thread.sleep(500);
        return page.tableSize.isEmpty();
    }
    public void mbyllFiltrat(){
        wait.until(ExpectedConditions.elementToBeClickable(page.mbyllFiltrat));
        page.mbyllFiltrat.click();
    }
    public void hapFiltrat(){
        wait.until(ExpectedConditions.elementToBeClickable(page.nxirrFiltrat));
        page.nxirrFiltrat.click();
    }
    public void pastroFiltrat(){
        wait.until(ExpectedConditions.elementToBeClickable(page.pastroFiltrat));
        page.pastroFiltrat.click();

    }
    public int tableSize(){
        waitUntilNoTableReaload();
        return page.tableSize.size();
    }




    public String getNrAplikimitTable(){
    return      page.nrAplikimitTABLE.getText();
    }
    public String getSherbimiTable(){
        return page.sherbimiTABLE.getText();
    }
    public String getInstitucionitTABLE(){
        return page.institucioniTABLE.getText();
    }
    public String getNiptID(){
        return page.niptTABLE.getText();
    }
    public String getStatusTABLE(){
        return page.statusiTABLE.getText();
    }
}
