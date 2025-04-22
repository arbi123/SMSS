package SMSelements;

import Utilities.BaseInformation;
import org.json.XML;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListaEKlienteve {
    public ListaEKlienteve(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    @FindBy(xpath = "//p-button/button")
    public WebElement shtoButton;
    @FindBy(css = "#Nipt")
    public WebElement niptTB;
    @FindBy(css = "#Code")
    public WebElement kodiTB;
    @FindBy(css = "#Name")
    public WebElement emriTB;
    @FindBy(css = "input[name='registrationDate']")
    public WebElement dataERegjistrimit;
    @FindBy(css = "#address")
    public WebElement adressaTB;
    @FindBy(css = "#description")
    public WebElement pershkrim;
    @FindBy(xpath = "(//div/div/button)[2]")
    public WebElement ruajButton;
    //tabela
    @FindBy(xpath = "(//th/input)[1]")
    public WebElement niptTableSB;
    @FindBy(xpath = "(//th/input)[2]")
    public WebElement kodiTableSB;
    @FindBy(xpath = "(//th/input)[3]")
    public WebElement emriTableSB;
    @FindBy(xpath = "(//th/input)[4]")
    public WebElement dataTableSB;
    @FindBy(xpath = "(//th/input)[5]")
    public WebElement adresaTableSB;
    //TABLE TEXT
    @FindBy(xpath = "//tr/td[2]")
    public WebElement niptTextTABLE;
    @FindBy(xpath = "//tr/td[3]")
    public WebElement kodiTextTABLE;
    @FindBy(xpath = "//tr/td[4]")
    public WebElement emriTextTABLE;
    @FindBy(xpath = "//tr/td[6]")
    public WebElement adresaTextTABLE;
    @FindBy(xpath = "//tr/td[7]")
    public WebElement pershrkimiTextTABLE;
    @FindBy(xpath = "//tr/td[8]/div/button[1]")
    public WebElement editButton;
    @FindBy(xpath = "//tr/td[8]/div/button[2]")
    public WebElement deleteButton;
    @FindBy(xpath = "//span[normalize-space()='Po']")
    public WebElement poButton;
    @FindBy(xpath = "//td[normalize-space()='Nuk u gjetën klientë.']")
    public WebElement skaKliente;



}
