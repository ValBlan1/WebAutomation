package home;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SectionsPage {

    @FindBy(how = How.CSS, using = "#sections > span.pages.menu-icon > svg")
    public static WebElement sectionMenuWebElement;

    @FindBy(how = How.CSS, using = "#menu-main-menu li:nth-child(2) a")
    public static WebElement metroMenuWebElement;

    @FindBy(how = How.CSS, using = "#menu-main-menu li:nth-child(5) a")
    public static WebElement businessMenuWebElement;

    @FindBy(how = How.CSS, using = "#menu-main-menu li:nth-child(7) a")
    public static WebElement entertainmentMenuWebElement;

    public WebElement getSectionMenuWebElement(){

        return sectionMenuWebElement;
    }

    public WebElement getMetroMenuWebElement(){

        return metroMenuWebElement;
    }
    public WebElement getBusinessMenuWebElement(){

        return businessMenuWebElement;
    }
    public WebElement getEntertainmentMenuWebElement(){

        return entertainmentMenuWebElement;
    }
    public void clickOnSectionMenuTab(){
        getSectionMenuWebElement().click();
    }
    public MetroPage goToMetroPage(WebDriver driver){
        getMetroMenuWebElement().click();
        return new MetroPage(driver);
    }
}
