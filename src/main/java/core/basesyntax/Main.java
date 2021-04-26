package core.basesyntax;

import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.service.CsvReaderImpl;
import core.basesyntax.service.CsvWriterImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String PATH_FROM = "src/main/java/resources/data.csv";
    private static final String PATH_TO = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new BalanceHandler());
        handlers.put("s", new SupplyHandler());
        handlers.put("p", new PurchaseHandler());
        handlers.put("r", new ReturnHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        FruitShopService fruitShopService = new FruitShopServiceImpl(new CsvReaderImpl(),
                operationStrategy, new ProductDaoImpl(), new CsvWriterImpl(new ProductDaoImpl()));
        fruitShopService.createReport(PATH_FROM, PATH_TO);
    }
}