package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.operation.OperationDecreaseHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationIncreaseHandler;
import core.basesyntax.service.parser.TransactionDtoParser;
import core.basesyntax.service.parser.TransactionDtoParserImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String PATH_TO_FILE_INPUT = "src/main/resources/data.csv";
    private static final String PATH_TO_FILE_OUTPUT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoImpl();
        Map<String, OperationHandler> handlers = getHandlersStorage(productDao);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);
        FruitShopService service = new FruitShopServiceImpl(operationStrategy, productDao);
        FileReader reader = new FileReaderImpl();
        FileWriter writer = new FileWriterImpl();
        TransactionDtoParser parser = new TransactionDtoParserImpl();
        service.saveData(parser.parse(reader.read(PATH_TO_FILE_INPUT)));
        writer.write(PATH_TO_FILE_OUTPUT,service.createReport());
    }

    private static Map<String, OperationHandler> getHandlersStorage(ProductDao productDao) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new OperationIncreaseHandler(productDao));
        handlers.put("s", new OperationIncreaseHandler(productDao));
        handlers.put("p", new OperationDecreaseHandler(productDao));
        handlers.put("r", new OperationIncreaseHandler(productDao));
        return handlers;
    }
}
