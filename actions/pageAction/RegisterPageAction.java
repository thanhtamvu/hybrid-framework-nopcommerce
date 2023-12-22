package pageAction;

import commons.BasePage;
import commons.GetPropertiesValue;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageAction extends BasePage {

    private WebDriver driver;

        public RegisterPageAction(WebDriver driver){
        this.driver = driver;
    }

    public void clickToRegisterButton() {
            String button = GetPropertiesValue.getObjectRepository("RegisterPage","Register");
            String xpath = String.format(RegisterPageUI.REGISTER_BUTTON,button);
            waitForElementClickable(driver,xpath);
            clickToElement(driver,xpath);
    }

    public String getErrorMessageUnderTextArea(String errorMessageType) {
            String messageType = translateErrorMessage(errorMessageType);
            String xpath = String.format(RegisterPageUI.ERROR_MESSAGE,messageType);
            waitForElementVisible(driver,xpath);
            String text = getElementText(driver,xpath);
        return text;
    }

    private String translateErrorMessage(String errorMessageType ){
            if(errorMessageType.equalsIgnoreCase("First name")){
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","FIRSTNAME_ERROR_MESSAGE");
            } else if (errorMessageType.equalsIgnoreCase("Last name")) {
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","LASTNAME_ERROR_MESSAGE");
            }else if (errorMessageType.equalsIgnoreCase("Email")) {
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","EMAIL_ERROR_MESSAGE");
            }else if (errorMessageType.equalsIgnoreCase("Password")) {
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","PASSWORD_ERROR_MESSAGE");
            }else if (errorMessageType.equalsIgnoreCase("Confirm password")) {
                errorMessageType = GetPropertiesValue.getObjectRepository("RegisterPage","CONFIRMPASSWORD_ERROR_MESSAGE");
            }
            return errorMessageType;
    }

    public void inputToFirstnameTextbox(String firstName) {

    }

    public String inputToLastnameTextbox(String lastName) {
        return null;
    }

    public String inputToEmailTextbox(String number) {
        return null;
    }

    public String inputToPasswordTextbox(String password) {
        return null;
    }

    public String inputToConfirmPasswordTextbox(String password) {
        return null;
    }

    public String getRegisterSuccessMessage() {
        return null;
    }

    public String clickToRegisterLink() {
        return null;
    }

    public String getErrorExistingEmailMessage() {
        return null;
    }



//    public void clickToRegisterButton() {
//        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
//        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
//
//    }
//
//    public String getErrorMessageAtFirstnameTextbox() {
//        waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
//        return getElementText(driver,RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
//    }
//
//    public String getErrorMessageAtLastNameTextbox() {
//        waitForElementVisible(driver,RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
//        return getElementText(driver,RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
//    }
//
//    public String getErrorMessageAtEmailTextbox() {
//        waitForElementVisible(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);
//        return getElementText(driver,RegisterPageUI.EMAIL_ERROR_MESSAGE);
//    }
//
//
//    public String getErrorMessageAtPasswordTextbox() {
//        waitForElementVisible(driver,RegisterPageUI.PASSWORD_ERROR_MESSAGE);
//        return getElementText(driver,RegisterPageUI.PASSWORD_ERROR_MESSAGE);
//    }
//
//    public String getErrorMessageAtConfirmPasswordTextbox() {
//        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
//        return getElementText(driver,RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
//    }
//
//    public void inputToFirstnameTextbox(String firstName) {
//        waitForElementVisible(driver,RegisterPageUI.FIRST_NAME_TEXTBOX);
//        inputToElement(driver,RegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
//    }
//
//    public void inputToLastnameTextbox(String lastName) {
//        waitForElementVisible(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
//        inputToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lastName);
//    }
//
//    public void inputToEmailTextbox(String email) {
//        waitForElementVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
//        inputToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,email);
//    }
//
//    public void inputToPasswordTextbox(String password) {
//        waitForElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
//        inputToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,password);
//    }
//
//    public void inputToConfirmPasswordTextbox(String confirmPassword) {
//        waitForElementVisible(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
//        inputToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
//    }
//
//    public String getRegisterSuccessMessage() {
//        waitForElementVisible(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
//        return getElementText(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
//    }
//
//    public void clickToLoginLink() {
//        waitForElementClickable(driver, RegisterPageUI.LOGIN_LINK);
//        clickToElement(driver, RegisterPageUI.LOGIN_LINK);
//    }
//
//    public String getErrorExistingEmailMessage() {
//        waitForElementVisible(driver,RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
//        return getElementText(driver,RegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
//    }
//
//    public void clickToRegisterLink() {
//        waitForElementClickable(driver, RegisterPageUI.REGISTER_LINK);
//        clickToElement(driver, RegisterPageUI.REGISTER_LINK);
//    }
}
