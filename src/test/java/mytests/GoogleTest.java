package mytests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test(priority = 1)
    public void titleTest() {
        testCaseId = "3";
        String title = driver.getTitle();
        System.out.println("page title:" + title);
        Assert.assertEquals(title, "Google");
    }

    @Test(priority = 2)
    public void isSearchExist() {
        testCaseId = "4";
        boolean flag = driver.findElement(By.name("q")).isDisplayed();
        Assert.assertTrue(flag);
    }

}
