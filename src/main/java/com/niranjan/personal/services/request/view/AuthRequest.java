package com.niranjan.personal.services.request.view;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class AuthRequest {
    @NotBlank
    @Size(max = 16)
    @ApiModelProperty(notes = "Username to login.", example = "user1234", required = true, position = 0)
    private String username;

    @NotBlank
    @Size(max = 16)
    @ApiModelProperty(notes = "Password for login.", example = "********", required = true, position = 1)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}