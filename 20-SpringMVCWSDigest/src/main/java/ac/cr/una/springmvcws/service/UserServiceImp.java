package ac.cr.una.springmvcws.service;

import ac.cr.una.springmvcws.config.AppSecurityClientConfig;
import ac.cr.una.springmvcws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserServiceImp implements UserService {

    @Autowired
    private Environment env;

    @Autowired
    private AppSecurityClientConfig securityClientConfig;

    @Override
    public User add(User user) {
        User newUser = null;
        RestTemplate restTemplate = securityClientConfig.restTemplate();
        HttpEntity<User> request = new HttpEntity<>(user);
        String urlWebService = env.getProperty("ws.restful.path").concat("users");;

        newUser = restTemplate.postForObject(urlWebService,request, User.class);

        return newUser;
    }

    @Override
    public User update(Long idUser, User user) {

        RestTemplate restTemplate = securityClientConfig.restTemplate();
        String urlWebService = env.getProperty("ws.restful.path").concat("users");;

        restTemplate.put(urlWebService, user);

        return user;

    }

    @Override
    public List<User> listUsers() {

        List<User> listUsers = null;
        RestTemplate restTemplate = securityClientConfig.restTemplate();
        String urlWebService = env.getProperty("ws.restful.path").concat("users");;

        listUsers = restTemplate.getForObject(urlWebService, List.class);

        return listUsers;
    }

    @Override
    public User getUserById(Long idUser) {
        User user = null;
        RestTemplate restTemplate = securityClientConfig.restTemplate();
        String urlWebService = env.getProperty("ws.restful.path").concat("users/{id}");

        user = restTemplate.getForObject(urlWebService, User.class, idUser);

        return user;
    }

    @Override
    public boolean deleteById(Long idUser) {
        boolean isDeleted = true;
        RestTemplate restTemplate = securityClientConfig.restTemplate();
        String urlWebService = env.getProperty("ws.restful.path").concat("users/").concat(idUser.toString());

        restTemplate.delete(urlWebService);

        return isDeleted;
    }
}