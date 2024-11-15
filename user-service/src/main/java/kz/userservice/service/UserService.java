package kz.userservice.service;

import kz.userservice.entity.UserEntity;

import java.util.Optional;

public interface UserService {
    UserEntity registerUser(UserEntity user);
    Optional<UserEntity> findByEmail(String email);
    // Additional methods like updateProfile, login, etc.
}
