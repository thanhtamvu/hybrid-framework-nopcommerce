package comNopcommerceUser;

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

public class Level_03_Page_Object {


    private WebDriver driver;
//    String projectPath = System.getProperty("user.dir");
    private BasePage basePage = new BasePage();
    private HomePageAction homePageAction;
    private RegisterPageAction registerAction;

    private String emailAddress;
    private String firstName, lastName, password ="";

    @BeforeClass
    public void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        basePage = new BasePage();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        homePageAction = new HomePageAction(driver);
        registerAction = new RegisterPageAction(driver);

        emailAddress = "afc" + generateFakeNumber() + "@email.vn";
        firstName = "Automation";
        lastName = "FC";
        password = "123456";

        driver.get("https://demo.nopcommerce.com/");

    }

    @Test
    public void Register_01_Empty_Data(){

//        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
//        basePage.clickToElement(driver,"//a[@class='ico-register']");

        System.out.println("Register_01 - Step 1: Click to Register link");
        homePageAction.clickToRegisterLink();


//        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
//        basePage.clickToElement(driver,"//button[@id='register-button']");
        System.out.println("Register_02 - Step 2: Click to Register button");
        registerAction.clickToRegisterButton();

        System.out.println("Register_03 - Step 03: Verify error message displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("First name"),"First name is required.","First name is required. Should be displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("Last name"),"Last name is required.","Last name is required. Should be displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("Email"),"Email is required.","Email is required. Should be displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("Password"),"Password is required.","Password is required. Should be displayed");
        Assert.assertEquals(registerAction.getErrorMessageUnderTextArea("Confirm password"),"Password is required.","Password is required. Should be displayed");


    }

    @Test
//    public void TC_02_Invalid_Email(){
//
//        System.out.println("Home page - Step 1: Click to Register link");
//        homePageAction.clickToRegisterLink();
//
//        System.out.println("Register page - Step 2: Input to required fields");
//        registerAction.inputToFirstnameTextbox(firstName);
//        registerAction.inputToLastnameTextbox(lastName);
//        registerAction.inputToEmailTextbox("12345");
//        registerAction.inputToPasswordTextbox(password);
//        registerAction.inputToConfirmPasswordTextbox(password);
//
//        System.out.println("Register page - Step 3: Click to Register button");
//        registerAction.clickToRegisterButton();
//
//        System.out.println("Register Page - Step 04: Verify error message displayed");
//        Assert.assertEquals(registerAction.getErrorMessageAtEmailTextbox(),"Wrong email");
//
//    }
//
//    @Test
//    public void TC_03_Register_Success(){
//
//        System.out.println("Home page - Step 1: Click to Register link");
//        homePageAction.clickToRegisterLink();
//
//        System.out.println("Register page - Step 2: Input to required fields");
//        registerAction.inputToFirstnameTextbox(firstName);
//        registerAction.inputToLastnameTextbox(lastName);
//        registerAction.inputToEmailTextbox(emailAddress);
//        registerAction.inputToPasswordTextbox(password);
//        registerAction.inputToConfirmPasswordTextbox(password);
//
//        System.out.println("Register page - Step 3: Click to Register button");
//        registerAction.clickToRegisterButton();
//
//        System.out.println("Register Page - Step 04: Verify success message displayed");
//        Assert.assertEquals(registerAction.getRegisterSuccessMessage(),"Your registration completed");
//
//        System.out.println("Register Page - Step 05: Click to Register link");
//        registerAction.clickToRegisterLink();
//
//
//    }
//
//    @Test
//    public void TC_04_Register_Existing_Email(){
//        System.out.println("Home page - Step 1: Click to Register link");
//        homePageAction.clickToRegisterLink();
//
//        System.out.println("Register page - Step 2: Input to required fields");
//        registerAction.inputToFirstnameTextbox(firstName);
//        registerAction.inputToLastnameTextbox(lastName);
//        registerAction.inputToEmailTextbox(emailAddress);
//        registerAction.inputToPasswordTextbox(password);
//        registerAction.inputToConfirmPasswordTextbox(password);
//
//        System.out.println("Register page - Step 3: Click to Register button");
//        registerAction.clickToRegisterButton();
//
//        System.out.println("Register Page - Step 04: Verify error message displayed");
//        Assert.assertEquals(registerAction.getErrorExistingEmailMessage(),"The specified email already exists");
//
//    }
//    @Test
//    public void TC_05_Register_Password_Less_Than_6_Chars(){
//        System.out.println("Home page - Step 1: Click to Register link");
//        homePageAction.clickToRegisterLink();
//
//        System.out.println("Register page - Step 2: Input to required fields");
//        registerAction.inputToFirstnameTextbox(firstName);
//        registerAction.inputToLastnameTextbox(lastName);
//        registerAction.inputToEmailTextbox(emailAddress);
//        registerAction.inputToPasswordTextbox("123");
//        registerAction.inputToConfirmPasswordTextbox("123");
//
//        System.out.println("Register page - Step 3: Click to Register button");
//        registerAction.clickToRegisterButton();
//
//        System.out.println("Register Page - Step 04: Verify error message displayed");
//        Assert.assertEquals(registerAction.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");
//
//
//
//    }
//
//    @Test
//    public void TC_06_Register_Invalid_Confirm_Password(){
//        System.out.println("Home page - Step 1: Click to Register link");
//        homePageAction.clickToRegisterLink();
//
//        System.out.println("Register page - Step 2: Input to required fields");
//        registerAction.inputToFirstnameTextbox(firstName);
//        registerAction.inputToLastnameTextbox(lastName);
//        registerAction.inputToEmailTextbox(emailAddress);
//        registerAction.inputToPasswordTextbox(password);
//        registerAction.inputToConfirmPasswordTextbox(emailAddress);
//
//        System.out.println("Register page - Step 3: Click to Register button");
//        registerAction.clickToRegisterButton();
//
//        System.out.println("Register Page - Step 04: Verify error message displayed");
//        Assert.assertEquals(registerAction.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");
//
//
//    }


    @AfterClass
    public  void closeBrowser(){
       // driver.quit();

    }


   private int generateFakeNumber(){

        Random rand = new Random();

        return rand.nextInt(9999);
    }



}
