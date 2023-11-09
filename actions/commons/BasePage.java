package commons;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class BasePage {

   private long longTimeout = 30;
   private long shortTimeout = 5;
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
        WebDriverWait explicitWait = new WebDriverWait(driver,longTimeout );
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

    private By getByXpath (String xpathLocator){
        return By.xpath(xpathLocator);
    }

    private WebElement getWebElement(WebDriver driver, String xpathLocator){
       return driver.findElement(getByXpath(xpathLocator));
    }

    private List<WebElement> getListWebElement(WebDriver driver, String xpathlocator){
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



    public void selectItemInDropdown(WebDriver driver, String parentXpath, String childXpath, String expText){

        getWebElement(driver,parentXpath).click();
        sleepInSecond(1);

        WebDriverWait expliciwait = new WebDriverWait(driver,longTimeout);

        List <WebElement> allItems = expliciwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpath)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expText)){
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

    public boolean isElementDisplayed(WebDriver driver, String xpathLocator){
        return getWebElement(driver,xpathLocator).isDisplayed();
    }

    public boolean isElementEnable(WebDriver driver, String xpathLocator){
        return getWebElement(driver, xpathLocator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String xpathLocator){
        return  getWebElement(driver, xpathLocator).isSelected();
    }

    public void switchToFrameIframe(WebDriver driver, String xpathLocator){
        driver.switchTo().frame(getWebElement(driver, xpathLocator));
    }

    public void swicthToDefaulContent(WebDriver driver){
        driver.switchTo().defaultContent();
    }

    public void hoverMouseToElemnt(WebDriver driver, String xpathLocator){
        Actions act = new Actions(driver);
        act.moveToElement(getWebElement(driver, xpathLocator)).perform();
    }

    public void scrollToBottomPage(WebDriver driver){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void highlightElement(WebDriver driver, String xpathLocator){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getWebElement(driver, xpathLocator);
        String originalStyle = element.getAttribute("style");
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",element,"style","border: 2px solid red;");
        sleepInSecond(1);
        jsExecutor.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",element,"style",originalStyle);
    }

    public void clickToElementByJs(WebDriver driver, String xpathLocator){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click;", getWebElement(driver, xpathLocator));
    }

    public void scrollToElement(WebDriver driver, String xpathLocator){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
    }

    public void removeAttributeInDOM(WebDriver driver, String attributeRemove){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('"+ attributeRemove + "');", getWebElement(driver, attributeRemove));
    }

    public boolean areJQueryAndJSLoadedSuccess(WebDriver driver, long timeOut){
        WebDriverWait explicitwait = new WebDriverWait(driver,timeOut);

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        ExpectedCondition <Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply( WebDriver driver) {
                try{
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                }catch (Exception e){
                    return true;
                }
            }
        };

        ExpectedCondition <Boolean> jsLoad = new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                return  jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        return explicitwait.until(jQueryLoad) && explicitwait.until(jsLoad);
    }

    public String getElementValidationMessage(WebDriver driver, String xpathLocator){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return  (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
    }

    public boolean isImageLoaded (WebDriver driver, String xpathLocator){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",getWebElement(driver, xpathLocator));
        return status;
    }

    public void waitForElementVisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForAllElementVisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
    }

    public void waitForElementInvisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
    }

    public void waitForAllElementInvisible(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
    }

    public void waitForElementClickable(WebDriver driver, String xpathLocator){
        WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
        explicitWait.until(ExpectedConditions.invisibilityOf(getWebElement(driver, xpathLocator)));
    }







}
