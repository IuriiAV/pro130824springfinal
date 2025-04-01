package org.telran.social.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.telran.social.entity.NetworkUser;
import org.telran.social.security.model.SignInRequest;
import org.telran.social.security.model.SignInResponse;
import org.telran.social.service.NetworkUserService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private NetworkUserService userService;

    @Autowired
    private JwtService jwtService;

    @Override
    public SignInResponse authenticate(SignInRequest request) {
        //вызов этого метода - проверка логина и пароля как и при базовой аутентификации
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.login(), request.password()));

        NetworkUser networkUser = userService.findByLogin(request.login());
        String token = jwtService.generateToken(networkUser);
        return new SignInResponse(token);
    }
}
