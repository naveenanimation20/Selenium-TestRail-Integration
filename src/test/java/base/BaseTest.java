package base;

import com.manager.TestRailManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {

    protected WebDriver driver;
    protected String testCaseId;

    @Parameters({"url", "browser"})
    @BeforeTest
    public void setup(String url, String browserName) {
        System.out.println("launching browser: " + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-crash-reporter");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-in-process-stack-traces");
            options.addArguments("--disable-logging");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--log-level=3");
            options.addArguments("--output=/dev/null");
            options.addArguments("ignore-certificate-errors");

            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("please pass the right browserName..." + browserName);
        }

        driver.get(url);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    @AfterMethod
    public void addResultsToTestRail(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_PASS_STATUS, "");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            TestRailManager.addResultForTestCase(testCaseId, TestRailManager.TEST_CASE_FAIL_STATUS, String.valueOf(result.getThrowable()));

        }


    }

}


