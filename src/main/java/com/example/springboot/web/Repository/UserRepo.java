package com.example.springboot.web.Repository;

import com.example.springboot.web.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User,Long>, Serializable {
    User findByEmail(String email);
}
