package com.kushal.Place.Booking.System.user.dto;

import com.kushal.Place.Booking.System.user.UserEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDTO {

    private final Integer id;
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;

    public UserResponseDTO(UserEntity user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
    }
}
