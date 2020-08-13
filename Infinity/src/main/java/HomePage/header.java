package HomePage;

import base.CommonAPI;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class header extends CommonAPI {

    @FindBy(how = How.CSS,using = "#megamenu-mlid-3325")
    public static WebElement ourProductsHeader;

    @FindBy(how = How.CSS,using = "megamenu-mlid-3327 ")
    public static WebElement claimCenterHeader;

    @FindBy(how = How.CSS,using = "megamenu-mlid-3329 ")
    public static WebElement mypolicyHeader;

    @FindBy(how = How.CSS,using = "#megamenu-mlid-3331 ")
    public static WebElement knowledgeHeader;


    public void clickOnOurProduct(){
        ourProductsHeader.click();
    }
    public void clickOnClaims(){
        claimCenterHeader.click();
    }
    public void clickOnmypolicy(){
        mypolicyHeader.click();
    }
    public void clickOknowledgeHeader(){
        knowledgeHeader.click();
    }





}
