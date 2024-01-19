import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class NewWindowTest {
    @Test
    public void TestNewWindow() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

       WebElement newPageButton =  driver.findElement(By.id("newPage"));
       newPageButton.click();
       String currentWindow = driver.getWindowHandle();


       Set<String> listOkien = driver.getWindowHandles();
       for(String window : listOkien) {
           if(!window.equals(currentWindow)) {
               driver.switchTo().window(window);
           }
       }
        WebElement element = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        element.click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Maciej");





    }
}
