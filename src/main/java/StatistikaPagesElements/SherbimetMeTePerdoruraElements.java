package StatistikaPagesElements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SherbimetMeTePerdoruraElements {
    public SherbimetMeTePerdoruraElements() {
        PageFactory.initElements(BaseInformation.getDriver(), this);
    }
    @FindBy(css = "span[data-i18n='clear_filters']")
    public WebElement fshijFiltrat;
    @FindBy(css = "#startDatePicker")
    public WebElement nisjaEdatesTB;
    @FindBy(css = "#endDatePicker")
    public WebElement fundiEdatesTB;
    @FindBy(css = ".loader")
    public WebElement loader;
    @FindBy(css = "#select2-Ministry-container")
    public WebElement ministriaDergueseDD;
    @FindBy(xpath = "//span/ul/li[@class='select2-results__option']")
    public List<WebElement> minsitriaOptions;
    @FindBy(xpath = "//select[@data-select2-id='Institution']/following-sibling::span/span/span/ul/li/input")
    public WebElement institucionetDergueseDD;
    @FindBy(xpath = "//span/ul/li[@class='select2-results__option']/ul/li/span")
    public List<WebElement> institucionetDergueseOptions;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(2)")
    public WebElement  emriSherbimitTable;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(3)")
    public WebElement emriInstitucionitlTable;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(4)")
    public WebElement numriAplikimitTable;
    @FindBy(css = "tbody tr:nth-child(1) td:nth-child(5)")
    public WebElement perqindjaEaplikimeve;
}
