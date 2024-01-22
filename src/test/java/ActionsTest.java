import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionsTest {

    @Test
    public void actionsPerform() throws IOException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");


        WebElement button = driver.findElement(By.id("bottom"));
        Actions actions = new Actions(driver);
        actions.contextClick().perform();
      //  actions.contextClick(driver.findElement(By.id("myFile"))).perform();

        actions.doubleClick(button).perform();





    }
}
