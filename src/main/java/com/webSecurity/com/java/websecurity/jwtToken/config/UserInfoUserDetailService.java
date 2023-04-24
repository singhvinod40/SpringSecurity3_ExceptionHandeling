package com.webSecurity.com.java.websecurity.jwtToken.config;

import com.webSecurity.com.java.websecurity.BasicAuth.entity.UserInfo;
import com.webSecurity.com.java.websecurity.BasicAuth.repo.UserInfoRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserInfoUserDetailService implements UserDetailsService {

    @Autowired
    private UserInfoRepos userInfoRepos;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         Optional<UserInfo> user = userInfoRepos.findByName(username);

         return user.map(UserInfoUserDetails::new)
                 .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));


    }
}
