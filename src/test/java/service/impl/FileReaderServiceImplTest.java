package service.impl;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.*;

import java.io.*;
import java.util.*;

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
}