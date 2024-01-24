package actions.pageAction;

import interfaces.pageUIs.MyAccountPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyAccountPageAction extends commons.BasePage {

    private WebDriver driver;

    public MyAccountPageAction (WebDriver driver){
        this.driver = driver;
    }

    public void validateTitleOfMyAccountPage(String title){
        String xpath = MyAccountPageUI.MY_ACCOUNT_TITLE;
        waitForElementVisible(driver,xpath,title);
        Assert.assertEquals(getElementText(driver,xpath,title),title,"The " + title + " should be displayed");
    }

}
