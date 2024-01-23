package TestNG;

import TestNG.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FIrstTest  extends BaseTest {


    WebDriver driver;

    @Test
    public void firstTest() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        By locator = By.cssSelector("p");
        waitForElementToExist(locator);
        WebElement para = driver.findElement(By.cssSelector("p"));
        String paraText = driver.findElement(locator).getText();
        Assert.assertEquals(para.isDisplayed(), true);
        Assert.assertTrue(para.isDisplayed());
        Assert.assertTrue(paraText.startsWith("Dopiero"));

        Assert.assertEquals(paraText, "Dopiero się pojawiłem!");
//        Assert.assertEquals(paraText, "Dopiero", "Teksy są różne");
        driver.quit();

    }
    @Test 
    public void secondTest() {


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        By locator = By.cssSelector("p");
        waitForElementToExist(locator);

        String paraText = driver.findElement(locator).getText();
        Assert.assertEquals(paraText, "Dopiero się pojawiłem!");
        driver.quit();

    }

    public void waitForElementToExist(By locator) {


        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element jest na stronie");
                return true;
            } else {
                System.out.println("Brak elementu na stronie");
                return false;
            }

        });
    }
}