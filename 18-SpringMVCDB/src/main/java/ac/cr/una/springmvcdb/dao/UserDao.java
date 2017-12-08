package ac.cr.una.springmvcdb.dao;

import ac.cr.una.springmvcdb.model.User;

import java.util.List;

public interface UserDao {
    User add(User user);
    User update (Long idUser, User user);
    List<User> listUsers();
    User getUserById (Long idUser);
    boolean deleteById (Long idUser);
}
