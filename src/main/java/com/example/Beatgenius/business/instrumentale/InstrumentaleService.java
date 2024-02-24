package com.example.Beatgenius.business.instrumentale;

import com.example.Beatgenius.generic.GenericService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface InstrumentaleService extends GenericService<InstrumentaleDto> {

    String getFileExtension(MultipartFile file) ;


    String uploadFile(MultipartFile file, String typeFile) throws IOException;
}
