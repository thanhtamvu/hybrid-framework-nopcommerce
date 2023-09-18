package comNopcommerceUser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_01_Register_DRY {

    WebDriver driver;
//    String projectPath = System.getProperty("user.dir");

    String emailAddress;


    @BeforeClass
    public void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        emailAddress = "afc" + generateFakeNumber() + "@email.vn";

        driver.get("https://demo.nopcommerce.com/");

    }

    @Test
    public void TC_01_Empty_Data(){

        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='FirstName-error']")).getText(),"First name is required.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='LastName-error']")).getText(),"Last name is required.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(),"Email is required.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(),"Password is required.");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(),"Password is required.");
    }

    @Test
    public void TC_02_Invalid_Email(){
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("FC");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("123@456#%*");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Email-error']")).getText(),"Wrong email");

    }

    @Test
    public void TC_03_Register_Success(){

        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("FC");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");
    }

    @Test
    public void TC_04_Register_Existing_Email(){
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("FC");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");

        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']//li")).getText(),"The specified email already exists");
    }
    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars(){
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("FC");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123");

        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='Password-error']")).getText(),"Password must meet the following rules:\nmust have at least 6 characters");


    }

    @Test
    public void TC_06_Register_Invalid_Confirm_Password(){
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Automation");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("FC");
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailAddress);
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("654123");

        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@id='ConfirmPassword-error']")).getText(),"The password and confirmation password do not match.");

    }


    @AfterClass
    public  void closeBrowser(){
        driver.quit();

    }


    public  int generateFakeNumber(){

        Random rand = new Random();

        return rand.nextInt(9999);
    }
}
