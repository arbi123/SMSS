package Elements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SherbimiConfigElements {
    public SherbimiConfigElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(css = "#addService")
    public WebElement shtoSherbimButton;
    @FindBy(css = "input[aria-controls='services_table']")
    public WebElement searchBox;
    @FindBy(css = "#serviceAdd")
    public WebElement sherbimiSS;
    @FindBy(css = "#select2-institutionSelectAdd-container")
    public WebElement DDinsititucioniSS;
    @FindBy(css = "//span//ul//li[contains(@class, 'select2-results')]")
    public List<WebElement> institucioniOptionsSS;
    @FindBy(css = "#serviceCodeAdd")
    public WebElement kodiSherbimitSS;
    @FindBy(css = "input[aria-controls='documents_table']")
    public WebElement dokumenteSHsearchBoxSS;
    @FindBy(css = "#service-type")
    public WebElement selectLLojiSherbimitSS;
    @FindBy(xpath = "//input[@id='wsIntegrationAdd']/following-sibling::span[@title='Selekto']")
    public WebElement integrimWSCheckBoxSS;
    @FindBy(css = "//input[@id='thinkingAdd']/following-sibling::span[@title='Selekto']")
    public WebElement mendimDhenieCheckBoxSS;
    @FindBy(css = "//input[@id='inactiveAdd']/following-sibling::span[@title='Selekto']")
    public WebElement inaktiveCheckBoxSS;
    @FindBy(css = "//input[@id='canDeleteAd']/following-sibling::span[@title='Selekto']")
    public WebElement canDeleteCheckBoxSS;
    @FindBy(css = "//input[@id='processingSqdneAdd']/following-sibling::span[@title='Selekto']")
    public WebElement procesimCheckBoxSS;
    @FindBy(css = "//input[@id='noMonitoringAdd']/following-sibling::span[@title='Selekto']")
    public WebElement paMonitorimCheckBoxSS;
    //sherbim me procesim
    @FindBy(css = "#deadline-type")
    public WebElement selectLlojiAfatitSS;
    @FindBy(css = "#replyDeadlineAdd")
    public WebElement afatiPergjigjesSS;


    @FindBy(css = "#chosenDocuments")
    public WebElement dokumentetEzgjedhura;

}
