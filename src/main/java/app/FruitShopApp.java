package app;

import files.CsvReader;
import files.CsvWriter;
import model.DailyReport;
import model.FruitTransaction;
import model.Operation;
import operation.BalanceOperationHandlerImpl;
import operation.SupplyOperationHandlerImpl;
import operation.PurchaseOperationHandlerImpl;
import operation.ReturnOperationHandlerImpl;
import operation.OperationStrategyImpl;
import operation.OperationHandler;
import java.util.HashMap;
import java.util.Map;

import static storages.FruitStorage.fruitQuantity;
import static storages.TransactionStorage.transactionList;

public class FruitShopApp {
    private static final String TEST_DATA_FILE_NAME = "data.csv";
    private static final String TEST_RESULT_FILE_NAME = "result.csv";
    private final CsvWriter writer = new CsvWriter();
    private final CsvReader reader = new CsvReader(transactionList);
    private final Map<Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();
    private final OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationOperationHandlerMap);

    public void createDailyReport(){
        fillOperationMap();
        reader.readFromFile(TEST_DATA_FILE_NAME);
        for (FruitTransaction transaction : transactionList) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.perform(transaction);
        }
        DailyReport dailyReport = new DailyReport(fruitQuantity);
        String reportString = dailyReport.createReportString();
        writer.writeIntoFile(TEST_RESULT_FILE_NAME, reportString);
    }

    public void fillOperationMap() {
        operationOperationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandlerImpl());
        operationOperationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandlerImpl());
        operationOperationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        operationOperationHandlerMap.put(Operation.RETURN, new ReturnOperationHandlerImpl());
    }
}
