package ac.cr.una.springwsdto.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ac.cr.una.springwsdto")
public class AppWebConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
