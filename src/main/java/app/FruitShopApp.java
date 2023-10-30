package app;

import static storages.FruitStorage.fruitQuantity;
import static storages.TransactionStorage.transactionList;

import files.CsvReader;
import files.CsvWriter;
import java.util.HashMap;
import java.util.Map;
import model.DailyReport;
import model.FruitTransaction;
import model.Operation;
import operation.BalanceOperationHandlerImpl;
import operation.OperationHandler;
import operation.OperationStrategyImpl;
import operation.PurchaseOperationHandlerImpl;
import operation.ReturnOperationHandlerImpl;
import operation.SupplyOperationHandlerImpl;

public class FruitShopApp {
    private static final String TEST_DATA_FILE_NAME = "data.csv";
    private static final String TEST_RESULT_FILE_NAME = "result.csv";
    private final CsvWriter writer = new CsvWriter();
    private final CsvReader reader = new CsvReader();
    private final Map<Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();
    private final OperationStrategyImpl operationStrategy =
            new OperationStrategyImpl(operationOperationHandlerMap);

    public void createDailyReport() {
        fillOperationMap();
        reader.readFromFile(TEST_DATA_FILE_NAME);
        performTransactionList();
        DailyReport dailyReport = new DailyReport(fruitQuantity);
        writer.writeIntoFile(TEST_RESULT_FILE_NAME, dailyReport.createReportString());
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
