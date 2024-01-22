import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class UploadFileTest {

    @Test
    public void UploadFile() throws IOException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        int randomNumber = (int) (Math.random()*1000);

        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        String BeforeUpload = "beforeUpload" + randomNumber + ".png";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File beforeFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(beforeFile,new File("src/test/resources/" + BeforeUpload));

      driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\PC\\Desktop\\Selenium kurs\\Test.txt");


        File afterFile = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(afterFile,new File("src/test/resources/afterUpload.png"));

        Actions actions = new Actions(driver);
       // actions.contextClick().perform();
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();




    }
}
