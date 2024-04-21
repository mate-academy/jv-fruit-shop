package core.basesyntax;

import core.basesyntax.dao.impl.FruitStorageDaoImpl;
import core.basesyntax.dao.impl.TransactionStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvReportService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FruitStorageService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvReportServiceImpl;
import core.basesyntax.service.impl.FruitStorageServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl(new TransactionStorageDaoImpl());
        FruitStorageService fruitStorageService = new FruitStorageServiceImpl(
                new FruitStorageDaoImpl(),
                new TransactionStorageDaoImpl(), operationStrategy);
        CsvReportService csvReportService = new CsvReportServiceImpl(new FruitStorageDaoImpl());

        List<String> list = fileReaderService.read(Path.of("src/main/resources/file.csv"));
        parserService.parse(list);
        fruitStorageService.update();
        csvReportService.writeReport(Path.of("src/main/resources/report.csv"));
    }
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
}
