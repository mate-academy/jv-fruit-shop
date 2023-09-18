package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.GeneratingReportService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ProcessingDataService;
import core.basesyntax.service.ReadingFromCsvFileService;
import core.basesyntax.service.WritingIntoCsvFileService;
import core.basesyntax.service.impl.GeneratingReportServiceImpl;
import core.basesyntax.service.impl.ProcessingDataServiceImpl;
import core.basesyntax.service.impl.ReadingFromCsvFileServiceImpl;
import core.basesyntax.service.impl.WritingIntoCsvFileServiceImpl;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.impl.BalanceOperationHandler;
import core.basesyntax.service.strategy.impl.BuyOperationHandler;
import core.basesyntax.service.strategy.impl.ReturnOperationHandler;
import core.basesyntax.service.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new BuyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReadingFromCsvFileService readingFromCsvFileService = new ReadingFromCsvFileServiceImpl();
        List<String> inputData = readingFromCsvFileService.readFromFile(
                "src/main/resources/fruit_shop_input.csv");

        ProcessingDataService processingDataService =
                new ProcessingDataServiceImpl(operationStrategy);
        processingDataService.updateDataInStorage(inputData);
        GeneratingReportService generatingReportService = new GeneratingReportServiceImpl();
        List<String> report = generatingReportService.generateReport();
        WritingIntoCsvFileService writingIntoCsvFileService = new WritingIntoCsvFileServiceImpl();
        writingIntoCsvFileService.writeIntoFile(report,"src/main/resources/fruit_shop_results.csv");
    }
}
