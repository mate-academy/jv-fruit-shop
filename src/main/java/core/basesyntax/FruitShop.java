package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FileReaderService;
import service.OperationStrategy;
import service.ProcessingDataService;
import service.ReportGeneratorService;
import service.WritingIntoCsvFileService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ProcessingDataServiceImpl;
import service.impl.ReportGeneratorServiceImpl;
import service.strategy.OperationHandler;
import service.strategy.hendlers.BalanceOperationHandler;
import service.strategy.hendlers.PurchaseOperationHandler;
import service.strategy.hendlers.ReturnOperationHandler;
import service.strategy.hendlers.SupplyOperationHandler;

public class FruitShop {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileReaderService readingFromCsvFileService = new FileReaderServiceImpl();
        List<String> inputData = readingFromCsvFileService.readFromFile(
                "src/main/resources/input.csv");
        ProcessingDataService processingDataService =
                new ProcessingDataServiceImpl(operationStrategy);
        processingDataService.updateDataInStorage(inputData);
        ReportGeneratorService generatingReportService = new ReportGeneratorServiceImpl();
        List<String> report = generatingReportService.generateReport();
        WritingIntoCsvFileService writingIntoCsvFileService = new FileWriterServiceImpl();
        writingIntoCsvFileService.writeIntoFile(report, "src/main/resources/results.csv");
    }
}
