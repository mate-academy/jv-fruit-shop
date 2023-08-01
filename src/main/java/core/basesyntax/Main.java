package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverterService;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.CsvDataConverterService;
import core.basesyntax.service.impl.CsvDataProcessingService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.io.File;
import java.util.Map;

public class Main {
    private static final Map<Operation, OperationHandler> operationHandlerMap = Map.of(
            Operation.BALANCE, new BalanceOperationHandler(),
            Operation.SUPPLY, new SupplyOperationHandler(),
            Operation.PURCHASE, new PurchaseOperationHandler(),
            Operation.RETURN, new ReturnOperationHandler());

    public static void main(String[] args) {
        File file = new File("src/main/resources/input.csv");
        FileReaderService fileReaderService = new CsvFileReaderService(file);
        DataConverterService dataConverting = new CsvDataConverterService(fileReaderService);

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        DataProcessingService dataProcessingService = new CsvDataProcessingService(strategy,
                                                                                dataConverting);
        dataProcessingService.importDataToStorage();
        ReportCreatorService reportCreator = new ReportCreatorServiceImpl();
        String report = reportCreator.createReport();
        FileWriterService fileWriterService = new CsvFileWriterService();
        fileWriterService.writeToFile("src/main/resources/", report);
    }
}
