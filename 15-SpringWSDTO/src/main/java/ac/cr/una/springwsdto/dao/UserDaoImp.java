package ac.cr.una.springwsdto.dao;

import ac.cr.una.springwsdto.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User add(User user) {
        sessionFactory.getCurrentSession().save(user);

        return user;
    }

    @Override
    public List<User> listUsers() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserById(Long idUser) {
        User user = (User) sessionFactory.getCurrentSession().get(User.class, idUser);
        return user;
    }

    @Override
    public boolean deleteById(Long idUser) {
        boolean isDeleted = false;
        User user = getUserById(idUser);

        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
            isDeleted = true;
        }

        return isDeleted;
    }

    @Override
    public User update(Long idUser, User user) {

        User userUpdated = getUserById(idUser);

        if (userUpdated != null) {
            sessionFactory.getCurrentSession().merge(user);
        } else {
            user = null;
        }

        return user;
    }

}
