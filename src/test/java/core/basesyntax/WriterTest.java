package core.basesyntax;

import core.basesyntax.dto.FruitDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitStorage;
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
    private Writer writer = new Writer();

    @BeforeClass
    public static void beforeClass() {
        Reader reader = new Reader();
        OperationHandler operationHandler = new OperationHandler();
        List<FruitDto> transactions = reader.readFromFile("src/CsvFolder/inputNormal1.csv");
        operationHandler.handleOperation(transactions);
    }

    @Test
    public void normalWrite() throws IOException {
        writer.write("src/CsvFolder/result1.csv");
        List<String> expected = Files
                .readAllLines(Path.of("src/CsvFolder/expectedResultFromWriterTest.csv"));
        List<String> actual = Files
                .readAllLines(Path.of("src/CsvFolder/result1.csv"));
        expected.removeAll(actual);
        Assert.assertTrue(expected.isEmpty());
    }

    @Test
    public void writeFromEmptyStorageTest() throws IOException {
        FruitStorage.getFruitStorage().clear();
        writer.write("src/CsvFolder/onlyHeader.csv");
        List<String> actual = Files
                .readAllLines(Path.of("src/CsvFolder/onlyHeader.csv"));
        Assert.assertEquals(1, actual.size());
    }
}
