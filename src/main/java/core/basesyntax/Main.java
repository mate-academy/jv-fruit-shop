package core.basesyntax;

import static core.basesyntax.model.FruitTransaction.Operation;

import core.basesyntax.dao.impl.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitStorageService;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileServiceCsvImpl;
import core.basesyntax.service.impl.FruitStorageServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceCsvImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String FILE_NAME_SOURCE = "src/main/resources/file.csv";
    private static final String FILE_NAME_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ParserService parserService = new ParserServiceImpl();
        FruitStorageService fruitStorageService = new FruitStorageServiceImpl(
                new FruitStorageDaoImpl(),
                operationStrategy);
        ReportService reportService = new ReportServiceCsvImpl(new FruitStorageDaoImpl());
        FileService fileService = new FileServiceCsvImpl();

        List<String> list = fileService.readFile(FILE_NAME_SOURCE);
        List<FruitTransaction> transactions = parserService.parse(list);
        fruitStorageService.processTransactions(transactions);
        String report = reportService.createReport();
        fileService.writeFile(report, FILE_NAME_REPORT);
    }
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
}
