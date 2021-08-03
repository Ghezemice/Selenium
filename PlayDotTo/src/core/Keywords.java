package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Keywords implements _OBJECTS {
    public static List<WebElement> getAllDots(){
        return Driver.findElementsByXpath(dot);
    }
    public static void startPlay(){
        Driver.getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(dot+"[2]")));
        List<WebElement> dots = getAllDots();
        drag(dots.get(0), dots.get(1));
    }
    public static void drag(WebElement honnan, WebElement hova){
        Driver.getActions().dragAndDrop(honnan, hova).build().perform();
    }
}
