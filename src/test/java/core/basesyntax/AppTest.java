package core.basesyntax;

import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppTest {
    private static final String FILE_FROM_OK = "src/main/resources/shop_activity.csv";
    private static final String FILE_FROM_NOT_OK = "src/main/resources/shopactivity.csv";
    private static final String FILE_TO = "src/main/resources/report.csv";
    private static CsvFileReader reader;
    private static CsvFileWriter writer;

    @BeforeAll
    static void beforeAll() {
        reader = new CsvFileReaderImpl();
        writer = new CsvFileWriterImpl();
    }

    @Test
    void readFromFile_OK() {

    }
}
