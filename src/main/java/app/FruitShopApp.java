package app;

import static storages.TransactionStorage.transactionList;

import files.CsvReader;
import files.CsvWriter;
import java.util.HashMap;
import java.util.Map;
import files.Reader;
import files.Writer;
import model.FruitTransaction;
import model.Operation;
import operation.BalanceOperationHandlerImpl;
import operation.OperationHandler;
import operation.OperationStrategyImpl;
import operation.PurchaseOperationHandlerImpl;
import operation.ReturnOperationHandlerImpl;
import operation.SupplyOperationHandlerImpl;
import reporter.FruitReporterImpl;
import reporter.Reporter;

public class FruitShopApp {
    private static final String TEST_DATA_FILE_NAME = "data.csv";
    private static final String TEST_RESULT_FILE_NAME = "result.csv";
    private final Writer writer = new CsvWriter();
    private final Reader reader = new CsvReader();
    private final Reporter reporter = new FruitReporterImpl();
    private final Map<Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();
    private final OperationStrategyImpl operationStrategy =
            new OperationStrategyImpl(operationOperationHandlerMap);

    public void createDailyReport() {
        fillOperationMap();
        reader.readFromFile(TEST_DATA_FILE_NAME);
        performTransactionList();
        writer.writeIntoFile(TEST_RESULT_FILE_NAME, reporter.createReport());
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
