package ac.cr.una.springwsrestfuldigestsecurity.dao;

import ac.cr.una.springwsrestfuldigestsecurity.model.Role;
import ac.cr.una.springwsrestfuldigestsecurity.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public User getUserByEmail(String email) {
        // Create CriteriaBuilder
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        criteria.select(userRoot);
        criteria.where(builder.equal(userRoot.get("email"), email));

        User user = sessionFactory.getCurrentSession().createQuery(criteria).getSingleResult();

        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        List<User> users = null;

        // Create CriteriaBuilder
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> userRoot = criteria.from(User.class);
        criteria.select(userRoot);
        criteria.where(builder.equal(userRoot.get("username"), username));

        users = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        if (users != null && !users.isEmpty()) {
            user = users.get(0);
        }

        return user;
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
