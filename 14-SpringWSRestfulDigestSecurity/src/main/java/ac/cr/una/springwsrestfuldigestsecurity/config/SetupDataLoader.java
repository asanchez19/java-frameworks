package ac.cr.una.springwsrestfuldigestsecurity.config;

import ac.cr.una.springwsrestfuldigestsecurity.dao.RoleDao;
import ac.cr.una.springwsrestfuldigestsecurity.dao.UserDao;
import ac.cr.una.springwsrestfuldigestsecurity.model.Role;
import ac.cr.una.springwsrestfuldigestsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        User userAdmin = userDao.getUserByUsername("admin");

        if ((!alreadySetup) && (userAdmin == null)) {
            // == create initial roles
            Set<Role> rolesAdmin =  new HashSet<Role>();
            createRoleIfNotFound("ROLE_ADMIN");
            createRoleIfNotFound("ROLE_USER");

            final Role adminRole = roleDao.findByAuthority("ROLE_ADMIN");
            rolesAdmin.add(adminRole);
            final User user = new User();
            user.setFirstName("Mike");
            user.setLastName("Guzman");
            user.setUsername("admin");
            user.setPassword("admin");
            user.setEmail("mike@test.com");
            user.setRoles(rolesAdmin);
            user.setEnabled(true);

            userDao.add(user);


            final Role userRole = roleDao.findByAuthority("ROLE_USER");
            Set<Role> rolesUser =  new HashSet<Role>();
            rolesUser.add(userRole);

            // Add Users
            User user1 = userDao.add(new User("guest", "Paul", "Bora",
                    "suni.bora@example.com", "guest", true, rolesUser));
            User user2 = userDao.add(new User("david", "David", "Miller",
                    "david.miller@example.com","guest", true, rolesUser));
            User user3 = userDao.add(new User("sammer", "Sameer", "Singh",
                    "sameer.singh@example.com","guest", true, rolesUser));
            User user4 = userDao.add(new User("smit", "Smit", "Smith",
                    "paul.smith@example.com","guest", true, rolesUser));


            alreadySetup = true;
        }
    }

    private Role createRoleIfNotFound(final String authority) {
        Role role = roleDao.findByAuthority(authority);
        if (role == null) {
            role = new Role(authority);
            roleDao.add(role);
        }
        return role;
    }
}
