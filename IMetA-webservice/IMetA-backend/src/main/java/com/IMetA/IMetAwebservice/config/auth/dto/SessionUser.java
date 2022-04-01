package com.IMetA.IMetAwebservice.config.auth.dto;

import com.IMetA.IMetAwebservice.domain.User;
import lombok.Getter;

@Getter
public class SessionUser { //인증된 사용자 정보

    private String name;
    private String email;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
