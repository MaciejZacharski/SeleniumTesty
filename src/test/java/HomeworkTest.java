import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HomeworkTest {

    @Test
    public void Homework() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/");
        driver.findElement(By.linkText("Podstawowa strona testowa")).click();

        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.tagName("h1"));
        actions.moveToElement(heading).perform();

        driver.findElement(By.name("fname")).sendKeys("Maciej");

       // driver.findElement(By.linkText("Visit W3Schools.com!")).click();
       String month = driver.findElement(By.cssSelector("th.tableHeader:nth-child(1)")).getText();

      //  System.out.println(month);

      WebElement selector =  driver.findElement(By.cssSelector("select"));
        Select carSelect = new Select(selector);
        carSelect.selectByValue("volvo");

        driver.findElement(By.cssSelector("[type = 'checkbox']")).click();

        driver.findElement(By.cssSelector("[value = 'male'")).click();

        WebElement userName =  driver.findElement(By.name("username"));
        userName.clear();
        userName.sendKeys("Janusz");
        userName.sendKeys(Keys.TAB);
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("qwerty");

        driver.findElement(By.cssSelector("[value = 'Submit'")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Alert alert2 = driver.switchTo().alert();
        alert2.accept();







    }
}
