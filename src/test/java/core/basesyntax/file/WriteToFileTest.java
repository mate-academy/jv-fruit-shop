package core.basesyntax.file;

import static org.junit.Assert.assertTrue;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriteToFileTest {
    private static final String FILE_TO = "src/test/resources/report.csv";
    private static final Fruit BANANA = new Fruit("banana");
    private static final Fruit APPLE = new Fruit("apple");
    private static CsvFileWriter writer;

    @Before
    public void before() {
        writer = new CsvFileWriterImpl();
        Storage.storage.put(BANANA, 50);
        Storage.storage.put(APPLE, 25);
    }

    @Test
    public void writeToFile() {
        writer.writeToFile(FILE_TO, Storage.storage);
        assertTrue(Files.exists(Path.of(FILE_TO)));
    }

    @Test
    public void actualDataInFile() throws IOException {
        writer.writeToFile(FILE_TO, Storage.storage);
        List<String> expected = new ArrayList<>();
        expected.add("fruit,quantity");
        expected.add("banana,50");
        expected.add("apple,25");
        List<String> actualData = Files.readAllLines(Path.of(FILE_TO));
        Assert.assertEquals(expected, actualData);
    }

    @After
    public void afterClass() {
        Storage.storage.clear();
    }
}
