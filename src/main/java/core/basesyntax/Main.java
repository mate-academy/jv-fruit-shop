package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessorService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.DataProcessorServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
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
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> inputData = fileReaderService.readFromFile(
                "src/main/resources/fruit_shop_input.csv");

        DataProcessorService dataProcessorService =
                new DataProcessorServiceImpl(operationStrategy);
        dataProcessorService.updateDataInStorage(inputData);
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        List<String> report = reportGeneratorService.generateReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeIntoFile(report, "src/main/resources/fruit_shop_results.csv");
    }
}
