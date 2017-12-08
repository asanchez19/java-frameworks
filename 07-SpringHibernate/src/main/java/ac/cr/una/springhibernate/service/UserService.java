package ac.cr.una.springhibernate.service;

import ac.cr.una.springhibernate.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
}