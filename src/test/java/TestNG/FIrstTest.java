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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
@Listeners(value = SampleTestListener.class)
public class FIrstTest  extends BaseTest {


    WebDriver driver;

    @Test
    public void firstTest() {


        driver = DriverFactory.getDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        By locator = By.cssSelector("p");
        waitForElementToExist(locator);
        WebElement para = driver.findElement(By.cssSelector("p"));
        String paraText = driver.findElement(locator).getText();

        Assert.assertTrue(para.isDisplayed());
        Assert.assertTrue(paraText.startsWith("Dopiero"));
        Assert.assertTrue(paraText.startsWith("Pojawilem"));
        Assert.assertEquals(paraText, "Dopiero się pojawiłem!");
        Assert.assertEquals(paraText, "Dopiero", "Teksy są różne");
        driver.quit();

    }
    @Test 
    public void secondTest() {


       driver = DriverFactory.getDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        By locator = By.cssSelector("p");
        waitForElementToExist(locator);
        WebElement para = driver.findElement(By.cssSelector("p"));

        SoftAssert softAssert = new SoftAssert();
        String paraText = driver.findElement(locator).getText();
        softAssert.assertEquals(para.isDisplayed(), true);
        softAssert.assertTrue(para.isDisplayed());
        softAssert.assertTrue(paraText.startsWith("Dopiero"));
        softAssert.assertTrue(paraText.startsWith("Pojawilem"));
        softAssert.assertEquals(paraText, "Dopiero się pojawiłem!");
        softAssert.assertEquals(paraText, "Dopiero", "Teksy są różne");
        softAssert.assertEquals(paraText, "Siema");

        driver.quit();
        softAssert.assertAll();

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