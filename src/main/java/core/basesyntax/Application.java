package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataHandler;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.impl.AddDataHandler;
import core.basesyntax.service.impl.DataReaderFromFile;
import core.basesyntax.service.impl.DataWriterToFile;
import core.basesyntax.service.impl.FileHandlerImpl;
import core.basesyntax.service.impl.InitDataHandler;
import core.basesyntax.service.impl.SubtractDataHandler;
import core.basesyntax.strategy.StoreOperationsStrategy;
import core.basesyntax.strategy.impl.StoreOperationsStrategyImpl;

public class Application {
    public static final String PATH_TO_FILE = "src/main/resources/daily_report.csv";
    private static final String PATH_FROM_FILE = "src/main/resources/daily_activities.csv";
    private static final StorageDao storageDao = new StorageDaoImpl();
    private static final DataReader reader = new DataReaderFromFile();
    private static final DataWriter writer = new DataWriterToFile();

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, DataHandler> operationDataHandlerMap = getOperationsAndRelativeHandlers();
        StoreOperationsStrategy activitiesStrategy = new StoreOperationsStrategyImpl(operationDataHandlerMap);
        FileHandlerImpl fileHandler = new FileHandlerImpl(reader, writer,
                activitiesStrategy, storageDao);
        fileHandler.processFiles(PATH_FROM_FILE, PATH_TO_FILE);
    }

    private static Map<FruitTransaction.Operation, DataHandler> getOperationsAndRelativeHandlers() {
        Map<FruitTransaction.Operation, DataHandler> operationDataHandlerMap = new HashMap<>();
        operationDataHandlerMap.put(FruitTransaction.Operation.BALANCE, new InitDataHandler());
        operationDataHandlerMap.put(FruitTransaction.Operation.SUPPLY, new AddDataHandler());
        operationDataHandlerMap.put(FruitTransaction.Operation.RETURN, new AddDataHandler());
        operationDataHandlerMap.put(FruitTransaction.Operation.PURCHASE, new SubtractDataHandler());
        return operationDataHandlerMap;
    }
}
