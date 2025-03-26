package StatistikaPagesElements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StatistikaNderInstitucionElements {

    public StatistikaNderInstitucionElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(css = ".loader")
    public WebElement loader;
    @FindBy(css = "#applications_table_processing")
    public WebElement loaderTable;
    @FindBy(xpath = "//div[@class='loader']")
    public WebElement divLoader;
    @FindBy(css = "#nrAplikimi")
    public WebElement nrIAplikimit;
    @FindBy(css = "#startDatePicker")
    public WebElement nisjaEdatesTB;
    @FindBy(css = "#endDatePicker")
    public WebElement fundiEdatesTB;
    @FindBy(css = "#select2-Ministry-container")
    public WebElement ministriaDergueseDD;
    @FindBy(xpath = "//span/ul/li[@class='select2-results__option']")
    public List<WebElement> minsitriaOptions;
    @FindBy(xpath = "//select[@data-select2-id='Institution']/following-sibling::span/span/span/ul/li/input")
    public WebElement institucionetDergueseDD;
    @FindBy(xpath = "//span/ul/li[@class='select2-results__option']/ul/li/span")
    public WebElement institucionetDergueseOptions;
    @FindBy(css = "#select2-MinistryReceiver-container")
    public WebElement ministriaPriteseDD;
    @FindBy(css = "#select2-ResponseBack-container")
    public WebElement selectKthimPergjigje;
    @FindBy(css = "#insideDeadline")
    public WebElement brendaAfatitRB;
    @FindBy(css = "#outsideDeadline")
    public WebElement jashtAfatitRB;
    @FindBy(css = "#clearFilters")
    public WebElement pastroFiltratButton;


}
