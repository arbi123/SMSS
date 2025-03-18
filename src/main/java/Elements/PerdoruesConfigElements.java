package Elements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PerdoruesConfigElements{

    public PerdoruesConfigElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }
    //Filtrat
    @FindBy(css = "#fullNameFilter")
    public WebElement emriFilterTB;
    @FindBy(css = "#emailFilter")
    public WebElement emailFileterTB;
    @FindBy(css ="#select2-institucioniListFilter-container" )
    public WebElement institucioniFilterDD;
    @FindBy(css = "#select2-njesiaListFilter-container")
    public WebElement njesiaFilterDD;
    @FindBy(css = "#select2-roleListFilter-container")
    public WebElement roletFiletDD;
    @FindBy(xpath = "//span//ul//li[contains(@class, 'select2-results')]")
    public WebElement filetOptions;


    @FindBy(css = "button[class=\"btn btn-primary btn-icon rounded-circle mx-2 addUserDocuments\"]")
    public WebElement addUserConfigButton;
    @FindBy(css = "#addUserConfigurationModal")
    public WebElement configPerdoruesBox;
    @FindBy(css = "#emailAdd")
    public WebElement UCemailiTB;
    @FindBy(css = "#nidAdd")
    public WebElement NID_UC;
    @FindBy(WebElement)





}
