package actions.commons;

import actions.pageObjects.nopCommerce.admin.AdminLoginPageAction;
import actions.pageObjects.nopCommerce.user.*;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager extends commons.BasePage {

    public static UserHomePageAction getUserHomePage(WebDriver driver){
        return new UserHomePageAction(driver);
    }

    public static UserRegisterPageAction getUserRegisterPage(WebDriver driver){
        return  new UserRegisterPageAction(driver);
    }

    public static UserLoginPageAction getUserLoginPage(WebDriver driver){
        return new UserLoginPageAction(driver);
    }

    public static UserMyAccountPageAction getUserMyAccountPage(WebDriver driver){
        return new UserMyAccountPageAction(driver);
    }

    public static UserCommonPageAction getUserCommonPage(WebDriver driver){
        return new UserCommonPageAction(driver);
    }

    public static UserAddressPageAction getUserAddressPage(WebDriver driver){
        return new UserAddressPageAction(driver);
    }

    public static UserCustomInforPageAction getUserCustomPage(WebDriver driver){
        return new UserCustomInforPageAction(driver);
    }

    public static UserMyProductReiewsPageAction getUserMyProductReiewsPage(WebDriver driver){
        return new UserMyProductReiewsPageAction(driver);
    }

    public static UserRewardPointsPageAction getUserRewardPointsPage(WebDriver driver){
        return new UserRewardPointsPageAction(driver);
    }

    public static AdminLoginPageAction getAdminLoginPage(WebDriver driver){
        return new AdminLoginPageAction(driver);
    }

}
