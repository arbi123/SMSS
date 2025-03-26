package StatistikaPagesElements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}
