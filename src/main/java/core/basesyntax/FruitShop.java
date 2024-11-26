package core.basesyntax;

import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.SupplyOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.services.impl.DataProcessorServiceImpl;
import core.basesyntax.services.impl.FileReaderServiceImpl;
import core.basesyntax.services.impl.FileWriterServiceImpl;
import core.basesyntax.services.impl.OperationProcessorImpl;
import core.basesyntax.services.impl.ReportCreatorServiceImpl;
import core.basesyntax.services.*;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShop {
    public static final String INPUT_FILE_PATH = "src/main/java/resources/input.csv";
    public static final String OUTPUT_FILE_PATH = "src/main/java/resources/output.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.readFromFile(INPUT_FILE_PATH);
        DataProcessorService dataProcessorService = new DataProcessorServiceImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        OperationProcessor operationService = new OperationProcessorImpl(operationMap);
        List<FruitTransaction> fruitTransactionList = dataProcessorService.processInputData(lines);
        operationService.manageTransactions(fruitTransactionList);

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        String report = reportCreatorService.createReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_FILE_PATH, report);
    }
    // HINT: In the `public static void main(String[] args)` it is better to create instances of your classes, 
    // and call their methods, but do not write any business logic in the `main` method!
}
