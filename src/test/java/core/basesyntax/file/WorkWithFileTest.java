package core.basesyntax.file;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Before;
import org.junit.Test;

public class WorkWithFileTest {
    private static final String FILE_FROM_OK = "src/test/resources/shop_activity_test.csv";
    private static final String FILE_FROM_NOT_OK = "src/main/resources/shop_activitytest.csv";
    private static final String FILE_TO = "src/test/resources/report.csv";
    private static final Fruit BANANA = new Fruit("banana");
    private static final Fruit APPLE = new Fruit("apple");

    private static CsvFileReader reader;
    private static CsvFileWriter writer;

    @Before
    public void before() {
        reader = new CsvFileReaderImpl();
        writer = new CsvFileWriterImpl();
    }

    @Test
    public void readFromFile_OK() {
        assertNotNull(reader.readFromFile(FILE_FROM_OK));
    }

    @Test(expected = RuntimeException.class)
    public void readFromFile_NotOK() {
        reader.readFromFile(FILE_FROM_NOT_OK);
    }

    @Test
    public void writeToFile() {
        writer.writeToFile(FILE_TO, Storage.storage);
        assertTrue(Files.exists(Path.of(FILE_TO)));
    }
}
