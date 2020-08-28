package core.basesyntax;

import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.StoreOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.service.ConverterCsvToTransaction;
import core.basesyntax.service.InputFileService;
import core.basesyntax.service.OutputFileService;
import core.basesyntax.service.impl.InputFileServiceImpl;
import core.basesyntax.service.impl.OutputFileServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputFileServiceTest {
    private static OutputFileService outputFileService = new OutputFileServiceImpl();
    private static Storage storage = new Storage();
    public static final String TEST_INPUT_FILE = "src/main/resources/testInput.csv";

    @Test
    public void outputFileOkTest() {
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

        outputFileService.writeToFile(TEST_INPUT_FILE, storage.getFruitsQuantity());
    }
}
