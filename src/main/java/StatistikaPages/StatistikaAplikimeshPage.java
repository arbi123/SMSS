package StatistikaPages;

import StatistikaPagesElements.StatistikaAplikimeshElements;
import Utilities.BaseInformation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StatistikaAplikimeshPage {
    StatistikaAplikimeshElements page = new StatistikaAplikimeshElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));


    public void waitUntilNoTableReaload(){
        wait.until(ExpectedConditions.invisibilityOf(page.loaderTable));
    }
}
