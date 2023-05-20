package mytests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {

    @Test(priority = 1)
    public void logoTest() {
         testCaseId = "1";
        System.out.println("open cart - logo test");
        boolean flag = driver.findElement(By.cssSelector("img[title='naveenopencart']")).isDisplayed();
        Assert.assertEquals(flag, true);
    }

    @Test(priority = 2)
    public void forgotPwdLinkExistTest() {
         testCaseId = "2";
        System.out.println("open cart - forgot pwd test");
        Assert.assertTrue(driver.findElement(By.linkText("Forgotten Password")).isDisplayed());
    }


}
