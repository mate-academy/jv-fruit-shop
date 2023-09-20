package core.basesyntax;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataProcessorService;
import service.FileReaderService;
import service.FileWriterService;
import service.OperationStrategy;
import service.ReportGeneratorService;
import service.impl.DataProcessorServiceImpl;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ReportGeneratorServiceImpl;
import service.strategy.OperationHandler;
import service.strategy.hendlers.BalanceOperationHandler;
import service.strategy.hendlers.PurchaseOperationHandler;
import service.strategy.hendlers.ReturnOperationHandler;
import service.strategy.hendlers.SupplyOperationHandler;

public class FruitShop {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/results.csv";

    private static Map<FruitTransaction.Operation, OperationHandler>
            initializeOperationHandlerMap() {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        return operationHandlerMap;
    }

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap =
                initializeOperationHandlerMap();
        OperationStrategy operationStrategy =
                new OperationStrategyImpl(operationHandlerMap);
        FileReaderService readingFromCsvFileService =
                new FileReaderServiceImpl();
        List<String> inputData = readingFromCsvFileService.readFromFile(INPUT_FILE_PATH);
        DataProcessorService processingDataService =
                new DataProcessorServiceImpl(operationStrategy);
        processingDataService.processData(inputData);
        ReportGeneratorService generatingReportService = new ReportGeneratorServiceImpl();
        List<String> report = Collections.singletonList(generatingReportService.generateReport());
        FileWriterService writingIntoCsvFileService = new FileWriterServiceImpl();
        writingIntoCsvFileService.writeIntoFile(report, OUTPUT_FILE_PATH);
    }
}
