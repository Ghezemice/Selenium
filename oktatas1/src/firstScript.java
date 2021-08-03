import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class firstScript {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\istva\\IdeaProjects\\szoft\\Driver\\Chrome\\chromedriver_win32_91.0.4472.101\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://auth.citromail.hu/regisztracio/");

        WebElement userName = driver.findElement(By.xpath("//*[@id='username']"));
        WebElement password = driver.findElement(By.xpath("//*[@id='password_1']"));
        WebElement password2 = driver.findElement(By.xpath("//*[@id='password_2']"));
        WebElement email2 = driver.findElement(By.xpath("//*[@id='alternate_mail']"));
        WebElement secQuestionSelect = driver.findElement(By.xpath("//input[@id='security_question-selectized']"));
        WebElement question_input = driver.findElement(By.xpath("//input[@id='question_input']"));
        WebElement surename = driver.findElement(By.xpath("//input[@id='surname']"));
        WebElement forename = driver.findElement(By.xpath("//input[@id='forename']"));
        WebElement gender = driver.findElement(By.xpath("//input[@id='sex_f']"));
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='zip_code']"));
        WebElement birthYear = driver.findElement(By.xpath("//input[@id='birth_year']"));



        userName.sendKeys("khjhkjkj");
        password.sendKeys("Password01");
        password2.sendKeys("Password01");
        email2.sendKeys("asd@welsj.zfg");


        secQuestionSelect.click();
        WebElement secQuestion =  driver.findElement(By.xpath("//div[@data-value='8']"));
        secQuestion.click();

        question_input.sendKeys("Bodrika");
        surename.sendKeys("Nagy");
        forename.sendKeys("Orsolya");
        gender.click();
        zipCode.sendKeys("6666");
        birthYear.sendKeys("1985-01/10");











    }
}
