package TestNG;

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

}
