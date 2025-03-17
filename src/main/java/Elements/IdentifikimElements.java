package Elements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IdentifikimElements{

    public IdentifikimElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(css = "#email1")
    public WebElement emriPerdoruesit;
    @FindBy(css = "#pass1")
    public WebElement fjalekalimi;
    @FindBy(css = "#rememberMe")
    public WebElement meKujto;
    @FindBy(css = "button[type='Submit']")
    public WebElement identifikojuButton;
}
