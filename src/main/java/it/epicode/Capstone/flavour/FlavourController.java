package it.epicode.Capstone.flavour;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flavour")
@RequiredArgsConstructor
public class FlavourController {
    private final FlavourService flavourService;

    @GetMapping
    public ResponseEntity<List<Flavour>> getAllFlavours() {
        List<Flavour> flavours = flavourService.getAllFlavours();
        return ResponseEntity.ok(flavours);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok( flavourService.findById(id) );
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Flavour> createFlavour(@Valid @RequestBody FlavourRequest flavourRequest) {
        Flavour flavour = flavourService.createFlavour(flavourRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(flavour);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Flavour> updateFlavour(@PathVariable Long id, @Valid @RequestBody FlavourRequest flavourRequest) {
        Flavour updatedFlavour = flavourService.updateFlavour(id, flavourRequest);
        return ResponseEntity.ok(updatedFlavour);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteFlavour(@PathVariable Long id) {
        flavourService.deleteFlavour(id);
        return ResponseEntity.noContent().build();
    }
}