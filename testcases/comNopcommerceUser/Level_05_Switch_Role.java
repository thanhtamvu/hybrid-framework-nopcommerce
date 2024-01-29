package testcases.comNopcommerceUser;

import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import actions.pageObjects.nopCommerce.admin.AdminLoginPageAction;
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

public class Level_05_Switch_Role extends BasePage {


    private WebDriver driver;
//    String projectPath = System.getProperty("user.dir");
    private UserHomePageAction UserHomePage;
    private UserRegisterPageAction UserRegisterPage;
    private UserCommonPageAction UserCommonPage;
    private UserLoginPageAction UserLoginPage;
    private AdminLoginPageAction adminLoginPage;
    private String emailAddress;
    private String firstName, lastName, password ="";

    @BeforeClass
    public void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        UserHomePage = PageGeneratorManager.getUserHomePage(driver);
        UserCommonPage = PageGeneratorManager.getUserCommonPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        emailAddress = "afc" + generateFakeNumber() + "@email.vn";
        firstName = "Automation";
        lastName = "FC";
        password = "123456";

        driver.get(GlobalConstants.PORTAL_PAGE_URL);

    }

    @Test
    public void Role_01_User(){
        UserRegisterPage = UserHomePage.openRegisterPage();

        System.out.println("Register page - Step 2: Input to required fields");
        UserRegisterPage.inputToTextbox("First name",firstName);
        UserRegisterPage.inputToTextbox("Last name",lastName);
        UserRegisterPage.inputToTextbox("Email",emailAddress);
        UserRegisterPage.inputToTextbox("Password",password);
        UserRegisterPage.inputToTextbox("Confirm password",password);

        System.out.println("Register page - Step 3: Click to Register button");
        UserRegisterPage.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify success message displayed");
        Assert.assertEquals(UserRegisterPage.getRegisterSuccessMessage(),"Your registration completed");

        System.out.println("Register page - Step 5: Login as user role");
        UserCommonPage.validateHeaderLinkIsDisplayed("Log in");
        UserRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
        UserLoginPage =  UserRegisterPage.clickOnLoginLink();
        UserHomePage = UserLoginPage.loginAsUser(emailAddress,password);
    }

    @Test
    public void Role_01_Admin(){
        UserHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
    }

    @Test
    public void User_03_Open_MyAccountPage(){
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
