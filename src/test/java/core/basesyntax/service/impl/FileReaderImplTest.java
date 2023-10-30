package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderImplTest {
    String INPUT_FILE_NAME = "src/main/resources/fruits.csv";


    @Test
    void isFileReader_Ok() {
        FileReader fileReader = new FileReaderImpl();
        List<String> strings = fileReader.readFile(INPUT_FILE_NAME);
        assertNotNull(strings.size());
        assertThrows(RuntimeException.class,() -> fileReader.readFile(""));
    }
}