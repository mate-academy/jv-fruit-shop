package core.basesyntax.app;

import static core.basesyntax.storages.TransactionStorage.transactionList;

import core.basesyntax.files.FileReader;
import core.basesyntax.files.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operation.BalanceOperationHandlerImpl;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.PurchaseOperationHandlerImpl;
import core.basesyntax.operation.ReturnOperationHandlerImpl;
import core.basesyntax.operation.SupplyOperationHandlerImpl;
import core.basesyntax.parsers.DataParser;
import core.basesyntax.reporter.Reporter;

public class FruitShopApp {
    private static final String TEST_DATA_FILE_NAME = "data.csv";
    private static final String TEST_RESULT_FILE_NAME = "result.csv";
    private final Map<Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();
    private final FileWriter fileWriter;
    private final FileReader fileReader;
    private final Reporter reporter;
    private final DataParser<String> dataParser;
    private final OperationStrategy operationStrategy =
            new OperationStrategyImpl(operationOperationHandlerMap);

    public FruitShopApp(FileWriter fileWriter, FileReader fileReader,
                        Reporter reporter, DataParser<String> dataParser) {
        this.fileWriter = fileWriter;
        this.fileReader = fileReader;
        this.reporter = reporter;
        this.dataParser = dataParser;
    }

    public void createDailyReport() {
        fillOperationMap();
        List<String> strings = fileReader.readFromFile(TEST_DATA_FILE_NAME);
        dataParser.parseData(strings);
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
