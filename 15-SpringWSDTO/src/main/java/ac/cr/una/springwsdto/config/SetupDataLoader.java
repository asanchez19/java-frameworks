package ac.cr.una.springwsdto.config;

import ac.cr.una.springwsdto.dao.UserDao;
import ac.cr.una.springwsdto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        List<User> users = userDao.listUsers();

        if ((!alreadySetup) && ((users == null) || (users.isEmpty()))) {

            // == create initial users
            User user1 = userDao.add(new User("Paul", "Bora", "suni.bora@example.com"));
            User user2 = userDao.add(new User("David", "Miller", "david.miller@example.com"));
            User user3 = userDao.add(new User("Sameer", "Singh", "sameer.singh@example.com"));

            alreadySetup = true;
        }
    }

}
