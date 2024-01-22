import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest {

    @Test
    public void ExecuteJavaScript() {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/");
        WebElement webElement = driver.findElement(By.linkText("Podstawowa strona testowa"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

        javascriptExecutor.executeScript("arguments[0].click();", webElement);

        WebElement element = driver.findElement(By.id("fname"));
        javascriptExecutor.executeScript("arguments[0].setAttribute('value', 'Maciej');",element);

    }
}
