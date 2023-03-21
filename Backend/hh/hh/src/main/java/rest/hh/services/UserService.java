package rest.hh.services;
import rest.hh.models.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUserByEmail(String email);
}
