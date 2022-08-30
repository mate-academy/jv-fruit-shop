package core;

import core.service.ProcessingService;
import core.service.ReaderService;
import core.service.ReportHandlingService;
import core.service.WriterService;
import core.service.impl.ProcessingServiceImpl;
import core.service.impl.ReaderServiceImpl;
import core.service.impl.ReportHandlingServiceImpl;
import core.service.impl.WriterServiceImpl;
import core.strategy.FruitStrategy;
import core.strategy.FruitStrategyImpl;
import core.strategy.OperationHandler;
import core.strategy.impl.BalanceOperation;
import core.strategy.impl.PurchaseOperation;
import core.strategy.impl.ReturnOperation;
import core.strategy.impl.SupplyOperation;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILEPATH = "src/main/java/resources/input.csv";
    private static final String REPORT_FILEPATH = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> strategyMap = createHashMapOperations();
        ReaderService readerService = new ReaderServiceImpl();
        List<String> queries = readerService.readFrom(INPUT_FILEPATH);

        FruitStrategy fruitStrategy = new FruitStrategyImpl(strategyMap);

        ProcessingService processingService = new ProcessingServiceImpl();
        processingService.process(fruitStrategy,queries);

        ReportHandlingService report = new ReportHandlingServiceImpl();
        List<String> reportList = report.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeTo(Path.of(REPORT_FILEPATH), reportList);

    }

    public static Map<String, OperationHandler> createHashMapOperations() {
        Map<String, OperationHandler> map = new HashMap<>();
        map.put("b", new BalanceOperation());
        map.put("s", new SupplyOperation());
        map.put("p", new PurchaseOperation());
        map.put("r", new ReturnOperation());
        return map;
    }
}
