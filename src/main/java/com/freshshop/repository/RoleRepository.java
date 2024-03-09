package com.freshshop.repository;

import com.freshshop.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
    Roles getByRoleName(String roleName);

    Roles findByRoleName(String roleName);

}
