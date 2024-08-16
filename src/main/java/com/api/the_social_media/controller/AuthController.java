package com.api.the_social_media.controller;

import com.api.the_social_media.DTOS.requests.JwtDTO;
import com.api.the_social_media.DTOS.requests.LoginDTO;
import com.api.the_social_media.DTOS.requests.RegisterDTO;
import com.api.the_social_media.domain.user.User;
import com.api.the_social_media.service.security.auth.AuthService;
import com.api.the_social_media.service.security.token.TokenProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

    private final TokenProviderService tokenProviderService;
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(TokenProviderService tokenProviderService, AuthService authService, AuthenticationManager authenticationManager) {
        this.tokenProviderService = tokenProviderService;
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> signUp(@RequestBody @Validated RegisterDTO data) throws Exception {
        authService.signUp(data);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> signIn(@RequestBody @Validated LoginDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var authUser = authenticationManager.authenticate(usernamePassword);
        var accessToken = tokenProviderService.generateAccessToken((User)authUser.getPrincipal());
        return ResponseEntity.ok(new JwtDTO(accessToken));
    }
}