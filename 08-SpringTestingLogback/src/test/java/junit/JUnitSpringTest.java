package junit;

import ac.cr.una.springtesting.config.AppConfig;
import ac.cr.una.springtesting.model.Order;
import ac.cr.una.springtesting.service.OrderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/*
 * @RunWith – is an annotation to tag a class that this should Run with a specific runner class.
 * There are a lot of alternative runners for JUnit but since we are using Spring test, we use: SpringJUnit4ClassRunner.class
 * @ContextConfiguration – Similar to calling the ClassPathContextConfiguration, this one is a pretty neat feature in Spring,
 * especially in Unit test cases. It can be used to what type of ContextLoader for our class and the Java class files
 * that we need to run on the ioc container (basically JVM) that are injectable on this class.
 * For this case, we use AnnotationConfigContextLoader.class as our ContextLoader since we are creating a fully using
 * annotation as our context metadata information and passed our AppConfig.class as our configuration stating point.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class,loader=AnnotationConfigContextLoader.class)
public class JUnitSpringTest {

    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(JUnitSpringTest.class);

    @Before
    public void setUp() throws Exception {
        logger.info("-----> SETUP <-----");
    }

    @After
    public void tearDown() throws Exception {
        logger.info("-----> DESTROY <-----");
    }

    @Test
    public void testOrderService() throws Exception {
        assertEquals("class ac.cr.una.springtesting.service.OrderServiceImpl",this.orderService.getClass().toString());
    }

    @Test
    public void testSampleServiceGetAccountDescription() {
        //	Check if the return description has a 'Description:' string.
        assertTrue(orderService.getOrderDescription().contains("Description:"));
    }

    @Test
    public void testSampleServiceGetAccountCode() {
        //	Check if the return description has a 'Code:' string.
        assertTrue(orderService.getOrderStringCode().contains("Code:"));
    }

    @Test
    public void testSampleServiceCreateNewOrder() {
        Order newOrder = new Order();
        newOrder.setSecurityCode("XYZ");
        newOrder.setDescription("Description");
        if(newOrder != null) {
            assertThat(orderService.createOrder(newOrder), instanceOf(Order.class));
            assertNotNull("Security isn't null", newOrder.getSecurityCode());
            assertNotNull("Description isn't not null", newOrder.getDescription());
        }

        assertNotNull("New Order is not null", newOrder);

    }

    @Test
    public void testSampleServiceGetOrder() {

        Order existingOrder = orderService.getOrder(0);

        if(existingOrder != null) {
            assertThat(orderService.getOrder(0), instanceOf(Order.class));
            assertNotNull("Security isn't null", existingOrder.getSecurityCode());
            assertNotNull("Description isn't null", existingOrder.getDescription());
        }

        assertNotNull("Object is not null", existingOrder);
    }

}
