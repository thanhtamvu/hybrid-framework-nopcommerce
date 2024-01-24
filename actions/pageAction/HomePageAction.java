package pageAction;

import actions.commons.PageGeneratorManager;
import actions.pageAction.LoginPageAction;
import actions.pageAction.MyAccountPageAction;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageAction extends BasePage {

    private WebDriver driver;

    public HomePageAction(WebDriver driver){
        this.driver = driver;
    }
    public pageAction.RegisterPageAction clickToRegisterLink() {
        String xpath = String.format(HomePageUI.HEADER_LINK,"Register");
        waitForElementClickable(driver,xpath);
        clickToElement(driver,xpath);
        return PageGeneratorManager.getRegisterPageAction(driver);
    }

    public LoginPageAction clickToLoginLink() {
        String xpath = String.format(HomePageUI.HEADER_LINK,"Log in");
        waitForElementClickable(driver,xpath);
        clickToElement(driver,xpath);
        return PageGeneratorManager.getLoginPageAction(driver);
    }

    public MyAccountPageAction clickOnMyAccountLink(){
        String xpath = HomePageUI.HEADER_LINK;
        waitForElementClickable(driver,xpath,"My account");
        clickToElement(driver,xpath,"My account");
        return PageGeneratorManager.getMyAccountPageAction(driver);
    }


}
