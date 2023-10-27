package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ArrayList;
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

    public void switchToTabNumber(WebDriver driver, int tabNumber){

        List <String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(tabNumber -1));

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

    public void closeAllOpeningTabsExceptTheFirst(WebDriver driver){

        while(driver.getWindowHandles().size() > 1){

            switchToTabNumber(driver,2);
            driver.close();
            switchToTabNumber(driver,1);
        }

    }

    public By getByXpath (String xpathLocator){
        return By.xpath(xpathLocator);
    }

    public WebElement getWebElement(WebDriver driver, String xpathLocator){
       return driver.findElement(getByXpath(xpathLocator));
    }

    public List<WebElement> getListWebElement(WebDriver driver, String xpathlocator){
        return  driver.findElements(getByXpath(xpathlocator));
    }

    public void clickToElement(WebDriver driver, String xpathLocator){
        getWebElement(driver,xpathLocator).click();
    }

    public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue){
        WebElement element = getWebElement(driver,xpathLocator);
        element.clear();
        element.sendKeys(textValue);
    }

    public String getElementText(WebDriver driver, String xpathLocator){
       return getWebElement(driver,xpathLocator).getText();
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem){
        Select select = new Select(getWebElement(driver,xpathLocator));
        select.selectByValue(textItem);
    }

    public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator){
        Select select = new Select(getWebElement(driver,xpathLocator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String xpathLocator){
     Select select = new Select(getWebElement(driver, xpathLocator));
     return select.isMultiple();
    }

    public void sleepInSecond(long time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public void selectItemInDropdown(WebDriver driver, String parentXpath, String childXpath, String exptext){

        getWebElement(driver,parentXpath).click();
        sleepInSecond(1);

        WebDriverWait expliciwait = new WebDriverWait(driver,30);

        List <WebElement> allItems = expliciwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(exptext)){
                JavascriptExecutor jstExecutor = (JavascriptExecutor) driver;
                jstExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                sleepInSecond(1);
                item.click();
                break;
            }
        }

    }


    public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName){
        return getWebElement(driver,xpathLocator).getAttribute(attributeName);
    }

    public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName){
        return  getWebElement(driver,xpathLocator).getCssValue(propertyName);
    }


    public String GetHexaColorFromRgba(String rgbaValue){
        return Color.fromString(rgbaValue).asHex();
    }

    public int getElementSize(WebDriver driver, String xpathLocator){

        return getListWebElement(driver,xpathLocator).size();
    }

    public void checkOrUncheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator,String expText, String checkOrUncheck){
        List<WebElement> elements = getListWebElement(driver, xpathLocator);

        for (WebElement item : elements){
            if(checkOrUncheck.equalsIgnoreCase("check")){
                if (item.getAttribute("value").trim().equals(expText) && !item.isSelected()){
                    item.click();
                }
            }if (checkOrUncheck.equalsIgnoreCase("Uncheck")){
                if(item.getAttribute("value").trim().equals(expText) && item.isSelected()){
                    item.click();
                }
            }
        }
    }

}
