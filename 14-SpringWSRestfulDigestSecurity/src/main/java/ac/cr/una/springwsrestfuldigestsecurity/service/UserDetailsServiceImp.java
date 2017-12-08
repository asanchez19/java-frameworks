package ac.cr.una.springwsrestfuldigestsecurity.service;

import ac.cr.una.springwsrestfuldigestsecurity.dao.UserDao;
import ac.cr.una.springwsrestfuldigestsecurity.model.Role;
import ac.cr.una.springwsrestfuldigestsecurity.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    private static final Logger slf4jLogger = LoggerFactory.getLogger(UserDetailsServiceImp.class);

    @Autowired
    private UserDao userDao;

    @Transactional
    public User add(User user) {
        User userPersisted = userDao.add(user);
        return userPersisted;
    }

    @Transactional
    public User update(Long idUser, User user) {
        User userPersisted = userDao.update(idUser, user);

        return userPersisted;
    }

    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional(readOnly = true)
    public User getUserById(Long idUser) {
        return userDao.getUserById(idUser);
    }

    @Transactional
    public boolean deleteById(Long idUser) {
        return userDao.deleteById(idUser);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            slf4jLogger.debug("user not found with the provided username");
            throw new UsernameNotFoundException("No user present with username: "+ username);
        } else {
            userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(), user.isEnabled(), true, true,
                    true, getGrantedAuthorities(user.getRoles()));
        }

        return userDetails;
    }

    private List<GrantedAuthority> getGrantedAuthorities(final Set<Role> roles) {
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (final Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        return authorities;
    }

}