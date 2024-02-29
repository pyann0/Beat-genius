package com.example.Beatgenius.business.instrumentale;

import com.example.Beatgenius.generic.GenericService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface InstrumentaleService extends GenericService<InstrumentaleDto> {

    String getFileExtension(MultipartFile file) ;


    //String uploadFile(MultipartFile file, String typeFile) throws IOException;
    InstrumentaleDto uploadInstrumentale(MultipartFile instrumentale, MultipartFile cover, InstrumentaleDto instrumentaleDto) throws IOException;
    boolean deleteFile(long id);
}
