package ac.cr.una.springwstaskscheduling.service;

import ac.cr.una.springwstaskscheduling.model.User;

import java.util.List;

public interface UserService {
    User add (User user);
    User update (Long idUser, User user);
    List<User> listUsers();
    User getUserById (Long idUser);
    boolean deleteById (Long idUser);
}