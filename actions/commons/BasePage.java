package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {

    //Open URL
    public void openPageUrl(WebDriver driver, String pageUrl){
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver ){
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver){
        return  driver.getCurrentUrl();
    }

    public String getPageSourceCode(WebDriver driver){
        return driver.getPageSource();
    }


    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void refreshCurrentPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public  void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }

    public Alert waitForAlertPresence(WebDriver driver){
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        return explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver){
        waitForAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver){
        waitForAlertPresence(driver).dismiss();
    }

    public String getAlertText(WebDriver driver){
        return waitForAlertPresence(driver).getText();
    }

    public void sendkeyToAlert(WebDriver driver, String textValue){
        waitForAlertPresence(driver).sendKeys(textValue);
    }

    public void switchToWindowByID(WebDriver driver, String windowID){
        Set <String> allWindowIDs = driver.getWindowHandles();
        for (String id: allWindowIDs) {

            if(!id.equals(windowID)){
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String tabTitle){
        Set <String> allWindowIDs = driver.getWindowHandles();
        for(String id : allWindowIDs){
            driver.switchTo().window(id);
            String actualTitle = driver.getTitle();
            if(actualTitle.equals(tabTitle)){
                break;
            }
        }
   }

    public void closeAllTabWithoutParent(WebDriver driver, String parentID){
        Set<String> allWindowIDs = driver.getWindowHandles();
        for(String id : allWindowIDs){
            if(!id.equals(parentID)){
                driver.switchTo().window(id);
                driver.close();
            }
            driver.switchTo().window(parentID);
        }
    }

    public WebElement getWebElement(WebDriver driver, String xpathLocator){
       return driver.findElement(By.xpath(xpathLocator));
    }

    public void clickToElement(WebDriver driver, String xpathLocator){
        getWebElement(driver,xpathLocator).click();
    }

    public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue){
        getWebElement(driver,xpathLocator).clear();
        getWebElement(driver,xpathLocator).sendKeys(textValue);
    }

    public String getElementText(WebDriver driver, String xpathLocator){
       return getWebElement(driver,xpathLocator).getText();
    }





}
