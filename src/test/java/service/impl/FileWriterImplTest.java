package service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileWriterImplTest {

    private Path filePath;

    @BeforeEach
    void setUp() throws IOException {
        filePath = Files.createTempFile("reportToRead", ".csv");
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(filePath);
    }

    @Test
    void writeToFile_ok() throws IOException {
        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.write(filePath.toString(), "fruit,quantity\napple,20\n");

        String result = Files.readString(filePath);
        assertEquals("fruit,quantity\napple,20\n", result);
    }
}
