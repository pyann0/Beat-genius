package com.example.Beatgenius.business.instrumentale;

import com.example.Beatgenius.generic.AbstractGenericRestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
        instrumentaleDto.setCover(service.uploadFile(cover, "cover"));
        instrumentaleDto.setFile(service.uploadFile(file, "instrumentale"));
        return super.saveOrUpdate(instrumentaleDto);
    }
}
