package unit;

import ac.cr.una.springintro.configuration.AppConfig;
import ac.cr.una.springintro.consumer.MyApplication;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Test our annotation based Spring Dependency Injection
 *
 * @author mguzmana
 */

public class TestSpringIntro {

    private AnnotationConfigApplicationContext context = null;

    public TestSpringIntro() {
    }

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @After
    public void tearDown() throws Exception {
        // close the context
        context.close();
    }

    @Test
    public void testSpringIntro() throws Exception {
        MyApplication app = context.getBean(MyApplication.class);

        Assert.assertTrue(app.processMessage("Hola Maikol", "profe@mike.education"));
    }
}
