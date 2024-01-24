package actions.pageAction;

import interfaces.pageUIs.CommonPageUI;
import interfaces.pageUIs.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CommonPageAction extends commons.BasePage {

    WebDriver driver;

    public CommonPageAction (WebDriver driver){
        this.driver = driver;
    }

    public void validateHeaderLinkIsDisplayed(String header){
        String xpath = CommonPageUI.HEADER_LINK;
        waitForElementVisible(driver,xpath,header);
        Assert.assertEquals(getElementText(driver,xpath,header),header,"Header link: " + header + "should be displayed");
    }

}
