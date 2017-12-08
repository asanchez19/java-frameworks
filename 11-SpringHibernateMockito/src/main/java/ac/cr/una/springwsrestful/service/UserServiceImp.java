package ac.cr.una.springwsrestful.service;

import ac.cr.una.springwsrestful.dao.UserDao;
import ac.cr.una.springwsrestful.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User add(User user) {
        User userPersisted = userDao.add(user);
        return userPersisted;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

}