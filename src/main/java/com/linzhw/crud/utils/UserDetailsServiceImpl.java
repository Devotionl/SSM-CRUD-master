package com.linzhw.crud.utils;

import com.linzhw.crud.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.ArrayList;
import java.util.List;

/**
 * 认证类
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private SellerService sellerService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("经过了");
        //构建角色列表
        List<GrantedAuthority> grantAuths = new ArrayList<GrantedAuthority>();
        grantAuths.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        sellerService.findOne(username);
        return new User(username,"123456",grantAuths);
    }
}
