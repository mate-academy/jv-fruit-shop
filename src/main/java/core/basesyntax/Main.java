package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.dto.TransactionDtoParser;
import core.basesyntax.service.dto.TransactionDtoParserImpl;
import core.basesyntax.service.implementations.FileReaderServiceImpl;
import core.basesyntax.service.implementations.FileWriterServiceImpl;
import core.basesyntax.service.implementations.FruitShopServiceImpl;
import core.basesyntax.service.implementations.OperationStrategyImpl;
import core.basesyntax.service.operations.OperationDecreaseHandler;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.OperationIncreaseHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH_TO_FILE = "src/main/resources/data.csv";
    private static final String OUTPUT_PATH_TO_FILE = "src/main/resources/report.csv";

    public static void main(String[]args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<String, OperationHandler> handlers = getHandlersStorage(fruitDao);
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);
        FruitShopService service = new FruitShopServiceImpl(operationStrategy, fruitDao);
        FileReaderService reader = new FileReaderServiceImpl();
        FileWriterService writer = new FileWriterServiceImpl();
        TransactionDtoParser parser = new TransactionDtoParserImpl();
        service.saveData(parser.parse(reader.readFromFile(INPUT_PATH_TO_FILE)));
        writer.writeToFile(OUTPUT_PATH_TO_FILE, service.createReport());
    }

    private static Map<String, OperationHandler> getHandlersStorage(FruitDao fruitDao) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new OperationIncreaseHandler(fruitDao));
        handlers.put("s", new OperationIncreaseHandler(fruitDao));
        handlers.put("p", new OperationDecreaseHandler(fruitDao));
        handlers.put("r", new OperationIncreaseHandler(fruitDao));
        return handlers;
    }
}
