package com.pushpush.server.controller;

import com.google.gson.JsonObject;
import com.pushpush.server.config.JwtTokenUtil;
import com.pushpush.server.web.jwt.JwtUserDetailsService;
import com.pushpush.server.web.jwt.JwtRequest;
import com.pushpush.server.web.jwt.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/api/users/login", method = RequestMethod.POST)
    public String createAuthenticationToken(@RequestBody JwtRequest authenticationRequest, HttpServletResponse response) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        userDetailsService.saveToken(authenticationRequest.getUsername(), token);

        Cookie myCookie = new Cookie("userToken", token);
        myCookie.setMaxAge(5 * 60 * 60);
        myCookie.setPath("/");

        Cookie idCookie = new Cookie("userId", authenticationRequest.getUsername());
        idCookie.setMaxAge(5 * 60 * 60);
        idCookie.setPath("/");
        response.addCookie(idCookie);

        JsonObject obj =new JsonObject();
        obj.addProperty("success", true);
        obj.addProperty("token", token);

        return obj.toString();
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}