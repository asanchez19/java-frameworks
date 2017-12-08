package ac.cr.una.springaopexception.config;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScans(value = {
        @ComponentScan("ac.cr.una.springaopexception.service"),
        @ComponentScan("ac.cr.una.springaopexception.aspect")
})
public class AppConfig {
}
