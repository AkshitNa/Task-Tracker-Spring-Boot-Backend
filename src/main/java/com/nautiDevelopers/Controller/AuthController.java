package com.nautiDevelopers.Controller;

import com.nautiDevelopers.DTO.JwtAuthResponseDTO;
import com.nautiDevelopers.DTO.LoginDTO;
import com.nautiDevelopers.DTO.RegisterDTO;
import com.nautiDevelopers.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Build Register REST API
    //http://localhost:8080/api/auth/register
    @PostMapping("/register")
    public ResponseEntity<String> register(@Validated @RequestBody RegisterDTO registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Build Check Username or Email REST API
    // http://localhost:8080/api/auth/checkUsernameOrEmail
    @PostMapping("/checkUsernameOrEmail")
    public ResponseEntity<Boolean> checkUsernameOrEmail(@RequestBody RegisterDTO registerDto) {
        boolean exists = authService.checkUsernameOrEmailExists(registerDto.getUsername(), registerDto.getEmail());
        if (exists) {
            return new ResponseEntity<>(true, HttpStatus.BAD_REQUEST); // Return true with 400 Bad Request if exists
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK); // Return false with 200 OK if it doesn't exist
        }
    }

    // Build Login REST API
    //http://localhost:8080/api/auth/login
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponseDTO> login(@RequestBody LoginDTO loginDto){
        String token = authService.login(loginDto);

        JwtAuthResponseDTO jwtAuthResponse = new JwtAuthResponseDTO();
        jwtAuthResponse.setAccessToken(token);

        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

}

