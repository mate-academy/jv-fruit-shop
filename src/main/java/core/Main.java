package core;

import core.service.ProcessingService;
import core.service.ReaderService;
import core.service.ReportHandlingService;
import core.service.impl.ProcessingServiceImpl;
import core.service.impl.ReaderServiceImpl;
import core.service.impl.ReportHandlingServiceImpl;
import core.strategy.FruitStrategy;
import core.strategy.impl.BalanceOperation;
import core.strategy.impl.PurchaseOperation;
import core.strategy.impl.ReturnOperation;
import core.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILEPATH = "src/main/java/resources/input.csv";

    public static void main(String[] args) {
        Map<String, FruitStrategy> strategyMap = createHashMapOperations();

        ReaderService readerService = new ReaderServiceImpl();
        List<String> queries = readerService.readFrom(INPUT_FILEPATH);

        ProcessingService processingService = new ProcessingServiceImpl();
        processingService.process(strategyMap, queries);

        ReportHandlingService report = new ReportHandlingServiceImpl();
        report.createReportLine();
    }

    public static Map<String, FruitStrategy> createHashMapOperations() {
        Map<String, FruitStrategy> map = new HashMap<>();
        map.put("b", new BalanceOperation());
        map.put("s", new SupplyOperation());
        map.put("p", new PurchaseOperation());
        map.put("r", new ReturnOperation());
        return map;
    }
}
