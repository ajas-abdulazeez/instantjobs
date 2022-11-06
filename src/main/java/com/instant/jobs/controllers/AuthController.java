package com.instant.jobs.controllers;

import com.instant.jobs.entity.Accounts;
import com.instant.jobs.entity.AuthRequest;
import com.instant.jobs.repository.UserRepository;
import com.instant.jobs.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }

        Accounts accounts = userRepository.findByUserName(authRequest.getUserName());
        return jwtUtil.generateToken(authRequest.getUserName());
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> registerNewUser(@RequestBody Accounts accounts){
//
//        Accounts newAccount = new Accounts();
//        newAccount =accounts;
//        newAccount.setAppVersion("1");
//        return ResponseEntity.ok(userDetailsService.addUser(newAccount));
//
//    }
}
