package it.epicode.Capstone.flavour;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlavourRepository extends JpaRepository<Flavour, Long> {
    Optional<Flavour> findByName(String name);
}