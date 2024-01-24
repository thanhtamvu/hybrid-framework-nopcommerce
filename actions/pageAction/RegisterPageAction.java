package pageAction;

import actions.commons.PageGeneratorManager;
import actions.pageAction.LoginPageAction;
import commons.BasePage;
import commons.GetPropertiesValue;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageAction extends BasePage {

    private WebDriver driver;

        public RegisterPageAction(WebDriver driver){
        this.driver = driver;
    }

    public RegisterPageAction clickToRegisterButton() {
        String button = GetPropertiesValue.getObjectRepository("RegisterPage", "REGISTER_BUTTON");
        String xpath = String.format(RegisterPageUI.REGISTER_BUTTON, button);
        waitForElementClickable(driver, xpath);
        clickToElement(driver, xpath);
        return PageGeneratorManager.getRegisterPageAction(driver);
    }

    public String getErrorMessageUnderTextArea(String errorMessageType) {
            String xpath = translateErrorMessageXpath(errorMessageType);
            waitForElementVisible(driver,xpath);
            String text = getElementText(driver,xpath);
        return text;
    }

    private String translateErrorMessageXpath(String typeOfField){
            String xpath ="";
            if(typeOfField.equalsIgnoreCase("FirstName")){
                xpath = String.format(RegisterPageUI.ERROR_MESSAGE,"FirstName");
            } else if(typeOfField.equalsIgnoreCase("LastName")){
                xpath = String.format(RegisterPageUI.ERROR_MESSAGE,"LastName");
            } else if(typeOfField.equalsIgnoreCase("Email")){
                xpath = String.format(RegisterPageUI.ERROR_MESSAGE,"Email");
            } else if(typeOfField.equalsIgnoreCase("Password")){
                xpath = String.format(RegisterPageUI.ERROR_MESSAGE,"Password");
            } else if(typeOfField.equalsIgnoreCase("ConfirmPassword")){
                xpath = String.format(RegisterPageUI.ERROR_MESSAGE,"ConfirmPassword");
            }
            return xpath;
    }

    public String translateErrorMessage(String errorMessageType ){
            if(errorMessageType.equalsIgnoreCase("First name")){
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","FIRSTNAME_ERROR_MESSAGE");
            } else if (errorMessageType.equalsIgnoreCase("Last name")) {
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","LASTNAME_ERROR_MESSAGE");
            }else if (errorMessageType.equalsIgnoreCase("Email")) {
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","EMAIL_ERROR_MESSAGE");
            }else if (errorMessageType.equalsIgnoreCase("Wrong email")) {
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","WRONG_EMAIL");
            }else if (errorMessageType.equalsIgnoreCase("Password")) {
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","PASSWORD_ERROR_MESSAGE");
            }else if (errorMessageType.equalsIgnoreCase("Confirm password")) {
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","CONFIRMPASSWORD_ERROR_MESSAGE");
            }
            return errorMessageType;
    }

    public void inputToTextbox(String typeOfTextbox, String text) {
            String xpath = "";
            if (typeOfTextbox.equalsIgnoreCase("First name")){
                xpath = String.format(RegisterPageUI.TEXTAERA_EMAIL_PASSWORD_TYPE,"FirstName");
            } else if (typeOfTextbox.equalsIgnoreCase("Last name")){
                xpath = String.format(RegisterPageUI.TEXTAERA_EMAIL_PASSWORD_TYPE,"LastName");
            } else if (typeOfTextbox.equalsIgnoreCase("Email")){
                xpath = String.format(RegisterPageUI.TEXTAERA_EMAIL_PASSWORD_TYPE,"Email");
            } else if (typeOfTextbox.equalsIgnoreCase("Password")){
                xpath = String.format(RegisterPageUI.TEXTAERA_EMAIL_PASSWORD_TYPE,"Password");
            } else if (typeOfTextbox.equalsIgnoreCase("Confirm password")){
                xpath = String.format(RegisterPageUI.TEXTAERA_EMAIL_PASSWORD_TYPE,"ConfirmPassword");
            }
            waitForElementVisible(driver,xpath);
            inputToElement(driver,xpath,text);
    }

    public String getRegisterSuccessMessage() {
            String xpath = RegisterPageUI.REGISTER_SUCCESS_MESSAGE;
            waitForElementVisible(driver,xpath);
        return getElementText(driver,xpath);
    }

    public void clickToRegisterLink() {
        String button = GetPropertiesValue.getObjectRepository("RegisterPage", "REGISTER_BUTTON");
        String xpath = String.format(RegisterPageUI.HEADER_LINK,button);
        waitForElementClickable(driver,xpath);
        clickToElement(driver,xpath);
    }

    public String getErrorExistingEmailMessage() {
        String xpath = RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE;
        waitForElementVisible(driver,xpath);
        return getElementText(driver,xpath);
    }

    public pageAction.HomePageAction clickOnLogOutLink(){
            String xpath = RegisterPageUI.HEADER_LINK;
            waitForElementClickable(driver,xpath,"Log out");
            clickToElement(driver,xpath,"Log out");
            return PageGeneratorManager.getHomePageAction(driver);
    }

    public LoginPageAction clickOnLoginLink(){
            String xpath = RegisterPageUI.HEADER_LINK;
            waitForElementClickable(driver,xpath,"Log in");
            clickToElement(driver,xpath,"Log in");
            return PageGeneratorManager.getLoginPageAction(driver);
    }

}
