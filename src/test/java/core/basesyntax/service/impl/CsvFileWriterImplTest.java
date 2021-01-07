package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileWriterImplTest {
    private static CsvFileWriter csvFileWriter;

    @BeforeClass
    public static void beforeClass() {
        csvFileWriter = new CsvFileWriterImpl();
    }

    @Test(expected = RuntimeException.class)
    public void incorrectFilePath_notOk() {
        String filePath = "";
        csvFileWriter.writeData(filePath);
    }

    @Test
    public void writeFileTest() {
        Storage.fruitsMap.put(new Fruit("banana"), 70);
        Storage.fruitsMap.put(new Fruit("apple"), 30);
        csvFileWriter.writeData("src/test/resources/test-writer.csv");
        List<String> expected = List.of("fruit,quantity", "banana,70", "apple,30");
        List<String> actually = readFile("src/test/resources/test-writer.csv");
        Assert.assertEquals(expected, actually);
    }

    private List<String> readFile(String filePath) {
        List<String> read;
        try {
            read = Files.readAllLines(new File(filePath).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return read;
    }
}
