package org.telran.social.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/security")
public class SecurityCheckController {

    @GetMapping("/one")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> checkOne() {
        return ResponseEntity.ok("Ok check one");
    }

    @GetMapping("/two")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public ResponseEntity<String> checkTwo() {
        return ResponseEntity.ok("Ok check two");
    }
}
