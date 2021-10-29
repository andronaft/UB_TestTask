package com.zuk.rest;



import com.zuk.dto.AuthDto;

import com.zuk.repository.UserRepository;
import com.zuk.service.AuthService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthenticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;
    private final AuthService authService;
    private final UserRepository repository;

    @Autowired
    public AuthenticationRestControllerV1(AuthenticationManager authenticationManager, AuthService authService, UserRepository repository) {
        this.authenticationManager = authenticationManager;
        this.authService = authService;
        this.repository = repository;
    }

    @PostMapping("/test")
    public ResponseEntity test() {
        return ResponseEntity.ok("I work)");
    }

    @PostMapping("/")
    public ResponseEntity login() throws JSONException {
        AuthDto authDto = new AuthDto();
        return ResponseEntity.ok(authService.login(authDto));
    }





}