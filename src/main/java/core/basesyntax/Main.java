package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ProcessingService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.StatisticsStorageService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ProcessingServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.StatisticsStorageServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/fruits.csv";
        String resultFilePath = "src/main/resources/statistics.csv";
        Map<Fruit.Operation, OperationHandler> strategyMap =
                Map.of(Fruit.Operation.BALANCE, new BalanceHandler(),
                        Fruit.Operation.PURCHASE, new PurchaseHandler(),
                        Fruit.Operation.RETURN, new ReturnHandler(),
                        Fruit.Operation.SUPPLY, new SupplyHandler());
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        ProcessingService processingService = new ProcessingServiceImpl(operationStrategy);
        StatisticsStorageService statisticsStorageService = new StatisticsStorageServiceImpl();
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> fruitsStrings = readerService.readFromFile(inputFilePath);
        List<Fruit> fruitsObjects = parserService.parseData(fruitsStrings);
        Map<String, Integer> statistics = processingService.processStatistics(fruitsObjects);
        statisticsStorageService.store(statistics);
        String report = reportCreatorService.createReport();
        writerService.writeToFile(resultFilePath, report);
    }
}
