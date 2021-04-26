package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.service.FileEntryReader;
import core.basesyntax.service.FileEntryReaderImpl;
import core.basesyntax.service.FileEntryWriter;
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
        ProductDao productDao = new ProductDaoImpl();
        FileEntryReader reader = new FileEntryReaderImpl();
        FileEntryWriter writer = new FileEntryWriterImpl(new ProductDaoImpl());
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new OperationHandlerIncrease(productDao));
        handlers.put("s", new OperationHandlerIncrease(productDao));
        handlers.put("p", new OperationHandlerDecrease(productDao));
        handlers.put("r", new OperationHandlerIncrease(productDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        FruitShopService fruitShopService = new FruitShopServiceImpl(
                reader,
                operationStrategy,
                productDao,
                writer);

        fruitShopService.createReport(PATH_FROM_FILE_INPUT, PATH_TO_FILE_OUTPUT);
    }
}
