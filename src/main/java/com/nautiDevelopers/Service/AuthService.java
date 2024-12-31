package com.nautiDevelopers.Service;

import com.nautiDevelopers.DTO.LoginDTO;
import com.nautiDevelopers.DTO.RegisterDTO;

public interface AuthService {
    String register(RegisterDTO registerDto);
    String login(LoginDTO loginDto);
    boolean checkUsernameOrEmailExists(String username, String email);
}
