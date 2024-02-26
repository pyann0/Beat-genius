package com.example.Beatgenius.business.instrumentale;

import com.example.Beatgenius.generic.AbstractGenericRestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/instrumentales")
public class InstrumentaleRestController extends AbstractGenericRestController<InstrumentaleDto, InstrumentaleService> {
    public InstrumentaleRestController(InstrumentaleService service) {
        super(service);
    }
    @Autowired
    private ObjectMapper objectMapper;





    @PostMapping("save")
    //Modifier nom de la methode pour saveOrUpdate
    // Simplifier le code
    protected ResponseEntity<InstrumentaleDto> save(@RequestPart("cover") MultipartFile cover, @RequestPart("file") MultipartFile file, @RequestParam("instrumentale") String instrumentaleJson) throws IOException {
        InstrumentaleDto instrumentaleDto =objectMapper.readValue(instrumentaleJson, InstrumentaleDto.class);
        List<String> fileDetail = service.uploadInstrumentale(file, cover);
        if (fileDetail.get(0) != null && fileDetail.get(1)!=null){
            instrumentaleDto.setFile(fileDetail.get(0));
            instrumentaleDto.setCover(fileDetail.get(1));
            System.out.println(instrumentaleDto.getFile());
            System.out.println(instrumentaleDto.getCover());
            return super.saveOrUpdate(instrumentaleDto);
        } else {
            return null;
        }


    }

    @Override
    @DeleteMapping("{id}")
    protected void deleteById(@PathVariable long id) {
        if (service.deleteFile(id)) {
            service.deleteById(id);
        }


    }
}
