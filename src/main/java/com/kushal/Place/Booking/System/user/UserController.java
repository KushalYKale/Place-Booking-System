package com.kushal.Place.Booking.System.user;

import com.kushal.Place.Booking.System.user.dto.CreateUserRequestDTO;
import com.kushal.Place.Booking.System.user.dto.UserResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/users")
    public UserResponseDTO createUser(@RequestBody @Valid CreateUserRequestDTO createUserRequestDTO){
        return new UserResponseDTO(userService.createUser(createUserRequestDTO.getName(), createUserRequestDTO.getEmail()));
    }

    @GetMapping("/users/{userId}")
    public UserResponseDTO getUsersById(@PathVariable Integer userId){
        return new UserResponseDTO(userService.getUserById(userId));
    }
}
