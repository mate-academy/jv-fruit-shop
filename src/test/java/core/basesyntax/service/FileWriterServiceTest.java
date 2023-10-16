package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.Impl.FileWriterServiceImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileWriterServiceTest {

    private static final String PATH_TO_WRITE = "src/test/resources/database.csv";
    private FileWriterService fileWriter;

    @BeforeEach
    void setUp() {
        fileWriter = new FileWriterServiceImpl();
    }

    @Test
    void write_checkCorrectWriting_ok() {
        String textForTest = "r,banana,20";
        fileWriter.write(textForTest, PATH_TO_WRITE);
        List<String> exceptedData = List.of("r,banana,20");
        List<String> actualData;
        try {
            actualData = Files.readAllLines(new File(PATH_TO_WRITE).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file! ",e);
        }
        assertEquals(exceptedData, actualData);
    }

    @Test
    void write_pathIsNull_notOk() {
        String report = "test";
        String path = null;
        assertThrows(RuntimeException.class, () -> fileWriter.write(report, path));
    }

    @Test
    void write_dataForWriteIsNull_notOk() {
        String dataForWrite = null;
        assertThrows(RuntimeException.class, () -> fileWriter.write(dataForWrite, PATH_TO_WRITE));
    }

    @Test
    public void write_fileException_notOK() {
        String report = "Sample report content";
        String fileName = "sample.txt";
        String filePath = "nonexistentfolder" + File.separator + fileName;
        assertThrows(RuntimeException.class,() -> fileWriter.write(report, filePath));
    }
}