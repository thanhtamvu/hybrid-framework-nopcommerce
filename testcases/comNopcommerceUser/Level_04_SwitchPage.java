package testcases.comNopcommerceUser;

import actions.commons.PageGeneratorManager;
import actions.pageAction.CommonPageAction;
import actions.pageAction.LoginPageAction;
import actions.pageAction.MyAccountPageAction;
import commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageAction.HomePageAction;
import pageAction.RegisterPageAction;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_04_SwitchPage extends BasePage {


    private WebDriver driver;
//    String projectPath = System.getProperty("user.dir");
    private HomePageAction homePageAction;
    private RegisterPageAction registerAction;
    private CommonPageAction commonPageAction;
    private LoginPageAction loginPageAction;
    private MyAccountPageAction myAccountPageAction;
    private String emailAddress;
    private String firstName, lastName, password ="";

    @BeforeClass
    public void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        homePageAction = PageGeneratorManager.getHomePageAction(driver);
        commonPageAction = PageGeneratorManager.getCommonPageAction(driver);
        registerAction = PageGeneratorManager.getRegisterPageAction(driver);
        loginPageAction = PageGeneratorManager.getLoginPageAction(driver);
        myAccountPageAction = PageGeneratorManager.getMyAccountPageAction(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        emailAddress = "afc" + generateFakeNumber() + "@email.vn";
        firstName = "Automation";
        lastName = "FC";
        password = "123456";

        driver.get("https://demo.nopcommerce.com/");

    }

    @Test
    public void User_01_Register(){
        homePageAction.clickToRegisterLink();

        System.out.println("Register page - Step 2: Input to required fields");
        registerAction.inputToTextbox("First name",firstName);
        registerAction.inputToTextbox("Last name",lastName);
        registerAction.inputToTextbox("Email",emailAddress);
        registerAction.inputToTextbox("Password",password);
        registerAction.inputToTextbox("Confirm password",password);

        System.out.println("Register page - Step 3: Click to Register button");
        registerAction.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify success message displayed");
        Assert.assertEquals(registerAction.getRegisterSuccessMessage(),"Your registration completed");
    }

    @Test
    public void User_02_Open_LoginPage(){
        System.out.println("Register page - Step 1: Click to 'Log in' link");
        commonPageAction.validateHeaderLinkIsDisplayed("Log in");
        registerAction.clickOnLoginLink();
        loginPageAction.loginHighLevel(emailAddress,password);
    }

    @Test
    public void User_03_Open_MyAccountPage(){
        homePageAction.clickOnMyAccountLink();
        myAccountPageAction.validateTitleOfMyAccountPage("My account - Customer info");
    }
    @AfterClass
    public  void closeBrowser(){
       // driver.quit();

    }


   private int generateFakeNumber(){

        Random rand = new Random();

        return rand.nextInt(9999);
    }



}
