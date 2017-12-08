package ac.cr.una.springwsrestfulbasicsecurity.dao;

import ac.cr.una.springwsrestfulbasicsecurity.model.User;

import java.util.List;

public interface UserDao {
    User add(User user);
    User update (Long idUser, User user);
    List<User> listUsers();
    User getUserById (Long idUser);
    boolean deleteById (Long idUser);
}
