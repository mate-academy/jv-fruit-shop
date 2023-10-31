package app;

import static storages.TransactionStorage.transactionList;

import files.FIleReader;
import files.FileWriter;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import operation.*;
import reporter.Reporter;

public class FruitShopApp {
    private static final String TEST_DATA_FILE_NAME = "data.csv";
    private static final String TEST_RESULT_FILE_NAME = "result.csv";
    private final Map<Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();
    private final FileWriter fileWriter;
    private final FIleReader FIleReader;
    private final Reporter reporter;
    private final OperationStrategy operationStrategy =
            new OperationStrategyImpl(operationOperationHandlerMap);

    public FruitShopApp(FileWriter fileWriter, FIleReader FIleReader, Reporter reporter) {
        this.fileWriter = fileWriter;
        this.FIleReader = FIleReader;
        this.reporter = reporter;
    }

    public void createDailyReport() {
        fillOperationMap();
        FIleReader.readFromFile(TEST_DATA_FILE_NAME);
        performTransactionList();
        fileWriter.writeIntoFile(TEST_RESULT_FILE_NAME, reporter.createReport());
    }

    private void fillOperationMap() {
        operationOperationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandlerImpl());
        operationOperationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandlerImpl());
        operationOperationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        operationOperationHandlerMap.put(Operation.RETURN, new ReturnOperationHandlerImpl());
    }

    private void performTransactionList() {
        for (FruitTransaction transaction : transactionList) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.perform(transaction);
        }
    }
}
