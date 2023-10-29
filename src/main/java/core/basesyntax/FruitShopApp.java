package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import core.basesyntax.services.ParseDataService;
import core.basesyntax.services.ProccessingDataService;
import core.basesyntax.services.ReaderService;
import core.basesyntax.services.TransactionService;
import core.basesyntax.services.WriterService;
import core.basesyntax.services.impl.ParseDataServiceImpl;
import core.basesyntax.services.impl.ProccessingDataServiceImpl;
import core.basesyntax.services.impl.ReaderServiceImpl;
import core.basesyntax.services.impl.TransactionServiceImpl;
import core.basesyntax.services.impl.WriterServiceImpl;
import core.basesyntax.strategy.operations.OperationHandler;
import core.basesyntax.strategy.operations.impl.BalanceOperationHandler;
import core.basesyntax.strategy.operations.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.operations.impl.ReturnOperationHandler;
import core.basesyntax.strategy.operations.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopApp {
    private static final String INPUT_FILEPATH
            = "src/main/java/core/basesyntax/resources/input.csv";
    private static final String OUTPUT_FILEPATH
            = "src/main/java/core/basesyntax/resources/output.csv";

    public static void main(String[] args) {
        Map<Transaction.Operation, OperationHandler> operationsMap = new HashMap<>();
        operationsMap.put(Transaction.Operation.RETURN, new ReturnOperationHandler());
        operationsMap.put(Transaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationsMap.put(Transaction.Operation.BALANCE, new BalanceOperationHandler());
        operationsMap.put(Transaction.Operation.PURCHASE, new PurchaseOperationHandler());

        // Read from file
        ReaderService fileReader = new ReaderServiceImpl();
        final List<String> listData = fileReader.readFromFile(INPUT_FILEPATH);

        // Convert data from file to java Transaction object
        ParseDataService parser = new ParseDataServiceImpl();
        final List<Transaction> parsedData = parser.parse(listData);

        // Process java object
        ProccessingDataService proccessDataService = new ProccessingDataServiceImpl(operationsMap);
        proccessDataService.process(parsedData);

        // Create report
        TransactionService transactionService = new TransactionServiceImpl();
        String report = transactionService.createReport(Storage.REPORT);

        // Write report to file
        WriterService ws = new WriterServiceImpl();
        ws.writeToFile(OUTPUT_FILEPATH, report);
    }
}
