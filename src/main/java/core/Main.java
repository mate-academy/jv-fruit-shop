package core;

import core.operations.BalanceOperation;
import core.operations.Operation;
import core.operations.PurchaseOperation;
import core.operations.ReturnOperation;
import core.operations.SupplyOperation;
import core.service.ParserServiceImpl;
import core.service.ReaderServiceImpl;
import core.service.ReportServiceImpl;
import core.service.WriterService;
import core.service.WriterServiceImpl;
import core.storage.Storage;
import core.storage.StorageImpl;
import core.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FROM_FILE_NAME = "src/main/resources/operations.csv";
    private static final String WRITE_TO_FILE_NAME = "src/main/resources/report.csv";
    private static Map<FruitTransaction.Activity, Operation> activityOperationMap;

    public static void main(String[] args) {
        Storage storage = new StorageImpl();
        activityOperationMap = createHashMap(storage);
        List<String> dataFromFile = new ReaderServiceImpl().readFromFile(READ_FROM_FILE_NAME);
        List<FruitTransaction> fruitTransactions = new ParserServiceImpl().parse(dataFromFile);
        performOperations(fruitTransactions);
        String report = new ReportServiceImpl().create(storage.getAllData());
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(WRITE_TO_FILE_NAME, report);
    }

    private static Map<FruitTransaction.Activity, Operation> createHashMap(Storage storage) {
        Map<FruitTransaction.Activity, Operation> activityOperationMap = new HashMap<>();
        activityOperationMap.put(FruitTransaction.Activity.BALANCE,
                new BalanceOperation(storage));
        activityOperationMap.put(FruitTransaction.Activity.PURCHASE,
                new PurchaseOperation(storage));
        activityOperationMap.put(FruitTransaction.Activity.RETURN,
                new ReturnOperation(storage));
        activityOperationMap.put(FruitTransaction.Activity.SUPPLY,
                new SupplyOperation(storage));
        return activityOperationMap;
    }

    private static void performOperations(List<FruitTransaction> fruitTransactions) {
        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(activityOperationMap);
        fruitTransactions.forEach(fruitTransaction ->
                operationStrategy
                .get(fruitTransaction.getActivity())
                .performOperation(fruitTransaction));
    }
}
