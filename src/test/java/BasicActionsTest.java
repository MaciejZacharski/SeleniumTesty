import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {

    @Test
    public void PerformAction() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement  webElement = driver.findElement(By.linkText("Podstawowa strona testowa"));
        webElement.click();

        WebElement webElementInput = driver.findElement(By.id("fname"));
        webElementInput.click();
        webElementInput.sendKeys("Janusz");

        WebElement webElementInput2 = driver.findElement(By.name("username"));
        webElementInput2.clear();
        webElementInput2.sendKeys("Siema");
        System.out.println(webElementInput2.getText());
        System.out.println(webElementInput2.getAttribute("value"));
        webElementInput2.sendKeys(Keys.ENTER);

        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();

        Alert secondAlert = driver.switchTo().alert();
        secondAlert.accept();

        webElementInput2.sendKeys(Keys.TAB);

        WebElement webElementCheckbox = driver.findElement(By.cssSelector("[type = 'checkbox']"));
        webElementCheckbox.click();

        WebElement webElementGender = driver.findElement(By.cssSelector("[value='male']"));
        webElementGender.click();

        WebElement webElementSelect = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(webElementSelect);
        cars.selectByIndex(2);
        cars.selectByValue("saab");
        cars.selectByVisibleText("Audi");
        List<WebElement> listOfCars = cars.getOptions();

        for(WebElement carOptions : listOfCars) {
            System.out.println(carOptions.getText());
        }

        SelectTest selectTest = new SelectTest();

        System.out.println(selectTest.checkOption("Audi",webElementSelect));
        System.out.println(selectTest.checkOption("Jeep",webElementSelect));

        WebElement HiddenParagraf = driver.findElement(By.cssSelector(".topSecret"));
        HiddenParagraf.getText();
        HiddenParagraf.getAttribute("value");
        System.out.println(HiddenParagraf.getAttribute("textContent"));


    }
}
