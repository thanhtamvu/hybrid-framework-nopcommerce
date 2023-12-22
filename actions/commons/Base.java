package commons;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Base {
//    private Logger logger = Logger.getLogger(KeyWord.class.getSimpleName());
//
//    public static int waitTime = 15;
//    public static final int smallTimeOut = 1000;
//
//    public enum Element_Type {
//        DISPLAYED, ISENABLE, ISSELECTED, HIDDEN, TEXT_VALUE, NOT_EXIST
//    }
//
//
//    /***************Functions: Waiting Element function ( Ex: Wait for clickable, wait for visible,... *************/
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait element to be visible.
//     */
//    public void waitForVisibleElement(WebElement element, String elementName) {
//        logger.info("+++ Wait For Visible Element: " + elementName);
//        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @param waitTimeOut Wait Time out
//     * @Description In order to wait element to be visible.
//     */
//    public void waitForVisibleElement(WebElement element, String elementName, int waitTimeOut) {
//        logger.info("+++ Wait For Visible Element: " + elementName);
//        WebDriverWait wait = new WebDriverWait(getDriver(), waitTimeOut);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    /**
//     * @Description In order to wait element to be present by locator.
//     */
//    public void waitForPresentOfLocator(By by) {
//        logger.info("+++ Wait For Present Of Locator");
//        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
//        wait.until(ExpectedConditions.presenceOfElementLocated(by));
//    }
//
//    /**
//     * @Description In order to wait element to be visible by locator.
//     */
//    public void waitForVisibleOfLocator(By by) {
//        logger.info("+++ Wait For Visible Of Locator");
//        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//    }
//
//    public boolean isClickable(WebElement webe, int timeout) {
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
//            wait.until(ExpectedConditions.elementToBeClickable(webe));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    /**
//     * @Description In order to wait element to be visible by locator with seconds input.
//     */
//    public boolean waitForVisibleOfLocator(By locator, int seconds) {
//        logger.info("+++ Wait For Visible Of Locator by seconds");
//        boolean isResult = false;
//        try {
//            int i = 0;
//            while (i < seconds) {
//                try {
//                    getDriver().findElement(locator);
//                    isResult = true;
//                    break;
//                } catch (Exception ex) {
//                }
//                try {
//                    Thread.sleep(smallTimeOut);
//                    i++;
//                } catch (Exception e) {
//
//                }
//            }
//            if (!isResult) {
//                logger.info("+++++ Element is not visible.");
//            }
//            return isResult;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Element is not visible.");
//            return isResult;
//        }
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait element to be visible.
//     */
//    public void waitForClickableOfElement(WebElement element, String elementName) {
//        logger.info("+++ Wait For Clickable Of Element: " + elementName);
//        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait element to be visible.
//     */
//    public void waitForClickableOfElement(WebElement element, String elementName, int waitTimeOut) {
//        logger.info("+++ Wait For Clickable Of Element: " + elementName);
//        WebDriverWait wait = new WebDriverWait(getDriver(), waitTimeOut);
//        wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait element to be visible.
//     */
//    public void waitForInvisibleElement(WebElement element, String elementName) {
//        logger.info("+++ Wait For Invisible Element: " + elementName);
//        WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
//        wait.until(ExpectedConditions.invisibilityOf(element));
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait element to be visible.
//     */
//    public void waitForInvisibleElement(WebElement element, String elementName, int waitTimeOut) {
//        logger.info("+++ Wait For Invisible Element: " + elementName);
//        WebDriverWait wait = new WebDriverWait(getDriver(), waitTimeOut);
//        wait.until(ExpectedConditions.invisibilityOf(element));
//    }
//
//
//    /**
//     * @param webElement
//     * @param timeOut
//     * @param text
//     */
//    public void waitUtilTextPresent(WebElement webElement, long timeOut, String text) {
//        logger.info("+++ Wait util Element: " + webElement + " present.");
//        WebDriverWait wait = new WebDriverWait(driver, timeOut);
//        wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
//    }
//
//    /*
//Method to wait Ajax function on Site be loaded successfully.
//*/
//    public boolean waitForJSandJQueryToLoad() {
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        // wait for jQuery to load
//        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                try {
//                    return ((Long) ((JavascriptExecutor) getDriver()).executeScript("return jQuery.active") == 0);
//                } catch (Exception e) {
//                    // no jQuery present
//                    return true;
//                }
//            }
//        };
//        // wait for Javascript to load
//        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                return ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").toString()
//                        .equals("complete");
//            }
//        };
//        return wait.until(jQueryLoad) && wait.until(jsLoad);
//    }
//
//    public void waitSomeSeconds(int seconds) {
//        try {
//            Thread.sleep(seconds * 1000);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void waitSomeMilliSeconds(int miliSeconds) {
//        try {
//            Thread.sleep(miliSeconds);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//
//    /**
//     * Wait Web Element is util hidden
//     *
//     * @param by
//     * @param timeOut
//     */
//    public void waitUtilElementHidden(By by, long timeOut) {
//        logger.info("+++ Wait util Element is hidden.");
//        WebDriverWait wait = new WebDriverWait(driver, timeOut);
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
//    }
//
//    /**
//     * Author: Thuan Duong.
//     *
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait element to change Attribute value.
//     */
//    public boolean waitForAttributeValueChanged(WebElement element, String elementName, String attributeName,
//                                                String attributeValue) {
//        logger.info("Try to waitForAtrributeValueChanged: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    String actualAttributeValue = null;
//                    if (element.getAttribute(attributeName) != null) {
//                        actualAttributeValue = element.getAttribute(attributeName);
//                        logger.info("Actual Displayed Value: " + actualAttributeValue);
//                        logger.info("Expect Displayed Value: " + attributeValue);
//                    } else {
//                        logger.info(String.format("Attribute %s is null", attributeName));
//                        return false;
//                    }
//                    if (actualAttributeValue.equals(attributeValue))
//                        return true;
//                    else
//                        return false;
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean waitForAttributeValueChangedXpath(String xpathString, String elementName, String attributeName, String attributeValue, int time) {
//        logger.info("Try to waitForAtrributeValueChanged ....");
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), time);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    String actualAttributeValue = null;
//                    WebElement element = getElementByXpath(xpathString);
//                    if (element.getAttribute(attributeName) != null) {
//                        actualAttributeValue = element.getAttribute(attributeName);
//                        logger.info("Actual Displayed Value: " + actualAttributeValue);
//                    } else {
//                        logger.info("Attribute " + attributeName + " is null");
//                        return false;
//                    }
//                    if (actualAttributeValue.equals(attributeValue))
//                        return true;
//                    else
//                        return false;
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean waitForAttributeValueChanged(WebElement element, String elementName, String attributeName,
//                                                String attributeValue, int time) {
//        logger.info("Try to waitForAtrributeValueChanged: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), time);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    String actualAttributeValue = null;
//                    if (element.getAttribute(attributeName) != null) {
//                        actualAttributeValue = element.getAttribute(attributeName);
//                        logger.info("Actual Displayed Value: " + actualAttributeValue);
//                    } else {
//                        logger.info("Attribute " + attributeName + " is null");
//                        return false;
//                    }
//                    if (actualAttributeValue.trim().equals(attributeValue.trim())) {
//                        logger.info("Actual   Displayed Value: " + actualAttributeValue);
//                        logger.info("Expected Displayed Value: " + attributeValue);
//                        return true;
//                    } else {
//                        return false;
//                    }
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait element to be visible.
//     */
//    public boolean waitForCssValueChanged(WebElement element, String elementName, String cssName, String cssValue) {
//        logger.info("Try to waitForCssValueChanged: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 15);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    String actualcssValue = element.getCssValue(cssName);
//                    logger.info("Expected Displayed Value: " + cssValue);
//                    logger.info("Actual Displayed Value: " + actualcssValue);
//                    if (actualcssValue.equals(cssValue))
//                        return true;
//                    else
//                        return false;
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error(e);
//            logger.error("CSS Value is not changed");
//            return false;
//        }
//    }
//
//    public boolean waitForCssValueChanged(WebElement element, String elementName, String cssName, String cssValue, int timeSecond) {
//        logger.info("Try to waitForCssValueChanged: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeSecond);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    String actualcssValue = element.getCssValue(cssName);
//                    logger.info("Expected Displayed Value: " + cssValue);
//                    logger.info("Actual Displayed Value: " + actualcssValue);
//                    if (actualcssValue.equals(cssValue))
//                        return true;
//                    else
//                        return false;
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error(e);
//            logger.error("CSS Value is not changed");
//            return false;
//        }
//    }
//
//    public boolean waitForCssValueChanged(String elementXpath, String elementName, String cssName, String cssValue) {
//        logger.info("Try to waitForCssValueChanged: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 15);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    String actualcssValue = getDriver().findElement(By.xpath(elementXpath)).getCssValue(cssName);
//                    logger.info("Expected Displayed Value: " + cssValue);
//                    logger.info("Actual Displayed Value: " + actualcssValue);
//                    if (actualcssValue.equals(cssValue))
//                        return true;
//                    else
//                        return false;
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error(e);
//            logger.error("CSS Value is not changed");
//            return false;
//        }
//    }
//
//    public boolean waitForTextValueChanged(WebElement element, String elementName, String textValue) {
//        logger.info("Try to waitForTextValueChanged: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 90);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        String actualTextValue = getText(element).trim();
//                        logger.info("Actual Displayed Value: " + actualTextValue);
//                        logger.info("Expected Displayed Value: " + textValue);
//                        if (actualTextValue.equals(textValue))
//                            return true;
//                        else
//                            return false;
//                    } catch (StaleElementReferenceException e) {
//                        logger.error(e);
//                        return false;
//                    }
//                }
//            });
//            logger.info(String.format("Text Value of element '%s' is changed to '%s' ", elementName, textValue));
//            return true;
//        } catch (Exception e) {
//            logger.error("CSS Value is not changed");
//            logger.error("Text Value of element '%s' is NOT changed " + elementName);
//            return false;
//        }
//    }
//
//    public boolean waitForTextValueChanged(String xpath, String elementName, String textValue, int timeSecond) {
//        logger.info("Try to waitForTextValueChanged: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeSecond);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        WebElement elementInput = getDriver().findElement(By.xpath(xpath));
//                        String actualTextValue = getText(elementInput).trim();
//                        logger.info("Actual Displayed Value: " + actualTextValue);
//                        logger.info("Expected Displayed Value: " + textValue);
//                        return actualTextValue.equals(textValue);
//                    } catch (StaleElementReferenceException e) {
//                        logger.error(e);
//                        return false;
//                    }
//                }
//            });
//            logger.info(String.format("Text Value of element '%s' is changed to '%s' ", elementName, textValue));
//            return true;
//        } catch (Exception e) {
//            logger.error("CSS Value is not changed");
//            logger.error("Text Value of element " + elementName + " is NOT changed ");
//            logger.info("Xpath: " + xpath);
//            return false;
//        }
//    }
//
//    public boolean waitForTextValueChanged(WebElement element, String elementName, String textValue, int timeSecond) {
//        logger.info("Try to waitForTextValueChanged: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeSecond);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        String actualTextValue = getText(element).trim();
//                        logger.info("Actual Displayed Value: " + actualTextValue);
//                        logger.info("Expected Displayed Value: " + textValue);
//                        if (actualTextValue.equals(textValue))
//                            return true;
//                        else
//                            return false;
//                    } catch (StaleElementReferenceException e) {
//                        logger.error(e);
//                        return false;
//                    }
//                }
//            });
//            logger.info(String.format("Text Value of element '%s' is changed to '%s' ", elementName, textValue));
//            return true;
//        } catch (Exception e) {
//            logger.error("Text Value is not changed");
//            logger.error("Text Value of element '%s' is NOT changed " + elementName);
//            return false;
//        }
//    }
//
//    /**
//     * wait until animation for element finish
//     *
//     * @param webElement  xpath to get element
//     * @param elementName vararg for formating
//     */
//    public boolean waitForAnimation(WebElement webElement, String elementName) {
//        // This function is waiting to Popup Delete To Do task is displayed after running animation.
//        // We can move this function to Abstract Page or Common Page.
//        try {
//            logger.info("Waiting For Animation: " + elementName);
//            WebDriverWait wait = new WebDriverWait(getDriver(), 30);
//            wait.until((WebDriver driver) -> {
//                boolean result = false;
//                result = (boolean) ((JavascriptExecutor) driver).executeScript(
//                        "var elm = arguments[0];" + "var doc1 = elm.ownerDocument || document;" + "var rect = elm" +
//                                ".getBoundingClientRect();" + "return elm === doc1.elementFromPoint(rect.left, rect"
//                                + ".top);",
//                        webElement);
//                logger.info("result: " + result);
//                return result;
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait the size of Element is changed.
//     */
//    public boolean waitForSizeListElementChanged(List<WebElement> element, String elementName, int sizeListElement) {
//        logger.info("Try to waitForSizeListElementChanged: " + elementName);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    int actualSizeListElement = element.size();
//                    logger.info("Actual Size of List Element: " + actualSizeListElement);
//                    logger.info("Expected Size of List Element: " + sizeListElement);
//                    if (actualSizeListElement == sizeListElement)
//                        return true;
//                    else
//                        return false;
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error("Size of Element is not changed");
//            return false;
//        } finally {
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        }
//    }
//
//    /**
//     * @param xpath       element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait the size of Element is changed.
//     */
//    public boolean waitForSizeListElementChanged(String xpath, String elementName, int sizeListElement) {
//        logger.info("Try to waitForSizeListElementChanged: " + elementName);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), waitTime);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    List<WebElement> element = getElementsByXpath(xpath);
//                    int actualSizeListElement = element.size();
//                    logger.info("Actual Size of List Element: " + actualSizeListElement);
//                    logger.info("Expected Size of List Element: " + sizeListElement);
//                    if (actualSizeListElement == sizeListElement)
//                        return true;
//                    else
//                        return false;
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error("Size of Element is not changed");
//            return false;
//        } finally {
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        }
//    }
//
//    /************ ++++++++++++++++++++++++++++++++ End Block +++++++++++++++++++++++++++++++++++++ ****************/
//
//    /***************************Functions: Action on Element ( Ex: Click Element, Hover Element   *****************/
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to click
//     * @Description: Click on element
//     */
//
//    public void clickElement(WebElement element, String elementName) {
//        logger.info("+++ Click on Element: " + elementName);
//        waitUntilElementIsDisplayed(element, elementName);
//        try {
//            element.click();
//        } catch (ElementClickInterceptedException e) {
//            logger.info("Cannot click on element: " + e.getMessage());
//            scrollElementToView(element, "center");
//            logger.info("Scroll to element");
//            waitForClickableOfElement(element, elementName);
//            clickByJavaScripts(element, elementName);
//        } catch (ElementNotInteractableException e) {
//            logger.info("ElementNotInteractableException");
//            scrollElementToView(element, "center");
////            element.click();
//            clickByJavaScripts(element, elementName);
//        } catch (NullPointerException e) {
//            Assert.fail("Cannot click element: " + elementName + "(NullPointerException)");
//        } catch (NoSuchElementException e) {
//            Assert.fail("Cannot click element: " + elementName + "(NoSuchElementException)");
//        }
//    }
//
//    public void clickElementPageDown(WebElement element, String elementName) {
//        logger.info("+++ Click on Element: " + elementName);
//
//        waitForVisibleElement(element, elementName);
//        waitForClickableOfElement(element, elementName);
//        boolean condition = true;
//        while (condition) {
//            try {
//                element.click();
//                break;
//            } catch (Exception e) {
//                logger.info("Cannot click on element: " + e);
//                scrollPageDown();
//                waitSomeSeconds(1);
//                continue;
//            }
//        }
//    }
//
//    public void rightClickElement(WebElement element, String elementName) {
//        logger.info("+++ Right click on Element: " + elementName);
//        Actions action = new Actions(driver);
//        waitForVisibleElement(element, elementName);
//        waitSomeSeconds(1);
//        action.release().contextClick(element).perform();
//    }
//
//    public void rightClickAndSelectFirstContextItem(WebElement element, String elementName) {
//        logger.info("+++ Right click on Element: " + elementName);
//        Actions action = new Actions(driver);
//        waitForVisibleElement(element, elementName);
//        waitForClickableOfElement(element, elementName);
//        action.release().contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
//    }
//
//    public void rightClickAndSelectSecondContextItem(WebElement element, String elementName) {
//        logger.info("+++ Right click on Element: " + elementName);
//        Actions action = new Actions(driver);
//        waitForVisibleElement(element, elementName);
//        waitForClickableOfElement(element, elementName);
//        action.release().keyDown(Keys.SHIFT).click(element).keyUp(Keys.SHIFT).build().perform();
//    }
//
//    public void ctrlShiftClick(WebElement element, String elementName) {
//        logger.info("+++ Right click on Element: " + elementName);
//        Actions action = new Actions(driver);
//        waitForVisibleElement(element, elementName);
//        waitForClickableOfElement(element, elementName);
//        action.release().keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(element).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
//    }
//
//    public void shiftClick(WebElement element, String elementName) {
//        logger.info("+++ Shift click on Element: " + elementName);
//        Actions action = new Actions(driver);
//        waitForVisibleElement(element, elementName);
//        waitForClickableOfElement(element, elementName);
//        action.release().keyDown(Keys.SHIFT).click(element).keyUp(Keys.SHIFT).build().perform();
//    }
//
//    public void dragAndDropElement(WebElement source, WebElement target, int x, int y) {
//        logger.info("Drag and drop to (x,y) of target element");
//        String script = "var triggerDragAndDrop = function(elemDrag, elemDrop, posX, posY) { var fireMouseEvent = function(type, elem, centerX, centerY) { var evt = document.createEvent('MouseEvents'); evt.initMouseEvent(type, true, true, window, 1, 1, 1, centerX, centerY, false, false, false, false, 0, elem); elem.dispatchEvent(evt); }; var pos = elemDrag.getBoundingClientRect(); var center1X = Math.floor((pos.left + pos.right) / 2); var center1Y = Math.floor((pos.top + pos.bottom) / 2); pos = elemDrop.getBoundingClientRect(); var center2X = Math.floor(pos.left + posX); var center2Y = Math.floor(pos.top + posY + 20) ; fireMouseEvent('mousemove', elemDrag, center1X, center1Y); fireMouseEvent('mouseenter', elemDrag, center1X, center1Y); fireMouseEvent('mouseover', elemDrag, center1X, center1Y); fireMouseEvent('mousedown', elemDrag, center1X, center1Y); fireMouseEvent('dragstart', elemDrag, center1X, center1Y); fireMouseEvent('drag', elemDrag, center1X, center1Y); fireMouseEvent('mousemove', elemDrag, center1X, center1Y); fireMouseEvent('drag', elemDrag, center2X, center2Y); fireMouseEvent('mousemove', elemDrop, center2X, center2Y); fireMouseEvent('mouseenter', elemDrop, center2X, center2Y); fireMouseEvent('dragenter', elemDrop, center2X, center2Y); fireMouseEvent('mouseover', elemDrop, center2X, center2Y); fireMouseEvent('dragover', elemDrop, center2X, center2Y); fireMouseEvent('drop', elemDrop, center2X, center2Y); fireMouseEvent('dragend', elemDrag, center2X, center2Y); fireMouseEvent('mouseup', elemDrag, center2X, center2Y); return true; }; triggerDragAndDrop(arguments[0], arguments[1],arguments[2], arguments[3]);";
//        ((JavascriptExecutor) driver).executeScript(script, source, target, x, y);
//        waitSomeSeconds(1);
//
//    }
//
//    public void dragAndDropElementToElement(WebElement source, WebElement target) {
//        logger.info("Drag and drop from source to target element");
//        String script = "var triggerDragAndDrop = function (elemDrag, elemDrop) { var fireMouseEvent = function (type, elem, centerX, centerY) { var evt = document.createEvent('MouseEvents'); evt.initMouseEvent( type, true, true, window, 1, 1, 1, centerX, centerY, false, false, false, false, 0, elem ); elem.dispatchEvent(evt); }; var pos = elemDrag.getBoundingClientRect(); var center1X = Math.floor((pos.left + pos.right) / 2); var center1Y = Math.floor((pos.top + pos.bottom) / 2); pos = elemDrop.getBoundingClientRect(); var center2X = Math.floor((pos.left + pos.right) / 2); var center2Y = Math.floor((pos.top + pos.bottom) / 2); fireMouseEvent('mousemove', elemDrag, center1X, center1Y); fireMouseEvent('mouseenter', elemDrag, center1X, center1Y); fireMouseEvent('mouseover', elemDrag, center1X, center1Y); fireMouseEvent('mousedown', elemDrag, center1X, center1Y); fireMouseEvent('dragstart', elemDrag, center1X, center1Y); fireMouseEvent('drag', elemDrag, center1X, center1Y); fireMouseEvent('mousemove', elemDrag, center1X, center1Y); fireMouseEvent('drag', elemDrag, center2X, center2Y); fireMouseEvent('mousemove', elemDrop, center2X, center2Y); fireMouseEvent('mouseenter', elemDrop, center2X, center2Y); fireMouseEvent('dragenter', elemDrop, center2X, center2Y); fireMouseEvent('mouseover', elemDrop, center2X, center2Y); fireMouseEvent('dragover', elemDrop, center2X, center2Y); fireMouseEvent('drop', elemDrop, center2X, center2Y); fireMouseEvent('dragend', elemDrag, center2X, center2Y); fireMouseEvent('mouseup', elemDrag, center2X, center2Y); return true; }; triggerDragAndDrop(arguments[0], arguments[1]);";
//        ((JavascriptExecutor) driver).executeScript(script, source, target);
//        waitSomeSeconds(1);
//    }
//
//    public Object executeJavascript(String script, WebElement... listElement) {
//        Object value = ((JavascriptExecutor) getDriver()).executeScript(script, listElement);
//        return value;
//    }
//
//    public void turnOnFullScreen() {
//        driver.manage().window().fullscreen();
//    }
//
//    public void turnOffFullScreen() {
//        driver.manage().window().maximize();
//    }
//
//    /**
//     * Added by huy.huynh on 12/06/2017.
//     * check element on dev-branch
//     */
//    /**
//     * @param webElement  Element defined in page class
//     * @param elementName The text name of element
//     */
//    public void clickByJavaScripts(WebElement webElement, String elementName) {
//        logger.info("Click by javascript of element " + elementName);
//        try {
//            executeJavascript("arguments[0].click()", webElement);
//        } catch (JavascriptException e) {
//            if (Objects.isNull(webElement)) {
//                Assert.fail(elementName + " element is null");
//            } else {
//                throw e;
//            }
//        }
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to click and hold
//     * @Description: Click and Hold on element
//     */
//    public void clickAndHold(WebElement element, String elementName) {
//        logger.info("+++ Click And Hold: " + elementName);
//        if (Generic.sBrowser.equals("chr.")) {
//            Actions actions = new Actions(driver);
//            actions.moveToElement(element);
//            actions.click(element);
//            actions.perform();
//        } else {
//            element.click();
//        }
//
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to hover to
//     * @Description: Hover on element
//     */
//    public void hoverElement(WebElement element, String elementName) {
//        logger.info("+++ Hover on Element: " + elementName);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element);
//        actions.build().perform();
//        waitSomeSeconds(1);
//    }
//
//    public void hoverElementxy(WebElement element, String elementName, Integer x, Integer y) {
//        logger.info("+++ Hover on Element x y : " + elementName);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element, x, y);
//        actions.build().perform();
//        waitSomeSeconds(1);
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to input value.
//     * @Description: Clear all Strings to textBox.
//     * @Description: Clear all Strings to textBox.
//     */
//    public void clearTextBox(WebElement element, String elementName) {
//        logger.info("+++ Clear text on : " + elementName);
//        element.sendKeys(Keys.END, Keys.SHIFT, Keys.HOME, Keys.DELETE);
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param text        The content of text that we want to input.
//     * @param elementName Name of element that we want to input value.
//     * @Description: Send a String to textBox.
//     * @Description: Send a String to textBox.
//     */
//    public void sendKeyTextBox(WebElement element, String text, String elementName) {
//        logger.info("+++ SendKey on : " + elementName);
//        clickElement(element, elementName);
//        element.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
//        element.sendKeys(text);
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element: CheckBox that we want to Send TabKey
//     * @Description: Send TabKey
//     * @Description: Send TabKey
//     */
//    public void sendTabKey(WebElement element, String elementName) {
//        logger.info("+++ Send TabKey on Element " + elementName);
//        element.sendKeys(Keys.TAB);
//    }
//
//    public void sendEnterKey(WebElement element, String elementName) {
//        logger.info("+++ Send Enter Key: " + elementName);
//        //        element.sendKeys(Keys.ENTER);
//        try {
//            element.sendKeys(Keys.ENTER);
//            logger.info("+++++ Sent Enter Key: " + elementName);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Unable to sendEnterkey on: " + elementName);
//        }
//    }
//
//    /************ ++++++++++++++++++++++++++++++++ End Block +++++++++++++++++++++++++++++++++++++ ****************/
//
//    /********Functions: Validate Element function ( Ex: validateElementText, validateDisPlayedElement,... *********/
//
//    /**
//     * @param webElement  WebElement
//     * @param elementText Text of Element be presented.
//     */
//    public boolean validateElementText(WebElement webElement, String elementText) {
//        waitSomeSeconds(1);
//        try {
//            logger.info("+++++ Check rendered of text: " + elementText.trim());
//            logger.info("+++++ Actual Text  displayed: " + getText(webElement).trim());
//            Assert.assertEquals(getText(webElement).trim(), elementText.trim());
//            return true;
//        } catch (AssertionError error) {
//            logger.info(error);
//            logger.info("+++++ Text of Element is not: " + elementText);
//            return false;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error(e.getMessage());
//            logger.error("+++++ Text of Element is not: " + elementText);
//            return false;
//        }
//    }
//
//    /**
//     * This function to copy and past text into benchmark name
//     *
//     * @param text
//     * @throws InterruptedException
//     * @throws AWTException
//     */
//    public void copyAndPastTextIntoTextBox(WebElement webElement, String text) {
//        try {
//            clickElement(webElement, "Element object");
//            webElement.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
//            if (isSeleniumGridMode()) {
//                String sessionID = this.getSessionId();
//                SelenoidUtils utils = new SelenoidUtils(sessionID);
//                utils.postClipboardToSelenoid(text);
//            } else {
//                StringSelection ss = new StringSelection(text);
//                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, ss);
//            }
//            webElement.sendKeys(Keys.CONTROL, "V");
//            waitSomeSeconds(1);
//        } catch (Exception e) {
//            logger.info("Cannot copy and paste");
//        }
//    }
//
//    /**
//     * @param webElement  WebElement
//     * @param elementText Text of Element be presented.
//     */
//    public boolean validateElementTextIgnoreCase(WebElement webElement, String elementText) {
//        logger.info("+++ Check rendered of text: " + elementText.trim());
//        try {
//            logger.info("+++ Check rendered of text: " + elementText.trim());
//            logger.info("+++++ Actual Text is displayed: " + getText(webElement).trim());
//            Assert.assertEquals(getText(webElement).toUpperCase().trim(), elementText.toUpperCase().trim());
//            return true;
//        } catch (AssertionError error) {
//            logger.info(error);
//            logger.info("+++++ Text of Element is not: " + elementText);
//            return false;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error(e.getMessage());
//            logger.error("+++++ Text of Element is not: " + elementText);
//            return false;
//        }
//    }
//
//    /**
//     * @param element
//     * @throws InvalidElementStateException
//     * @elementName Name of element that we want to verify
//     */
//    public boolean validateDisPlayedElement(WebElement element,
//                                            String elementName) throws InvalidElementStateException {
//        logger.info("+++ Verify Displayed of: " + elementName);
//        //
//        try {
//            waitForVisibleElement(element, elementName);
//            if (element.isDisplayed()) {
//                logger.info("+++ Element : " + elementName + " is presented");
//                return true;
//            } else {
//                logger.info("+++ Element : " + elementName + "is not presented");
//                return false;
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Element : " + elementName + "is not presented");
//            return false;
//        }
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @throws InvalidElementStateException
//     */
//
//    public boolean validateEnabledElement(WebElement element, String elementName) throws InvalidElementStateException {
//        logger.info("+++ Verify enabled of: " + elementName);
//        try {
//            if (element.isEnabled()) {
//                logger.info("+++++ Element : " + elementName + "is enable");
//                return true;
//            } else {
//                logger.info("+++++ Element : " + elementName + "is disable");
//                return false;
//            }
//
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Element : " + elementName + "is not enable.");
//            return false;
//        }
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @throws InvalidElementStateException
//     */
//
//    public boolean validateEnabledElement(WebElement element, String elementName, int waitTimeOut) {
//        logger.info("+++ Verify enabled of: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), waitTimeOut);
//            wait.until(ExpectedConditions.elementToBeClickable(element));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @throws InvalidElementStateException
//     */
//    public boolean validateSelectedElement(WebElement element, String elementName) throws InvalidElementStateException {
//        logger.info("+++ Verify selected of: " + elementName);
//        try {
//
//            logger.info("+++++ Element : " + element.getText() + "is selected.");
//            return element.isSelected();
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Element : " + element.getText() + "is not selected.");
//            return false;
//        }
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @throws InvalidElementStateException
//     */
//    public boolean validateNotSelectedElement(WebElement element,
//                                              String elementName) throws InvalidElementStateException {
//        logger.info("+++ Verify not selected of: " + elementName);
//        try {
//            if (!element.isSelected()) {
//                logger.info("+++++ Element : " + element.getText() + "is not selected.");
//                return true;
//            } else {
//                throw new Exception();
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Element : " + element.getText() + "is selected.");
//            return false;
//        }
//    }
//
//    public boolean validateMaxLength(WebElement webElement, String webElementName, int maxLength) {
//        logger.info("Verify input with max length with " + maxLength + " characters");
//        try {
//            String inputTextWithMaxLength = randomCharacters(maxLength);
//            clickElement(webElement, webElementName);
//            clearTextBox(webElement, webElementName);
//            webElement.sendKeys(inputTextWithMaxLength);
//            String actualTextInput = webElement.getAttribute("value");
//            Assert.assertEquals(actualTextInput, inputTextWithMaxLength,
//                    String.format("%s cannot input %d characters", webElementName, maxLength));
//            return true;
//        } catch (AssertionError error) {
//            logger.error(error);
//            return false;
//        }
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait element to be visible.
//     */
//    public boolean validateDisabledElement(WebElement element, String elementName) {
//        waitSomeSeconds(1);
//        logger.info("verify disable of: " + elementName);
//        try {
//            if (!(element.isEnabled())) {
//                logger.info(element.getTagName() + "+++ is disabled");
//                return true;
//            } else {
//                logger.info(element.getTagName() + "--- is enabled");
//                throw new Exception();
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error(elementName + "*** is  not disabled");
//            return false;
//        }
//    }
//
//    /**
//     * @param element                element defined on page class
//     * @param attributeName          Attribute that we want to validate
//     * @param expectedAttributeValue Expected value that we want to validate
//     */
//    public boolean validateAttributeElement(WebElement element, String attributeName, String expectedAttributeValue) {
//        logger.info("+++ Verify Attribute " + attributeName + " of: " + element.toString());
//        String actualAttributeValue = null;
//        try {
//            actualAttributeValue = element.getAttribute(attributeName).trim();
//            logger.info("actualAttributeValue of " + attributeName + " is: " + actualAttributeValue);
//            if (actualAttributeValue.equals(expectedAttributeValue)) {
//                logger.info(element.getTagName() + " has attribute " + actualAttributeValue);
//                return true;
//            } else {
//                throw new Exception(String.format("Expected ['%s'] but found ['%s']", expectedAttributeValue,
//                        actualAttributeValue));
//            }
//        } catch (Exception e) {
//            logger.error(e);
//            logger.error(e.getMessage());
//            logger.error("+++++ Error: " + element
//                    .getTagName() + " has attribute not as expected with actual: " + actualAttributeValue);
//            return false;
//        }
//    }
//
//    /**
//     * @param element        element defined on page class
//     * @param attributeName  AttributeCSSS that we want to validate
//     * @param attributeValue Expected value that we want to validate
//     */
//    public boolean validateCssValueElement(WebElement element, String attributeName,
//                                           String attributeValue) throws InvalidElementStateException {
//        logger.info("+++ Verify style with " + attributeName);
//        try {
//            logger.info("Actual value: " + element.getCssValue(attributeName).trim());
//            logger.info("Expected value: " + attributeValue);
//            Assert.assertEquals(element.getCssValue(attributeName).trim(), attributeValue);
//            return true;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Validate CSS Value Element is not correct.");
//            return false;
//        } catch (AssertionError e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ CSS Value Element is not correct.");
//            return false;
//        }
//    }
//
//    /**
//     * @param element        element defined on page class
//     * @param attributeName  Attribute CSS that we want to validate
//     * @param attributeValue Expected value that we want to validate
//     * @param elementName    Element name
//     */
//    public boolean validateCssValueContain(WebElement element, String attributeName, String attributeValue, String elementName) {
//        logger.info("+++ Verify style of element " + elementName + " with " + attributeName);
//        try {
//            logger.info("Actual value: " + element.getCssValue(attributeName).trim());
//            logger.info("Expected value: " + attributeValue);
//            if (element.getCssValue(attributeName).contains(attributeValue))
//                return true;
//            else
//                return false;
//        } catch (NoSuchElementException e) {
//            logger.info(e.getMessage());
//            return false;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    /**
//     * @param element        element defined on page class
//     * @param attributeName  Attribute CSS that we want to validate
//     * @param attributeValue Expected value that we want to validate
//     * @param elementName    Element name
//     */
//    public boolean validateCssValueNotContain(WebElement element, String attributeName, String attributeValue, String elementName) {
//        logger.info("+++ Verify style of element " + elementName + " with " + attributeName);
//        try {
//            logger.info("Actual value: " + element.getCssValue(attributeName).trim());
//            logger.info("Expected value: " + attributeValue);
//            if (!element.getCssValue(attributeName).contains(attributeValue))
//                return true;
//            else
//                return false;
//        } catch (NoSuchElementException e) {
//            logger.info(e.getMessage());
//            return false;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean validateIsNotDisPlayedElement(WebElement element, String elementName) {
//        logger.info("+++ Verify element is not displayed of: " + elementName);
//        try {
//            if (!element.isDisplayed()) {
//                return true;
//            } else {
//                logger.info("+++++ Element is displayed.");
//                return false;
//            }
//        } catch (Exception e) {
//            logger.info("+++++ Element is not displayed.");
//            logger.info(e.getMessage());
//            return true;
//        }
//    }
//
//    public boolean validateElementIsClickable(WebElement element, String elementName) {
//        logger.info("Validate element: " + elementName + " is clickable");
//        try {
//            element.click();
//            logger.info("Element is able to click");
//            /////Temporary code/////
////            clickByJavaScripts(element, "click on element");
//            ///////////////////////
//            return true;
//        } catch (ElementNotInteractableException e) {
////            e.printStackTrace();
//            logger.info("Element is NOT able to click");
//            return false;
//        }
//    }
//
//    /**
//     * Check properties of element
//     *
//     * @param webElement
//     * @param expected
//     * @param type
//     */
//    public void validateElememt(WebElement webElement, String expected, Element_Type type) {
//        logger.info("+++++ Validate Element with: " + type);
//        switch (type) {
//            case DISPLAYED:
//                try {
//                    Assert.assertTrue(webElement.isDisplayed(), expected + " is not displayed.");
//                } catch (NoSuchElementException e) {
//                    logger.info(e.getMessage());
//                    throw new AssertionError(e.getMessage());
//                } catch (AssertionError e) {
//                    logger.info(e.getMessage());
//                    throw new AssertionError(e.getMessage());
//                }
//                break;
//            case ISENABLE:
//                try {
//                    Assert.assertTrue(webElement.isEnabled(), expected + " is not enabled.");
//                } catch (NoSuchElementException e) {
//                    logger.info(e.getMessage());
//                    throw new AssertionError(e.getMessage());
//                } catch (AssertionError e) {
//                    logger.info(e.getMessage());
//                    throw new AssertionError(e.getMessage());
//                }
//                break;
//            case ISSELECTED:
//                try {
//                    Assert.assertTrue(webElement.isSelected(), expected + " is not selected  ");
//                } catch (NoSuchElementException e) {
//                    logger.info(e.getMessage());
//                    throw new AssertionError(e.getMessage());
//                } catch (AssertionError e) {
//                    logger.info(e.getMessage());
//                    throw new AssertionError(e.getMessage());
//                }
//                break;
//            case HIDDEN:
//                try {
//                    Assert.assertFalse(webElement.isDisplayed(), expected + " is not hidden.");
//                } catch (NoSuchElementException e) {
//                    logger.info(e.getMessage());
//                    throw new AssertionError(e.getMessage());
//                } catch (AssertionError e) {
//                    logger.info(e.getMessage());
//                    throw new AssertionError(e.getMessage());
//                }
//                break;
//            case TEXT_VALUE:
//                try {
//                    Assert.assertEquals(getText(webElement), expected);
//                } catch (NoSuchElementException e) {
//                    logger.info(e.getMessage());
//                    throw new AssertionError(e.getMessage());
//                } catch (AssertionError e) {
//                    logger.info(e.getMessage());
//                    throw new AssertionError(e.getMessage());
//                }
//                break;
//            case NOT_EXIST:
//                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//                try {
//                    webElement.click();
//                    throw new AssertionError(expected + " is still displayed.");
//                } catch (NoSuchElementException e) {
//                }
//
//                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//                break;
//            default:
//                break;
//        }
//    }
//
//    /**
//     * validate if attribute contain given value
//     *
//     * @param webElement  element need to validate
//     * @param attribute   attribute name
//     * @param value       Expected attribute value
//     * @param elementName Element name
//     */
//    public boolean validateAttributeContain(WebElement webElement, String attribute, String value, String elementName) {
//        try {
//            logger.info("Validate Style Attribute Exist " + elementName);
//            logger.info("class value of " + elementName + " is: " + webElement.getAttribute(attribute));
//            if (webElement.getAttribute(attribute).contains(value)) {
//                logger.info(value + " exist on " + attribute + " of element: " + elementName);
//                return true;
//            } else {
//                logger.info(value + " does not exist on " + attribute + " of element: " + elementName);
//                return false;
//            }
//        } catch (NoSuchElementException e) {
//            logger.info(e.getMessage());
//            return false;
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//            return false;
//        }
//    }
//
//    public boolean waitAndValidateAttributeContain(String xpath, String attributeName, String attributeValue, int timeout) {
//        try {
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        String actualAttributeValue = null;
//                        WebElement element = getElementByXpath(xpath);
//                        if (element.getAttribute(attributeName) != null) {
//                            actualAttributeValue = element.getAttribute(attributeName);
//                            logger.info("Actual Displayed Value: " + actualAttributeValue);
//                            logger.info("Expect Displayed Value: " + attributeValue);
//                        } else {
//                            logger.info(String.format("Attribute %s is null", attributeName));
//                            return true;
//                        }
//                        if (actualAttributeValue.contains(attributeValue))
//                            return true;
//                        else
//                            return false;
//                    } catch (Exception e) {
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean waitAndValidateAttributeContain(WebElement element, String attributeName, String attributeValue, int timeout) {
//        try {
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    String actualAttributeValue = null;
//                    if (element.getAttribute(attributeName) != null) {
//                        actualAttributeValue = element.getAttribute(attributeName);
//                        logger.info("Actual Displayed Value: " + actualAttributeValue);
//                        logger.info("Expect Displayed Value: " + attributeValue);
//                    } else {
//                        logger.info(String.format("Attribute %s is null", attributeName));
//                        return true;
//                    }
//                    if (actualAttributeValue.contains(attributeValue))
//                        return true;
//                    else
//                        return false;
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean waitAndValidateAttributeNotContain(String xpath, String attributeName, String attributeValue, int timeout) {
//        try {
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        String actualAttributeValue = null;
//                        WebElement element = driver.findElement(By.xpath(xpath));
//                        if (element.getAttribute(attributeName) != null) {
//                            actualAttributeValue = element.getAttribute(attributeName);
//                            logger.info("Actual Displayed Value: " + actualAttributeValue);
//                            logger.info("Expect Displayed Value: " + attributeValue);
//                        } else {
//                            logger.info(String.format("Attribute %s is null", attributeName));
//                            return true;
//                        }
//                        if (!actualAttributeValue.contains(attributeValue))
//                            return true;
//                        else
//                            return false;
//                    } catch (Exception e) {
//                        logger.info("xpath: " + xpath);
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean waitAndValidateAttributeNotContain(WebElement element, String attributeName, String attributeValue, int timeout) {
//        try {
//            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    String actualAttributeValue = null;
//                    if (element.getAttribute(attributeName) != null) {
//                        actualAttributeValue = element.getAttribute(attributeName);
//                        logger.info("Actual Displayed Value: " + actualAttributeValue);
//                        logger.info("Expect Displayed Value: " + attributeValue);
//                    } else {
//                        logger.info(String.format("Attribute %s is null", attributeName));
//                        return true;
//                    }
//                    if (!actualAttributeValue.contains(attributeValue)) {
//                        logger.info("attribute is not contain " + attributeValue);
//                        return true;
//                    } else {
//                        logger.info("attribute is contain " + attributeValue);
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    /**
//     * validate text contain given value
//     *
//     * @param webElement  element need to validate
//     * @param value       Expected attribute value
//     * @param elementName Element name
//     */
//    public boolean validateElementTextContain(WebElement webElement, String value, String elementName) {
//        try {
//            logger.info("Validate Element Text Contain " + elementName);
//            logger.info("expected = " + value);
//            logger.info("actualll = " + webElement.getText());
//            if (webElement.getText().contains(value)) {
//                logger.info(elementName + "'s text contain: " + value);
//                return true;
//            } else {
//                Assert.fail(elementName + "'s text contain: " + value);
//                return false;
//            }
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//            Assert.fail("Error: Validate text contain " + elementName);
//            return false;
//        }
//    }
//
//    public boolean validateNotExistedElement(WebElement element, String elementName) {
//        boolean isNotExist = false;
//        try {
//            logger.info("Try to validate Element is not existed.");
//            element.click();
//            element.getText();
//            element.sendKeys("try to send key");
//        } catch (NoSuchElementException e) {
//            logger.error("Element is not existed.");
//            logger.error(e.toString());
//            isNotExist = true;
//        } catch (ElementNotVisibleException e) {
//            logger.error("Element is not visible.");
//            logger.error(e.toString());
//            isNotExist = true;
//        } catch (IndexOutOfBoundsException outEx) {
//            logger.error("List element is empty.");
//            logger.error(outEx.toString());
//            isNotExist = true;
//        } catch (Exception e) {
//            logger.error("cannot focus element.");
//            e.printStackTrace();
//            logger.error("=== " + e.toString() + " ===");
//            isNotExist = true;
//        } finally {
//            getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        }
//        return isNotExist;
//    }
//
//    public boolean validateNotExistedElement(WebElement element, String elementName, int timeOut) {
//        try {
//            logger.info("Try to validate Element is not existed.");
//            getDriver().manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
//            element.click();
//            element.getText();
//            element.sendKeys("try to send key");
//            getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//        } catch (NoSuchElementException e) {
//            logger.error("Element is not existed.");
//            logger.error(e.toString());
//            getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (ElementNotVisibleException e) {
//            logger.error("Element is not visible.");
//            logger.error(e.toString());
//            getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (IndexOutOfBoundsException outEx) {
//            logger.error("List element is empty.");
//            logger.error(outEx.toString());
//            getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.error("cannot focus element.");
//            e.printStackTrace();
//            logger.error("=== " + e.toString() + " ===");
//            getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        }
//    }
//
//    /**
//     * validate element list size equal
//     *
//     * @param elements    list element
//     * @param quantity    Expected quantity
//     * @param elementName Element name
//     */
//    public void validateElementsQuantity(List<WebElement> elements, int quantity, String elementName) {
//        try {
//            logger.info("Validate elements quantity" + elementName);
//            if (elements.size() == quantity) {
//                logger.info(elementName + " quantity equal: " + quantity);
//            } else {
//                Assert.fail(elementName + " quantity not equal: [Expected]= " + quantity + " /[Actual]= " + elements
//                        .size());
//            }
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }
//    }
//
//    /**
//     * validate placeholder text
//     *
//     * @param webElement  element need to validate
//     * @param value       Expected placeholder text
//     * @param elementName Element name
//     */
//    public void validatePlaceholder(WebElement webElement, String value, String elementName) {
//        try {
//            logger.info("Validate placeholder " + elementName);
//            if (webElement.getAttribute("placeholder").equals(value)) {
//                logger.info(elementName + " placeholder equal: " + value);
//            } else {
//                Assert.fail(elementName + " placeholder not equal: [Expected]= " + value + " /[Actual]= " + webElement
//                        .getAttribute("placeholder"));
//            }
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }
//    }
//
//    /**
//     * validate if attribute not contain given value
//     *
//     * @param webElement  element need to validate
//     * @param attribute   attribute name
//     * @param value       Expected attribute value
//     * @param elementName Element name
//     */
//    public boolean validateAttributeNotContain(WebElement webElement, String attribute, String value, String elementName) {
//        try {
//            logger.info("Validate Style Attribute Not Exist " + elementName);
//            logger.info("class value of " + elementName + " is: " + webElement.getAttribute(attribute));
//            if (webElement.getAttribute(attribute).contains(value)) {
//                logger.info(value + " exist on " + attribute + " of element: " + elementName);
//                return false;
//            } else {
//                logger.info(value + " does not exist on " + attribute + " of element: " + elementName);
//                return true;
//            }
//        } catch (NoSuchElementException e) {
//            logger.info(e.getMessage());
//            Assert.fail("Error: " + elementName + " is not exist.");
//            return true;
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//            Assert.fail("Error: Validate attribute contain " + elementName);
//            return true;
//        }
//    }
//
//    /**
//     * validate text get by JS contain given value
//     *
//     * @param webElement  element need to validate
//     * @param value       Expected attribute value
//     * @param elementName Element name
//     */
//    public void validateElementJavaScriptTextContain(WebElement webElement, String value, String elementName) {
//        try {
//            logger.info("Validate Element JavaScript Text Contain " + elementName);
//            if (getTextByJavaScripts(webElement, elementName).contains(value)) {
//                logger.info(elementName + "'s JavaScript text contain: " + value);
//            } else {
//                Assert.fail(elementName + "'s JavaScript text contain: " + value);
//            }
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }
//    }
//
//    public boolean validateExistedElement(WebElement element, String elementName) {
//        try {
//            logger.info("Validating " + elementName + " is existed.");
//            element.getText();
//            return true;
//        } catch (NoSuchElementException e) {
//            logger.error(elementName + " is not existed.");
//            return false;
//        } catch (ElementNotVisibleException e) {
//            logger.error(elementName + " is visible.");
//            return false;
//        } catch (IndexOutOfBoundsException outEx) {
//            logger.error("List " + elementName + " is empty.");
//            return false;
//        } catch (Exception e) {
//            logger.error("Error: Finding " + elementName + " error.");
//            //getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//            return false;
//        }
//    }
//
//
//    /************ ++++++++++++++++++++++++++++++++ End Block +++++++++++++++++++++++++++++++++++++ ****************/
//
//    /*************************Functions: Select an option in Select Dropdown Element  *****************************/
//
//    /**
//     * @param element     element defined on page class
//     * @param selText     Visible text that you want to select on dropdown
//     * @param elementName checkbox name
//     * @Description: select a value on dropdown via visible text
//     * @Description: select a value on dropdown via visible text
//     */
//    public void selectOptionByText(WebElement element, String selText, String elementName) {
//        logger.info("+++ Select By VisibleText on element: " + elementName);
//        Select dropDown = new Select(element);
//        dropDown.selectByVisibleText(selText);
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param selValue    Value that you want to select on dropdown
//     * @param elementName checkbox name
//     * @Description: select a value on dropdown via visible text
//     * @Description: select a value on dropdown via visible text
//     */
//    public void selectOptionByValue(WebElement element, String selValue, String elementName) {
//        logger.info("+++ Select By Value on element: " + elementName);
//        Select dropDown = new Select(element);
//        dropDown.selectByValue(selValue);
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param selIndex    Value that you want to select on dropdown
//     * @param elementName checkbox name
//     * @Description: select a value on dropdown via visible text
//     * @Description: select a value on dropdown via visible text
//     */
//    public void selectOptionByIndex(WebElement element, int selIndex, String elementName) {
//        logger.info("+++ Select By Index on element: " + elementName);
//        Select dropDown = new Select(element);
//        dropDown.selectByIndex(selIndex);
//    }
//
//    /************ ++++++++++++++++++++++++++++++++ End Block +++++++++++++++++++++++++++++++++++++ ****************/
//
//    /******************Functions: Finding an Element with parameter: "ByXpath, By Value,... ***********************/
//
//    /**
//     * @param xpathElement
//     * @return Web element by xpath
//     */
//    public boolean validateNoExistElement(String xpathElement) {
//        logger.info("---- Validate not existed element -----");
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 15);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        getDriver().findElement(By.xpath(xpathElement));
//                        logger.info("Element is exist");
//                        return false;
//                    } catch (Exception e) {
//                        logger.info("Element not found");
//                        return true;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//    }
//
//    /**
//     * @param xpathElement
//     * @return Web element by xpath
//     */
//    public boolean validateNoExistElement(String xpathElement, String elementName) {
//
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 15);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        getDriver().findElement(By.xpath(xpathElement));
//                        logger.info("Element " + elementName + " is exist");
//                        return false;
//                    } catch (Exception e) {
//                        logger.info("Element " + elementName + " not found");
//                        return true;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//
//    }
//
//    /**
//     * @param xpathElement
//     * @return Web element by xpath
//     */
//    public boolean validateNoExistElement(String xpathElement, String elementName, int timeOut) {
//
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        getDriver().findElement(By.xpath(xpathElement));
//                        logger.info("Element " + elementName + " is exist");
//                        return false;
//                    } catch (Exception e) {
//                        logger.info("Element " + elementName + " not found");
//                        return true;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//
//    }
//
//    /**
//     * @param xpathElement
//     * @return Web element by xpath
//     */
//    public boolean validateExistElement(String xpathElement) {
//        logger.info("---- Validate existed element ----- + xpathElement");
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    WebElement ele = null;
//                    try {
//                        getDriver().findElement(By.xpath(xpathElement));
//                        return true;
//                    } catch (Exception e) {
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//    }
//
//    /**
//     * @param xpathElement
//     * @return Web element by xpath
//     */
//    public boolean validateExistElement(String xpathElement, String elementName) {
//        logger.info("-- Validate existed element: " + elementName);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    WebElement ele = null;
//                    try {
//                        getDriver().findElement(By.xpath(xpathElement));
//                        return true;
//                    } catch (Exception e) {
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//    }
//
//    /**
//     * @param xpathElement
//     * @return Web element by xpath
//     */
//    public boolean validateExistElement(String xpathElement, String elementName, int timeOutSeconds) {
//        logger.info("-- Validate existed element: " + elementName);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutSeconds);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        getDriver().findElement(By.xpath(xpathElement));
//                        logger.info("Element " + elementName + " is exist");
//                        logger.info("Xpath: " + xpathElement + " is exist");
//                        return true;
//                    } catch (Exception e) {
//                        logger.info("Element " + elementName + " is not exist");
//                        logger.info("Xpath: " + xpathElement + " is not exist");
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//
//    }
//
//    /**
//     * get element which cant use @FindBy to find
//     *
//     * @param xpath xpath to get element
//     * @param arg   vararg for formating
//     */
//    public WebElement getElementByXpath(String xpath, String... arg) {
//        WebElement webElement = null;
//        if (arg.length > 0) {
//            xpath = String.format(xpath, arg);
//        }
//        logger.info("xpath = " + xpath);
//        try {
//            webElement = getDriver().findElement(By.xpath(xpath));
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }
//        return webElement;
//    }
//
//    /**
//     * Find element from a parent element
//     *
//     * @param parent
//     * @param xpath
//     * @param arg
//     * @return
//     */
//    public WebElement getElementByXpath(WebElement parent, String xpath, String... arg) {
//        logger.info("Get Element by Xpath. " + arg);
//        WebElement webElement = null;
//        xpath = String.format(xpath, arg);
//        logger.info("xpath = " + xpath);
//        try {
//            webElement = parent.findElement(By.xpath(xpath));
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }
//        return webElement;
//    }
//
//    /**
//     * get list elements which cant use @FindBy to find
//     *
//     * @param xpath xpath to get element
//     * @param arg   vararg for formating
//     */
//    public List<WebElement> getElementsByXpath(String xpath, String... arg) {
//        List<WebElement> webElements = new ArrayList<>();
//        xpath = String.format(xpath, arg);
//        logger.info("xpaths = " + xpath);
//        try {
//            webElements = getDriver().findElements(By.xpath(xpath));
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }
//        return webElements;
//    }
//
//    public List<WebElement> getElementsByXpath(WebElement parent, String xpath, String... arg) {
//        List<WebElement> webElements = null;
//        xpath = String.format(xpath, arg);
//        logger.info("xpaths = " + xpath);
//        try {
//            webElements = parent.findElements(By.xpath(xpath));
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }
//        return webElements;
//    }
//    /************ ++++++++++++++++++++++++++++++++ End Block +++++++++++++++++++++++++++++++++++++ ****************/
//
//    /**************Functions: Finding position of Element in a list: By text, By attribute value ******************/
//
//    public int findElementByText(List<WebElement> listElement, String textValue) {
//        try {
//            String actualTextValue;
//            logger.info("Engagement name: " + textValue);
//            for (int i = 0; i < listElement.size(); i++) {
//                actualTextValue = listElement.get(i).getText().trim();
//                if (actualTextValue.equals(textValue)) {
//                    logger.info("Element is found at " + i);
//                    return i;
//                }
//            }
//            logger.info(String.format("Cannot find the text name: %s", textValue));
//            return -1;
//
//        } catch (Exception e) {
//            logger.error(String.format("Cannot find the text name: %s", textValue));
//            return -1;
//        }
//    }
//
//    /**
//     * Find the index(position) of Web Element in the list Web Element by attribute value
//     *
//     * @param listElement   List WebElement
//     * @param textValue     String text which is compared with each WebElements.
//     * @param attributeName String attributeName which attribute will be found with get Attribute method.
//     * @return i if the WebElement is matched, otherwise return -1.
//     */
//    public int findElementByAttribute(List<WebElement> listElement, String textValue, String attributeName) {
//        try {
//            String actualAttributeValue;
//            for (int i = 0; i < listElement.size(); i++) {
//                actualAttributeValue = listElement.get(i).getAttribute(attributeName).trim();
//                if (actualAttributeValue.equals(textValue)) {
//                    logger.info("Element is found at " + i);
//                    logger.info(String.format("The position of the text name '%s' at %d", textValue, i));
//                    return i;
//                }
//            }
//            Assert.fail(String.format("Cannot find the text name: %s", textValue));
//            return -1;
//
//        } catch (Exception e) {
//            Assert.fail(String.format("Cannot find the text name: %s", textValue));
//            return -1;
//        }
//    }
//
//    /************ ++++++++++++++++++++++++++++++++ End Block +++++++++++++++++++++++++++++++++++++ ****************/
//
//    /***************************************Functions: Scroll Page function: **************************************/
//
//    public void scrollPageUp() {
//        logger.info("+++ Scroll Page up.");
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_PAGE_UP);
//            robot.keyRelease(KeyEvent.VK_PAGE_UP);
//            logger.info("+++++ Scroll Page up successfully.");
//            waitSomeSeconds(1);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Scroll Page up unsuccessfully.");
//        }
//    }
//
//    /*
//    Method to scrollPageDown
//     */
//    public void scrollPageDown() {
//        logger.info("+++ Scroll Page down.");
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
//            logger.info("+++++ Scroll Page down successfully.");
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Scroll Page down unsuccessfully.");
//        }
//    }
//
//    public void scrollBottomPage() {
//        logger.info("+++ Scroll Page bottom.");
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_END);
//            robot.keyRelease(KeyEvent.VK_END);
//            logger.info("+++++ Scroll Page bottom successfully.");
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Scroll Page bottom unsuccessfully.");
//        }
//    }
//
//    /**
//     * Scroll to footer of current page
//     * TODO: duplicating with scrollToFooter on AbstractService, find solution later
//     */
//    public void scrollToFooter() {
//        logger.info("Scroll down to see page footer.");
//        JavascriptExecutor js = ((JavascriptExecutor) getDriver());
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        waitSomeSeconds(2);
//    }
//
//    public void scrollToTop() {
//        logger.info("Scroll up to see page top.");
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("document.documentElement.scrollTop = 0;");
//        waitSomeSeconds(1);
//    }
//
//    public void scrollIntoViewByElement(WebElement element) {
//        logger.info("Scroll into view by element");
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }
//
//    public void scrollToElement(WebElement element) {
//        logger.info("+++ Scroll to element " + element);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + "true" + ");", element);
//    }
//
//    public boolean validateElementIsNotOverlap(WebElement webElement) {
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        boolean result;
//        result = (boolean) js.executeScript(
//                "var elt = arguments[0]; var rect = elt.getBoundingClientRect();" + "var x=rect.left;" + "var y=rect" +
//                        ".top;" + "var topElt = document.elementFromPoint(x,y); return elt.isSameNode(topElt);",
//                webElement);
//        return result;
//    }
//
//    public boolean validateElementIsNotEditable(WebElement webElement) {
//        boolean result = false;
//        try {
//            webElement.clear();
//        } catch (InvalidElementStateException e) {
//            result = true;
//        }
//        return result;
//    }
//
//    /************ ++++++++++++++++++++++++++++++++ End Block +++++++++++++++++++++++++++++++++++++ ****************/
//
//    /****************************************Functions: Get Text of an Element: ***********************************/
//
//    /**
//     * @param eleGetText  Element defined in page class
//     * @param elementName The text name of element
//     * @return The text of web element
//     */
//    public String getTextByJavaScripts(WebElement eleGetText, String elementName) {
//        logger.info("+++ Get text by javascript of element " + elementName);
//        String textOfElement = "";
//        try {
//            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//            textOfElement = (String) ((JavascriptExecutor) getDriver())
//                    .executeScript("return arguments[0].value;", eleGetText);
//            logger.info("+++++ Text of element: " + elementName + textOfElement);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error(e.getMessage());
//            logger.error("+++++ Unable to get text of element: " + elementName + textOfElement);
//        }
//        return textOfElement;
//    }
//
//    /**
//     * Get text value of element
//     *
//     * @param webElement
//     * @return
//     */
//    public String getText(WebElement webElement) {
//        if (webElement.getTagName().equals("input") || webElement.getTagName().equals("textarea")) {
//            return webElement.getAttribute("value");
//        } else if (webElement.getTagName().equals("span") || webElement.getTagName().equals("div") || webElement.getTagName().equals("a")) {
//            return webElement.getAttribute("textContent");
//        } else if (webElement.getTagName().equals("TD")) {
//            return webElement.getAttribute("textContent");
//        } else if (webElement.getTagName().equalsIgnoreCase("select")) {
//            return (new Select(webElement)).getFirstSelectedOption().getText();
//        }
//        return webElement.getText();
//    }
//
//    /**
//     * @param webElement  Element defined in page class
//     * @param elementName The text name of element
//     * @return The text of web element
//     */
//    public String getTextByAttributeValue(WebElement webElement, String elementName) {
//        logger.info("Get text by attribute 'value' " + elementName);
//        try {
//            return webElement.getAttribute("value");
//        } catch (NoSuchElementException e) {
//            logger.info(e.getMessage());
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }
//        return null;
//    }
//
//    /************ ++++++++++++++++++++++++++++++++ End Block +++++++++++++++++++++++++++++++++++++ ****************/
//
//    /***************************************Function: Switch to tab, iframe: **************************************/
//
//    /**
//     * Switch to other tab
//     * Tab index count from 0(mean first tab tabIndex=0, second tab tabIndex=1)
//     *
//     * @param tabIndex
//     */
//    public void switchToOtherTab(int tabIndex) {
//        logger.info("+++ Switch to tab: " + tabIndex);
//        java.util.List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(tabIndex));
//    }
//
//    /**
//     * Switch back to previous tab
//     * Tab index count from 0(mean first tab tabIndex=0, second tab tabIndex=1)
//     */
//    public void switchToPreviousTab() {
//        logger.info("+++ Switch to previous tab: ");
//        java.util.List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(tabs.size() - 2));
//    }
//
//    /**
//     * Switch to other frame
//     *
//     * @param IframeName
//     */
//    public void switchToFrame(String IframeName) {
//        logger.info("+++ Switch to iFrame: " + IframeName);
//        driver.switchTo().frame(IframeName);
//
//    }
//
//    /**
//     * Switch to other frame
//     *
//     * @param iFrameId
//     */
//    public void switchToFrame(int iFrameId) {
//        logger.info("+++ Switch to iFrame with id: " + iFrameId);
//        driver.switchTo().frame(iFrameId);
//
//    }
//
//    /**
//     * Switch to other frame
//     *
//     * @param eleFrame
//     */
//    public void switchToFrame(WebElement eleFrame) {
//        logger.info("+++ Switch to iFrame with WebElement: " + eleFrame);
//        driver.switchTo().frame(eleFrame);
//
//    }
//    /************ ++++++++++++++++++++++++++++++++ End Block +++++++++++++++++++++++++++++++++++++ ****************/
//
//    /********************************************Functions: Other *************************************************/
//
//    public String randomCharacters(int maxLength) {
//        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
//        StringBuilder sb = new StringBuilder();
//        Random random = new Random();
//        for (int i = 0; i < maxLength; i++) {
//            char c = chars[random.nextInt(chars.length)];
//            sb.append(c);
//        }
//        String results = sb.toString();
//        return results;
//    }
//
//
//    public void verifySortDataGrid(java.util.List<WebElement> elementRowValue, WebElement elementSortIcon) {
//        logger.info("+++ Verify Sort Data Grid: " + elementSortIcon);
//        java.util.List<String> listToDoTaskName = new ArrayList<String>();
//        java.util.List<String> listSortedToDoTaskName;
//        for (int i = 0; i < elementRowValue.size(); i++) {
//            listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
//        }
//        listSortedToDoTaskName = listToDoTaskName;
//        Collections.sort(listSortedToDoTaskName);
//        elementSortIcon.click();
//        listToDoTaskName.clear();
//        for (int i = 0; i < elementRowValue.size(); i++) {
//            listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
//        }
//        Assert.assertEquals(listSortedToDoTaskName, listToDoTaskName, "Ascending sort is NOT as expected");
//        Collections.reverse(listSortedToDoTaskName);
//        elementSortIcon.click();
//        listToDoTaskName.clear();
//        for (int i = 0; i < elementRowValue.size(); i++) {
//            listToDoTaskName.add(elementRowValue.get(i).getAttribute("value"));
//        }
//        Assert.assertEquals(listSortedToDoTaskName, listToDoTaskName, "Descending sort is NOT as expected");
//        logger.info("++++ Verified Sort Data Grid: " + elementSortIcon);
//    }
//
//
//    /**
//     * Method togo to URL
//     *
//     * @param url
//     */
//    public void navigateToUrl(String url) {
//        logger.info("+++ Navigate to URL: " + url);
//        driver.get(url);
//    }
//
//    public String getDate(int day) {
//        Calendar date = Calendar.getInstance();
//        date.add(Calendar.DATE, day);
//        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/d/yyyy");
//        //  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
//        return simpleDateFormat.format(date.getTime());
//    }
//
//    public String getDate(int day, String datePattern) {
//        Calendar date = Calendar.getInstance();
//        date.add(Calendar.DATE, day);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
//        return simpleDateFormat.format(date.getTime());
//    }
//
//    public void chooseFirstOptionOfInputSelect(List<WebElement> list, String elementName) {
//        // Change the first Item to Third Item
//        clickElement(list.get(0), elementName);
//    }
//
//    /**
//     * @param webElement  WebElement
//     * @param elementText Text of Element be presented.
//     */
//    public boolean validateElementContainsText(WebElement webElement, String elementText) {
//        logger.info("+++ Check rendered of text: " + elementText.trim());
//        try {
//            String actualText = getText(webElement).trim();
//            logger.info("+++++ Actual Text is displayed: " + actualText);
//            boolean result = actualText.contains(elementText.trim());
//            logger.info("result = " + result);
//            Assert.assertTrue(result);
//            return true;
//        } catch (AssertionError error) {
//            logger.error(error);
//            logger.error("+++++ Text of Element is not: " + elementText);
//            return false;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error(e.getMessage());
//            logger.error("+++++ Text of Element is not: " + elementText);
//            return false;
//        }
//    }
//
//    /**
//     * Thuan Duong create this function.
//     * Get the current Date in the system with the format
//     *
//     * @param format which is followed.
//     * @return String currentDate with the following format
//     */
//    public String getCurrentDate(String format) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
//        Date dates = new Date();
//        String currentDate = dateFormat.format(dates);
//        logger.info("Current Date: " + currentDate);
//        return currentDate;
//    }
//
//    /**
//     * Thuan Duong create this function.
//     * Convert a date to format MM-dd-yyyy for select a date on Date Picker.
//     *
//     * @param date
//     * @return
//     */
//    public String convertToDatePickerFormat(String date) {
//        final String OLD_FORMAT = "yyyy-MMM-dd";
//        final String NEW_FORMAT = "MM-dd-yyyy";
//
//        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
//        Date d = null;
//        try {
//            d = sdf.parse(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        sdf.applyPattern(NEW_FORMAT);
//        logger.info("New Date: " + sdf.format(d));
//        return sdf.format(d);
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param tagName     expected tag name of element
//     * @param elementName name element
//     */
//    public boolean validateElementTagName(WebElement element, String tagName, String elementName) {
//        logger.info("+++ Verify element " + elementName + " have tag name: " + tagName);
//        if (element.getTagName().equalsIgnoreCase(tagName)) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * @param element element defined on page class
//     */
//    public boolean validateElementHasChild(WebElement element, String elementName) {
//        logger.info("+++ Verify element: " + elementName + " has child(descendants)");
//        List<WebElement> webElements = element.findElements(By.xpath(".//*"));
//        if (webElements.size() == 0) {
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * this function is refresh the page.
//     */
//    public void refreshPage() {
//        logger.info("+++ Refresh Page +++");
//        waitSomeSeconds(1);
//        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        getDriver().navigate().refresh();
//        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        waitSomeSeconds(1);
//    }
//
//    public void refreshWebPageAfterTimeSet(int numSecond) {
//        waitSomeSeconds(numSecond);
//        getDriver().navigate().refresh();
//        waitSomeSeconds(1);
//    }
//
//    /**
//     * Thuan Duong create this function.
//     * Convert a date to format MM-dd-yyyy for select a date on Date Picker.
//     *
//     * @param date
//     * @return
//     */
//    public String convertToDatePickerFormat(String date, String oldFormat, String newFormat) {
//        //        final String OLD_FORMAT = oldFormat;
//        //        final String NEW_FORMAT = newFormat;
//
//        SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
//        Date d = null;
//        //        logger.info("OLD_FORMAT = " + OLD_FORMAT);
//        //        logger.info("OLD_FORMAT = " + NEW_FORMAT);
//        try {
//            d = sdf.parse(date);
//            logger.info("Old Date: " + d);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        sdf.applyPattern(newFormat);
//        logger.info("New Date: " + sdf.format(d));
//        return sdf.format(d);
//    }
//
//    /**
//     * this function click back to  the page.
//     */
//    public void clickBackButtonOnBrowser() {
//        logger.info("+++ Back To Page +++");
//        waitSomeSeconds(2);
//        getDriver().navigate().back();
//        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }
//
//    /**
//     * this function click forward to the page.
//     */
//    public void clickForwardButtonOnBrowser() {
//        logger.info("+++ Forward To Page +++");
//        waitSomeSeconds(2);
//        getDriver().navigate().forward();
//        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }
//
//    public void scrollToInsideWebElement(WebElement outSideEle, WebElement insideEle) {
//        logger.info("Scroll to inside web element");
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        js.executeScript("var elt = arguments[0]; elt.scrollTop = 0;", outSideEle);
//        long scrollHeight = (long) js.executeScript("var elt = arguments[0]; return elt.scrollHeight;", outSideEle);
//        long count = 0;
//        boolean result;
//        do {
//            result = validateElementIsNotOverlap(insideEle);
//            logger.info("Overlap = " + result);
//            if (!result) {
//                count += 100;
//                js.executeScript("var elt = arguments[0]; elt.scrollTop = " + count, outSideEle);
//            } else {
//                count = scrollHeight;
//            }
//        } while (count < scrollHeight);
//        js.executeScript(
//                "var elt = arguments[0]; var rect = elt.getBoundingClientRect(); var x=rect.bottom; " + "var y=rect" +
//                        ".top; window.scrollBy(0, x-y)",
//                insideEle);
//    }
//
//    /**
//     * Thuan Duong implement
//     * Verify element is focused on.
//     *
//     * @param element which is verified.
//     * @return true if element is focused else false.
//     */
//    public boolean verifyElementIsFocus(WebElement element) {
//        logger.info("Verify element is focused on.");
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    WebElement actualElementActive = (WebElement) js.executeScript("return document.activeElement;");
//                    if (element.equals(actualElementActive)) {
//                        logger.info("Actual Element is focused: " + actualElementActive.getAttribute("outerHTML"));
//                        return true;
//                    } else
//                        return false;
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean validateElementAttributeExist(WebElement element, String attributeName) {
//        logger.info("Verify element attribute " + attributeName + " exist");
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    if (element.getAttribute(attributeName) != null) {
//                        logger.info("attribute " + attributeName + " of element is exist and value :" + element.getAttribute(attributeName));
//                        return true;
//                    } else
//                        logger.info("attribute " + attributeName + " of element is not exist and value :" + element.getAttribute(attributeName));
//                    return false;
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            return false;
//        }
//    }
//
//    public boolean verifyElementScrollbar(WebElement element) {
//        String JS_ELEMENT_IS_SCROLLABLE = "return arguments[0].scrollHeight > arguments[0].offsetHeight;";
//        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//        return (boolean) jse.executeScript(JS_ELEMENT_IS_SCROLLABLE, element);
//    }
//
//    /**
//     * Nguyen Quach: Some web elements are not loaded completely, need refresh page to load again to show them
//     */
//    public void refreshPageToLoadElement(String elementXpath, Integer loopTime) throws Throwable {
//        WebElement we;
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        for (int i = 0; i < loopTime; i++) {
//            try {
//                we = getElementByXpath(elementXpath);
//                scrollToElement(we);
//                we.click();
//                break;
//            } catch (Exception e) {
//                e.printStackTrace();
//                refreshPage();
//            }
//        }
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }
//
//    /**
//     * Get kind of browser
//     *
//     * @return browser
//     */
//    public String getBrowser() {
//        String strBrowser = "";
//        if (Generic.getPrefixFromBrowser().equals("chr.")) {
//            strBrowser = "Chrome";
//        } else if (Generic.getPrefixFromBrowser().equals("ff.")) {
//            strBrowser = "Firefox";
//        }
//        return strBrowser;
//    }
//
//    public boolean waitUntilElementIsDisplayed(WebElement webElement, String elementName) {
//        logger.info("Wait for element displayed: " + elementName);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 15);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    WebElement ele = null;
//                    try {
//                        if (webElement.isDisplayed()) {
//                            logger.info(elementName + " is displayed ");
//                            return true;
//                        } else {
//                            logger.info(elementName + " element NOT displayed");
//                            return false;
//                        }
//                    } catch (Exception e) {
//                        logger.info("Does not displayed element: " + elementName);
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//        }
//    }
//
//    public boolean waitUntilElementIsDisplayed(WebElement webElement, String elementName, int timeOutSeconds) {
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        logger.info("Wait for element displayed: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutSeconds);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        if (webElement.isDisplayed()) {
//                            logger.info(elementName + " element is displayed");
//                            return true;
//                        } else {
//                            logger.info(elementName + " element NOT displayed");
//                            return false;
//                        }
//                    } catch (Exception e) {
//                        logger.info("Does not displayed element: " + elementName);
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//        }
//    }
//
//    public boolean waitUntilPageTitleIsDisplayed(String expectedPageTitle, int timeOutSeconds) {
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        logger.info("Wait for page title is displayed: " + expectedPageTitle);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutSeconds);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        wait.until(new ExpectedCondition<Boolean>() {
//                            public Boolean apply(WebDriver driver) {
//                                if (driver.getTitle().equals(expectedPageTitle)) {
//                                    logger.info("Current page title: " + driver.getTitle());
//                                    return true;
//                                } else {
//                                    logger.info("Current page title: " + driver.getTitle());
//                                    return false;
//                                }
//                            }
//                        });
//                        return true;
//                    } catch (Exception e) {
//                        logger.info("Does not displayed page title: " + expectedPageTitle);
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//        }
//    }
//
//    public boolean waitUntilElementIsDisplayed(String elementXpath, String elementName) {
//        logger.info("Wait for element displayed: " + elementName);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    WebElement ele = null;
//                    try {
//                        if (getDriver().findElement(By.xpath(elementXpath)).isDisplayed()) {
//                            logger.info(elementXpath + " is displayed ");
//                            return true;
//                        } else {
//                            logger.info(elementXpath + " is Not displayed ");
//                            return false;
//                        }
//                    } catch (Exception e) {
//                        logger.info("Does not displayed element: " + elementXpath);
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//    }
//
//    public boolean waitUntilElementIsDisplayed(String elementXpath, String elementName, int timeOutSeconds) {
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        logger.info("Wait for element displayed: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutSeconds);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        if (getDriver().findElement(By.xpath(elementXpath)).isDisplayed()) {
//                            logger.info(elementXpath + " is displayed ");
//                            return true;
//                        } else {
//                            logger.info(elementXpath + " is Not displayed ");
//                            return false;
//                        }
//                    } catch (Exception e) {
//                        logger.info("Does not displayed element: " + elementXpath);
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//    }
//
//    public boolean waitUntilElementNotDisplayed(WebElement webElement, String elementName) {
//        logger.info("Wait for element is not displayed: " + elementName);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        if (webElement.isDisplayed()) {
//                            logger.info("Element: " + elementName + "is displayed");
//                            return false;
//                        } else {
//                            logger.info("Element: " + elementName + " not displayed");
//                            return true;
//                        }
//                    } catch (Exception e) {
//                        logger.info("Element not displayed");
//                        return true;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//    }
//
//    public boolean waitUntilElementNotDisplayed(WebElement webElement, String elementName, int timeSecond) {
//        logger.info("Wait for element is not displayed: " + elementName);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeSecond);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        if (webElement.isDisplayed()) {
//                            logger.info("Element: " + elementName + "is displayed");
//                            return false;
//                        } else {
//                            logger.info("Element: " + elementName + " not displayed");
//                            return true;
//                        }
//                    } catch (Exception e) {
//                        logger.info("Element: " + elementName + " not displayed");
//                        return true;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//    }
//
//    public boolean waitUntilElementNotDisplayed(String elementXpath, String elementName) {
//        logger.info("Wait for element is not displayed: " + elementName);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 20);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        if (getDriver().findElement(By.xpath(elementXpath)).isDisplayed()) {
//                            logger.info("Element " + elementName + " is displayed");
//                            return false;
//                        } else {
//                            logger.info("Element " + elementName + " not displayed");
//                            return true;
//                        }
//                    } catch (Exception e) {
//                        logger.info("Element not displayed");
//                        return true;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//
//        }
//    }
//
//    public boolean waitUntilElementNotDisplayed(String elementXpath, String elementName, int timeSecond) {
//        logger.info("Wait for element is not displayed: " + elementName);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeSecond);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        if (getDriver().findElement(By.xpath(elementXpath)).isDisplayed()) {
//                            logger.info("Element " + elementName + " is displayed");
//                            logger.info("Xpath: " + elementXpath);
//                            return false;
//                        } else {
//                            logger.info("Element " + elementName + " not displayed");
//                            logger.info("Xpath: " + elementXpath);
//                            return true;
//                        }
//                    } catch (Exception e) {
//                        logger.info("Element: " + elementName + " not displayed");
//                        logger.info("Xpath: " + elementXpath);
//                        return true;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//        }
//    }
//
//
//    public boolean validateCannotChangeValue(WebElement element, String text, String elementName) {
//        try {
//            logger.info("Try to change value of element: " + elementName);
//            //sendKeyTextBox(element, text, elementName);
//            element.sendKeys();
//            logger.info("Can change value of element: " + elementName);
//            return false;
//        } catch (Exception e) {
//            logger.info("Cannot change value of element: " + elementName);
//            return true;
//        }
//    }
//
//    public boolean waitAndVerifyExistingElements(String strXpath, String elementName) {
//        boolean bResult = false;
//        int count = 0;
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        do {
//            List<WebElement> eles = getElementsByXpath(strXpath, elementName);
//            logger.info(eles.size());
//            if (eles.size() > 0) {
//                bResult = true;
//                break;
//            } else {
//                waitSomeSeconds(1);
//                count++;
//            }
//        } while (count < 20);
//        waitSomeSeconds(1);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        return bResult;
//    }
//
//    public boolean waitAndVerifyExistingElements(String strXpath, String elementName, Integer waitInMiliSecondForEachFinding, Integer loop) {
//        boolean bResult = false;
//        int count = 0;
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        do {
//            List<WebElement> eles = getElementsByXpath(strXpath, elementName);
//            logger.info(eles.size());
//            if (eles.size() > 0) {
//                bResult = true;
//                break;
//            } else {
//                try {
//                    Thread.sleep(waitInMiliSecondForEachFinding);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                count++;
//            }
//        } while (count < loop);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        return bResult;
//    }
//
//    public boolean imageExist(Screen screen, String image) {
//        try {
//            screen.wait(image, 10);
//            Match m = screen.exists(new Pattern(image).similar(0.6f));
//            if (m != null)
//                return true;
//            else
//                return false;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public boolean imageExist(Screen screen, String image, float matchPercent) {
//        try {
//            screen.wait(image, 10);
//            Match m = screen.exists(new Pattern(image).similar(matchPercent));
//            if (m != null)
//                return true;
//            else
//                return false;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    private WebElement getElementIfDisplays(String xpath, int timeOut, int pollingEvery) {
//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(timeOut))
//                .pollingEvery(Duration.ofSeconds(pollingEvery))
//                .ignoring(NoSuchElementException.class);
//        WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
//            public WebElement apply(WebDriver driver) {
//                logger.info("Wait element with xpath: " + xpath);
//                return driver.findElement(By.xpath(xpath));
//            }
//        });
//        logger.info("+++++ Element is display.");
//        return webElement;
//    }
//
//    public WebElement waitElementIsDisplay(String xpath, int timeOut, int pollingEvery) {
//        WebElement webElement = null;
//        try {
//            webElement = getElementIfDisplays(xpath, timeOut, pollingEvery);
//        } catch (org.openqa.selenium.TimeoutException e) {
//            Assert.fail("Could not found element: " + xpath);
//        }
//        return webElement;
//    }
//
//    /*
//    Parameter:
//    type = [true, false, skipped]
//    true : the top of the element will be aligned to the top of the visible area of the scrollable ancestor
//    false : the bottom of the element will be aligned to the bottom of the visible area of the scrollable ancestor
//    skipped : it will scroll to the top of the element
//    * */
//    public void scrollElementToView(WebElement webElement, String type) {
//        logger.info("Scroll to " + webElement);
//
//        if (type.equalsIgnoreCase("center")) {
//            type = "{block: \"center\"}";
//        }
//        ((JavascriptExecutor) getDriver()).executeScript(String.format("arguments[0].scrollIntoView(%s)", type), webElement);
//        waitSomeSeconds(1);
//    }
//
//    public void scrollElementToView(WebElement webElement) {
//        scrollElementToView(webElement, "center");
//    }
//
//    public boolean isInnerAnotherElement(WebElement parent, WebElement child) {
//        // Get location of parent
//        int widthParent = parent.getRect().width;
//        int heightParent = parent.getRect().height;
//        int leftParent = parent.getRect().x;
//        int topParent = parent.getRect().y;
//        int horizontalRangeParent = leftParent + widthParent;
//        int verticalRangeParent = topParent + heightParent;
//
//        // Get location of child
//        int widthChild = child.getRect().width;
//        int heightChild = child.getRect().height;
//        int leftChild = child.getRect().x;
//        int topChild = child.getRect().y;
//        int horizontalRangeChild = leftChild + widthChild;
//        int verticalRangeChild = topChild + heightChild;
//
//        return leftParent <= leftChild && horizontalRangeParent >= horizontalRangeChild && verticalRangeParent >= verticalRangeChild;
//    }
//
//    public void scrollElementToMiddleView(WebElement webElement) {
//        logger.info("Scroll element to middle view.");
//        WebElement mainView = getElementByXpath("(//div[contains(@class,'planning-content')])[1]");
//        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
//                + "var elementTop = arguments[0].getBoundingClientRect().top;"
//                + "arguments[1].scrollBy(0, elementTop-(viewPortHeight/2));";
//        logger.info("Script: " + scrollElementIntoMiddle);
//        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, webElement, mainView);
//        Assert.assertTrue(isElementInViewport(webElement, 3), "Cannot scroll to element");
//
//    }
//
//    public void scrollToElementInsideElement(WebElement insideElement, WebElement outsideElement) {
//        logger.info("Scroll element to middle view.");
//        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
//                + "var elementTop = arguments[0].getBoundingClientRect().top;"
//                + "arguments[1].scrollBy(0, elementTop-(viewPortHeight/2));";
//        logger.info("Script: " + scrollElementIntoMiddle);
//        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, insideElement, outsideElement);
//    }
//
//    public boolean elementIsExisting(String xpath, int timeOut) {
//        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
//        boolean existing = driver.findElements(By.xpath(xpath)).size() > 0;
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        return existing;
//    }
//
//    public String getDatePickerString(int difference, String format) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DATE, difference);
//        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
//        return simpleDateFormat.format(calendar.getTime());
//    }
//
//    public void clearContent(WebElement webElement) {
//        String text = getText(webElement);
//        if (text != null && !text.isEmpty()) {
//            int length = text.length();
//            Actions action = new Actions(driver).click(webElement);
//            for (int i = 0; i < length; i++) {
//                action.release().sendKeys(Keys.BACK_SPACE);
//            }
//            action.build().perform();
//            text = getText(webElement);
//            if (text != null && !text.isEmpty()) {
//                for (int i = 0; i < length; i++) {
//                    action.release().sendKeys(Keys.DELETE);
//                }
//                action.build().perform();
//            }
//        }
//    }
//
//
//    public boolean isElementInViewport(WebElement el, int timeOut) {
//        boolean result = false;
//        int i = 0;
//        do {
//            int xCordinate = el.getLocation().getX();
//            int yCordinate = el.getLocation().getY();
//            logger.info(" element x coordinate: " + xCordinate);
//            logger.info(" element y coordinate: " + yCordinate);
//            int screenHeight = driver.manage().window().getSize().getHeight();
//            int screenWith = driver.manage().window().getSize().getWidth();
//            logger.info(" Screen width  : " + screenWith);
//            logger.info(" Screen height : " + screenHeight);
//            if (xCordinate >= 0 && yCordinate >= 0 && xCordinate <= screenWith && yCordinate <= screenHeight) {
//                return true;
//            }
//            i++;
//            waitSomeSeconds(1);
//        } while (i < timeOut && !result);
//        return result;
//    }
//
//    public boolean isElementInOtherElementView(WebElement testElement, WebElement containerElement, int timeOut) {
//        boolean result = false;
//        int i = 0;
//        do {
//            //X from left element side
//            //Y from top element side
//            int xContainerCoordinate = containerElement.getLocation().getX();
//            int yContainerCoordinate = containerElement.getLocation().getY();
//            int containerWidth = xContainerCoordinate + containerElement.getSize().getWidth();
//            int containerHeight = yContainerCoordinate + containerElement.getSize().getHeight();
//            logger.info("xContainerCoordinate: " + xContainerCoordinate);
//            logger.info("yContainerCoordinate: " + yContainerCoordinate);
//            logger.info("containerWidth: " + containerWidth);
//            logger.info("containerHeight: " + containerHeight);
//            int xElementCoordinate = testElement.getLocation().getX();
//            int yElementCoordinate = testElement.getLocation().getY();
//            int elementWidth = xElementCoordinate + testElement.getSize().getWidth();
//            int elementHeight = yElementCoordinate + testElement.getSize().getHeight();
//            logger.info("xCoordinate: " + xElementCoordinate);
//            logger.info("yCoordinate: " + yElementCoordinate);
//            logger.info("elementWidth: " + elementWidth);
//            logger.info("elementHeight: " + elementHeight);
//            boolean xCoordinateBoolean = xContainerCoordinate <= xElementCoordinate;
//            boolean widthBoolean = elementWidth <= containerWidth;
//            boolean yCoordinateBoolean = yContainerCoordinate <= yElementCoordinate;
//            boolean heightBoolean = elementHeight <= containerHeight;
//            if (xCoordinateBoolean && widthBoolean && yCoordinateBoolean && heightBoolean) {
//                result = true;
//            }
//            i++;
//            waitSomeSeconds(1);
//        } while (i < timeOut && !result);
//        return result;
//    }
//
//    public boolean isElementInViewport(String xpath, int timeOut) {
//        boolean result = false;
//        int i = 0;
//        do {
//            WebElement el = getElementByXpath(xpath);
//            int xCordinate = el.getLocation().getX();
//            int yCordinate = el.getLocation().getY();
//            logger.info(" element x coordinate: " + xCordinate);
//            logger.info(" element y coordinate: " + yCordinate);
//            int screenHeight = driver.manage().window().getSize().getHeight();
//            int screenWith = driver.manage().window().getSize().getWidth();
//            logger.info(" Screen width  : " + screenWith);
//            logger.info(" Screen height : " + screenHeight);
//            if (xCordinate >= 0 && yCordinate >= 0 && xCordinate <= screenWith && yCordinate <= screenHeight) {
//                return true;
//            }
//            i++;
//            waitSomeSeconds(1);
//        } while (i < timeOut && !result);
//        return result;
//    }
//
//    public boolean verifyClearContent(WebElement webElement) {
//        String text = getText(webElement);
//        if (text == null || text.isEmpty()) {
//            return false;
//        }
//        clearContent(webElement);
//        text = getText(webElement);
//        if (text == null || text.isEmpty()) {
//            return true;
//        }
//        return false;
//    }
//
//    public void setDatePicker(WebElement datePickerInput, int difference, String format) {
//        scrollElementToView(datePickerInput, "false");
//        datePickerInput.click();
//        clearContent(datePickerInput);
//        String date = getDatePickerString(difference, format);
//        datePickerInput.sendKeys(date);
//        datePickerInput.click();
//    }
//
//    public void actionClick(WebElement webElement) {
//        Actions action = new Actions(driver);
//        action.release().moveToElement(webElement);
//        action.click(webElement);
//        action.build().perform();
//    }
//
//    public void actionDoubleClick(WebElement webElement) {
//        Actions action = new Actions(driver);
//        action.release().moveToElement(webElement);
//        action.doubleClick(webElement);
//        action.build().perform();
//    }
//
//    public boolean equalLists(List<String> a, List<String> b) {
//        // Check for sizes and nulls
//
//        if (a == null && b == null) return true;
//
//        if ((a == null && b != null) || (a != null && b == null) || (a.size() != b.size()))
//            return false;
//
//        // Sort and compare the two lists
//        Collections.sort(a);
//        Collections.sort(b);
//        return a.equals(b);
//    }
//
//    public Date stringToDate(String strDate, int type, String strLocale) {
//        try {
//            Locale locale = stringToLocale(strLocale);
//            DateFormat df = DateFormat.getDateInstance(type, locale);
//            return df.parse(strDate);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    public void unfocusActiveElement() {
//        logger.info("Blur mouse event on active element");
//        try {
//            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
//            jse.executeScript("!!document.activeElement ? document.activeElement.blur() : 0");
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//        }
//    }
//
//    public Locale stringToLocale(String str) {
//        Locale locale = null;
//        switch (str) {
//            case "English (United States)":
//                locale = Locale.US;
//                break;
//            case "English (United Kingdom)":
//                locale = Locale.UK;
//                break;
//            case "Japanese (Japan)":
//                locale = Locale.JAPANESE;
//                break;
//            default:
//                locale = Locale.US;
//                break;
//        }
//        return locale;
//    }
//
//    public void seeTotalTabs(int expectedTotal) throws Throwable {
//        int count = 0;
//        do {
//            int totalTabs = driver.getWindowHandles().size();
//            logger.info("Total tabs: " + totalTabs);
//            if (totalTabs == expectedTotal) {
//                break;
//            } else {
//                waitSomeSeconds(1);
//                count++;
//            }
//        } while (count < 10);
//        Assert.assertEquals(driver.getWindowHandles().size(), expectedTotal, "Current opening tabs should be: " + expectedTotal);
//    }
//
//
//    public boolean verifyElementCannotClickable(WebElement element, String elementName) {
//        logger.info("Verify element cannot clickable");
//        try {
//            element.click();
//            logger.info("Element " + elementName + " can be clickable");
//            return false;
//        } catch (ElementClickInterceptedException ex) {
//            logger.info("Element " + elementName + " can not be clickable");
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            return false;
//        }
//    }
//
//    public String getBrowserLanguage() {
//        String browserLanguage = "";
//        try {
//            browserLanguage = (String) ((JavascriptExecutor) getDriver()).executeScript("return window.navigator.language");
//            logger.info("+++++ browser Language is: " + browserLanguage);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//            logger.error("+++++ Unable to get browser Language");
//        }
//        return browserLanguage;
//    }
//
//    public boolean validateScrollBar(String type, WebElement xpathElement, String elementName) {
//        boolean result = false;
//        try {
//            JavascriptExecutor js = (JavascriptExecutor) getDriver();
//            if (type.equalsIgnoreCase("Horizontal")) {
//                result = (boolean) js.executeScript("return arguments[0].scrollWidth > arguments[0].offsetWidth;", xpathElement);
//            } else {
//                result = (boolean) js.executeScript("return arguments[0].scrollHeight > arguments[0].offsetHeight;", xpathElement);
//            }
//            if (result) {
//                logger.info(elementName + " has " + type + " scroll bar");
//            } else {
//                logger.info(elementName + " has not " + type + " scroll bar");
//            }
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//        return result;
//    }
//
//    public HashMap<String, Integer> getScrollBarProperties(WebElement element, String elementName) {
//        HashMap<String, Integer> properties = new HashMap<String, Integer>();
//        try {
//            JavascriptExecutor js = (JavascriptExecutor) getDriver();
//            properties.put("scrollWidth", ((Long) js.executeScript("return arguments[0].scrollWidth;", element)).intValue());
//            properties.put("offsetWidth", ((Long) js.executeScript("return arguments[0].offsetWidth;", element)).intValue());
//            properties.put("scrollLeft", ((Long) js.executeScript("return arguments[0].scrollLeft;", element)).intValue());
//            properties.put("scrollHeight", ((Long) js.executeScript("return arguments[0].scrollHeight;", element)).intValue());
//            properties.put("offsetHeight", ((Long) js.executeScript("return arguments[0].offsetHeight;", element)).intValue());
//            properties.put("scrollTop", ((Long) js.executeScript("return arguments[0].scrollTop;", element)).intValue());
//            logger.info(String.format("%s has scrollbar properties: %s", elementName, properties.toString()));
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//        return properties;
//    }
//
//    public void verticalScrollToPositionOnElement(String xpath, String position) {
//        WebElement element = waitElementIsDisplay(xpath, 5, 2);
//        verticalScrollToPositionOnElement(element, position);
//    }
//
//    public void verticalScrollToPositionOnElement(WebElement element, String position) {
//        logger.info(String.format("Scroll to %s of element", position));
//        long value;
//        JavascriptExecutor js = driver;
//        if (position.equalsIgnoreCase("top")) {
//            value = 0;
//        } else if (position.equalsIgnoreCase("bottom")) {
//            value = (Long) js.executeScript("return arguments[0].scrollHeight", element);
//        } else if (position.equalsIgnoreCase("middle")) {
//            value = ((Long) js.executeScript("return arguments[0].scrollHeight", element)) / 2;
//        } else {
//            throw new AssertionError("Invalid position value: " + position);
//        }
//        js.executeScript("arguments[0].scrollTop = arguments[1];", element, value);
//        waitSomeSeconds(1);
//    }
//
//    public void closeCurrentTabByJavascript() {
//        try {
//            JavascriptExecutor js = (JavascriptExecutor) getDriver();
//            js.executeScript("window.top.close();");
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//    }
//
//    public void highlightTextOfElement(WebElement webElement, String type) {
//        Actions actions = new Actions(driver);
//        clickElement(webElement, "highlight text");
//        if (type.equalsIgnoreCase("all")) {
//            actions.release().moveToElement(webElement).clickAndHold().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).release().pause(1000).perform();
//        } else {
//            actions.release().moveToElement(webElement).clickAndHold().keyDown(Keys.SHIFT).sendKeys(Keys.ARROW_LEFT).keyUp(Keys.SHIFT).release().pause(1000).perform();
//        }
//        waitSomeSeconds(1);
//    }
//
//    public void zoomInBrowserByJavascript(String percent) {
//        try {
//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            executor.executeScript("document.body.style.zoom = arguments[0]", percent);
//        } catch (Exception e) {
//            logger.error(e.getMessage());
//        }
//    }
//
//    public String captureElementScreenshot(String xpath, String formatName) throws IOException {
//        WebElement element = getElementByXpath(xpath);
//        return captureElementScreenshot(element, formatName);
//    }
//
//    public String captureElementScreenshot(WebElement element, String formatName) throws IOException, IOException {
//
//        //Capture entire page screenshot as buffer.
//        //Used TakesScreenshot, OutputType Interface of selenium and File class of java to capture screenshot of entire page.
//        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        //Used selenium getSize() method to get height and width of element.
//        //Retrieve width of element.
//        int ImageWidth = element.getSize().getWidth();
//        //Retrieve height of element.
//        int ImageHeight = element.getSize().getHeight();
//
//        //Used selenium Point class to get x y coordinates of Image element.
//        //get location(x y coordinates) of the element.
//        Point point = element.getLocation();
//        int xcord = point.getX();
//        int ycord = point.getY();
//
//        //Reading full image screenshot.
//        BufferedImage img = ImageIO.read(screen);
//        logger.info(String.format("Element: X: %s - Y: %s - Width: %s - Height: %s", xcord, ycord, ImageWidth, ImageHeight));
//
//        //cut Image using height, width and x y coordinates parameters.
//        BufferedImage dest = img.getSubimage(xcord, ycord, ImageWidth, ImageHeight);
//        ImageIO.write(dest, "PNG", screen);
//
//        String fileName = "screenshot_" + UUID.randomUUID().toString() + formatName;
//        //Used FileUtils class of apache.commons.io.
//        //save Image screenshot In D: drive.
//        String pathImage = convertDirectory(Generic.FOLDER_UPLOAD) + "Screenshot/" + fileName;
//        FileUtils.copyFile(screen, new File(pathImage));
//        return pathImage;
//    }
//
//
//    public void copyTextInput(WebElement inputElement) {
//        inputElement.click();
//        inputElement.sendKeys(Keys.CONTROL, "a");
//        inputElement.sendKeys(Keys.CONTROL, "c");
//    }
//
//    public void pasteTextInput(WebElement inputElement) {
//        inputElement.click();
//        inputElement.sendKeys(Keys.CONTROL, "a");
//        inputElement.sendKeys(Keys.DELETE);
//        inputElement.sendKeys(Keys.CONTROL, "v");
//    }
//
//    public String getClipboard() throws IOException, UnsupportedFlavorException {
//        return (String) Toolkit.getDefaultToolkit()
//                .getSystemClipboard().getData(DataFlavor.stringFlavor);
//    }
//
//    public void doubleClickElement(WebElement element, String elementName) {
//        logger.info("Double click on elemennt: " + elementName);
//        Actions action = new Actions(getDriver());
//        action.moveToElement(element).doubleClick().perform();
//    }
//
//    public boolean findImageExistInElement(String imgPath, WebElement element) throws IOException {
//        //Get size and position of element
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//        String xString = String.valueOf(js.executeScript("return arguments[0].getBoundingClientRect().x;", element));
//        String yString = String.valueOf(js.executeScript("return arguments[0].getBoundingClientRect().y;", element));
//        String widthString = String.valueOf(js.executeScript("return arguments[0].getBoundingClientRect().width;", element));
//        String heightString = String.valueOf(js.executeScript("return arguments[0].getBoundingClientRect().height;", element));
//        Double xDouble = Double.parseDouble(xString);
//        Double yDouble = Double.parseDouble(yString);
//        Double widthDouble = Double.parseDouble(widthString);
//        Double heightDouble = Double.parseDouble(heightString);
//
//        int imageWidth = widthDouble.intValue();
//        int imageHeight = heightDouble.intValue();
//        int xCord = xDouble.intValue();
//        int yCord = yDouble.intValue();
//
//        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        Pattern pattern = new Pattern(imgPath);
//        BufferedImage img = ImageIO.read(screen);
//        logger.info(String.format("Img: MinX: %s - MinY: %s - Width: %s - Height: %s", img.getMinX(), img.getMinY(), img.getWidth(), img.getHeight()));
//        logger.info(String.format("Element: X: %s - Y: %s - Width: %s - Height: %s", xCord, yCord, imageWidth, imageHeight));
//        BufferedImage dest = img.getSubimage(xCord, yCord, imageWidth, imageHeight);
////        Save capture incase you need check after run testcase
//        ImageIO.write(dest, "png", screen);
//        String fileName = "screenshot_" + UUID.randomUUID().toString() + ".png";
//        String pathImage = convertDirectory(Generic.FOLDER_UPLOAD) + "Screenshot/" + fileName;
//        FileUtils.copyFile(screen, new File(pathImage));
////        End
//        Finder finder = new Finder(dest);
//        finder.find(pattern);
//        if (finder.hasNext()) {
//            Match m = finder.next();
//            logger.info("Match found with " + (m.getScore()) * 100 + "%");
//            finder.destroy();
//            return m.getScore() >= (double) 0.95;
//
//        } else {
//            logger.info("Image has no match found with path: " + imgPath);
//            logger.info(String.format("Please open image: [%s] to check your capture", pathImage));
//            return false;
//        }
//    }
//
//    public void sendEnterKey() {
//        new Actions(driver).sendKeys(Keys.ENTER).perform();
//    }
//
//    public void sendTabKey() {
//        new Actions(driver).sendKeys(Keys.TAB).perform();
//    }
//
//
//    public String getComputedCSSValue(WebElement element, String pseudo, String property) {
//        String style = String.format("return window.getComputedStyle(arguments[0],'%s').getPropertyValue('%s')", pseudo, property);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        return js.executeScript(style, element).toString();
//    }
//
//    public String getComputedCSSValue(String cssSelector, String pseudo, String property) {
//        String style = String.format("return window.getComputedStyle(document.querySelector('%s'),'%s').getPropertyValue('%s')", cssSelector, pseudo, property);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        return js.executeScript(style).toString();
//    }
//
//    public String replaceNonBreakingSpace(String text) {
//        return text.replace(StringEscapeUtils.unescapeHtml("&nbsp;"), " ");
//    }
//
//    public String replaceSpecialCharacter(String text, String specialCharacter, String expectedCharacter) {
//        return text.replace(StringEscapeUtils.unescapeHtml(specialCharacter), expectedCharacter);
//    }
//
//    public String getCurrentDateWithTimeZone(String format, String timeZone) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
//        Date dates = new Date();
//        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
//        String currentDate = dateFormat.format(dates);
//        logger.info("Current Date: " + currentDate);
//        return currentDate;
//    }
//
//    public List getListText(List<WebElement> listElement) {
//        try {
//            List<String> listString = listElement.stream().map(item -> item.getText()).collect(Collectors.toList());
////            if (listString.isEmpty())
////                Assert.fail("Cannot get string from list element");
//            logger.info("Get list String " + listString);
//            return listString;
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.info("No text in List Element");
//            return null;
//        }
//    }
//
//    public void verifyListEqualsList(List<String> a, List<String> b, boolean sorted) {
//        if (sorted) {
//            Collections.sort(a);
//            Collections.sort(b);
//        }
//        List<String> errorMessage = new ArrayList();
//        Assert.assertEquals(a.size(), b.size(), String.format("Size of list [%s] is not equal with [%s]", a, b));
//        for (int i = 0; i < a.size(); i++) {
//            try {
//                Assert.assertEquals(a.get(i), b.get(i));
//            } catch (AssertionError e) {
//                errorMessage.add(e.getMessage());
//            }
//        }
//        Assert.assertTrue(errorMessage.isEmpty(), errorMessage.toString());
//    }
//
//    /***
//     *
//     * @param list: big list
//     * @param subList: sub list
//     */
//    public void verifyListContainsList(List<String> list, List<String> subList) {
//        List<String> errorMessage = new ArrayList();
//        for (String s : subList) {
//            try {
//                Assert.assertTrue(list.contains(s), String.format("Not found [%s] in list", s));
//            } catch (AssertionError e) {
//                errorMessage.add(e.getMessage());
//            }
//        }
//        Assert.assertTrue(errorMessage.isEmpty(), errorMessage.toString());
//    }
//
//    public boolean waitUntilElementTextNotEmpty(String xpath, int timeout) {
//        logger.info("Wait for element text is not empty");
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    try {
//                        WebElement webElement = getElementByXpath(xpath);
//                        if (webElement.getText().isEmpty()) {
//                            return false;
//                        } else {
//                            logger.info("Text of element: " + webElement.getText());
//                            return true;
//                        }
//                    } catch (Exception e) {
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//        }
//    }
//
//    public boolean waitUntilElementTextNotEmpty(WebElement webElement, int timeout) {
//        logger.info("Wait for element text is not empty");
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    if (webElement.getText().isEmpty()) {
//                        return false;
//                    } else {
//                        logger.info("Text of element: " + webElement.getText());
//                        return true;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//        }
//    }
//
//    public List<WebElement> getElementsByCss(String cssSelector, String... arg) {
//        List<WebElement> webElements = new ArrayList<>();
//        cssSelector = String.format(cssSelector, arg);
//        logger.info("css Selector = " + cssSelector);
//        try {
//            webElements = getDriver().findElements(By.cssSelector(cssSelector));
//        } catch (Exception ex) {
//            logger.info(ex.getMessage());
//        }
//        return webElements;
//    }
//
//    public void sendKeyOnBrowser(String key) {
//        Keys keyCode = Keys.NULL;
//        if (key.equalsIgnoreCase("Enter")) {
//            keyCode = Keys.ENTER;
//        } else if (key.equalsIgnoreCase("Tab")) {
//            keyCode = Keys.TAB;
//        } else if (key.equalsIgnoreCase("Page down")) {
//            keyCode = Keys.PAGE_DOWN;
//        } else if (key.equalsIgnoreCase("Arrow down")) {
//            keyCode = Keys.ARROW_DOWN;
//        } else if (key.equalsIgnoreCase("Esc")) {
//            keyCode = Keys.ESCAPE;
//        }
//        new Actions(driver).sendKeys(keyCode).perform();
//    }
//
//    public void getEmailDomain(String email) {
//        emailDomain = email.substring(email.indexOf("@"));
//    }
//
//    public String translateEmail(String userName) {
//        User user = null;
//        try {
//            user = TestDataUtilities.getUserByUsername(userName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (user != null) {
//            userName = user.getEmail();
//        }
//        if (!userName.contains("@") && !userName.contains("username:") && !userName.contains(" ")) {
//            userName = userName + emailDomain;
//        }
//        return userName;
//    }
//
//    public static String translateUserFullName(String userName) throws Throwable {
//        if (userName.equalsIgnoreCase("user1")) {
//            userName = TestDataUtilities.getUser1().getFullName();
//        } else if (userName.equalsIgnoreCase("user2")) {
//            userName = TestDataUtilities.getUser2().getFullName();
//        } else if (userName.equalsIgnoreCase("user3")) {
//            userName = TestDataUtilities.getUser3().getFullName();
//        }
//        return userName;
//    }
//
//    public int getColumnIndexByXpath(String xpath, String... params) {
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            String columnXpath = xpath.substring(0, xpath.lastIndexOf("/preceding-sibling::"));
//            // Remove last slash if any
//            if (columnXpath.substring(columnXpath.length() - 1).equalsIgnoreCase("/")) {
//                columnXpath = columnXpath.substring(0, columnXpath.length() - 1);
//                logger.info("Xpath after trim /: " + columnXpath);
//            }
//            Assert.assertNotNull(waitElementIsDisplay(String.format(columnXpath, params), 10, 1), "Column name is not exist");
//            int value = getElementsByXpath(xpath, params).size() + 1;
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return value;
//        } catch (Exception e) {
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            throw new AssertionError("Invalid xpath to get column index: " + e.toString());
//        }
//    }
//
//    /**
//     * @param element     element defined on page class
//     * @param elementName Name of element that we want to verify
//     * @Description In order to wait element to be visible.
//     */
//    public boolean waitForCssValueContains(WebElement element, String elementName, String cssName, String cssValue) {
//        logger.info("Try to waitForCssValueChanged: " + elementName);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 15);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    String actualcssValue = element.getCssValue(cssName);
//                    logger.info("Expected Displayed Value: " + cssValue);
//                    logger.info("Actual Displayed Value: " + actualcssValue);
//                    if (actualcssValue.contains(cssValue))
//                        return true;
//                    else
//                        return false;
//                }
//            });
//            return true;
//        } catch (Exception e) {
//            logger.error(e);
//            logger.error("CSS Value is not changed");
//            return false;
//        }
//    }
//
//    public void clickOutSideByRobotKey() throws Exception {
//        //Setup robot
//        Robot robot = new Robot();
//        robot.setAutoDelay(50);
//
//        //Fullscreen page so selenium coordinates work
//        robot.keyPress(KeyEvent.VK_F11);
//        logger.info("Open full screen mode");
//        Thread.sleep(2000);
//
//        //Find x and y coordinates to pass to mouseMove method
//        //1. Get the size of the current window.
//        //2. Dimension class is similar to java Point class which represents a location in a two-dimensional (x, y) coordinate space.
//        Dimension i = driver.manage().window().getSize();
//        logger.info("Dimension x and y :" + i.getWidth() + " " + i.getHeight());
//
////        //3. Get the height and width of the screen
////        int x = (i.getWidth() / 4) + 50;
////        logger.info("X: " + x);
////        int y = (i.getHeight() / 8) + 50;
////        logger.info("Y: " + y);
//
//        //4. Now, adjust the x and y coordinates with reference to the Windows popup size on the screen
//        robot.mouseMove(180, 50);
//
//        //Clicks Left mouse button
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        System.out.println("Browse button clicked");
//        Thread.sleep(2000);
//
//        logger.info("Close full screen mode");
//        robot.keyPress(KeyEvent.VK_F11);
//        robot.keyRelease(KeyEvent.VK_F11);
//    }
//
//
//    public boolean compareImageByPathFile(String pathFile1, String pathFile2) throws IOException {
//        BufferedImage bufferedImage1 = ImageIO.read(new File(pathFile1));
//
//        Finder finder = new Finder(bufferedImage1);
//        finder.find(pathFile2);
//        if (finder.hasNext()) {
//            Match m = finder.next();
//            logger.info("Match found with " + (m.getScore()) * 100 + "%");
//            finder.destroy();
//            return m.getScore() >= (double) 0.95;
//        } else {
//            logger.info(String.format("Image with path: %s has no match found with path: %s", pathFile1, pathFile2));
//            return false;
//        }
//    }
//
//    public boolean findImageExistsOnScreenCapture(String expectedImagePath, double... arg) throws IOException {
//        Pattern expectedPattern = new Pattern(expectedImagePath);
//        Screen screen = Screen.getPrimaryScreen();
//        BufferedImage actualCapture = screen.capture().getImage();
//        String actualCaptureExportName = "screenshot_Logo_" + UUID.randomUUID().toString() + ".png";
//        String actualCaptureExportPath = convertDirectory(Generic.FOLDER_DOWNLOAD) + actualCaptureExportName;
//        ImageIO.write(actualCapture, "PNG", new File(actualCaptureExportPath));
//
//        Finder finder = new Finder(actualCapture);
//        finder.find(expectedPattern);
//        if (finder.hasNext()) {
//            Match m = finder.next();
//            logger.info("Match found with " + (m.getScore()) * 100 + "%");
//            finder.destroy();
//            double percent = 0.95;
//            if (arg.length > 0) {
//                percent = arg[0];
//            }
//            return m.getScore() >= percent;
//        } else {
//            logger.info("Image has no match found with path: " + expectedImagePath);
//            logger.info(String.format("Please open image: [%s] to check your capture", actualCaptureExportPath));
//            return false;
//        }
//    }
//
//    public String getSelectionByJavascript() {
//        logger.info("Get highlighted text on page by javascript");
//        String selectedText = "";
//        try {
//            JavascriptExecutor js = (JavascriptExecutor) getDriver();
//            selectedText = js.executeScript("return window.getSelection().toString();").toString();
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//        }
//        return selectedText;
//    }
//
//    public boolean waitUntilBrowserUrlChanged(String expectedUrl, int timeout) {
//        logger.info("Wait for element displayed: " + expectedUrl);
//        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
//            wait.until(new ExpectedCondition<Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                    WebElement ele = null;
//                    try {
//                        String actualUrl = getDriver().getCurrentUrl();
//                        return expectedUrl.equalsIgnoreCase(actualUrl);
//                    } catch (Exception e) {
//                        logger.info("Does not displayed element: " + expectedUrl);
//                        return false;
//                    }
//                }
//            });
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//            return false;
//        }
//    }
//
//    public String getSessionId() {
//        SessionId id = ((RemoteWebDriver) getDriver()).getSessionId();
//        logger.info("Session id: " + id.toString());
//        return id.toString();
//    }
//
//    public String getElementXpathByIndex(String xpath, int index) {
//        return String.format("(%s)[%s]", xpath, index);
//    }
//
//    public void focusOnBrowser() throws Throwable {
//        getDriver().manage().window().setPosition(new Point(0, -1000));
//        Thread.sleep(1000);
//        getDriver().manage().window().maximize();
//        Thread.sleep(2000);
//    }
//
//    public void closeCurrentTabOrBrowserByShotcutKey(String option) throws Throwable {
//        Robot robot = null;
//        if (option.equalsIgnoreCase("tab")) {
//            try {
//                logger.info("***Focus on Chrome Driver***");
//                Thread.sleep(300);
//                robot = new Robot();
//                robot.delay(2);
//                robot.keyPress(KeyEvent.VK_CONTROL);
//                robot.keyPress(KeyEvent.VK_W);
//                Thread.sleep(300);
//                robot.keyRelease(KeyEvent.VK_W);
//                robot.keyRelease(KeyEvent.VK_CONTROL);
//                Thread.sleep(300);
//                Thread.sleep(1000);
//            } catch (AWTException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        } else if (option.equalsIgnoreCase("browser")) {
//            try {
//                logger.info("***Focus on Chrome Driver***");
//                Thread.sleep(300);
//                robot = new Robot();
//                robot.delay(2);
//                robot.keyPress(KeyEvent.VK_ALT);
//                robot.keyPress(KeyEvent.VK_F4);
//                Thread.sleep(300);
//                robot.keyRelease(KeyEvent.VK_F4);
//                robot.keyRelease(KeyEvent.VK_ALT);
//                Thread.sleep(300);
//                Thread.sleep(1000);
//            } catch (AWTException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public void sendEscByRobotKey() {
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_ESCAPE);
//            robot.delay(200);
//            robot.keyRelease(KeyEvent.VK_ESCAPE);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
