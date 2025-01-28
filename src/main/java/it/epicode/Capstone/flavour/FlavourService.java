package it.epicode.Capstone.flavour;

import it.epicode.Capstone.auth.AppUser;
import it.epicode.Capstone.auth.AppUserRepository;
import it.epicode.Capstone.auth.Role;
import it.epicode.Capstone.exceptions.ResourceNotFoundException;
import it.epicode.Capstone.exceptions.UnauthorizedException;
import it.epicode.Capstone.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlavourService {
    private final FlavourRepository flavourRepository;
    private final AppUserRepository appUserRepository;

    //DEFINISCO ADMIN E CURRENT USER
    private boolean isAdmin(AppUser user) {
        return user.getRoles().contains(Role.ROLE_ADMIN);
    }

    private AppUser getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato"));
    }

    //RECUPERO TUTTI I GUSTI
    public List<Flavour> getAllFlavours() {
        return flavourRepository.findAll();
    }

    //CREO UN NUOVO GUSTO
    public Flavour createFlavour(FlavourRequest flavourRequest) {
        AppUser loggedInUser = getCurrentUser();

        if (!isAdmin(loggedInUser)) {
            throw new UnauthorizedException("Non sei autorizzato ad eseguire questa operazione");
        }

        Flavour flavour = new Flavour();
        flavour.setName(flavourRequest.getName());
        flavour.setDescription(flavourRequest.getDescription());
        return flavourRepository.save(flavour);
    }

    //MODIFICO UN GUSTO
    public Flavour updateFlavour(Long id, FlavourRequest flavourRequest) {
        AppUser loggedInUser = getCurrentUser();

        if (!isAdmin(loggedInUser)) {
            throw new UnauthorizedException("Non sei autorizzato ad eseguire questa operazione");
        }

        Flavour existingFlavour = flavourRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gusto con ID " + id + " non trovato"));

        existingFlavour.setName(flavourRequest.getName());
        existingFlavour.setDescription(flavourRequest.getDescription());
        return flavourRepository.save(existingFlavour);
    }

    //ELIMINO UN GUSTO
    public void deleteFlavour(Long id) {
        AppUser loggedInUser = getCurrentUser();

        if (!isAdmin(loggedInUser)) {
            throw new UnauthorizedException("Non sei autorizzato ad eseguire questa operazione");
        }

        if (!flavourRepository.existsById(id)) {
            throw new ResourceNotFoundException("Gusto con ID " + id + " non trovato");
        }

        flavourRepository.deleteById(id);
    }
}
