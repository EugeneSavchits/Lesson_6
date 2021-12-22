import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {

    @Test (dependsOnMethods = "cbaTest")
    public void abcTest () {
        System.out.println("DependencyTest -> abcTest");
        Assert.fail();
    }

    @Test
    public void cbaTest () {
        System.out.println("DependencyTest -> cbaTest");
    }

    @Test (dependsOnMethods = "abcTest", alwaysRun = true)
    public void bacTest () {
        System.out.println("DependencyTest -> bacTest");
    }
}
