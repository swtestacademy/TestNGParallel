import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

/**
 * Created by ONUR on 21.01.2017.
 */
public class HBTest extends TestBase {

    @Test
    public void HB() throws Exception {
        System.out.println("HB Test Started! " + Thread.currentThread().getId());
        driver.navigate().to("http://www.hepsiburada.com/");
        System.out.println("HB Test's Page title is: " + driver.getTitle() + " " + Thread.currentThread().getId());
        System.out.println("HB Test Ended! " + Thread.currentThread().getId());
        AjaxWaiter.waitUntilJQueryReady(driver,wait);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("myAccount"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login"))).click();
    }
}


