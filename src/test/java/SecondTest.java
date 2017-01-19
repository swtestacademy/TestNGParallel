import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ONUR on 03.12.2016.
 */
public class SecondTest extends TestBase{

    @Test(priority=1)
    public void GOOGLE1() throws Exception {
        System.out.println("Google1 Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.google.com");
        System.out.println("Google1 Test's Page title is: " + driver.getTitle() +" "+ Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Google");
        System.out.println("Google1 Test Ended! " + Thread.currentThread().getId());
    }

    @Test(priority=2)
    public void YANDEX() throws Exception {
        System.out.println("Yandex Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.yandex.com");
        System.out.println("Yandex Test's Page title is: " + driver.getTitle() +" "+ Thread.currentThread().getId());
        Assert.assertEquals(driver.getTitle(), "Yandex");
        System.out.println("Yandex Test Ended! " + Thread.currentThread().getId());
    }

    @Test(priority=3)
    public void HB() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        System.out.println("HB Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.hepsiburada.com/");
        System.out.println("HB Test's Page title is: " + driver.getTitle() +" "+ Thread.currentThread().getId());
        System.out.println("HB Test Ended! " + Thread.currentThread().getId());
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("myAccount"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login"))).click();


    }

}
