package ac.cr.una.springtesting.config;

import ac.cr.una.springtesting.service.OrderService;
import ac.cr.una.springtesting.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public OrderService getService() {
        return new OrderServiceImpl();
    }
}
