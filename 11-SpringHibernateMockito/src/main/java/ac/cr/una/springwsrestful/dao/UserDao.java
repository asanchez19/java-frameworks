package ac.cr.una.springwsrestful.dao;

import ac.cr.una.springwsrestful.model.User;

import java.util.List;

public interface UserDao {
    User add(User user);
    List<User> listUsers();
}
