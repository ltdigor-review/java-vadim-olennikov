package org.example.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.UpdateUserRecord;
import org.example.dto.UserRecord;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public UserRecord createUser(@RequestBody @Valid UserRecord userRecord) {
        return userService.createUser(userRecord);
    }

    @PatchMapping("/{id}")
    public UserRecord updateUserId(
            @PathVariable("id") UUID currentUserId, @RequestBody @Valid UpdateUserRecord updateUserRecord) {
        return userService.updateUser(currentUserId, updateUserRecord);
    }
}
