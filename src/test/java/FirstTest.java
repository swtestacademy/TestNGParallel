import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by ONUR on 03.12.2016.
 */
public class FirstTest extends TestBase {

    @Test
    public void firstTest() throws Exception {
        System.out.println("First Test Started!");
        getDriver().navigate().to("http://www.yahoo.com");
        waitForPageLoad();
        System.out.println("First Test's Page title is: " + getDriver().getTitle());
        Assert.assertEquals(getDriver().getTitle(), "Yahoo");
        System.out.println("First Test Ended!");
    }

}
