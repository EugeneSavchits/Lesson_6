import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public class BaseTest {
    @BeforeMethod
    public void beforeMethod () {
        System.out.println("Запуск теста");
    }

    @AfterMethod
    public void afterMethod () {
        System.out.println("Тест завершен");
    }
}
