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

}
