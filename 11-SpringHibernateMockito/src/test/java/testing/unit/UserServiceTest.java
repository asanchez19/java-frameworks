package testing.unit;

import ac.cr.una.springwsrestful.config.AppConfig;
import ac.cr.una.springwsrestful.dao.UserDao;
import ac.cr.una.springwsrestful.model.User;
import ac.cr.una.springwsrestful.service.UserService;
import ac.cr.una.springwsrestful.service.UserServiceImp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class,loader=AnnotationConfigContextLoader.class)
public class UserServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Mock
    private UserDao userDaoMock;

    @InjectMocks
    private UserService userServiceMock = new UserServiceImp();

    @Before
    public void setUp() throws Exception {
        logger.info("-----> SETUP <-----");
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        logger.info("-----> DESTROY <-----");
    }

    @Test
    public void testCreateUser() throws Exception {

        // Expected objects
        Long userId = 1L;
        String firstName = "David";
        User userToSave = new User(firstName, "Miller", "david.miller@example.com");
        User persistedUser = new User( userId, firstName, "Miller", "david.miller@example.com");

        // Mockito expectations
        when(userDaoMock.add(any(User.class))).thenReturn(persistedUser);

        // Execute the method being tested
        assertNotNull(userServiceMock);
        User userNew = userServiceMock.add(userToSave);

        // Validation
        assertNotNull(userNew);
        assertEquals(userId, userNew.getId());
        assertEquals(firstName, userNew.getFirstName());
        verify(userDaoMock).add(userToSave);
    }

}
