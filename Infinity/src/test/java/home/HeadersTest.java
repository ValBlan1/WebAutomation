package home;

import HomePage.header;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class HeadersTest extends header {


    header Header;
    @BeforeMethod
    public void  initialElements(){ Header = PageFactory.initElements(driver,header.class);
    }
    @Test
    public void ourProducts(){
        clickOnOurProduct();
    }
    @Test
    public void Claims(){
        clickOnClaims();
    }
    @Test
    public void MyPolicy(){
        clickOnmypolicy();
    }
    @Test
    public void KnoledgeBotton(){
        clickOknowledgeHeader();
    }

}
