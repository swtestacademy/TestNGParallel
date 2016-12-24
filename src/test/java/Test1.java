import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void Google1() {
        invokeBrowser("http://www.google.com");
    }

    @Test
    public void Yandex1() {
        invokeBrowser("http://www.yandex.com");
    }

    private void invokeBrowser(String url) {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
        LocalDriverManager.getDriver().get(url);
    }
}