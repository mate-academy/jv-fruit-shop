package core.basesyntax.service.impl;

import java.util.List;
import java.util.Map;
import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.FileHandler;
import core.basesyntax.strategy.StoreOperationsStrategy;

public class FileHandlerImpl implements FileHandler {
    public static final int INDEX_OF_OPERATION = 0;
    public static final int INDEX_OF_FRUIT_NAME = 1;
    public static final int INDEX_OF_QUANTITY = 2;
    private final DataReader reader;
    private final DataWriter writer;
    private final StoreOperationsStrategy activitiesStrategy;
    private final StorageDao storageDao;

    public FileHandlerImpl(DataReader reader, DataWriter writer, StoreOperationsStrategy activitiesStrategy, StorageDao storageDao) {
        this.reader = reader;
        this.writer = writer;
        this.activitiesStrategy = activitiesStrategy;
        this.storageDao = storageDao;
    }

    @Override
    public void processFiles(String fromFilePath, String toFilePath) {
        List<List<String>> dataFromFile = reader.getData(fromFilePath);
        Map<Fruit, Integer> processedData = countDailyActivity(dataFromFile);
        writer.writeData(processedData, toFilePath);
    }

    private Map<Fruit, Integer> countDailyActivity(List<List<String>> dailyActivity) {
        for (List<String> strings : dailyActivity) {
            activitiesStrategy.process(FruitTransaction.Operation.parse(strings.get(INDEX_OF_OPERATION)))
                    .processData(storageDao, new Fruit(strings.get(INDEX_OF_FRUIT_NAME)),
                            Integer.parseInt(strings.get(INDEX_OF_QUANTITY)));
        }
        return storageDao.getAll();
    }
}

