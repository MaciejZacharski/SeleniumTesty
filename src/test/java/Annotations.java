import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class Annotations {

    @FindBys( {
            @FindBy(tagName = "table"),
            @FindBy(tagName = "th")
    }    )
List<WebElement> elements;
    @FindAll( {
            @FindBy(tagName = "table"),
            @FindBy(tagName = "th"),
            @FindBy(tagName = "a")
    }    )
    List<WebElement> elements1;
    @Test
    public void PerformAction() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/");
        PageFactory.initElements(driver, this);
        WebElement  webElement = driver.findElement(By.linkText("Podstawowa strona testowa"));
        webElement.click();
        System.out.println(elements.size());
        System.out.println(elements1.size());




    }
}
