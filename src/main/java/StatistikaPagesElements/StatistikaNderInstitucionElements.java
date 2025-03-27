package StatistikaPagesElements;

import Utilities.BaseInformation;
import org.json.XML;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StatistikaNderInstitucionElements {

    public StatistikaNderInstitucionElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(css = "select[name='applications_table_length']")
    public WebElement shfaqTableData;
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
    public List<WebElement> institucionetDergueseOptions;
    @FindBy(css = "#select2-MinistryReceiver-container")
    public WebElement ministriaPriteseDD;
    @FindBy(xpath = "//select[@data-select2-id='DerguarTek']/following-sibling::span/span/span/ul/li/input")
    public WebElement institucionetPriteseDD;
    @FindBy(css = "#select2-ResponseBack-container")
    public WebElement selectKthimPergjigje;
    @FindBy(xpath = "//ul[@id='select2-ResponseBack-results']//li")
    public List<WebElement> kthimPergjigjeOptions;
    @FindBy(css = "#insideDeadline")
    public WebElement brendaAfatitRB;
    @FindBy(css = "#outsideDeadline")
    public WebElement jashtAfatitRB;
    @FindBy(css = "#clearFilters")
    public WebElement pastroFiltratButton;

    //table
    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> nrKerkesesTableC;
    @FindBy(xpath = "//tbody//td[3]")
    public List<WebElement> InstitucioniDerguesTableC;
    @FindBy(xpath = "//tbody//td[4]")
    public  List<WebElement> institucionPritesTableC;
    @FindBy(xpath = "//tbody//td[5]/div/span")
    public  List<WebElement> dataKerkeses;
    @FindBy(xpath = "//tbodt/td[8]")
    public List<WebElement> afatiPerKthim;
    @FindBy(xpath = "//tbody//td[4]")
    public  List<WebElement> afatiPerKthimPergjije;
    @FindBy(xpath = "//tbody/tr/td[9]")
    public List<WebElement> statusiTableC;
    @FindBy(xpath = "//strong/span")
    public WebElement institucionOptionsStrong;

    //nav
    @FindBy(xpath = "//li[@title='Tabela e Aplikimeve']")
    public WebElement tabelaButton;
    @FindBy(xpath = "//li[@title='Grafikët e Aplikimeve']")
    public WebElement grafiketButton;
    //tablefirst row
    @FindBy(xpath = "//tbody/tr/td[2]")
    public WebElement nrKerkeses1;
    @FindBy(xpath = "//tbody/tr/td[3]")
    public WebElement institucionDergues1;
    @FindBy(xpath = "//tbody/tr/td[4]")
    public WebElement institucionPrites1;
    @FindBy(xpath = "//tbody/tr/td[5]")
    public WebElement dataKerkeses1;
    @FindBy(xpath = "//tbody/tr/td[6]")
    public WebElement kerkesa1;
    @FindBy(xpath = "//tbody/tr/td[7]")
    public WebElement pergjegjesi1;
    @FindBy(xpath = "//tbody/tr/td[8]")
    public WebElement kthimPergjigje1;
    @FindBy(xpath = "//tbody/tr/td[9]")
    public WebElement statusi1;


    @FindBy(xpath = "//li[@id='applications_table_last']//a[@class='page-link']")
    public WebElement lastPage;


}
