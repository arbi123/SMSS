package Elements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.temporal.WeekFields;
import java.util.List;


import java.lang.invoke.CallSite;

public class PerdoruesConfigElements{

    public PerdoruesConfigElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }
    //Filtrat
    @FindBy(css = "#fullNameFilter")
    public WebElement emeriFilterTB;
    @FindBy(css = "#emailFilter")
    public WebElement emailFileterTB;
    @FindBy(css ="#select2-institucioniListFilter-container" )
    public WebElement institucioniFilterDD;
    @FindBy(css = "#select2-njesiaListFilter-container")
    public WebElement njesiaFilterDD;
    @FindBy(css = "#select2-roleListFilter-container")
    public WebElement roletFiletDD;
    @FindBy(xpath = "//span//ul//li[contains(@class, 'select2-results')]")
    public List<WebElement> options;


    @FindBy(css = "button[class=\"btn btn-primary btn-icon rounded-circle mx-2 addUserDocuments\"]")
    public WebElement addUserConfigButton;
    @FindBy(css = "#addUserConfigurationModal")
    public WebElement configPerdoruesBox;
    @FindBy(css = "#emailAdd")
    public WebElement emailiUC;
    @FindBy(css = "#nidAdd")
    public WebElement NID_UC;
    @FindBy(css = "#emriAdd")
    public WebElement emeriUC;
    @FindBy(css = "#komentAdd")
    public WebElement komentUC;
    @FindBy(css = "#nrTelAdd")
    public WebElement nrTelUC;
    @FindBy(css = "#jobPositionAdd")
    public WebElement pozicioniPunesUC;
    @FindBy(css = "#txtdatefrom")
    public WebElement dataUC;
    @FindBy(id = "atesiAdd")
    public WebElement atesiUC;
    @FindBy(id = "mbiemerAdd")
    public WebElement mbiemerUC;
    @FindBy(id = "adresaAdd")
    public WebElement adresaUC;
    @FindBy(css = "#select2-institucioniList-container")
    public WebElement institucioniUC;
    @FindBy(css = "#select2-njesiaList-container")
    public WebElement  njesiaUC;
    @FindBy(css = "#isActive")
    public WebElement inaktiveUC;
    @FindBy(css = "#sentRequest")
    public WebElement dergonKerkeseUC;
    @FindBy(css = "span[aria-expanded='true'] ul[class='select2-selection__rendered']")
    public WebElement roletUC;
    @FindBy(css = "#showFileUpload")
    public WebElement shikoDocUC;
    @FindBy(css = "#fileUploadSpan")
    public WebElement uploadFileUC;
    @FindBy(css = "#addInstitution")
    public WebElement shtoInstitucion;
    @FindBy(css = "#removeInstitution")
    public List<WebElement> fshiInstitucionUC;
    @FindBy(css = "button[class='btn btn-danger bootbox-accept']")
    public WebElement konfirmoFshirjenButton;
    @FindBy(css = "div[class='modal-dialog modal-dialog-centered'] h5[class='modal-title']")
    public WebElement konfirmoFshirjenTitle;
    @FindBy(css = "#addUserDocuments")
    public WebElement ruajPerdorues;
    @FindBy(xpath = "//span/span[1]/span/ul")
    public List<WebElement> rolet;
    @FindBy(css = ".form-group.col-8.m-0")
    public WebElement tableUC;

    //Table data after search
    @FindBy(css = "td:nth-child(2)")
    public WebElement emeriIPlote;
    @FindBy(css = "td:nth-child(3)")
    public WebElement emailTable;
    @FindBy(css = "td:nth-child(4)")
    public WebElement insititucioniDheNjesia;
    @FindBy(css = "td:nth-child(5)")
    public WebElement NID;
    @FindBy(css = "td:nth-child(6)")
    public WebElement nrTelefon;
    @FindBy(css = "td:nth-child(7)")
    public WebElement roli;
    @FindBy(css = "td:nth-child(8)")
    public WebElement dataKrijimit;
    @FindBy(css = "td:nth-child(9)")
    public WebElement dataModifikimiFundit;
    @FindBy(css = "td:nth-child(10) input")
    public WebElement inaktiveCheckBoxTable;
    @FindBy(css = "button[class='btn btn-sm btn-icon']")
    public WebElement editButton;
    @FindBy(css = "button[title='Fshi']")
    public WebElement deleteButton;
    @FindBy(css = "button[class='btn btn-danger bootbox-accept']")
    public WebElement konfirmoDelete;
    @FindBy(css = "#dropdownMenuButton")
    public WebElement dropdownMenu;
    @FindBy(css = ".dataTables_empty")
    public WebElement emptyData;





}
