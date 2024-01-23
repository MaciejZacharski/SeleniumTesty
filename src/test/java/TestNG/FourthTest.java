package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FourthTest extends BaseTest {
    @Test(dependsOnMethods = "thirdTest")
    public void firstTest() {

        System.out.println("I am first Test");
    }

    @Test(dependsOnMethods = "firstTest")
    public void secondTest() {

        System.out.println("I am second Test");
    }
    @Test
    public void thirdTest() {

        System.out.println("I am third Test");
    }

    @Test(dataProvider = "data")
    public void dpTest(String value , String number) {

        System.out.println(value);
        System.out.println(number);
    }
    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][] {{"I am first test", "First"},{"I am second Test", "Second"}, {"I am third test", "Third"}};
    }

}
