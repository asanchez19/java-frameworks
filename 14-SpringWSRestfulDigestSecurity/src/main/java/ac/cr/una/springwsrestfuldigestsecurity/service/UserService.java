package ac.cr.una.springwsrestfuldigestsecurity.service;


import ac.cr.una.springwsrestfuldigestsecurity.model.Role;
import ac.cr.una.springwsrestfuldigestsecurity.model.User;

import java.util.List;

public interface UserService {
    User add(User user);
    User update(Long idUser, User user);
    List<User> listUsers();
    User getUserById(Long idUser);
    boolean deleteById(Long idUser);
    List<Role> listRoles();
}