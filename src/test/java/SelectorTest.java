import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findElements(){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // clickOnMe
//        By buttonId = By.id("clickOnMe");
//        WebElement webElement = driver.findElement(buttonId);
//        webElement.click();

        WebElement webElement2 = driver.findElement(By.name("fname"));

        webElement2.isDisplayed();

        driver.findElement(By.className("tableHeader"));

        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);

        By tagName = By.tagName("input");
        WebElement input = driver.findElement(tagName);
        input.sendKeys("Pierwszy");
        List<WebElement> webElementList = driver.findElements(tagName);
        System.out.println(webElementList.size());

        By linkText = By.linkText("Visit W3Schools.com!");
        WebElement webElement = driver.findElement(linkText);
        /*webElement.click();*/

        By partialLinkText = By.partialLinkText("Visit");
        WebElement partialElement = driver.findElement(partialLinkText);
        partialElement.click();



    }
}
