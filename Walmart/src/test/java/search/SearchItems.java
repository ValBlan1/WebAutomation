package search;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItems extends CommonAPI {
    @Test
    public void test1() throws InterruptedException{
        driver.findElement(By.id("global-search-input")).sendKeys("Tablets", Keys.ENTER);
        Thread.sleep(2000);
    }
    @Test
    public void test2() {
        String expectedTitle ="Walmart.com | Save Money. Live Better.";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
