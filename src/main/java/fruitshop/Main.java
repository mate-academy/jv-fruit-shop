package fruitshop;

import fruitshop.model.FruitTransaction;
import fruitshop.sevice.DataProcessorService;
import fruitshop.sevice.FileReaderService;
import fruitshop.sevice.FileWriterService;
import fruitshop.sevice.OperationProcessor;
import fruitshop.sevice.impl.DataProcessorServiceImpl;
import fruitshop.sevice.impl.FileReaderSeviceImpl;
import fruitshop.sevice.impl.FileWriterServiceImpl;
import fruitshop.sevice.impl.OperationProcessorImpl;
import fruitshop.sevice.impl.ReportProcessorImpl;
import fruitshop.strategy.OperationHandler;
import fruitshop.strategy.handlers.BalanceOperationHandler;
import fruitshop.strategy.handlers.PurchaseOperationHandler;
import fruitshop.strategy.handlers.ReturnOperationHandler;
import fruitshop.strategy.handlers.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/resources/input.csv";
    private static final String TO_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderSeviceImpl();
        List<String> strings = fileReaderService.readFromFile(FROM_FILE_NAME);

        DataProcessorService dataProcessorService = new DataProcessorServiceImpl();

        Map<FruitTransaction.Operation, OperationHandler> processedOperations = getOperationsMap();
        OperationProcessor operationProcessor = new OperationProcessorImpl(processedOperations);
        List<FruitTransaction> format = dataProcessorService.processInputData(strings);
        operationProcessor.manageTransaction(format);

        ReportProcessorImpl reportProcessor = new ReportProcessorImpl();
        String report = reportProcessor.generateReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, TO_FILE_NAME);
    }

    private static Map<FruitTransaction.Operation, OperationHandler> getOperationsMap() {
        Map<FruitTransaction.Operation, OperationHandler> processedOperations = new HashMap<>();
        processedOperations.put(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        processedOperations.put(
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        processedOperations.put(
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        processedOperations.put(
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        return processedOperations;
    }
}
