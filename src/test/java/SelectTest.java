import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectTest {


    public boolean checkOption(String name, WebElement element) {


        Select cars = new Select(element);
        List<WebElement> listOfCars = cars.getOptions();

        for (WebElement carOption : listOfCars)
            if (carOption.getText().equals(name)) {
                return true;
            }
            return false;

        }

    }

