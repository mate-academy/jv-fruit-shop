package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.ProcessingService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ProcessingServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operations.BalanceHandler;
import core.basesyntax.strategy.operations.OperationHandler;
import core.basesyntax.strategy.operations.PurchaseHandler;
import core.basesyntax.strategy.operations.ReturnHandler;
import core.basesyntax.strategy.operations.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String readFromPath = "src/main/java/resources/inputFileExample.csv";
    private static final String writeToPath = "src/main/java/resources/outputFileExample.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandler());

        ReaderService readerService = new ReaderServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        WriterService writerService = new WriterServiceImpl();
        ProcessingService processingService = new ProcessingServiceImpl();

        List<String> dayStatistics = readerService.readFromFile(readFromPath);
        processingService.removeHeading(dayStatistics);
        processingService.processData(dayStatistics,strategy);
        String report = reportService.generate();
        writerService.writeToFile(report, writeToPath);
    }
}
