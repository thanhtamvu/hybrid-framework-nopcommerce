package actions.commons;

import actions.pageAction.CommonPageAction;
import actions.pageAction.LoginPageAction;
import actions.pageAction.MyAccountPageAction;
import org.openqa.selenium.WebDriver;
import pageAction.HomePageAction;

public class PageGeneratorManager extends commons.BasePage {

    public static pageAction.HomePageAction getHomePageAction(WebDriver driver){
        return new HomePageAction(driver);
    }

    public static pageAction.RegisterPageAction getRegisterPageAction(WebDriver driver){
        return  new pageAction.RegisterPageAction(driver);
    }

    public static LoginPageAction getLoginPageAction(WebDriver driver){
        return new LoginPageAction(driver);
    }

    public static MyAccountPageAction getMyAccountPageAction(WebDriver driver){
        return new MyAccountPageAction(driver);
    }

    public static CommonPageAction getCommonPageAction(WebDriver driver){
        return new CommonPageAction(driver);
    }
}
