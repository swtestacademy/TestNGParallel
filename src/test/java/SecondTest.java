import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ONUR on 03.12.2016.
 */
public class SecondTest extends TestBase{

    @Test
    public void secondTest() throws Exception {
        System.out.println("Second Test Started!");
        getDriver().navigate().to("http://www.google.com");
        waitForPageLoad();
        System.out.println("Second Test's Page title is: " + getDriver().getTitle());
        Assert.assertEquals(getDriver().getTitle(), "Google");
        System.out.println("Second Test Ended!");
    }
}
