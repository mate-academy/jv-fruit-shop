package service.impl;

import dao.StorageDao;
import dao.StorageDaoImpl;
import db.Storage;
import java.util.List;
import java.util.Map;
import service.ProcessDataService;
import strategy.OperationStrategy;

public class ProcessDataServiceImpl implements ProcessDataService {
    private static final int TYPE_OF_OPERATION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int QUANTITY_OF_FRUITS = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public Map<String, Integer> processData(List<String> dataFromFile) {
        StorageDao storageDao = new StorageDaoImpl();
        for (int i = 1; i < dataFromFile.size(); i++) {
            String[] splitedData = dataFromFile.get(i).split(CSV_SEPARATOR);
            storageDao
                    .changeQuantityOfFruit(splitedData[TYPE_OF_FRUIT],
                            Integer.parseInt(splitedData[QUANTITY_OF_FRUITS]),
                    OperationStrategy.getOperationServiceStrategy(splitedData[TYPE_OF_OPERATION]));
        }
        return Storage.getStorage();
    }
}
