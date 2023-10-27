package actions.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class test1  {

   static WebDriver driver;

@BeforeClass
    public static void base(){

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

@Test
    public void TC_01(){

    driver.get("https://www.fahasa.com/customer/account/create");

    driver.findElement(By.xpath("//li[contains(@class,'popup-login-tab-login')]")).click();

   Assert.assertEquals(driver.findElement(By.xpath("//li[contains(@class,'popup-login-tab-login')]")).isEnabled(),false);

   // Assert.assertEquals(driver.findElement(loginButton).getCssValue("background-color"),"224,224,224,1");

}



@AfterClass
    public static void closeBrowser(){

    driver.quit();
}




















}
