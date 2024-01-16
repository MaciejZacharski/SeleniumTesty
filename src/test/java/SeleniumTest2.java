import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest2 {

    @Test
    public void openGooglePage() {




        WebDriver driver = getDriver("chrome");


        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        // okienko z plikami cookie

        // znajduje przycisk
        WebElement element = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
        // klika na przycisk
        element.click();
        // powrot do peirwotnego okna
        driver.switchTo().defaultContent();
        // znajdz pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        // wprowadz wartosc selenium do pola
        searchField.sendKeys("Selenium");
        // nacisnij enter
        searchField.sendKeys(Keys.ENTER);
        // Znajdz rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));
        // Sprawdzenie czy element jest wyswietlony
        Assert.assertTrue(result.isDisplayed());



     /*   JavascriptExecutor executor =  (JavascriptExecutor) driver;

        executor.executeScript("window.open('https://www.testeroprogramowania.pl'), 'blank', 'height=1280', 'width=640'");*/


        // driver.quit();  // zamyka wszystkie okna
        driver.close();   // zamyka wczesniejsze okno


    }


    public WebDriver getDriver(String browser) {

        switch (browser) {

            case "chrome":
                return  new ChromeDriver();
            case "firefox":
                return  new FirefoxDriver();
            case "ie":
                return  new InternetExplorerDriver();

            default:
                throw new IllegalArgumentException("Invalid browser name");

        }


    }

}

