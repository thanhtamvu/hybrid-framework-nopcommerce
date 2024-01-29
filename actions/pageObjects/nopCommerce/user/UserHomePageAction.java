package actions.pageObjects.nopCommerce.user;

import actions.commons.PageGeneratorManager;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import interfaces.pageUIs.nopCommerce.user.UserHomePageUI;

public class UserHomePageAction extends BasePage {

    private WebDriver driver;

    public UserHomePageAction(WebDriver driver){
        this.driver = driver;
    }
    public UserRegisterPageAction openRegisterPage() {
        String xpath = String.format(UserHomePageUI.HEADER_LINK,"Register");
        waitForElementClickable(driver,xpath);
        clickToElement(driver,xpath);
        return PageGeneratorManager.getUserRegisterPage(driver);
    }

    public UserLoginPageAction openLoginPage() {
        String xpath = String.format(UserHomePageUI.HEADER_LINK,"Log in");
        waitForElementClickable(driver,xpath);
        clickToElement(driver,xpath);
        return PageGeneratorManager.getUserLoginPage(driver);
    }

    public UserMyAccountPageAction openMyAccountPage(){
        String xpath = UserHomePageUI.HEADER_LINK;
        waitForElementClickable(driver,xpath,"My account");
        clickToElement(driver,xpath,"My account");
        return PageGeneratorManager.getUserMyAccountPage(driver);
    }


}
