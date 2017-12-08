package ac.cr.una.springwsrestfuldigestsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "ac.cr.una.springwsrestfuldigestsecurity")
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomBasicAuthenticationEntryPoint customBasicAuthenticationEntryPoint;

    @Autowired
    private CustomDigestAuthenticationEntryPoint customDigestAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/rest/users/**").hasAnyRole("USER","admin")
                .antMatchers(HttpMethod.GET, "/rest/users/**").hasAnyRole("USER","guest")
                //.and().httpBasic().authenticationEntryPoint(customBasicAuthenticationEntryPoint)
                .and().exceptionHandling().authenticationEntryPoint(customDigestAuthenticationEntryPoint)
                .and().requiresChannel().antMatchers("/").requiresSecure()
                //.and().addFilter(basicAuthenticationFilter(super.authenticationManagerBean()));
                .and().addFilter(digestAuthenticationFilter());

    }

    public BasicAuthenticationFilter basicAuthenticationFilter(AuthenticationManager authManager) throws Exception {
        BasicAuthenticationFilter basicAuthenticationFilter = new BasicAuthenticationFilter(authManager,
                customBasicAuthenticationEntryPoint);
        return basicAuthenticationFilter;

    }

    public DigestAuthenticationFilter digestAuthenticationFilter() {
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setAuthenticationEntryPoint(customDigestAuthenticationEntryPoint);
        digestAuthenticationFilter.setUserDetailsService(userDetailsService);
        return digestAuthenticationFilter;
    }
}
