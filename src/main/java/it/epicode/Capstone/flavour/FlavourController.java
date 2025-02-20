package it.epicode.Capstone.flavour;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/flavour")
@RequiredArgsConstructor
public class FlavourController {
    private final FlavourService flavourService;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping
    public ResponseEntity<List<Flavour>> getAllFlavours() {
        List<Flavour> flavours = flavourService.getAllFlavours();
        return ResponseEntity.ok(flavours);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(flavourService.findById(id));
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

    @PostMapping("/upload")
    @PreAuthorize("hasRole('ADMIN')")
    /*public ResponseEntity<Map<String, String>> uploadImage(@RequestParam("file") MultipartFile file) {*/
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        if (fileStorageService == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FileStorageService not initialized");
        }
        try {
            String imageUrl = fileStorageService.saveFile(file);
            return ResponseEntity.ok(imageUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore nel caricamento del file" + e.getMessage());
        }
    }
}
       /* try {
            // Percorso assoluto in una cartella esterna
            String uploadDir = "uploads/flavours/";
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs(); // Crea la cartella se non esiste
            }

            // Salva il file nella cartella esterna
            Path path = Paths.get(uploadDir + file.getOriginalFilename());
            Files.write(path, file.getBytes());

            // Costruisci l'URL accessibile per l'immagine
            String imageUrl = "/uploads/flavours/" + file.getOriginalFilename();

            // Ritorna una risposta JSON valida
            Map<String, String> response = new HashMap<>();
            response.put("imageUrl", imageUrl);
            return ResponseEntity.ok(response);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}*/
        /*try {
            // Percorso della cartella dove salvare l'immagine
            String uploadDir = "src/main/resources/static/uploads/flavours/";

            // Salva il file con il suo nome originale
            Path path = Paths.get(uploadDir + file.getOriginalFilename());
            Files.write(path, file.getBytes());

            // Costruisci l'URL accessibile per l'immagine
            String imageUrl = "/uploads/flavours/" + file.getOriginalFilename();

            // Ritorna una risposta JSON valida
            Map<String, String> response = new HashMap<>();
            response.put("imageUrl", imageUrl);
            return ResponseEntity.ok(response);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}*/

