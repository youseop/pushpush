package com.pushpush.server.web.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String id;
    private String password;
    private String auth;
    private Long major_idx;
}
