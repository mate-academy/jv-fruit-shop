package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileReaderServiceImplTest {
    private static FileReaderService fileReaderService;
    private static String testFileOk;
    private static String nonexistentFile;

    @BeforeAll
    public static void setUp() {
        fileReaderService = new FileReaderServiceImpl();
        testFileOk = "test1.csv";
        nonexistentFile = "nonexistentFile.csv";
    }

    @Test
    public void getDataFromFile_Ok() {
        List<String> expected = getDataFromFile(testFileOk);
        List<String> actual = fileReaderService.getDataFromFile(testFileOk);
        assertEquals(expected, actual);
    }

    @Test
    public void getDataFromFile_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            List<String> actual = fileReaderService.getDataFromFile(nonexistentFile);
        });
    }

    private String readFromFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + fileName, e);
        }
    }

    private List<String> getDataFromFile(String filePath) {
        String[] strings = readFromFile(filePath).split(System.lineSeparator());
        String[] updatedData = new String[strings.length - 1];
        for (int i = 0; i < updatedData.length; i++) {
            updatedData[i] = strings[i + 1];
        }
        return Arrays.asList(updatedData);
    }
}
