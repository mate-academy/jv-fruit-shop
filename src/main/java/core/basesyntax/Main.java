package core.basesyntax;

import core.basesyntax.model.Operation;
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
    private static final String INPUT_FILE = "src/main/resources/fruit_shop_input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/fruit_shop_results.csv";

    public static void main(String[] args) {
        OperationStrategy operationStrategy = new OperationStrategyImpl(getMapOperationHandler());
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> inputData = fileReaderService.readFromFile(INPUT_FILE);
        DataProcessorService dataProcessorService =
                new DataProcessorServiceImpl(operationStrategy);
        dataProcessorService.updateDataInStorage(inputData);
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        List<String> report = reportGeneratorService.generateReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeIntoFile(report, OUTPUT_FILE);
    }

    private static Map<Operation, OperationHandler> getMapOperationHandler() {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new BuyOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        return operationHandlerMap;
    }
}
