package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.file.impl.ReaderServiceImpl;
import core.basesyntax.strategy.FruitWorkStrategy;

public class StorageServiceImpl implements StorageService {
    private String filePath;
    private FruitWorkStrategy fruitWork;
    private FruitDao fruitDao;
    private static final int KEY_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_NUMBER_INDEX = 2;

    public StorageServiceImpl(String filePath, FruitWorkStrategy fruitWork, FruitDao fruitDao) {
        this.filePath = filePath;
        this.fruitWork = fruitWork;
        this.fruitDao = fruitDao;
    }

    @Override
    public void workWithStorage() {
        String[] fileData = new ReaderServiceImpl(filePath).readFile();

        for (String dataLine : fileData) {
            String[] dataLineArr = dataLine.split(",");
            String key = dataLineArr[KEY_INDEX];
            String fruitName = dataLineArr[FRUIT_NAME_INDEX];
            int fruitNumber = Integer.parseInt(dataLineArr[FRUIT_NUMBER_INDEX]);

            fruitWork.get(key).workWithFruitInStorage(fruitNumber, fruitName, fruitDao);
        }
    }
}
