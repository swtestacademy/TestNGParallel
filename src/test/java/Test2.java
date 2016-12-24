import org.testng.annotations.Test;

public class Test2 {
    @Test
    public void Google2() {
        invokeBrowser("http://www.google.com");
    }

    @Test
    public void Yandex2() {
        invokeBrowser("http://www.yandex.com");
    }

    private void invokeBrowser(String url) {
        System.out.println("Thread id = " + Thread.currentThread().getId());
        System.out.println("Hashcode of webDriver instance = " + LocalDriverManager.getDriver().hashCode());
        LocalDriverManager.getDriver().get(url);
    }
}