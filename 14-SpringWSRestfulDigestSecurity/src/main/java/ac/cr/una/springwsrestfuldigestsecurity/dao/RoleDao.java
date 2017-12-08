package ac.cr.una.springwsrestfuldigestsecurity.dao;

import ac.cr.una.springwsrestfuldigestsecurity.model.Role;

import java.util.List;

public interface RoleDao {
    Role findByAuthority(String authority);
    Role add(Role role);
    List<Role> listRoles();
}
