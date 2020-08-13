package base;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import reporting.TestLogger;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;
    public String browserStackUserName="vallerieblankins1";
    public String browserStackAccessKey="xzhKARjpajaPxdEDjM4y";
    public String sauceLabsUserName="vallerie115";
    public String sauceLabsAccessKey="200c1781-e03d-437d-a9df-baf961f496d9";



    @Parameters({"url"})
    @BeforeMethod
    public void setUp(@Optional("https://www.infinity.com/")  String url) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jesse\\IdeaProjects\\TeamProject\\Generic\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }
 /*   @Parameters({"useCloudEnv", "cloudEnvName", "url", "os", "os_version", "browserName", "browserVersion"})
    @BeforeMethod
    public void setUp(@Optional String useCloudEnv, @Optional String cloudEnvName, @Optional("https://www.infinityauto.com/") String url,
                      @Optional String OS, @Optional String os_version, @Optional String browserName,
                      @Optional String browserVersion) throws IOException {
        if (useCloudEnv.equalsIgnoreCase("true")) {
            getCloudDriver(cloudEnvName,browserStackUserName,browserStackAccessKey,OS, os_version,browserName,browserVersion);
        } else if (useCloudEnv.equalsIgnoreCase("false")) {
            getLocalDriver(OS, browserName);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }*/

    public WebDriver getLocalDriver(String OS, String browserName) {
        if (OS.equalsIgnoreCase("OS X")) {
            System.setProperty("webdriver.chrome.driver", "..\\Generic\\driver\\chromedriver");
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }
        } else if (OS.equalsIgnoreCase("Windows")) {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "..\\Generic\\driver\\chromedriver.exe");
                driver = new ChromeDriver();
            }
        } else if (OS.equalsIgnoreCase("OS X")) {
            if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.chrome.driver", "..\\Generic\\driver\\geckodriver");
                driver = new ChromeDriver();
            }
        } else if (OS.equalsIgnoreCase("Windows")) {
            if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.chrome.driver", "..\\Generic\\driver\\geckodriver.exe");
                driver = new ChromeDriver();
            }
        }
        return driver;
    }

   public WebDriver getCloudDriver(String envName, String envUserName, String envAccessKey,String OS,
                                   String os_version, String browserName, String browserVersion) throws IOException {
       DesiredCapabilities cap = new DesiredCapabilities();
       cap.setCapability("browser",browserName);
       cap.setCapability("browserVersion",browserVersion);
       cap.setCapability("os", OS);
       cap.setCapability("os_version",os_version);
       if(envName.equalsIgnoreCase("Saucelabs")){
           driver = new RemoteWebDriver(new URL("http://"+envUserName+":"+envAccessKey+
                   "@ondemand.saucelabs.com:80/wd/hub"),cap);

       }else if(envName.equalsIgnoreCase("Browserstack")) {
           driver = new RemoteWebDriver(new URL("http://" + envUserName + ":" + envAccessKey +
                   "@hub-cloud.browserstack.com:80/wd/hub"), cap);
       }
        return driver;
    }

    @AfterMethod
    public void cleanUp(){
        driver.close();
    }

    public void clickOnElement(String locator){
        driver.findElement(By.cssSelector(locator)).click();

    }public void typeOnElement(String locator, String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    public List<WebElement>getListOfWebElements(String locator){
        List<WebElement> elementList = driver.findElements(By.cssSelector("#header-Header-sparkButton a "));
        return elementList;
    }
    public List<String>getListOfString(List<WebElement>elementList) {
        List<String> listOfString = new ArrayList<String>();
        for (WebElement element : elementList) {
        }
        return listOfString;

    }
    public static void navigateBack() {
        driver.navigate().back();
    }
    public static void waitUntilVisible(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public static void waitUntilClickAble(WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch(Exception ex){
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }
    }
    public static String convertToString(String st) {
        String splitString = "";
        splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
        return splitString;
    }
    public void clearInputField(String locator) {
        TestLogger.log(getClass().getSimpleName() + ": " + convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public static List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }

}
