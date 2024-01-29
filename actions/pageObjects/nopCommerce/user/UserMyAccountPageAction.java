package actions.pageObjects.nopCommerce.user;

import interfaces.pageUIs.nopCommerce.user.UserMyAccountPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserMyAccountPageAction extends commons.BasePage {

    private WebDriver driver;

    public UserMyAccountPageAction(WebDriver driver){
        this.driver = driver;
    }

    public void validateTitleOfMyAccountPage(String title){
        String xpath = UserMyAccountPageUI.MY_ACCOUNT_TITLE;
        waitForElementVisible(driver,xpath,title);
        Assert.assertEquals(getElementText(driver,xpath,title),title,"The " + title + " should be displayed");
    }

}
