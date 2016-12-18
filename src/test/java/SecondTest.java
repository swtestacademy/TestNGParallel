import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ONUR on 03.12.2016.
 */
public class SecondTest extends TestBase{

    @Test
    public void GOOGLE() throws Exception {
        System.out.println("Google Test Started!");
        getDriver().navigate().to("http://www.google.com");
        waitForPageLoad();
        System.out.println("Google Test's Page title is: " + getDriver().getTitle());
        Assert.assertEquals(getDriver().getTitle(), "Google");
        System.out.println("Google Test Ended!");
    }

    @Test
    public void YANDEX() throws Exception {
        System.out.println("Yandex Test Started!");
        getDriver().navigate().to("http://www.yandex.com");
        waitForPageLoad();
        System.out.println("Yandex Test's Page title is: " + getDriver().getTitle());
        Assert.assertEquals(getDriver().getTitle(), "Yandex");
        System.out.println("Yandex Test Ended!");
    }

}
