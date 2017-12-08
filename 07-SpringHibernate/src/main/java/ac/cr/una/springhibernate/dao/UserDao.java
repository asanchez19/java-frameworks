package ac.cr.una.springhibernate.dao;

import ac.cr.una.springhibernate.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
}
