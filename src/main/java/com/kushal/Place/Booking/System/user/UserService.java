package com.kushal.Place.Booking.System.user;

import com.kushal.Place.Booking.System.exception.UserAlreadyExistException;
import com.kushal.Place.Booking.System.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(String name,String email){
        UserEntity userEntity;
        Optional<UserEntity> emailCheck = userRepository.findByEmail(email);

        if(emailCheck.isPresent()){
            throw new UserAlreadyExistException();
        }

        userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setEmail(email);
        userRepository.save(userEntity);

        return userEntity;
    }

    public UserEntity getUserById(Integer id){
        Optional<UserEntity> idCheck = userRepository.findById(id);
        if(!idCheck.isPresent()) throw new UserNotFoundException();

        return idCheck.get();
    }

    public void validateUserExists(Integer id){
        Optional<UserEntity> idCheck = userRepository.findById(id);
        if(!idCheck.isPresent()) throw new UserNotFoundException();
    }
}
