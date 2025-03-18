package Elements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DitetPushimElements {
    public DitetPushimElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(css = "button[class=\"swal2-confirm swal2-styled\"]")
    public WebElement deshtimiListesOK;

    @FindBy(css = "#addholidaySpan")
    public WebElement shtoFestaButton;
    @FindBy(css = "#lbladdfreeDayModal")
    public WebElement shtimiFestaveTitle;
    @FindBy(css = "#dayName")
    public WebElement emeriFestes;
    @FindBy(css = "#dayDate")
    public WebElement dataEFestes;
    @FindBy(css = "#allservices")
    public WebElement teGjithaSherbimetRB;
    @FindBy(css = "#savebutton")
    public WebElement ruajButton;
    @FindBy(css = "label[for=\"oneormore\"]")
    public WebElement njeOseDisaSherbimeRB;
    @FindBy(css = "div[id=\"modalDialog\"] button[aria-label=\"Close\"]")
    public WebElement closeShtimiFestave;
    @FindBy(css = "button[data-i18n=\"cancel\"]")
    public WebElement anulloShtimiFestave;
    @FindBy(css="tbody tr:nth-child(1) td:nth-child(3) div:nth-child(1) button:nth-child(1)")
    public WebElement editFirstButton;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(3) div:nth-child(1) button:nth-child(1)")
    public WebElement deleteFirstButton;
    @FindBy(css = "tbody tr:nth-child(1) td")
    public WebElement firstColumn;
}
