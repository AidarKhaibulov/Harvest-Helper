package rest.hh.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rest.hh.models.Culture;
import rest.hh.repositories.CultureRepository;
import rest.hh.services.CultureService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CultureServiceImpl implements CultureService {
    private final CultureRepository cultureRepository;

    @Override
    public Optional<Culture> findById(Long id) {
        return cultureRepository.findById(id);
    }
}
