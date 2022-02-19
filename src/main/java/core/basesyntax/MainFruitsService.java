package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Apple;
import core.basesyntax.model.Banana;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Orange;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.TransactionLog;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.LogIteratorServiceImpl;
import core.basesyntax.service.impl.StorageAdditionServiceImpl;
import core.basesyntax.service.impl.StorageReductionServiceImpl;
import core.basesyntax.strategy.TransDistrStrategy;
import core.basesyntax.strategy.TransDistrStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFruitsService {
    static final String READ_DATA_PATH = "src/main/resources/input.csv";
    static final String WRITE_REPORT_PATH = "src/main/resources/report.csv";
    static final String PURCHASE = "p";
    static final String RETURN = "r";
    static final String SUPPLY = "s";
    static final String BALANCE = "b";

    public static void main(String[] args) {
        Fruit apple = new Apple("apple");
        Fruit banana = new Banana("banana");
        Fruit orange = new Orange("orange");

        Map<Fruit, Integer> storageDefaultMap = new HashMap<>();
        storageDefaultMap.put(apple, 0);
        storageDefaultMap.put(banana, 0);
        storageDefaultMap.put(orange, 0);

        Map<String, StorageService> operationDistributionMap = new HashMap<>();
        operationDistributionMap.put(PURCHASE, new StorageReductionServiceImpl());
        operationDistributionMap.put(RETURN, new StorageAdditionServiceImpl());
        operationDistributionMap.put(SUPPLY, new StorageAdditionServiceImpl());
        operationDistributionMap.put(BALANCE, new StorageAdditionServiceImpl());

        FileReaderService fileReaderService = new FileReaderServiceImpl();

        TransDistrStrategy transDistrStrategy =
                new TransDistrStrategyImpl(operationDistributionMap);

        List<TransactionLog> operationsList = fileReaderService.readFromFile(READ_DATA_PATH);

        Storage storage = new Storage(storageDefaultMap);

        new LogIteratorServiceImpl().iterate(operationsList, transDistrStrategy, storage);

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(WRITE_REPORT_PATH, storageDefaultMap);
    }
}
