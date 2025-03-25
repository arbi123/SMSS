package StatistikaPagesElements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatistikaAplikimeshElements {
    public StatistikaAplikimeshElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(css = "#applications_table_processing")
    public WebElement loaderTable;
    @FindBy(css = "#select2-llojiAplikimit-container")
    public WebElement tipiFilter;
    @FindBy(css = "#startDatePicker")
    public WebElement nisjaEdatesTB;
    @FindBy(css = "#endDatePicker")
    public WebElement fundiEdatesTB;
    @FindBy(css = "#nrAplikimi")
    public WebElement nrIAplikimit;
    @FindBy(css = "#select2-Ministry-container")
    public WebElement ministriaDD;
    @FindBy(css = ".btn.btn-sm.bg-white.rounded-circle.btn-icon.text-primary")
    public WebElement mbyllFiltrat;
    @FindBy(css = "#showFiltersBtn")
    public WebElement nxirrFiltrat;
    @FindBy(css = "#clearFilters")
    public WebElement pastroFiltrat;
}
