package front;

import core.Driver;
import core.Keywords;
import core._OBJECTS;
import core.enums.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Play2 implements _OBJECTS {
    public static void main(String[] args) throws InterruptedException {
        Driver.startSelenium(Browser.CHROME);
        Actions builder = new Actions(Driver.getDriver());

        for (int i = 0; i < 5; i++) {
            Keywords.startPlay();
            String finish = getFinishAttr();

            while(!finish.equals("display: block;")) {
                Driver.getWait().until(ExpectedConditions.attributeToBe(Driver.findElementByXpath("//div[@id='countdown']"), "style", "display: none;"));

                List<WebElement> dots = Driver.findElementsByXpath(dot);

                builder.clickAndHold(dots.get(0)).build().perform();
                for (int j = 0; j < dots.size(); j++) {
                    builder.moveToElement(dots.get(j)).build().perform();
                }
                builder.moveToElement(dots.get(0)).build().perform();
                Driver.getWait().until(ExpectedConditions.attributeToBe(Driver.findElementByXpath(wellDone), "style", "display: none;"));
                finish = getFinishAttr();
            }

            Driver.click(playAgain);
        }

    }

    public static String getFinishAttr() {
        return Driver.findElementByXpath("//div[@id='finish']").getAttribute("style");
    }
}
