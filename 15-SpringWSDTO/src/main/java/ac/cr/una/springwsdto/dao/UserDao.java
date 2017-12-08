package ac.cr.una.springwsdto.dao;

import ac.cr.una.springwsdto.model.User;

import java.util.List;

public interface UserDao {
    User add(User user);
    User update (Long idUser, User user);
    List<User> listUsers();
    User getUserById (Long idUser);
    boolean deleteById (Long idUser);
}
