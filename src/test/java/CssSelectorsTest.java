import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CssSelectorsTest {


    @Test
    public void findElements() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("Cienki balas");

        By cssName = By.cssSelector("[name = 'fname']");
        driver.findElement(cssName);

        By cssClass2 = By.cssSelector("[class = 'topSecret']");
        driver.findElement(cssClass2);

        By all = By.cssSelector("*");
        driver.findElements(all);

        By tableSelector = By.cssSelector("table tr");
        By divSelector = By.cssSelector("div ul");
        By tBodySelector = By.cssSelector("tbody tr");

        driver.findElement(tBodySelector);
        driver.findElements(tableSelector);
        driver.findElement(divSelector);

        By tBodyChild = By.cssSelector("tbody > tr");
        By DivFirstChild = By.cssSelector("div > ul");

        driver.findElement(DivFirstChild);
        driver.findElement(tBodyChild);

        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormsAfterLabel = By.cssSelector("label ~ form");

        driver.findElement(firstFormAfterLabel);
        driver.findElements(allFormsAfterLabel);

        By attributeTag = By.cssSelector("input[name = 'fname'");
        By attributeContains = By.cssSelector("[name*= 'name']");
        By attributeStarts = By.cssSelector("[name^= 'fn'");
        By attibuteEnds = By.cssSelector("[name$= 'name'");

        driver.findElement(attributeTag);
        driver.findElement(attributeContains);
        driver.findElement(attributeStarts);
        driver.findElement(attibuteEnds);

        By firstChild = By.cssSelector("li:first-child");
        By lastchild = By.cssSelector("li:last-child");
        By thirdChild = By.cssSelector(" li:nth-child(3)");

        driver.findElement(firstChild);
        driver.findElement(lastchild);
        driver.findElement(thirdChild);





    }
@Test
    public void EurosportTest() throws InterruptedException {

    WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new FirefoxDriver();

    driver.get("https://eurosport.tvn24.pl/");
    driver.findElement(By.xpath("//button[text()='Akceptuję']")).click();

    By parisBanner = By.cssSelector("span[class= 'flex-center h-full w-full']");

    WebElement foundBanner =  driver.findElement(parisBanner);

    Assert.assertTrue(foundBanner.isDisplayed());

    By wszystkieSporty = By.cssSelector("button.relative");

    WebElement foundButton =   driver.findElement(wszystkieSporty);
    Assert.assertTrue(foundButton.isDisplayed());






    }



}
