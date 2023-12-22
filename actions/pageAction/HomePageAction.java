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
        String xpath = String.format(HomePageUI.REGISTER_LINK,"Register");
        waitForElementClickable(driver, xpath);
        clickToElement(driver,xpath);
    }
}
