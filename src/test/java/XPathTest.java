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

        By all = By.xpath("//*");
        driver.findElement(all);

        By firstInput = By.xpath("(//input[1])");
        driver.findElement(firstInput);

        By lastElement = By.xpath("(//input[last()])");
        driver.findElement(lastElement);

        By idElement = By.xpath("(//*[@id])");
        driver.findElement(idElement);

        By buttonByName = By.xpath("(//input[@name])");
        driver.findElement(buttonByName);

        By attributeEquals = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(attributeEquals);

        By attributeNotEquals = By.xpath("//button[@id!='clickOnMe']");
        driver.findElement(attributeNotEquals);

        By attributeContains = By.xpath("//*[contains(@name, 'name')]");
        driver.findElement(attributeContains);

        By attributeStartsWith = By.xpath("//*[starts-with(@name,'fname')]");
        driver.findElement(attributeStartsWith);

        By attributeEndsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('ame')+1)='ame']");
        driver.findElement(attributeEndsWith);

        By child = By.xpath("//div/child::ul");
        driver.findElement(child);

        By descendant = By.xpath("//div/descendant::ul");
        driver.findElement(descendant);

        By ancestor = By.xpath("//div/ancestor::*");
        driver.findElement(ancestor);

        By parent = By.xpath("//div//..");
        driver.findElement(parent);

        By following = By.xpath("//img//following::*");
        driver.findElement(following);

        By followingSibling = By.xpath("//img//following-sibling::*");
        driver.findElement(followingSibling);

        By preceding = By.xpath("//button//preceding::*");
        driver.findElement(preceding);

        By divsAndLinks = By.xpath("//div | //a");
        driver.findElement(divsAndLinks);

        By andSelector = By.xpath("//input[@name = 'fname' and @id='fname']");
        driver.findElement(andSelector);

        By orSelector = By.xpath("//input[@name = 'fname' or @id='fnam']");
        driver.findElement(orSelector);








    }
}
