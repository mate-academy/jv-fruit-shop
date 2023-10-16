package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.impl.FileReaderServiceImpl;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileReaderServiceTest {

    private static final String FILE_PATH = "src/test/resources/database.csv";
    private FileReaderService reader;

    @BeforeEach
    void setUp() {
        reader = new FileReaderServiceImpl();
    }

    @Test
    void read_correctPath_ok() {
        List<String> actualData = reader.read(FILE_PATH);
        List<String> exceptedData = List.of("b,banana,20",
                "b,apple,100",
                "s,banana,100",
                "p,banana,13",
                "r,apple,10",
                "p,apple,20",
                "p,banana,5",
                "s,banana,50");
        assertEquals(exceptedData, actualData);
    }

    @Test
    void read_incorrectPath_notOK() {
        String incorrectPath = "incorrectPath";
        assertThrows(RuntimeException.class, () -> reader.read(incorrectPath));
    }

    @Test
    void read_pathIsNull_notOk() {
        String nullPath = null;
        assertThrows(RuntimeException.class, () -> reader.read(nullPath));
    }
}
