package core.basesyntax;

import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplyOperationHandler;
import core.basesyntax.impl.DataProcessorServiceImpl;
import core.basesyntax.impl.FileReaderServiceImpl;
import core.basesyntax.impl.FileWriterServiceImpl;
import core.basesyntax.impl.OperationProcessorImpl;
import core.basesyntax.impl.ReportCreatorServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.DataProcessorService;
import core.basesyntax.services.FileReaderService;
import core.basesyntax.services.FileWriterService;
import core.basesyntax.services.OperationProcessor;
import core.basesyntax.services.ReportCreatorService;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
