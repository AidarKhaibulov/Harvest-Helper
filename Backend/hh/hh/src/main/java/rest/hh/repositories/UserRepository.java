package rest.hh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.hh.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
}
