package com.example.springboot.web.Repository;

import com.example.springboot.web.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Set;

@Repository
@Transactional
public interface RoleRepo extends JpaRepository<Role,Long>, Serializable {
    Set<Role> findByName(String name);
}
