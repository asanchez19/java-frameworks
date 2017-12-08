package ac.cr.una.springmvcws.service;

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
@Configuration
@PropertySource("classpath:ws.properties")
public class UserServiceImp implements UserService {

    @Autowired
    private Environment env;

    private String urlWebService = env.getProperty("ws.restful.path").concat("users");

    @Override
    public User add(User user) {
        User newUser = null;
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<>(user);

        newUser = restTemplate.postForObject(urlWebService,request, User.class);

        return newUser;
    }

    @Override
    public User update(Long idUser, User user) {

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.put(urlWebService, user);

        return user;

    }

    @Override
    public List<User> listUsers() {

        List<User> listUsers = null;
        RestTemplate restTemplate = new RestTemplate();

        listUsers = restTemplate.getForObject(urlWebService, List.class);

        return listUsers;
    }

    @Override
    public User getUserById(Long idUser) {
        User user = null;
        RestTemplate restTemplate = new RestTemplate();
        String url = urlWebService.concat("/users/{id}");

        user = restTemplate.getForObject(url, User.class, idUser);

        return user;
    }

    @Override
    public boolean deleteById(Long idUser) {
        boolean isDeleted = true;
        RestTemplate restTemplate = new RestTemplate();

        String url = urlWebService.concat("/users/").concat(idUser.toString());

        restTemplate.delete(url);

        return isDeleted;
    }
}