package com.stu.mobile_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stu.mobile_shop.domains.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findByEmail(String email);
} 
