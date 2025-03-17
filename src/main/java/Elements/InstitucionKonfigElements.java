package Elements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InstitucionKonfigElements {

public InstitucionKonfigElements(){
    PageFactory.initElements(BaseInformation.getDriver(),this);
}
    @FindBy(css = "#addInstitutionSpan")
    public WebElement shtoInstitucion;
    @FindBy(css = "input.form-control.form-control-sm")
    public WebElement searchBox;
    @FindBy(xpath = "//tbody/tr/td[5]/div/button[1]")
    public List<WebElement> editButtons;
    @FindBy(xpath = "//tbody/tr/td[5]/div/button[2]")
    public List<WebElement> deleteButtons;
    @FindBy(css = "select[name='InstitutionsTable_length']")
    public WebElement shfaqSelect;
    @FindBy(css = "#downloadExcelbtn")
    public WebElement excelButton;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(1)")
    public WebElement getFirstNameText;

    @FindBy(css = ".loader")
    public WebElement loader;
    @FindBy(css = "#InstitutionsTable_processing")
    public WebElement procesingTable;


    //Shto Institucionn
    @FindBy(css = "#lbladdinstitutionsModal")
    public WebElement title;
    @FindBy(css = "#InstitutionName")
    public WebElement emertimiInstitucionitTB;
    @FindBy(css = "#kodi")
    public WebElement kodiTB;
    @FindBy(css = "#protocolNr")
    public WebElement nrProtokollitTB;
    @FindBy(css = "#titullar")
    public WebElement titullarTB;
    @FindBy(css = "#titullarP")
    public WebElement pozicioniTitullaritTB;
    @FindBy(xpath = "//span[@id='select2-parentId-container']")
    public WebElement institucioniPrindDD;//click send
    @FindBy(css = "#isMain")
    public WebElement kryesoreRB;
    @FindBy(css = "#activity")
    public WebElement inAktiveRB;
    @FindBy(css = "#generateTemplate")
    public WebElement gjenerimiTempRB;
    @FindBy(css = "input[placeholder='Zgjidh njësinë...']")
    public WebElement njesiaDD;//click send keys send enter
    @FindBy(css = "div[id='Header'] div[class='ql-editor ql-blank']")
    public WebElement kokaShkreses;//click send text;
    @FindBy(css = "div[id='Footer'] div[class='ql-editor ql-blank']")
    public WebElement fundiShkreses;
    @FindBy(id = "imageUpload")
    public WebElement shtoImazh;
    @FindBy(css = "#savebuttonCreate")
    public WebElement ruajButton;
    @FindBy(xpath = "button[onclick='hideModal();']")
    public WebElement anulloButton;
    @FindBy(css = ".sn-notify.sn-notify-outline.sn-notify-success.sn-notify-autoclose.sn-notify-fade.sn-notify-fade-in")
    public WebElement succesDiv;
    @FindBy(css = ".sn-notify.sn-notify-outline.sn-notify-error.sn-notify-autoclose.sn-notify-fade.sn-notify-fade-in")
    public WebElement failDiv;

    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
    public WebElement titullariTableFirstData;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(3)")
    public WebElement pozicioniTitullaritTableFirstData;
    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkboxes;


    //Modifikimi i institucionit
    @FindBy(css = "#lbladdinstitutionsModal")
    public WebElement pageModifikoTitle;
    @FindBy(css = "span#select2-parentId-container")
    public WebElement insitucioniPrindmi;
    @FindBy(css = "div[id='Header'] p")
    public WebElement kokaShkresesMI;
    @FindBy(css = "div[id='Footer'] p")
    public WebElement fundiShkresesMI;
    @FindBy(css = "ul[class='select2-selection__rendered']")
    public WebElement njesiaBOX;
    @FindBy(css = "#savebuttonModifiko")
    public WebElement ruajButtonMI;

    @FindBy(xpath = "//ul[@class='select2-selection__rendered']//li[1]")
    public WebElement njesiaMI;
    @FindBy(css = ".sn-notify.sn-notify-outline.sn-notify-error.sn-notify-autoclose.sn-notify-fade.sn-notify-fade-in")
    public WebElement errorNotification;

    @FindBy(css = "button[class='btn btn-danger bootbox-accept']")
    public WebElement konfirmoDelete;
    @FindBy(css ="button[class='btn btn-secondary btn-default bootbox-cancel']" )
    public WebElement mbyllDelete;
    @FindBy(css = ".sn-notify.sn-notify-outline.sn-notify-success.sn-notify-autoclose.sn-notify-fade.sn-notify-fade-in")
    public WebElement successDelete;

}
