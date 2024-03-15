package com.ind.lms.repository.interfaces;

import com.ind.lms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserRepository extends JpaRepository<User, Integer> {
    UserDetails findUserByUsername(String username);
}
