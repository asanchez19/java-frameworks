package unit;

import ac.cr.una.springintro.consumer.MyXMLApplication;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author mguzmana
 */

public class TestXMLSpringIntro {

    private ClassPathXmlApplicationContext context = null;

    public TestXMLSpringIntro() {
    }

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
    }

    @After
    public void tearDown() throws Exception {
        // close the context
        context.close();
    }

    @Test
    public void testXMLSpring() throws Exception {
        MyXMLApplication app = context.getBean(MyXMLApplication.class);

        Assert.assertTrue(app.processMessage("Hola Maikol", "profe@mike.education"));
    }
}
