package com.nautiDevelopers.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

    private String name;
    private String username;
    private String email;
    private String password;
}
