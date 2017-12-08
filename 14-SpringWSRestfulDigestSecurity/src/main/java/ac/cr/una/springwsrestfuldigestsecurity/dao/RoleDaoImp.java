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
public class RoleDaoImp implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role findByAuthority(String authority) {
        Role role = null;
        List<Role> roles = null;
        CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Role> criteria = builder.createQuery(Role.class);
        Root<Role> roleRoot = criteria.from(Role.class);
        criteria.select(roleRoot);
        criteria.where(builder.equal(roleRoot.get("authority"), authority));

        roles = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        if (roles != null && !roles.isEmpty()) {
            role = roles.get(0);
        }

        return role;
    }

    @Override
    public Role add(Role role) {
        sessionFactory.getCurrentSession().save(role);

        return role;
    }

    @Override
    public List<Role> listRoles() {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("from Role");
        return query.getResultList();
    }
}
