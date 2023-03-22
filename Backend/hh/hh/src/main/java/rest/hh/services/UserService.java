package rest.hh.services;
import rest.hh.dto.UserDto;
import rest.hh.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserByEmail(String email);

    User mapToUser(UserDto userDto);

    UserDto mapToUserDto(User user);

    void save(User user);

    Optional<User> findByEmail(String email);
}
