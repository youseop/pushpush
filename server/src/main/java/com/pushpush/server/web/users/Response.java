package com.pushpush.server.web.users;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    private Boolean success;
    private String response;
    private String message;
    private Object data;

    public Response(Boolean success, String response, String message, Object data) {
        this.success = success;
        this.response = response;
        this.message = message;
        this.data = data;
    }

}