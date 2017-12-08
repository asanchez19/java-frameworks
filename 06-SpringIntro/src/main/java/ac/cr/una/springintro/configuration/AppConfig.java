package ac.cr.una.springintro.configuration;

import ac.cr.una.springintro.service.EmailService;
import ac.cr.una.springintro.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration file
 *
 * Beans don't have to be defined in a Spring configuration class.
 * Spring will automatically generate a bean from any class annotated with @Component.
 *
 * @author mguzmana
 */
@Configuration
@ComponentScan(basePackages={"ac.cr.una.springintro.consumer"})
public class AppConfig {

    @Bean
    public MessageService getMessageService(){
        return new EmailService();
    }
}