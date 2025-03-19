package Elements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DokumentesSHConfigElements {
    public DokumentesSHConfigElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(css = "#addService")
    public WebElement shtoServicButton;
    @FindBy(css = "#clearFilters")
    public WebElement pastroFiltrat;
    @FindBy(css = "#select2-institucioniListFilter-container")
    public WebElement institucioniDD;
    @FindBy(xpath = "//span/input")
    public WebElement institucioniSearchBox;
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> tableDataSize;
    @FindBy(xpath = "//label/input")
    public WebElement searchBox;
    @FindBy(css = "select[name='services_table_length']")
    public WebElement shfaqTeDhena;
    @FindBy(css = "#serviceAdd")
    public WebElement dshEmeriISherbimit;
    @FindBy(xpath = "//span//ul//li")
    public List<WebElement> listaInstitucioneve;
    @FindBy(css = "#lblAddServiceDocumentsModal")
    public WebElement dshtitulliShtimit;
    @FindBy(css = "#select2-institutionSelectAdd-container")
    public WebElement dshInstitucioniDD;
    @FindBy(css = "#submitButton")
    public WebElement ruajButton;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
    public WebElement sherbimiTable1;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(3)")
    public WebElement insitucioniTable1;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(4) div:nth-child(1) button:nth-child(1)")
    public WebElement editTable1;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(4) div:nth-child(1) button:nth-child(2)")
    public WebElement deleteTable1;
    @FindBy(css = "button[class=\"btn btn-danger bootbox-accept\"]")
    public WebElement confirmDelete;
    @FindBy(css = "div[class=\"modal-dialog modal-dialog-centered\"] h5[class=\"modal-title\"]")
    public WebElement deleteTitle;
    @FindBy(css = ".sn-notify.sn-notify-outline.sn-notify-success.sn-notify-autoclose.sn-notify-fade.sn-notify-fade-in")
    public WebElement successAlert;
    @FindBy(css = ".sn-notify.sn-notify-outline.sn-notify-error.sn-notify-autoclose.sn-notify-fade.sn-notify-fade-in")
    public WebElement errorAlert;
    @FindBy(css = "tr td:nth-child(2)")
    public List<WebElement> sherbimiListTable;
    @FindBy(css = "tr td:nth-child(3)")
    public List<WebElement> insitucionetListTable;

    @FindBy(css = "#errServiceAdd")
    public WebElement sherbimiErrorTB;

    @FindBy(css = "#errInstitutionNameAdd")
    public WebElement institucionErrorTB;
    @FindBy(css = "span[class=\"select2-selection__clear\"]")
    public WebElement institucioniClearButton;

}
