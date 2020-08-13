package search;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class dropDownMenu extends CommonAPI {

    @Test
    public void dropDown(){
        List<WebElement>elementList = getListOfWebElements("#header-Header-sparkButton a");
        List<String>listOfString = getListOfString(elementList);
        for ( String st:listOfString){
            System.out.println(st);
        }
    }
}