package testing.integration;

import ac.cr.una.springwsrestful.config.AppRootConfig;
import ac.cr.una.springwsrestful.dao.UserDao;
import ac.cr.una.springwsrestful.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= AppRootConfig.class,loader=AnnotationConfigContextLoader.class)
public class UserDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);

    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    @Rollback(true)
    public void testAddUser() throws Exception {

        String firstNameUser = "Paul";

        // Add Users
        User user1 = userDao.add(new User("Paul", "Bora", "suni.bora@example.com"));
        User user2 = userDao.add(new User("David", "Miller", "david.miller@example.com"));
        User user3 = userDao.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        User user4 = userDao.add(new User(firstNameUser, "Smith", "paul.smith@example.com"));

        // Get Users
        List<User> users = userDao.listUsers();

        assertEquals(firstNameUser, users.get(0).getFirstName());
    }
}
