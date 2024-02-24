package com.example.Beatgenius.business.instrumentale;

import com.example.Beatgenius.generic.AbstractGenericService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
public class InstrumentaleServiceImpl extends AbstractGenericService<Instrumentale, InstrumentaleDto, InstrumentaleRepository, InstrumentaleMapper> implements InstrumentaleService {

    private Path apiFilePath;
    public InstrumentaleServiceImpl(InstrumentaleRepository repository, InstrumentaleMapper mapper, @Value("${APPLICATION_STORAGE_VOLUME}") String filePath) throws Exception {
        super(repository, mapper);

        apiFilePath = Paths.get(filePath).toAbsolutePath().normalize();

        try {
            Files.createDirectories(apiFilePath);
        } catch (IOException e) {
            throw new Exception("Impossible de créer le dossier au chemin " + filePath);
        }
    }


        public String getFileExtension(MultipartFile file) {
            String originalFilename = file.getOriginalFilename();
            if (originalFilename != null && originalFilename.contains(".")) {
                return originalFilename.substring(originalFilename.lastIndexOf(".") );
            }
            return null; // ou vous pouvez lancer une exception ou renvoyer une valeur par défaut si aucune extension n'est trouvée
        }



        public String uploadFile(MultipartFile file, String typeFile) throws IOException {
            UUID uuid = UUID.randomUUID();
            String nameFile = uuid.toString() + getFileExtension(file);
            file.transferTo((new File(apiFilePath + "\\" + typeFile+ "\\" + nameFile )));
            return nameFile;

        }

}



