package test.gui;

import org.testng.annotations.Test;

public class MavenTest {

    @Test
    public void parametrTest(){
        System.out.println(System.getProperty("testProp"));
    }
}
