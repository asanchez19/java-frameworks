package ac.cr.una.springwsrestful.service;

import ac.cr.una.springwsrestful.model.User;

import java.util.List;

public interface UserService {
    User add (User user);
    List<User> listUsers();
}