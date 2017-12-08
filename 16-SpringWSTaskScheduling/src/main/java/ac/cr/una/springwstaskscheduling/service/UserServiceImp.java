package ac.cr.una.springwstaskscheduling.service;

import ac.cr.una.springwstaskscheduling.dao.UserDao;
import ac.cr.una.springwstaskscheduling.model.User;
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

    @Transactional
    @Override
    public User update(Long idUser, User user) {
        User userPersisted = userDao.update(idUser, user);

        return userPersisted;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById (Long idUser) {
        return userDao.getUserById(idUser);
    }

    @Transactional
    @Override
    public boolean deleteById (Long idUser) {
        return userDao.deleteById(idUser);
    }
}