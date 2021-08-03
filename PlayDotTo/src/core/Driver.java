package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.enums.Browser;

import java.util.List;

public class Driver implements _GLOBAL_VARIABLES {
    public static WebDriver driver;
    public static WebDriverWait wait;// = new WebDriverWait(driver, 20);
    public static Actions builder;// = new Actions(driver);
    public static Alert alert;
    public static boolean ie;
    public static boolean chrome;

    public static void ieDriver(){
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        //cap.setCapability("nativeEvents", false);
        //cap.setCapability("unexpectedAlertBehaviour", "accept");
        //cap.setCapability("ignoreProtectedModeSettings", true);
        //cap.setCapability("disable-popup-blocking", true);
        //cap.setCapability("enablePersistentHover", true);
        //cap.setCapability("ignoreZoomSetting", true);
        cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.merge(cap);

        driver = new InternetExplorerDriver(options);
        ie = true;
    }
    public static void chromeDriver(){
        driver = new ChromeDriver();
        chrome = true;
    }

    public static WebDriver getDriver(){
        if (driver == null) {
            if(ie) {
                driver = new InternetExplorerDriver();
            } else {
                driver = new ChromeDriver();
            }
        }
        return driver;
    }
    public static WebDriverWait getWait(){
        wait = new WebDriverWait(driver, 20);
        return wait;
    }
    public static void waitUntilAttributeToBe(WebElement element, String attribute, String value){
        Driver.getWait().until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    public static Actions getActions(){
        builder = new Actions(driver);
        return builder;
    }
    public static Alert getAlert(){
        Alert alert = Driver.getDriver().switchTo().alert();
        return alert;
    }
    public static void startSelenium(Browser browser) {
        if(browser.toString().equals("ie")) {
            System.setProperty("webdriver.ie.driver", IE_DRIVER);
            Driver.ieDriver();
        } else if(browser.toString().equals("chrome")){
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER);
            Driver.chromeDriver();
        }
        driver.manage().window().maximize();
        Driver.getDriver().get(START_WEB_PAGE);
    }
    public static WebElement findElementById(String elem) {
        return getDriver().findElement(By.id(elem));
    }
    public static WebElement findElementByXpath(String elem) {
        return getDriver().findElement(By.xpath(elem));
    }
    public static List<WebElement> findElementsByXpath(String xpath) {
        return getDriver().findElements(By.xpath(xpath));
    }
    public static void click(String object) {
        Driver.getDriver().findElement(By.xpath(object)).click();
    }
    public static void sendKeys(String object, String text) {
        String value = Driver.getDriver().findElement(By.xpath(object)).getAttribute("value");
        if(value != null) {
            Driver.getDriver().findElement(By.xpath(object)).clear();
        }
        Driver.getDriver().findElement(By.xpath(object)).sendKeys(text);
    }
    public static String getTitle(String object) {
        return findElementByXpath(object).getAttribute("title");
    }
    public static String getValue(String object) {
        return findElementByXpath(object).getAttribute("Value");
    }
    public static String getText(String object) {
        return findElementByXpath(object).getText();
    }
}

