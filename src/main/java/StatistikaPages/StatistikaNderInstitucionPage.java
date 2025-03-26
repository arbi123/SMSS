package StatistikaPages;

import StatistikaPagesElements.StatistikaNderInstitucionElements;
import Utilities.BaseInformation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StatistikaNderInstitucionPage {
    StatistikaNderInstitucionElements page = new StatistikaNderInstitucionElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(100));
    Actions actions = new Actions(BaseInformation.getDriver());
    public void waitUntilNoTableReaload(){
        wait.until(ExpectedConditions.invisibilityOf(page.loader));
        wait.until(ExpectedConditions.invisibilityOf(page.divLoader));
        wait.until(ExpectedConditions.invisibilityOf(page.loaderTable));
    }
}
