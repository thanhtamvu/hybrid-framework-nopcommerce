package actions.pageObjects.nopCommerce.user;

import interfaces.pageUIs.nopCommerce.user.UserCommonPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserCommonPageAction extends commons.BasePage {

    WebDriver driver;

    public UserCommonPageAction(WebDriver driver){
        this.driver = driver;
    }

    public void validateHeaderLinkIsDisplayed(String header){
        String xpath = UserCommonPageUI.HEADER_LINK;
        waitForElementVisible(driver,xpath,header);
        Assert.assertEquals(getElementText(driver,xpath,header),header,"Header link: " + header + "should be displayed");
    }

}
