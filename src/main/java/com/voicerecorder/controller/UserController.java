package com.voicerecorder.controller;


import com.voicerecorder.entity.User;
import com.voicerecorder.service.VoiceRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    VoiceRecorderService voiceRecorderService;

    @Autowired
    public JdbcTemplate template;


    @PostMapping("/v1/user")
    @ResponseBody
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            voiceRecorderService.addUser(user);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Success");

    }

    @PostMapping("/v1/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user;

        try {
            user = voiceRecorderService.getUserById(userId);
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok().body(user);

    }

    @PutMapping("/v1/user")
    public ResponseEntity<Void> updateUser(@RequestBody User user) {
        try {
            voiceRecorderService.updateUser(user);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/user/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String userId) {
        try {
            Long id = Long.parseLong(userId);
            voiceRecorderService.deleteUserById(id);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/v1/user")
    public ResponseEntity<Void> deleteUser(@RequestBody User user) {
        try {
            voiceRecorderService.deleteUser(user);

        } catch (Exception e ) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();

    }


}
