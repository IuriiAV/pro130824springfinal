package org.telran.social.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/security")
public class SecurityCheckController {

    @GetMapping("/one")
    public ResponseEntity<String> checkOne() {
        return ResponseEntity.ok("Ok check one");
    }

    @GetMapping("/two")
    public ResponseEntity<String> checkTwo() {
        return ResponseEntity.ok("Ok check two");
    }
}
