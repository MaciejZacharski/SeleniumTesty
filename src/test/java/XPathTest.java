import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XPathTest {

    @Test
    public void findElements(){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // clickOnMe
        By buttonId = By.xpath("//button[@id='clickOnMe']");
        WebElement webElement = driver.findElement(buttonId);
//        webElement.click();

        WebElement webElement2 = driver.findElement(By.xpath("//input[@name= 'fname']"));

        webElement2.isDisplayed();



        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden);

        By tagName = By.tagName("input");
        WebElement input = driver.findElement(tagName);
        input.sendKeys("Pierwszy");
        List<WebElement> webElementList = driver.findElements(tagName);
        System.out.println(webElementList.size());

        By linkText = By.xpath("//a[text() = 'Visit W3Schools.com!']");
        WebElement webElement3 = driver.findElement(linkText);
        /*webElement.click();*/

        By partialLinkText = By.xpath("//a[contains(text(), 'Visit')]");
        WebElement partialElement = driver.findElement(partialLinkText);
        // partialElement.click();

        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);


    }
}
