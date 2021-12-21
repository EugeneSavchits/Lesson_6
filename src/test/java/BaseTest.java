import org.testng.annotations.*;

public class BaseTest {

    //Before Annotation
    @BeforeTest
    public void beforeTest() { System.out.println("BeforeTest"); }

    @BeforeSuite
    public void beforeSuite() { System.out.println("BeforeSuite"); }

    @BeforeGroups
    public void beforeGroups() { System.out.println("BeforeGroups"); }

    @BeforeClass
    public void beforeClass() { System.out.println("BeforeClass"); }

    @BeforeMethod
    public void beforeMethod() { System.out.println("BeforeMethod"); }

    //After Annotation
    @AfterTest
    public void afterTest() { System.out.println("AfterTest"); }

    @AfterSuite
    public void afterSuite() { System.out.println("AfterSuite"); }

    @AfterGroups
    public void afterGroups() { System.out.println("AfterGroups"); }

    @AfterClass
    public void afterClass() { System.out.println("AfterClass"); }

    @AfterMethod
    public void afterMethod() { System.out.println("AfterMethod"); }

}
