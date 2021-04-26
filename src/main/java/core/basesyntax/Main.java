package core.basesyntax;

import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.service.FileEntryReaderImpl;
import core.basesyntax.service.FileEntryWriterImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationHandlerDecrease;
import core.basesyntax.service.operation.OperationHandlerIncrease;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String PATH_FROM_FILE_INPUT = "src/main/java/resources/data.csv";
    private static final String PATH_TO_FILE_OUTPUT = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new OperationHandlerIncrease());
        handlers.put("s", new OperationHandlerIncrease());
        handlers.put("p", new OperationHandlerDecrease());
        handlers.put("r", new OperationHandlerIncrease());
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        FruitShopService fruitShopService = new FruitShopServiceImpl(new FileEntryReaderImpl(),
                operationStrategy, new ProductDaoImpl(),
                new FileEntryWriterImpl(new ProductDaoImpl()));
        fruitShopService.createReport(PATH_FROM_FILE_INPUT, PATH_TO_FILE_OUTPUT);
    }
}
