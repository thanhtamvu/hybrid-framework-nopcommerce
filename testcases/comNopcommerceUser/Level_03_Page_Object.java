package comNopcommerceUser;

import actions.commons.PageGeneratorManager;
import actions.pageObjects.nopCommerce.user.UserLoginPageAction;
import commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import actions.pageObjects.nopCommerce.user.UserHomePageAction;
import actions.pageObjects.nopCommerce.user.UserRegisterPageAction;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Level_03_Page_Object extends BasePage {


    private WebDriver driver;
//    String projectPath = System.getProperty("user.dir");
    private UserHomePageAction homePageAction;
    private UserRegisterPageAction registerAction;
    private UserLoginPageAction loginPageAction;
    private String emailAddress;
    private String firstName, lastName, password ="";

    @BeforeClass
    public void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        homePageAction = PageGeneratorManager.getUserHomePage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        emailAddress = "afc" + generateFakeNumber() + "@email.vn";
        firstName = "Automation";
        lastName = "FC";
        password = "123456";

        driver.get("https://demo.nopcommerce.com/");

    }

    @Test
    public void Register_01_Empty_Data(){
        System.out.println("Register_01 - Step 1: Click to Register link");

        registerAction = homePageAction.clickToRegisterLink();

        System.out.println("Register_02 - Step 2: Click to Register button");
        registerAction.clickToRegisterButton();

        System.out.println("Register_03 - Step 03: Verify error message displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("FirstName"),"First name is required.","First name is required. Should be displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("LastName"),"Last name is required.","Last name is required. Should be displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("Email"),"Email is required.","Email is required. Should be displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("Password"),"Password is required.","Password is required. Should be displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("ConfirmPassword"),"Password is required.","Password is required. Should be displayed");
    }

    @Test
    public void TC_02_Invalid_Email(){
        System.out.println("Home page - Step 1: Click to Register link");
        registerAction = homePageAction.clickToRegisterLink();

        System.out.println("Register page - Step 2: Input to required fields");
        registerAction.inputToTextbox("First name",firstName);
        registerAction.inputToTextbox("Last name",lastName);
        registerAction.inputToTextbox("Email","12345");
        registerAction.inputToTextbox("Password",password);
        registerAction.inputToTextbox("Confirm password",password);

        System.out.println("Register page - Step 3: Click to Register button");
        registerAction.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify error message displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("Email"),"Wrong email","The messsage should be displayed: Wrong email");
    }

    @Test
    public void TC_03_Register_Success(){
        System.out.println("Home page - Step 1: Click to Register link");
        registerAction =homePageAction.clickToRegisterLink();

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

        System.out.println("Register Page - Step 05: Click to Register link");
        registerAction.clickToRegisterLink();
    }

    @Test
    public void TC_04_Register_Existing_Email(){
        System.out.println("Home page - Step 1: Click to Register link");
        registerAction = homePageAction.clickToRegisterLink();

        System.out.println("Register page - Step 2: Input to required fields");
        registerAction.inputToTextbox("First name",firstName);
        registerAction.inputToTextbox("Last name",lastName);
        registerAction.inputToTextbox("Email",emailAddress);
        registerAction.inputToTextbox("Password",password);
        registerAction.inputToTextbox("Confirm password",password);

        System.out.println("Register page - Step 3: Click to Register button");
        registerAction.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify error message displayed");
        Assert.assertEquals(registerAction.getErrorExistingEmailMessage(),"The specified email already exists");
    }
    @Test
    public void TC_05_Register_Password_Less_Than_6_Chars(){
        System.out.println("Home page - Step 1: Click to Register link");
        registerAction = homePageAction.clickToRegisterLink();

        System.out.println("Register page - Step 2: Input to required fields");
        registerAction.inputToTextbox("First name",firstName);
        registerAction.inputToTextbox("Last name",lastName);
        registerAction.inputToTextbox("Email",emailAddress);
        registerAction.inputToTextbox("Password","123");
        registerAction.inputToTextbox("Confirm password","123");

        System.out.println("Register page - Step 3: Click to Register button");
        registerAction.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify error message displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("Password"),"Password must meet the following rules:\nmust have at least 6 characters");
    }

    @Test
    public void TC_06_Register_Invalid_Confirm_Password(){
        System.out.println("Home page - Step 1: Click to Register link");
        registerAction = homePageAction.clickToRegisterLink();

        System.out.println("Register page - Step 2: Input to required fields");
        registerAction.inputToTextbox("First name",firstName);
        registerAction.inputToTextbox("Last name",lastName);
        registerAction.inputToTextbox("Email",emailAddress);
        registerAction.inputToTextbox("Password",password);
        registerAction.inputToTextbox("Confirm password",emailAddress);

        System.out.println("Register page - Step 3: Click to Register button");
        registerAction.clickToRegisterButton();

        System.out.println("Register Page - Step 04: Verify error message displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("ConfirmPassword"),"The password and confirmation password do not match.");
    }

    @Test
    public void TC_07_Click_On_MyAccountLink_To_Open_MyAccountPage(){
        System.out.println("Home page - Step 1: Click to Register link");
        registerAction =homePageAction.clickToRegisterLink();

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

        System.out.println("Register Page - Step 05: Click to Log in link");
        loginPageAction = registerAction.clickOnLoginLink();

        System.out.println("Login Page - Step 06: Log in successfully");
        loginPageAction.inputTextIntoEmailOrPasswordField("email",emailAddress);
        loginPageAction.inputTextIntoEmailOrPasswordField("password",password);
        loginPageAction.clickOnLoginButton();

        System.out.println("Home Page - Step 07: Click on 'My account' link");
        homePageAction.clickOnMyAccountLink();

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
