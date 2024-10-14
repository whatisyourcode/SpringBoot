package edu.du.sb1011.dto;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String password;
    private String name;
    private String role;
}
