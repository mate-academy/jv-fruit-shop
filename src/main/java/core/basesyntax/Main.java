package core.basesyntax;

import core.basesyntax.dao.ProductStorageDao;
import core.basesyntax.dao.ProductStorageDaoImpl;
import core.basesyntax.model.ProductTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
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
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static final Path DIRECTORY_PROJECT = Path.of("").toAbsolutePath();
    public static final Path DIRECTORY_RESOURCES =
            Paths.get(DIRECTORY_PROJECT.toString(), "src", "main", "resources");
    public static final Path FILE_NAME_INPUT =
            DIRECTORY_RESOURCES.resolve("fruit-input-transactions.csv");
    public static final Path FILE_NAME_OUTPUT =
            DIRECTORY_RESOURCES.resolve("fruit-output-report.csv");

    public static void main(String[] args) {
        Map<ProductTransaction.Operation, ActionHandler> actionHandlerMap = new HashMap<>();
        actionHandlerMap.put(ProductTransaction.Operation.BALANCE, new BalanceHandler());
        actionHandlerMap.put(ProductTransaction.Operation.SUPPLY, new SupplyHandler());
        actionHandlerMap.put(ProductTransaction.Operation.PURCHASE, new PurchaseHandler());
        actionHandlerMap.put(ProductTransaction.Operation.RETURN, new ReturnHandler());

        ProductStorageDao productStorageDao = new ProductStorageDaoImpl();
        ActionStrategy actionStrategy = new ActionStrategyImpl(actionHandlerMap);
        ReportService report = new ReportServiceImpl(productStorageDao);
        WriterService writerService = new WriterServiceImpl();

        List<String> data = new ReaderServiceImpl().read(FILE_NAME_INPUT);
        Queue<ProductTransaction> transactions = new ParseServiceImpl().parse(data);
        while (!transactions.isEmpty()) {
            ProductTransaction productTransaction = transactions.poll();
            ActionHandler actionHandler = actionStrategy.get(productTransaction.getOperation());
            actionHandler.process(productStorageDao, productTransaction);
        }
        writerService.write(FILE_NAME_OUTPUT, report.create());
    }
}
