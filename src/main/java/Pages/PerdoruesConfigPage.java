package Pages;

import Elements.DitetPushimElements;
import Elements.PerdoruesConfigElements;
import Utilities.BaseInformation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PerdoruesConfigPage {
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));;
    PerdoruesConfigElements page= new PerdoruesConfigElements();
    Actions actions = new Actions(BaseInformation.getDriver());
}
