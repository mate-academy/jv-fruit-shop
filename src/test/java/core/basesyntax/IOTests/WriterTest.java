package core.basesyntax.IOTests;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.iooperations.OperationHandler;
import core.basesyntax.service.iooperations.Reader;
import core.basesyntax.service.iooperations.Writer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriterTest {

    @BeforeClass
    public static void beforeClass() {
        List<FruitDto> transactions = Reader.readFromFile("src/CsvFolder/inputNormal1.csv");
        OperationHandler.handleOperation(transactions);
    }

    @Test
    public void normalWrite() throws IOException {
        Writer.write("src/CsvFolder/result1.csv");
        List<String> expected = Files
                .readAllLines(Path.of("src/CsvFolder/expectedResultFromWriterTest.csv"));
        List<String> actual = Files
                .readAllLines(Path.of("src/CsvFolder/result1.csv"));
        expected.removeAll(actual);
        Assert.assertTrue(expected.isEmpty());
    }

    @Test
    public void writeFromEmptyStorageTest() throws IOException {
        Fruit.getFruitStorage().clear();
        Writer.write("src/CsvFolder/onlyHeader.csv");
        List<String> actual = Files
                .readAllLines(Path.of("src/CsvFolder/onlyHeader.csv"));
        Assert.assertEquals(1, actual.size());
    }
}
