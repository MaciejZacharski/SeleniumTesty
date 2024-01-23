package TestNG;

import org.testng.annotations.*;

public class BaseTest {


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("I am running before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("I am running after Suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("I am running before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("I am running after Class");
    }


    @BeforeTest
    public void beforeTest() {
        System.out.println("I am running before Test");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am running before Method");
    }


@AfterTest
public void afterTest() {
    System.out.println("I am running after Test");
}
@AfterMethod
public void afterMethod() {
    System.out.println("I am running after Method");
}
}


