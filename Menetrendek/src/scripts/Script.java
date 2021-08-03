package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Script {
    static WebDriver driver;
    static final String INDULAS = "Szeged";
    static final String ERKEZES = "Szolnok";
    static String MIVEL = "vonat";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\istva\\IdeaProjects\\szoft\\Driver\\Chrome\\chromedriver_win32_91.0.4472.101\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://menetrendek.hu/");

        WebElement
                bezar = find("//div[contains(@class, 'show')]//div[@class='close']"),
                honnan = find("//input[@id='route_from']"),
                hova = find("//input[@id='route_to']"),
                kereses = find("//div[@class='input_send']/button"),
                osszes = find("//input[@name='preference' and @value='0']/parent::div"),
                busz = find("//input[@name='preference' and @value='1']/parent::div"),
                vonat = find("//input[@name='preference' and @value='4']/parent::div");

        bezar.click();

        switch (MIVEL) {
            case "busz" -> busz.click();
            case "vonat" -> vonat.click();
        }

        honnan.sendKeys(INDULAS);
        find("//input[@id='route_from']/ancestor::div[contains(@class, 'input_from')]//li[contains(@class, '_full-match')]").click();

        hova.sendKeys(ERKEZES);
        find("//input[@id='route_to']/ancestor::div[contains(@class, 'input_to')]//li[contains(@class, '_full-match')]").click();

        kereses.click();

        List<WebElement>
                indulasok = findMore("//div[contains(@class, ' schedule')]/div[@class='list_cell'][1]//span[@class='time']"),
                varosok = findMore("//div[contains(@class, ' schedule')]/div[@class='list_cell'][1]//span[@class='city']"),
                allomasok = findMore("//div[contains(@class, ' schedule')]/div[@class='list_cell'][1]//span[@class='station']");

        for (int i = 0; i < indulasok.size(); i++) {
            if(!indulasok.get(i).getText().equals("")) {
                System.out.println(indulasok.get(i).getText());
            }
            if(!varosok.get(i).getText().equals("")) {
                System.out.println(varosok.get(i).getText());
            }
            if(!allomasok.get(i).getText().equals("")) {
                System.out.println(allomasok.get(i).getText());
            }
            System.out.print("\n");
        }
    }

    public static WebElement find(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }
    public static List<WebElement> findMore(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }
}
