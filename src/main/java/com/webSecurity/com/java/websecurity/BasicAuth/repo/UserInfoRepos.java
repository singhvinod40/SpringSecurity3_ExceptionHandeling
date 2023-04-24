package com.webSecurity.com.java.websecurity.BasicAuth.repo;

import com.webSecurity.com.java.websecurity.BasicAuth.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserInfoRepos extends JpaRepository<UserInfo,Integer> {

    @Query("Select u from UserInfo u where u.name=:username")
    Optional<UserInfo> findByName(@Param("username") String username);

}
