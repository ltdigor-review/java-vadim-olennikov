package org.example.controller;


import jakarta.validation.Valid;
import org.example.dto.UserRecord;
import org.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserRecord> createUser(@RequestBody @Valid UserRecord userRecord) {
        return userService.createUser(userRecord);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserRecord> updateUserId(
            @PathVariable("id") Long currentUserId, @RequestBody @Valid Long updateUserId) {
        return userService.updateUser(currentUserId, updateUserId);
    }
}
