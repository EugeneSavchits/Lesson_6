package tests;

import baseEntities.BaseTest;
import core.ReadProperties;
import models.Project;
import models.User;
import org.testng.annotations.Test;

public class LombokTest extends BaseTest {

    Project addProject;
    Project updateProject;

    /*@Test
    public void loginTest() {
        User user = new User();
        user.setEmail(ReadProperties.getUsername());
        user.setPassword(ReadProperties.getPassword());

        User user1 = new User();
        user1.setEmail(ReadProperties.getUsername());
        user1.setPassword(ReadProperties.getPassword());

        System.out.println(user.toString());
        System.out.println(user.equals(user1));
    }*/
    @Test
    public void loginTestWithBuilderLombok() { // c Builder
        User user = User.builder()
                .email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .build();

        User user1 = User.builder()
                .email(ReadProperties.getUsername())
                .password(ReadProperties.getPassword())
                .build();

        System.out.println(user.toString());
        System.out.println(user.equals(user1));

    }
}


