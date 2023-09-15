package core.basesyntax;

import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplyOperationHandler;
import core.basesyntax.impl.*;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.*;
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

        Map<FruitTransaction.Operation , OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY , new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE , new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN , new ReturnOperationHandler());

        OperationProcessor operationProcessor = new OperationProcessorImpl(operationHandlerMap);
        List<FruitTransaction> fruitTransactionList = dataProcessorService.processInputData(lines);
        operationProcessor.manageTransactions(fruitTransactionList);

        ReportProcessor reportProcessor = new ReportProcessorImpl();
        String report = reportProcessor.createReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_FILE_PATH , report);


    }
}
