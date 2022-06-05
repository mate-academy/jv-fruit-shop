package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.ProductTransaction;
import core.basesyntax.service.ProcessorServiceImpl;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.ActionStrategyImpl;
import core.basesyntax.strategy.action.ActionHandler;
import core.basesyntax.strategy.action.BalanceHandler;
import core.basesyntax.strategy.action.PurchaseHandler;
import core.basesyntax.strategy.action.ReturnHandler;
import core.basesyntax.strategy.action.SupplyHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
    private static final String PROJECT_DIRECTORY = Path.of("").toAbsolutePath().toString();
    private static final Path RESOURCES_PATH =
            Paths.get(PROJECT_DIRECTORY, "src", "main", "resources");
    private static final Path INPUT_FILE_NAME = RESOURCES_PATH.resolve("fruit-stat.csv");
    private static final Path OUTPUT_FILE_NAME = RESOURCES_PATH.resolve("fruit-stat.csv");

    public static void main(String[] args) {
        Map<ProductTransaction.Operation, ActionHandler> actionHandlerMap = new HashMap<>();
        Main.getActionHandlerMap(actionHandlerMap);

        Queue<ProductTransaction> productTransactions;
        String report;
        ProductDao productDao = new ProductDaoImpl();
        ActionStrategy actionStrategy = new ActionStrategyImpl(actionHandlerMap);
        ProcessorServiceImpl processorService =
                new ProcessorServiceImpl(actionStrategy, productDao);

        productTransactions = new ReaderServiceImpl().read(INPUT_FILE_NAME);
        processorService.processing(productTransactions);
        report = processorService.report();
        new WriterServiceImpl().write(OUTPUT_FILE_NAME, report);

        System.out.println(report);
    }

    private static void getActionHandlerMap(Map<ProductTransaction.Operation, ActionHandler> map) {
        map.put(ProductTransaction.Operation.BALANCE, new BalanceHandler());
        map.put(ProductTransaction.Operation.SUPPLY, new SupplyHandler());
        map.put(ProductTransaction.Operation.PURCHASE, new PurchaseHandler());
        map.put(ProductTransaction.Operation.RETURN, new ReturnHandler());
    }
}
