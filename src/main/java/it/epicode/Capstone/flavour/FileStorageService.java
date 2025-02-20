package it.epicode.Capstone.flavour;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private final String UPLOAD_DIR = "src/main/resources/static/uploads/flavours/";

    //SALVO IL FILE NELLA CARTELLA /uploads/flavours/ E RESTITUISCO IL PERCORSO
    public String saveFile(MultipartFile file) throws Exception {
        try {
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return "flavours/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Errore nel salvataggio del file", e);
        }
    }
}
