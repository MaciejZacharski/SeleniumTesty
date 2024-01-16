import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

public class SeleniumTest {


@Test
    public void openGooglePage() {

    String path = "C:\\Users\\PC\\Desktop\\Selenium kurs\\chromedriver.exe";





    /*ChromeDriver driver = new ChromeDriver();*/



    /*InternetExplorerDriver driver = new InternetExplorerDriver();*/
    InternetExplorerOptions options = new InternetExplorerOptions();
    options.withInitialBrowserUrl("https://www.google.com/");

    WebDriver driver = getDriver("chrome");
    //   driver.get("https://www.google.com/");

    driver.manage().window().maximize();
    Dimension dimension = new Dimension(1280, 640);
    driver.manage().window().setSize(dimension);

    driver.get("https://www.google.com/");

    JavascriptExecutor executor =  (JavascriptExecutor) driver;

    executor.executeScript("window.open('https://www.testeroprogramowania.pl'), 'blank', 'height=1280', 'width=640'");


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

