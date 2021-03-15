package com.sublink.api.controller;

import com.sublink.api.domain.user.UserAccount;
import com.sublink.api.domain.user.UserProfile;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "user", basePath = "/user", description = "사용자 관련 서비스")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/signup")
    public ResponseEntity<UserAccount> signup(@RequestBody UserAccount userEntity) {
        // TODO: save to mongodb
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody UserAccount userEntity) {
        // TODO: read from mongodb
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> readUserAccount(@PathVariable String id) {
        // TODO: read from mongodb
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<String> changePassword(@PathVariable String id, @RequestBody UserAccount userEntity) {
        // TODO: process PATCH request
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/account")
    public ResponseEntity<String> updateUserAccount(@PathVariable String id, @RequestBody UserAccount userEntity) {
        // TODO: process PUT request
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<String> updateUserProfile(@PathVariable String id, @RequestBody UserProfile userProfile) {
        // TODO: process PUT request
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
