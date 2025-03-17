package Pages;

import Elements.IdentifikimElements;
import Globals.Globals;



public class IdentifikimPage {

    IdentifikimElements page= new IdentifikimElements();

    public void validLogin(){
        page.emriPerdoruesit.sendKeys(Globals.validEmail);
        page.fjalekalimi.sendKeys(Globals.validPassword);
        page.meKujto.click();
        page.identifikojuButton.click();
    }


}
