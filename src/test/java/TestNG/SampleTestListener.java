package TestNG;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class SampleTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am starting Test");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }
    @Override
    public void onTestFailure(ITestResult iTestResult) {

        WebDriver driver = DriverFactory.getDriver();
        int randomNumber = (int) (Math.random()*1000);
        String onTestFailure = "TestXFailed" + randomNumber + ".png";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File beforeFile = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(beforeFile,new File("src/test/resources/" + onTestFailure));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }
    @Override
    public void onStart(ITestContext iTestContext) {

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }



}
