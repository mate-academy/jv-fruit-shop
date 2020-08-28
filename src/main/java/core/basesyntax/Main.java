package core.basesyntax;

import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.StoreOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.service.ConverterCsvToTransaction;
import core.basesyntax.service.InputFileService;
import core.basesyntax.service.impl.InputFileServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InputFileService fileService = new InputFileServiceImpl();
        List<List<String>> fileStrings = fileService.readFile("src/main/resources/testOK.csv");

        ConverterCsvToTransaction converter = new ConverterCsvToTransaction();
        List<Transaction> transactions = new ArrayList<>();
        for (List<String> data : fileStrings) {
            Transaction transaction = converter.convert(data);
            transactions.add(transaction);
        }

        Storage storage = new Storage();
        Map<String, StoreOperation> storeOperationMap = new HashMap<>();
        storeOperationMap.put("s", new SupplyOperation(storage));
        storeOperationMap.put("b", new BuyOperation(storage));
        storeOperationMap.put("r", new ReturnOperation(storage));

        for (Transaction transaction : transactions) {
            storeOperationMap.get(transaction.getOperation()).performOperation(transaction);
        }
    }
}
