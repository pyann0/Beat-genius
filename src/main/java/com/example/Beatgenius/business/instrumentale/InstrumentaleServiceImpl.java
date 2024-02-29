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
import java.util.*;

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
            return originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        return null; // ou vous pouvez lancer une exception ou renvoyer une valeur par défaut si aucune extension n'est trouvée
    }


    /*public String uploadFile(MultipartFile file, String typeFile) throws IOException {
        UUID uuid = UUID.randomUUID();
        String nameFile = uuid.toString() + getFileExtension(file);
        file.transferTo((new File(apiFilePath + "\\" + typeFile + "\\" + nameFile)));
        return nameFile;

    }*/
    public InstrumentaleDto uploadInstrumentale(MultipartFile instrumentale, MultipartFile cover, InstrumentaleDto instrumentaleDto) throws IOException {
        // Génère un identifiant afin qui sois donnée aux fichiers
        UUID uuid = UUID.randomUUID();
        // On retourne cette liste qui contiendra le nom des fichiers qu'on enregistre en base de donnée

        // Verifie que instrumentale est sois un mp3 ou un wav
        if ((Objects.equals(getFileExtension(instrumentale), ".mp3") || Objects.equals(getFileExtension(instrumentale), ".wav"))
                && (Objects.equals(getFileExtension(cover), ".png") || Objects.equals(getFileExtension(cover), ".jpeg") || Objects.equals(getFileExtension(cover), ".jpg"))){
            //Verifie que cover est un type png, jpeg ou jpg

                // le fichier prends l'indentifiant ainsi que l'extension du fichier ex: uuid.mp3
                String nameInstrumentale = uuid.toString() + getFileExtension(instrumentale);
                // Enregistrement du fichier en local dans le chemin configurer dans application.properties ensuite dans le dossier instrumentale
                // le fichier portera le nom générer
                instrumentale.transferTo((new File(apiFilePath + "\\instrumentale\\" + nameInstrumentale)));

                String nameCover = uuid.toString() + getFileExtension(cover);
                cover.transferTo((new File(apiFilePath + "\\cover\\" + nameCover)));
                    instrumentaleDto.setFile(nameInstrumentale);
                    instrumentaleDto.setCover(nameCover);
                    return instrumentaleDto;
            }

        return null;


    }

    public boolean deleteFile(long id) {

        Optional<InstrumentaleDto> instrumentale = this.findById(id);
        try {
            // Récupère le chemin du fichier a supprimer
            Path cheminCover = Paths.get(apiFilePath + "\\cover\\" + instrumentale.get().getCover());
            Path cheminFile = Paths.get(apiFilePath + "\\instrumentale\\" + instrumentale.get().getFile());
            // Supprime le fichier
            Files.delete(cheminCover);
            Files.delete(cheminFile);
            return true;


        } catch (IOException e) {
            System.out.println("La suppression à échoué" + e.getMessage());
            return false;
        }

    }

}



