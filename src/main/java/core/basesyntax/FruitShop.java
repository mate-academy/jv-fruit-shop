package core.basesyntax;

import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.DataProcessorService;
import core.basesyntax.services.FileReaderService;
import core.basesyntax.services.FileWriterService;
import core.basesyntax.services.OperationProcessor;
import core.basesyntax.services.ReportCreatorService;
import core.basesyntax.services.impl.DataProcessorServiceImpl;
import core.basesyntax.services.impl.FileReaderServiceImpl;
import core.basesyntax.services.impl.FileWriterServiceImpl;
import core.basesyntax.services.impl.OperationProcessorImpl;
import core.basesyntax.services.impl.ReportCreatorServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String INPUT_FILE_PATH = "src/main/java/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/java/resources/output.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.readFromFile(INPUT_FILE_PATH);
        DataProcessorService dataProcessorService = new DataProcessorServiceImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationMap = getOperationOperationMap();

        OperationProcessor operationService = new OperationProcessorImpl(operationMap);
        List<FruitTransaction> fruitTransactionList = dataProcessorService.processInputData(lines);
        operationService.manageTransactions(fruitTransactionList);

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        String report = reportCreatorService.createReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_FILE_PATH, report);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> getOperationOperationMap() {
        Map<FruitTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        return operationMap;

    }
}