package functional;

import ac.cr.una.springhibernate.config.AppConfig;
import ac.cr.una.springhibernate.model.User;
import ac.cr.una.springhibernate.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author mguzmana
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSpringHibernate {

    private static AnnotationConfigApplicationContext context = null;
    private static UserService userService = null;

    public TestSpringHibernate() {

    }

    @Before
    public void setUp() throws Exception {

        context = new AnnotationConfigApplicationContext(AppConfig.class);
        userService = context.getBean(UserService.class);
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }

    @Test
    public void test1() throws Exception {

        // Add Users
        userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());
            System.out.println();

            assertNotNull(user.getId());
        }


    }
}
