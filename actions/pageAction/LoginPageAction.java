package actions.pageAction;

import actions.commons.PageGeneratorManager;
import interfaces.pageUIs.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageAction extends commons.BasePage {

    private WebDriver driver;

    public LoginPageAction (WebDriver driver){
        this.driver = driver;
    }

    public void inputTextIntoEmailOrPasswordField(String typeField, String text){
        String xpath = "";
        if(typeField.equalsIgnoreCase("email")){
            xpath = String.format(LoginPageUI.EMAIL_PASSWORD_FIELD,"Email:");
        } else if (typeField.equalsIgnoreCase("password")){
            xpath = String.format(LoginPageUI.EMAIL_PASSWORD_FIELD,"Password:");
        }
        waitForElementClickable(driver,xpath);
        inputToElement(driver,xpath,text);
    }

    public pageAction.RegisterPageAction clickOnRegisterButton(){
        String xpath = LoginPageUI.LOGIN_REGISTER_BOTTON;
        waitForElementClickable(driver,xpath,"Register");
        clickToElement(driver,xpath,"Register");
        return PageGeneratorManager.getRegisterPageAction(driver);
    }

    public LoginPageAction clickOnLoginButton(){
        String xpath = LoginPageUI.LOGIN_REGISTER_BOTTON;
        waitForElementClickable(driver,xpath,"Log in");
        clickToElement(driver,xpath,"Log in");
        return PageGeneratorManager.getLoginPageAction(driver);
    }

    public void loginHighLevel(String account, String password){
        inputTextIntoEmailOrPasswordField("email",account);
        inputTextIntoEmailOrPasswordField("password",password);
        clickOnLoginButton();
    }

}
