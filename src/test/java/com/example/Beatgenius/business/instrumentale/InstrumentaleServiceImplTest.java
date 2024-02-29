package com.example.Beatgenius.business.instrumentale;

import com.example.Beatgenius.business.catalogue.Catalogue;
import com.example.Beatgenius.business.userSecurity.models.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InstrumentaleServiceImplTest {

    @Mock
    MultipartFile mockMultipartFile;

    @Mock
    MultipartFile coverMock;
    @Mock
    MultipartFile fileMock;

    InstrumentaleDto instrumentaleDto;
    @Mock
    InstrumentaleRepository instrumentaleRepository;

    @Mock
    InstrumentaleMapper instrumentaleMapper;


    InstrumentaleService instrumentaleService;

    @BeforeEach
    void beforeEach() throws Exception {
        instrumentaleService = new InstrumentaleServiceImpl(instrumentaleRepository, instrumentaleMapper, "Text");
    }



    @Test
    void getFileExtension() {
        //Arrange
        String fileName = "test.mp3";
        when(mockMultipartFile.getOriginalFilename()).thenReturn(fileName);

        //Act
        String result = instrumentaleService.getFileExtension(mockMultipartFile);

        //Assert
        assertEquals(result, ".mp3");
        assertNotEquals(result, ".mp2");

    }
    @Test
    void getFileExtensionWhenNotExtention() {
        //Arrange
        String fileName = "test";
        when(mockMultipartFile.getOriginalFilename()).thenReturn(fileName);

        //Act
        String result = instrumentaleService.getFileExtension(mockMultipartFile);

        //Assert
        assertNull(result);

    }
    @Test
    void getFileExtensionWhenIsNull() {
        //Arrange
        String fileName = null;
        when(mockMultipartFile.getOriginalFilename()).thenReturn(fileName);

        //Act
        String result = instrumentaleService.getFileExtension(mockMultipartFile);

        //Assert
        assertNull(result);

    }
    @Test
    void getFileExtensionWhenStringEmpty() {
        //Arrange
        String fileName = "";
        when(mockMultipartFile.getOriginalFilename()).thenReturn(fileName);

        //Act
        String result = instrumentaleService.getFileExtension(mockMultipartFile);

        //Assert
        assertNull(result);

    }

    @Test
    @DisplayName("uploadInstrumentale: cover Correct Type And file Correct Type")
    void uploadInstrumentale_coverCorrectType_fileCorrectType() throws IOException {
        // Arrange
        instrumentaleDto = new InstrumentaleDto(1, 0, "Instrumentale Nom", 1,1, null, null);
        when(coverMock.getOriginalFilename()).thenReturn("cover.png");
        when(fileMock.getOriginalFilename()).thenReturn("instrumentale.mp3");
        // Act
        InstrumentaleDto dto = instrumentaleService.uploadInstrumentale(fileMock, coverMock, instrumentaleDto);
        // Assert
        assertNotNull(dto.getFile());
        assertNotNull(dto.getCover());
    }
    @Test
    @DisplayName("uploadInstrumentale: cover Incorrect Type And file Correct Type")
    void uploadInstrumentale_coverInCorrectType_fileCorrectType() throws IOException {
        // Arrange
        instrumentaleDto = new InstrumentaleDto(1, 0, "Instrumentale Nom", 1,1, null, null);
        when(coverMock.getOriginalFilename()).thenReturn("cover.mp3");
        when(fileMock.getOriginalFilename()).thenReturn("instrumentale.mp3");
        // Act
        InstrumentaleDto dto = instrumentaleService.uploadInstrumentale(fileMock, coverMock, instrumentaleDto);
        // Assert
        assertNull(dto);
    }

    @Test
    @DisplayName("uploadInstrumentale: cover Correct Type And file IncorrectType")
    void uploadInstrumentale_coverCorrectType_fileIncorrectType() throws IOException {
        // Arrange
        instrumentaleDto = new InstrumentaleDto(1, 0, "Instrumentale Nom", 1,1, null, null);
        when(fileMock.getOriginalFilename()).thenReturn("instrumentale.mp4");
       // when(coverMock.getOriginalFilename()).thenReturn("cover.png");
        // Act
        InstrumentaleDto dto = instrumentaleService.uploadInstrumentale(fileMock, coverMock, instrumentaleDto);
        // Assert
        assertNull(dto);
    }

    @Test
    @DisplayName("uploadInstrumentale: cover No Extension And file Correct Type")
    void uploadInstrumentale_coverNoExtension_fileCorrectType() throws IOException {
        // Arrange
        instrumentaleDto = new InstrumentaleDto(1, 0, "Instrumentale Nom", 1,1, null, null);
        when(coverMock.getOriginalFilename()).thenReturn("cover");
        when(fileMock.getOriginalFilename()).thenReturn("instrumentale.mp3");
        // Act
        InstrumentaleDto dto = instrumentaleService.uploadInstrumentale(fileMock, coverMock, instrumentaleDto);
        // Assert
        assertNull(dto);
    }

    @Test
    @DisplayName("uploadInstrumentale: cover No Extension And file Correct Type")
    void uploadInstrumentale_coverCorrectType_fileNoExtension() throws IOException {
        // Arrange
        instrumentaleDto = new InstrumentaleDto(1, 0, "Instrumentale Nom", 1,1, null, null);
        //when(coverMock.getOriginalFilename()).thenReturn("cover.png");
        when(fileMock.getOriginalFilename()).thenReturn("instrumentale");
        // Act
        InstrumentaleDto dto = instrumentaleService.uploadInstrumentale(fileMock, coverMock, instrumentaleDto);
        // Assert
        assertNull(dto);
    }





}