package rest.hh.services;

import rest.hh.models.Culture;

import java.util.Optional;

public interface CultureService {
    Optional<Culture> findById(Long id);
}
