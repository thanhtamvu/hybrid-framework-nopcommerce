package actions.pageObjects.nopCommerce.user;

import actions.commons.PageGeneratorManager;
import interfaces.pageUIs.nopCommerce.user.UserLoginPageUI;
import org.openqa.selenium.WebDriver;

public class UserLoginPageAction extends commons.BasePage {

    private WebDriver driver;

    public UserLoginPageAction(WebDriver driver){
        this.driver = driver;
    }

    public void inputTextIntoEmailOrPasswordField(String typeField, String text){
        String xpath = "";
        if(typeField.equalsIgnoreCase("email")){
            xpath = String.format(UserLoginPageUI.EMAIL_PASSWORD_FIELD,"Email:");
        } else if (typeField.equalsIgnoreCase("password")){
            xpath = String.format(UserLoginPageUI.EMAIL_PASSWORD_FIELD,"Password:");
        }
        waitForElementClickable(driver,xpath);
        inputToElement(driver,xpath,text);
    }

    public UserRegisterPageAction clickOnRegisterButton(){
        String xpath = UserLoginPageUI.LOGIN_REGISTER_BOTTON;
        waitForElementClickable(driver,xpath,"Register");
        clickToElement(driver,xpath,"Register");
        return PageGeneratorManager.getUserRegisterPage(driver);
    }

    public UserHomePageAction clickOnLoginButton(){
        String xpath = UserLoginPageUI.LOGIN_REGISTER_BOTTON;
        waitForElementClickable(driver,xpath,"Log in");
        clickToElement(driver,xpath,"Log in");
        return PageGeneratorManager.getUserHomePage(driver);
    }

    public UserHomePageAction loginAsUser(String account, String password){
        inputTextIntoEmailOrPasswordField("email",account);
        inputTextIntoEmailOrPasswordField("password",password);
        return clickOnLoginButton();
    }

}
