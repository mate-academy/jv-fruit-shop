package core.basesyntax;

import core.basesyntax.service.ProcessingService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ProcessingServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.FruitStrategyImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
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

        ProcessingService processingService =
                new ProcessingServiceImpl(fruitStrategy, queries, strategyMap);
        processingService.process();

        ReportService report = new ReportServiceImpl();
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
