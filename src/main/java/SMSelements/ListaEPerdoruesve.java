package SMSelements;

import Utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListaEPerdoruesve {

    public ListaEPerdoruesve(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }

    @FindBy(css =".p-ripple.p-element.p-button.p-component.p-button-raised")
    public WebElement shtoPerdorues;
    @FindBy(css = "#nid")
    public WebElement nidTB;
    @FindBy(css = "#firstName")
    public WebElement emriTB;
    @FindBy(css = "#lastName")
    public WebElement mbiemriTB;
    @FindBy(css = "#email")
    public WebElement emailTB;
    @FindBy(css = "#address")
    public WebElement adressaTB;
    @FindBy(css = "input[name='birthdate']")
    public WebElement ditelindjaTB;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement passwordTB;
    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement konfirmoPasswordTB;
    @FindBy(css = "input[name='registerDate']")
    public WebElement dataERegjistrimit;
    @FindBy(css = "span[aria-label='Klientët']")
    public WebElement klientet;
    @FindBy(css = "//p-dropdownitem//span[1]")
    public List<WebElement> klientetList;
    @FindBy(css = "div[id='gender'] div[aria-label='dropdown trigger']")
    public WebElement gjiniaDD;
    @FindBy(css = "div[id='status'] div[aria-label='dropdown trigger']")
    public WebElement statusDD;


}
