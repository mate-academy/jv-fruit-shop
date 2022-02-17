package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileWriter;
import core.basesyntax.strategy.StoreOperationsStrategy;
import java.util.List;
import java.util.Map;

public class FileServiceImpl implements FileService {
    public static final int INDEX_OF_OPERATION = 0;
    public static final int INDEX_OF_FRUIT_NAME = 1;
    public static final int INDEX_OF_QUANTITY = 2;
    private final FileReader reader;
    private final FileWriter writer;
    private final StoreOperationsStrategy activitiesStrategy;
    private final FruitDao fruitDao;

    public FileServiceImpl(FileReader reader, FileWriter writer,
                           StoreOperationsStrategy activitiesStrategy, FruitDao fruitDao) {
        this.reader = reader;
        this.writer = writer;
        this.activitiesStrategy = activitiesStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void processFiles(String fromFilePath, String toFilePath) {
        List<List<String>> dataFromFile = reader.getData(fromFilePath);
        Map<Fruit, Integer> processedData = countDailyActivity(dataFromFile);
        writer.writeData(processedData, toFilePath);
    }

    private Map<Fruit, Integer> countDailyActivity(List<List<String>> dailyActivity) {
        for (List<String> strings : dailyActivity) {
            activitiesStrategy.process(Operation.parse(strings.get(INDEX_OF_OPERATION)))
                    .processData(new Fruit(strings.get(INDEX_OF_FRUIT_NAME)),
                            Integer.parseInt(strings.get(INDEX_OF_QUANTITY)));
        }
        return fruitDao.getAll();
    }
}

