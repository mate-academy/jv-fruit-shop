package service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.FileReader;

class FileReaderImplTest {
    private FileReader fileReader;
    private Path filePath;

    @BeforeEach
    void setUp() throws IOException {
        fileReader = new FileReaderImpl();
        filePath = Files.createTempFile("reportToRead", ".csv");
        Files.write(filePath, List.of("type,fruit,quantity", "b,banana,20", "b,apple,100"));
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(filePath);
    }

    @Test
    void read_validFile_success() {
        List<String> list = fileReader.read(filePath.toString());

        assertEquals(3, list.size());
        assertEquals("type,fruit,quantity", list.get(0));
        assertEquals("b,banana,20", list.get(1));
        assertEquals("b,apple,100", list.get(2));
    }

    @Test
    void read_inValidFile_success_Failure() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> fileReader.read("reportToRead.csv"));

        assertTrue(exception.getMessage().contains("Can`t read file"));
    }
}
