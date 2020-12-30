package core.basesyntax;

import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.StoreOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileWriterTest {
    private static FileWriterService outputFileService = new FileWriterServiceImpl();
    private static Storage storage = new Storage();
    public static final String TEST_INPUT_FILE = "src/main/resources/OutputFile.csv";

    @Test
    public void outputFileOkTest() throws IOException {
        Transaction transaction1 = new Transaction("s", "banana", 100,
                LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE));
        Transaction transaction2 = new Transaction("b", "banana", 17,
                LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));
        Transaction transaction3 = new Transaction("r", "banana", 10,
                LocalDate.parse("2020-10-18", DateTimeFormatter.ISO_LOCAL_DATE));
        Transaction transaction4 = new Transaction("s", "orange", 50,
                LocalDate.parse("2020-10-17", DateTimeFormatter.ISO_LOCAL_DATE));

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);

        Map<String, StoreOperation> storeOperationMap = new HashMap<>();
        storeOperationMap.put("s", new SupplyOperation(storage));
        storeOperationMap.put("b", new BuyOperation(storage));
        storeOperationMap.put("r", new ReturnOperation(storage));

        for (Transaction transaction : transactions) {
            storeOperationMap.get(transaction.getOperation()).performOperation(transaction);
        }

        Map<String, Integer> fruitsQuantity = storage.getFruitsQuantityByType();
        StringBuilder result = new StringBuilder();
        result.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry: fruitsQuantity.entrySet()) {
            result.append("\n").append(entry.getKey()).append(",").append(entry.getValue());
        }

        outputFileService.writeToFile(TEST_INPUT_FILE, result.toString());

        List<String> expected = Files.readAllLines(Paths.get("src/main/resources/testInput.csv"));
        List<String> actual = Files.readAllLines(Paths.get("src/main/resources/OutputFile.csv"));
        Assert.assertEquals(expected, actual);
    }

    @Test (expected = RuntimeException.class)
    public void outputFileFailTest() {
        outputFileService.writeToFile("someF/ ile", "some text");
    }
}
