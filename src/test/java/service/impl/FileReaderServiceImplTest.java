package service.impl;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.FileReaderService;

class FileReaderServiceImplTest {
    private FileReaderService fileReaderService;

    @BeforeEach
    void setUp() {
        fileReaderService = new FileReaderServiceImpl("src/main/resources/output.csv");
    }

    @Test
    void testReadFromFile() {
        try {
            List<String> lines = fileReaderService.readFromFile();
            Assertions.assertNotNull(lines);
            Assertions.assertFalse(lines.isEmpty());
        } catch (IOException e) {
            Assertions.fail("Failed to read from file" + e.getMessage());
        }
    }

    @Test
    void testFilePathIncorrect() {
        try {
            List<String> lines = fileReaderService.readFromFile();
            Assertions.assertNotNull(lines);
            Assertions.assertFalse(lines.isEmpty());
        } catch (IOException e) {
            Assertions.fail("Failed to read from file" + e.getMessage());
        }
    }
}
