package rest.hh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rest.hh.models.Culture;

public interface CultureRepository extends JpaRepository<Culture,Long> {
}
