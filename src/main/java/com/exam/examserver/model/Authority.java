package com.exam.examserver.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    final private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
