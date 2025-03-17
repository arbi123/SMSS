package Elements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NjesitKonfigElements {

    public NjesitKonfigElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(css = "#declarationsBtn")
    public WebElement shtoUnitButton;
    @FindBy(css = "div[id='units_table_filter'] label input")
    public WebElement serachBox;
    @FindBy(css="#addUnitLabel")
    public WebElement shtoUnitTitle;
    @FindBy(css = "#unitName")
    public WebElement emriUnitTB;
    @FindBy(css = "#isActive")
    public  WebElement inaktivCB;
    @FindBy(css = "#savebuttonModifiko")
    public WebElement ruajButton;
    @FindBy(css = "#modifyUnitLabel")
    public WebElement editTitle;
    @FindBy(css = ".button.btn.btn-sm.btn-icon.editbutton")
    public WebElement editButton;
    @FindBy(css = ".button.btn.btn-sm.btn-danger.btn-icon")
    public WebElement deleteButton;//could be a list
    @FindBy(css = "button[class='btn btn-danger bootbox-accept']")
    public WebElement deleteConfirmButton;
    @FindBy(css = "//h5[normalize-space()=\"Fshi njesinë\"]")
    public WebElement fshirjaTitle;
    @FindBy(css = ".sn-notify.sn-notify-outline.sn-notify-success.sn-notify-autoclose.sn-notify-fade.sn-notify-fade-in")
    public WebElement succesNotification;
    @FindBy(css=".sn-notify.sn-notify-outline.sn-notify-error.sn-notify-autoclose.sn-notify-fade.sn-notify-fade-in")
    public WebElement errorNotification;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
    public WebElement emeriTable;
}
