package unit;

import ac.cr.una.springintro.consumer.MyApplication;
import ac.cr.una.springintro.service.MessageService;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author mguzmana
 */

@Configuration
@ComponentScan(value="ac.cr.una.springintro.consumer")
public class TestSpringIntroMock {

    private AnnotationConfigApplicationContext context = null;

    public TestSpringIntroMock() {
    }

    @Bean
    public MessageService getMessageService() {
        return new MessageService(){

            public boolean sendMessage(String msg, String rec) {
                System.out.println("Mock Service");
                return true;
            }

        };
    }

    @Before
    public void setUp() throws Exception {
        context = new AnnotationConfigApplicationContext(TestSpringIntroMock.class);
    }

    @After
    public void tearDown() throws Exception {
        context.close();
    }

    @Test
    public void test() {
        MyApplication app = context.getBean(MyApplication.class);
        Assert.assertTrue(app.processMessage("Hola Maikol", "profe@mike.education"));
    }
}
