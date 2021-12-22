
import org.testng.annotations.Test;

public class GroupsTest extends BaseTest {

    @Test (groups = {"smoke", "sanity", "regression"})
    public void smokeTest() {
        System.out.println("CalcTest -> smokeTest");
    }

    @Test (groups = {"sanity", "regression"})
    public void sanityTest() {
        System.out.println("CalcTest -> sanityTest");
    }

    @Test (groups = "regression")
    public void regressionTest() {
        System.out.println("CalcTest -> regressionTest");
    }
}
