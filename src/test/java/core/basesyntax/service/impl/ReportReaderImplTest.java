package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.ReportReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReportReaderImplTest {

    private static final String FILE_EXIST_PATH = "src/test/resources/data.csv";
    private static final String FILE_DOES_NOT_EXIST_PATH = "src/test/resources/data_not_exist.csv";
    private static final String EMPTY_FILE_PATH = "src/test/resources/empty.csv";
    private static ReportReader reportReader;

    @BeforeEach
    void setUp() {
        reportReader = new ReportReaderImpl();
    }

    @Test
    void readFile_validFile_ok() {
        List<String> actual = reportReader.readFile(FILE_EXIST_PATH);
        List<String> expected = List.of("type,fruit,quantity",
                "b,banana,20",
                "b,apple,100",
                "s,banana,100",
                "p,banana,13",
                "r,apple,10",
                "p,apple,20",
                "p,banana,5",
                "s,banana,50");
        assertEquals(expected, actual);
    }

    @Test
    void readFile_nonExistentFile_notOk() {
        assertThrows(RuntimeException.class,
                () -> reportReader.readFile(FILE_DOES_NOT_EXIST_PATH),
                "Can't find the file with this pathname: src/test/resources/data_not_exist.csv");
    }

    @Test
    void readFile_emptyFile_notOk() {
        List<String> actual = reportReader.readFile(EMPTY_FILE_PATH);
        List<String> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }
}
