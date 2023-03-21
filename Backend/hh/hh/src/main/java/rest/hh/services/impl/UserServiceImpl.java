package rest.hh.services.impl;

import org.springframework.stereotype.Service;
import rest.hh.models.User;
import rest.hh.repositories.UserRepository;
import rest.hh.services.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
