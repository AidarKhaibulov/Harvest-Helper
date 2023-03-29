package rest.hh.services;
import org.springframework.http.ResponseEntity;
import rest.hh.dto.UserDto;
import rest.hh.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserByEmail(String email);

    User mapToUser(UserDto userDto);

    UserDto mapToUserDto(User user);

    ResponseEntity save(User user);

    Optional<User> findByEmail(String email);
}
