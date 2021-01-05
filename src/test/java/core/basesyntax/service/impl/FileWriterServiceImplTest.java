package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileWriterServiceImplTest {
    private static FileWriterService fileWriterService;
    private static String correctFilePath;
    private static String nonexistentFilePath;
    private static String message;

    @BeforeAll
    public static void setUp() {
        fileWriterService = new FileWriterServiceImpl();
        correctFilePath = "result1.csv";
        nonexistentFilePath = "";
        message = "some message";
    }

    @Test
    public void writeToFile_Ok() {
        String expected = readFromFile(correctFilePath);
        fileWriterService.writeToFile(correctFilePath, expected);
        String actual = readFromFile(correctFilePath);
        assertEquals(expected, actual);
    }

    @Test
    public void writeToFile_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            fileWriterService.writeToFile(nonexistentFilePath, message);
        });
    }

    private String readFromFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + fileName, e);
        }
    }
}
