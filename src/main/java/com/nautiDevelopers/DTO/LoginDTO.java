package com.nautiDevelopers.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private String usernameOrEmail;
    private String password;
}
