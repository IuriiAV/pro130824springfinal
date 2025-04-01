package org.telran.social.security;

import org.telran.social.security.model.SignInRequest;
import org.telran.social.security.model.SignInResponse;

public interface AuthenticationService {

    SignInResponse authenticate(SignInRequest request);
}
