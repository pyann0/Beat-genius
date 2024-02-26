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


    public String uploadFile(MultipartFile file, String typeFile) throws IOException {
        UUID uuid = UUID.randomUUID();
        String nameFile = uuid.toString() + getFileExtension(file);
        file.transferTo((new File(apiFilePath + "\\" + typeFile + "\\" + nameFile)));
        return nameFile;

    }
    public List<String> uploadInstrumentale(MultipartFile instrumentale, MultipartFile cover) throws IOException {
        UUID uuid = UUID.randomUUID();
        List<String> fileDetail = new ArrayList<>();

        if (Objects.equals(getFileExtension(instrumentale), ".mp3") || Objects.equals(getFileExtension(instrumentale), ".wav")){
            if (Objects.equals(getFileExtension(cover), ".png") || Objects.equals(getFileExtension(cover), ".jpeg") || Objects.equals(getFileExtension(cover), ".jpg")){
                String nameInstrumentale = uuid.toString() + getFileExtension(instrumentale);
                instrumentale.transferTo((new File(apiFilePath + "\\instrumentale\\" + nameInstrumentale)));
                fileDetail.add(nameInstrumentale);

                String nameCover = uuid.toString() + getFileExtension(cover);
                cover.transferTo((new File(apiFilePath + "\\cover\\" + nameCover)));
                fileDetail.add(nameCover);
            }


        }
        return fileDetail;

    }

    public boolean deleteFile(long id) {

        Optional<InstrumentaleDto> instrumentale = this.findById(id);
        try {
            Path cheminCover = Paths.get(apiFilePath + "\\cover\\" + instrumentale.get().getCover());
            Path cheminFile = Paths.get(apiFilePath + "\\instrumentale\\" + instrumentale.get().getFile());
            System.out.println(cheminCover);
            System.out.println(cheminFile);
            Files.delete(cheminCover);
            Files.delete(cheminFile);
            System.out.println("La suppression est réussi");
            return true;


        } catch (IOException e) {
            System.out.println("La suppression à échoué" + e.getMessage());
            return false;
        }

    }

}



