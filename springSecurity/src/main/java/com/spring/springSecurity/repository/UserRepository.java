package com.spring.springSecurity.repository;

import com.spring.springSecurity.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserInfo,String> {

    Optional<UserInfo> findByName(String username);
}
