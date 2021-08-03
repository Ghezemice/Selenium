package front;

import core.Driver;
import core.Keywords;
import core._OBJECTS;
import core.enums.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Play implements _OBJECTS {
    public static void main(String[] args) throws InterruptedException {
        Driver.startSelenium(Browser.CHROME);
        Keywords.startPlay();

        for (int k = 0; k < 3; k++) {
            String finish = getFinishAttr();

            while (!finish.equals("display: block;")) {
                Driver.getWait().until(ExpectedConditions.attributeToBe(Driver.findElementByXpath(countDown), "style", "display: none;"));
                List<WebElement> dots = Keywords.getAllDots();
                System.out.println(dots.size());

                for (int j = 0; j < dots.size() - 1; j++) {
                    Keywords.drag(dots.get(j), dots.get(j + 1));

                    if (j == dots.size() - 2) {
                        Keywords.drag(dots.get(dots.size() - 1), dots.get(0));
                    }
                }

                Driver.getWait().until(ExpectedConditions.attributeToBe(Driver.findElementByXpath(wellDone), "style", "display: none;"));
            }
        }
            Thread.sleep(3000);
            Driver.click(playAgain);
        }

    public static String getFinishAttr() {
        return Driver.findElementByXpath("//div[@id='finish']").getAttribute("style");
    }
}
