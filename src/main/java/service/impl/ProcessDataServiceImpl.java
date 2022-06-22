package service.impl;

import dao.StorageDao;
import dao.StorageDaoImpl;
import db.Storage;
import java.util.List;
import java.util.Map;
import service.ParseDataService;
import service.ProcessDataService;
import strategy.OperationStrategy;

public class ProcessDataServiceImpl implements ProcessDataService {
    @Override
    public Map<String, Integer> processData(List<String> dataFromFile) {
        StorageDao storageDao = new StorageDaoImpl();
        ParseDataService parseDataService = new ParseDataServiceImpl();
        for (int i = 1; i < dataFromFile.size(); i++) {
            parseDataService.parseString(dataFromFile.get(i));
            storageDao
                    .changeQuantityOfFruit(
                            parseDataService.getTypeOfFruit(),
                            parseDataService.getQuantityOfFruit(),
                            OperationStrategy
                                    .getOperationServiceStrategy(parseDataService.getOperation()));
            parseDataService.clear();
        }
        return Storage.storage;
    }
}
