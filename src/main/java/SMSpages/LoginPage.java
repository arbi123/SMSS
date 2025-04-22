package SMSpages;

import SMSelements.LoginElements;
import Utilities.BaseInformation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    LoginElements page = new LoginElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(30));

    public void fillEmail(String email){

        wait.until(ExpectedConditions.visibilityOf(page.emaili));
        page.emaili.clear();
        page.emaili.sendKeys(email);
    }
    public void fillPassword(String pw){
        page.fjalekalimi.clear();
        page.fjalekalimi.sendKeys(pw);
    }
    public void loginButton(){
        page.buttoni.click();
    }
}
