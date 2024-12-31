package com.nautiDevelopers.Utils;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BcryptPasswordGenerator {

    public static void main(String[] args) {

        // Create a PasswordEncoder using DelegatingPasswordEncoder
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //Username: Akshit
        System.out.println(passwordEncoder.encode("a12345"));//Password
        //Username: Admin
        System.out.println(passwordEncoder.encode("12345"));
    }
}

