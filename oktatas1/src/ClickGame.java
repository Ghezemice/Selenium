import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ClickGame {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\istva\\IdeaProjects\\szoft\\Driver\\Chrome\\chromedriver_win32_91.0.4472.101\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ghezemice.hu/oktatas/click.html");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);

        WebElement clickButton = driver.findElement(By.id("mybut"));
//        WebElement startSzamlalo = driver.findElement(By.id("backstart"));
//        WebElement timerSzamlalo = driver.findElement(By.id("timecount"));

        explicitWait.until(ExpectedConditions.textToBe(By.id("backstart"), "start"));
//
//        String timer = timerSzamlalo.getText();

        while(true) {
            try {
                clickButton.click();
            }catch(ElementNotInteractableException e) {
                break;
            }
            //timer = timerSzamlalo.getText();
        }
        System.out.println("Sikeresen kiléptünk!");




    }
}
