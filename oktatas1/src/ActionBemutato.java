import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionBemutato {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\istva\\IdeaProjects\\szoft\\Driver\\Chrome\\chromedriver_win32_91.0.4472.101\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ghezemice.hu/oktatas/click.html");
        WebElement jhsfd = driver.findElement(By.xpath("sgfd"));

        Actions builder = new Actions(driver);

        Action keyDown = builder.keyDown(jhsfd, "sdgg").build();
        Action mouseOverHome = builder.moveToElement(jhsfd).build();

        Action sokMuvelet = builder
                .keyDown(Keys.CONTROL)
                .keyDown(Keys.SHIFT)
                .keyDown("R")
                .build();

        sokMuvelet.perform();

        builder.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).keyDown("R").build().perform();

    }
}
