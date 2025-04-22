package SMSelements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElements {
    public LoginElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(css = "#email1")
    public WebElement emaili;
    @FindBy(css = "input[placeholder='Fjalëkalimi']")
    public WebElement fjalekalimi;
    @FindBy(xpath = "//button")
    public WebElement buttoni;
}
