package core.basesyntax.csvservice;

import core.basesyntax.FruitStorageStrategy;
import core.basesyntax.OperationHandler;
import core.basesyntax.Storage;
import core.basesyntax.Transaction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WriterTest {

    @BeforeClass
    public static void fillTheStorage() {
        List<Transaction> transactions = Reader.read("src/main/resources/easyIncome.csv");
        FruitStorageStrategy.initialize();
        OperationHandler.handleOperation(transactions);
    }

    @Test
    public void testWriteWithNormalData() {
        Writer.write("src/main/resources/result1.csv");
        try {
            Set<String> expected = new HashSet<>(Files
                    .readAllLines(Path.of("src/main/resources/expectedEasyIncomeResult.csv")));
            Set<String> actual = new HashSet<>(Files
                    .readAllLines(Path.of("src/main/resources/resultOfEasyIncome.csv")));
            expected.removeAll(actual);
            Assert.assertTrue(expected.isEmpty());
        } catch (IOException ignored) {
        }
    }

    @Test
    public void testWriteWithEmptyFile() {
        Storage.storage = new HashMap<>();
        Writer.write("src/main/resources/onlyHeader.csv");
        try {
            Set<String> expected = new HashSet<>(Files
                    .readAllLines(Path.of("src/main/resources/onlyHeader.csv")));
            Assert.assertEquals(1, expected.size());
        } catch (IOException ignored) {
        }
    }
}
