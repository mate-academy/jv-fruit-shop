package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.impl.DataWriterToFile;
import core.basesyntax.service.impl.DecreaseAmountHandler;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.IncreaseAmountHandler;
import core.basesyntax.service.impl.InitAmountHandler;
import core.basesyntax.strategy.StoreOperationsStrategy;
import core.basesyntax.strategy.impl.StoreOperationsStrategyImpl;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static final String PATH_TO_FILE = "src/main/resources/daily_report.csv";
    private static final String PATH_FROM_FILE = "src/main/resources/daily_activities.csv";
    private static final FruitDao storageDao = new FruitDaoImpl(Storage.getStorageOfFruits());
    private static final FileReader reader = new FileReaderImpl();
    private static final FileWriter writer = new DataWriterToFile();

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationDataHandlerMap
                = getOperationsAndRelativeHandlers();
        StoreOperationsStrategy activitiesStrategy
                = new StoreOperationsStrategyImpl(operationDataHandlerMap);
        FileServiceImpl fileHandler = new FileServiceImpl(reader, writer,
                activitiesStrategy, storageDao);
        fileHandler.processFiles(PATH_FROM_FILE, PATH_TO_FILE);
    }

    private static Map<Operation, OperationHandler> getOperationsAndRelativeHandlers() {
        Map<Operation, OperationHandler> operationDataHandlerMap = new HashMap<>();
        operationDataHandlerMap.put(Operation.BALANCE, new InitAmountHandler());
        operationDataHandlerMap.put(Operation.SUPPLY, new IncreaseAmountHandler());
        operationDataHandlerMap.put(Operation.RETURN, new IncreaseAmountHandler());
        operationDataHandlerMap.put(Operation.PURCHASE, new DecreaseAmountHandler());
        return operationDataHandlerMap;
    }
}
