package testcases.comNopcommerceUser;

import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.nopCommerce.user.*;
import commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_04_SwitchPage extends BasePage {


    private WebDriver driver;
//    String projectPath = System.getProperty("user.dir");
    private UserHomePageAction homePageAction;
    private UserRegisterPageAction registerAction;
    private UserCommonPageAction commonPageAction;
    private UserLoginPageAction loginPageAction;
    private UserMyAccountPageAction myAccountPageAction;
    private UserAddressPageAction addressPageAction;
    private UserCustomInforPageAction customInforPageAction;
    private UserMyProductReiewsPageAction myProductReiewsPageAction;
    private UserRewardPointsPageAction rewardPointsPageAction;
    private String emailAddress;
    private String firstName, lastName, password ="";

    @BeforeClass
    public void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        homePageAction = PageGeneratorManager.getUserHomePage(driver);
        commonPageAction = PageGeneratorManager.getUserCommonPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        emailAddress = "afc" + generateFakeNumber() + "@email.vn";
        firstName = "Automation";
        lastName = "FC";
        password = "123456";

        driver.get(GlobalConstants.PORTAL_PAGE_URL);

    }

    @Test
    public void User_01_Register(){
        registerAction = homePageAction.openRegisterPage();

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
        registerAction = PageGeneratorManager.getUserRegisterPage(driver);
        loginPageAction =  registerAction.clickOnLoginLink();
        loginPageAction.loginAsUser(emailAddress,password);
    }

    @Test
    public void User_03_Open_MyAccountPage(){
        myAccountPageAction = homePageAction.openMyAccountPage();
        myAccountPageAction.validateTitleOfMyAccountPage("My account - Customer info");

        addressPageAction = myAccountPageAction.openAddressPage(driver,"Addresses");
        customInforPageAction = addressPageAction.openCustomInforPage(driver,"Customer info");
        myProductReiewsPageAction = customInforPageAction.openMyProductReviewsPageAction(driver,"My product reviews");
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
