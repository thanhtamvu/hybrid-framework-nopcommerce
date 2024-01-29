package actions.pageObjects.nopCommerce.admin;

import interfaces.pageUIs.nopCommerce.admin.AdminLoginPageUI;
import org.openqa.selenium.WebDriver;

public class AdminLoginPageAction extends commons.BasePage {

    private WebDriver driver;

    public AdminLoginPageAction (WebDriver driver){
        this.driver = driver;
    }

    public void inputToUserNameOrPasswordTextbox(String textboxType, String text){
        String xpath = "";
        if(textboxType.equalsIgnoreCase("email")){
            xpath = String.format(AdminLoginPageUI.EMAIL_PASSWORD_TEXTBOX,"Email");
        } else if (textboxType.equalsIgnoreCase("password")) {
            xpath = String.format(AdminLoginPageUI.EMAIL_PASSWORD_TEXTBOX,"Password");
        }
        waitForElementClickable(driver,xpath);
        inputToElement(driver,xpath,text);
    }

}
