package ac.cr.una.springaoplogging.config;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScans(value = {
        @ComponentScan("ac.cr.una.springaoplogging.service"),
        @ComponentScan("ac.cr.una.springaoplogging.aspect")
})
public class AppConfig {
}
