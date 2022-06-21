package service.impl;

import dao.StorageDao;
import dao.StorageDaoImpl;
import db.Storage;
import java.util.Map;
import service.ProcessDataService;
import strategy.OperationStrategy;

public class ProcessDataServiceImpl implements ProcessDataService {
    private static final int TYPE_OF_OPERATION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int QUANTITY_OF_FRUITS = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public Map<String, Integer> processData(String[] dataFromFile) {
        StorageDao storageDao = new StorageDaoImpl();
        for (int i = 1; i < dataFromFile.length; i++) {
            String[] splitedData = dataFromFile[i].split(CSV_SEPARATOR);
            int changesInQuantity = Integer.parseInt(splitedData[QUANTITY_OF_FRUITS])
                    * OperationStrategy.getCahngesInQuantityByType(splitedData[TYPE_OF_OPERATION]);
            storageDao.changeQuantityOfFruit(splitedData[TYPE_OF_FRUIT], changesInQuantity);
        }
        return Storage.getStorage();
    }
}
