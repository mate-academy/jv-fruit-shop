package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.FruitStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_PATH = "src/main/java/resources/database.csv";
    private static final String REPORT_PATH = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<Fruit.Operation, OperationsStrategy> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Fruit.Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(Fruit.Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(Fruit.Operation.RETURN, new ReturnOperation());
        operationHandlerMap.put(Fruit.Operation.SUPPLY, new SupplyOperation());

        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl();
        FruitStrategy fruitStrategy = new FruitStrategyImpl(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writeToFileService = new WriterServiceImpl();

        List<String> fruitList = readerService.readFromFile(SOURCE_PATH);
        List<Fruit> fruitTransactionList =
                parserService.formatData(fruitList);

        fruitService.getAllOperationsStrategy(fruitTransactionList, fruitStrategy);
        writeToFileService.writeToFile(reportService.getReport(), REPORT_PATH);
    }
}
