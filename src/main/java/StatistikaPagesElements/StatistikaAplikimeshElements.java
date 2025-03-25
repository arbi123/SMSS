package StatistikaPagesElements;

import Utilities.BaseInformation;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StatistikaAplikimeshElements {
    public StatistikaAplikimeshElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(css = "#applications_table_processing")
    public WebElement loaderTable;
    @FindBy(css = "#select2-llojiAplikimit-container")
    public WebElement tipiDD;
    @FindBy(xpath = "//span/ul/li[@class='select2-results__option']")
    public List<WebElement> tipiOptions;
    @FindBy(css = "#startDatePicker")
    public WebElement nisjaEdatesTB;
    @FindBy(css = "#endDatePicker")
    public WebElement fundiEdatesTB;
    @FindBy(css = "#nrAplikimi")
    public WebElement nrIAplikimit;
    @FindBy(css = "#select2-Ministry-container")
    public WebElement ministriaDD;
    @FindBy(xpath = "//span/ul/li[@class='select2-results__option']")
    public List<WebElement> minsitriaOptions;
    @FindBy(xpath = "//select[@data-select2-id='Institution']/following-sibling::span/span/span/ul/li/input")
    public WebElement institucionetDD;
    @FindBy(xpath = "//ul[@id='select2-Institution-results']/li/ul/li/span")
    public List<WebElement> institucionetOptions;
    @FindBy(xpath = "//ul[@id='select2-Services-results']/li")
    public List<WebElement> sherbimetOptions;
    @FindBy(xpath = "//select[@data-select2-id='DerguarTek']/following-sibling::span/span/span/ul/li/input")
    public WebElement institucionetPriteseDD;
    @FindBy(xpath = "//span[@data-select2-id='8139']/span/span/ul/li/input")
    public WebElement sherbimetDD;
    @FindBy(xpath= "//span[@data-select2-id='1643']/span/span/ul/li/input")
    public WebElement statusiDD;
    @FindBy(xpath = "//ul[@id='select2-statusi-results']/li")
    public List<WebElement> statusiOptions;
    @FindBy(xpath = "//span[@class='select2-selection__clear']")
    public WebElement clearButtonX;
    @FindBy(xpath = "//div[@class='loader']")
    public WebElement divLoader;
    @FindBy(xpath = "//strong/span")
    public WebElement institucionOptionsStrong;
    @FindBy(css = ".loader")
    public WebElement loader;

    //filtrim buttons
    @FindBy(css = ".btn.btn-sm.bg-white.rounded-circle.btn-icon.text-primary")
    public WebElement mbyllFiltrat;
    @FindBy(css = "#showFiltersBtn")
    public WebElement nxirrFiltrat;
    @FindBy(css = "#clearFilters")
    public WebElement pastroFiltrat;
    @FindBy(css = "select[name='applications_table_length']")
    public WebElement shfaqTableData;
    //table
    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> tableSize;
    @FindBy(css = "#clearFilters")
    public WebElement emptyTable;
    @FindBy(xpath = "//tbody/tr/td[8]")
    public List<WebElement>  statusiTable;
    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> sherbimetTable;
    @FindBy(xpath = "//tbody/tr/td[5]")
    public List<WebElement> institucionetTable;
    //first table data
    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    public WebElement nrAplikimitTABLE;
    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    public WebElement sherbimiTABLE;
    @FindBy(xpath = "//tbody/tr[1]/td[5]")
    public WebElement institucioniTABLE;
    @FindBy(xpath = "//tbody/tr[1]/td[7]")
    public WebElement niptTABLE;
    @FindBy(xpath = "//tbody/tr[1]/td[8]")
    public WebElement statusiTABLE;

    //
    @FindBy(xpath = "//tbody[1]/tr/td[9]")
    public List<WebElement> dataAplikimit;
    @FindBy(xpath = "//tbody[1]/tr/td[10]")
    public List<WebElement> dataEPerfundimitTeAplikimit;

}
