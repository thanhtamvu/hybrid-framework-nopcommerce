package pageAction;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageAction extends BasePage {

    private WebDriver driver;

    public HomePageAction(WebDriver driver){
        this.driver = driver;
    }
    public void clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver,HomePageUI.REGISTER_LINK);
    }
}
