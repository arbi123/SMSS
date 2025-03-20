package Elements;

import Utilities.BaseInformation;
import org.json.XML;
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
    @FindBy(xpath = "//span//ul//li[contains(@class, 'select2-results')]")
    public List<WebElement> institucioniOptionsSS;
    @FindBy(css = "#serviceCodeAdd")
    public WebElement kodiSherbimitSS;
    @FindBy(css = "input[aria-controls='documents_table']")
    public WebElement dokumenteSHsearchBoxSS;
    @FindBy(css = "#service-type")
    public WebElement selectLLojiSherbimitSS;
    @FindBy(xpath = "//input[@id='wsIntegrationAdd']/following-sibling::span[@title='Selekto']")
    public WebElement integrimWSCheckBoxSS;
    @FindBy(xpath = "//input[@id='thinkingAdd']/following-sibling::span[@title='Selekto']")
    public WebElement mendimDhenieCheckBoxSS;
    @FindBy(xpath = "//input[@id='inactiveAdd']/following-sibling::span[@title='Selekto']")
    public WebElement inaktiveCheckBoxSS;
    @FindBy(xpath = "//input[@id='canDeleteAd']/following-sibling::span[@title='Selekto']")
    public WebElement canDeleteCheckBoxSS;
    @FindBy(xpath = "//input[@id='processingSqdneAdd']/following-sibling::span[@title='Selekto']")
    public WebElement procesimCheckBoxSS;
    @FindBy(xpath = "//input[@id='noMonitoringAdd']/following-sibling::span[@title='Selekto']")
    public WebElement paMonitorimCheckBoxSS;
    //sherbim me procesim
    @FindBy(css = "#deadline-type")
    public WebElement selectLlojiAfatitSS;
    @FindBy(css = "#replyDeadlineAdd")
    public WebElement afatiPergjigjesSS;
    @FindBy(css = "#submitButton")
    public WebElement ruajButton;

    @FindBy(css = "#chosenDocuments div")
    public List<WebElement> dokumentetEzgjedhura;

    @FindBy(xpath = "//div[@id='chosenDocuments']//span")
    public List<WebElement> docSHtextetEzgjedhura;
    @FindBy(css = "#select2-institutionSelectAdd-container")
    public WebElement instiucioniSSbutton;

    //TableData
    @FindBy(xpath ="//table[@id='services_table']//tbody/tr[1]/td[2]")
    public WebElement tableSherbimi1;
    @FindBy(xpath = "//table[@id='services_table']//tbody/tr[1]/td[3]")
    public WebElement tableKodi1;
    @FindBy(xpath = "//table[@id='services_table']//tbody/tr[1]/td[4]")
    public WebElement tableInstitucioni1;
    @FindBy(xpath = "//table[@id='services_table']//tbody/tr[1]/td[9]")
    public WebElement tableLlojiSherbimit;
    //4 checkboxat
    @FindBy(xpath = "//table[@id='services_table']//tbody/tr[1]/td[5]/input")
    public WebElement tableMendimDhenie;
    @FindBy(xpath = "//table[@id='services_table']//tbody/tr[1]/td[6]/input")
    public WebElement tableProcesimSQDNE;
    @FindBy(xpath = "//table[@id='services_table']//tbody/tr[1]/td[7]/input")
    public WebElement tableIntergrimWS;
    @FindBy(xpath = "//table[@id='services_table']//tbody/tr[1]/td[8]/input")
    public WebElement tableInaktive;
    //buttons
    @FindBy(xpath = "//table[@id='services_table']//tbody/tr[1]/td[10]/div/button[1]")
    public WebElement editTableButton;
    @FindBy(xpath = "//table[@id='services_table']//tbody/tr[1]/td[10]/div/button[2]")
    public WebElement deleteTableButton;
    @FindBy(css = "button[class='btn btn-danger bootbox-accept']")
    public WebElement confirmDeleteTableButton;
    @FindBy(xpath = "//h5[normalize-space(text())='Fshi Shërbimin']")
    public WebElement deleteTitle;
    @FindBy(css = "#serviceCodeFilter")
    public WebElement kodiSherbimitFilter;//click enter at the end
    @FindBy(css = "span[id='select2-institucioniListFilter-container'] span[class='select2-selection__placeholder']")
    public WebElement institucioniDDFilter;
    @FindBy(xpath = "//ul[@id='select2-institucioniListFilter-results']/li")
    public List<WebElement> institucionDDFilter;
    @FindBy(xpath = "//ul[@id='select2-serviceTypeFilter-results']/li")
    public List<WebElement> llojiSherbimitFilterOptions;
    @FindBy(css = "ul[class='select2-selection__rendered']")
    public WebElement llojiSherbimitFilter;
    @FindBy(xpath = "//table[@id='services_table']/thead/tr/th[1]")
    public WebElement sortFromTheNewest;
    @FindBy(xpath = "//h5[@id='lblAddServiceDocumentsModal' and normalize-space(text())='Modifiko Shërbimin']")
    public WebElement modifikoTitle;
    @FindBy(xpath = "//h5[@id='lblAddServiceDocumentsModal' and normalize-space(text())='Shto Shërbim']")
    public WebElement shtoSherbimTitle;


}
