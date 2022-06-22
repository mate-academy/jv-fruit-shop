package service.impl;

import dao.StorageDao;
import dao.StorageDaoImpl;
import db.Storage;
import java.util.List;
import model.Fruit;
import service.ProcessDataService;

public class ProcessDataServiceImpl implements ProcessDataService {
    @Override
    public List<Fruit> processData(List<Fruit> parsedValues) {
        StorageDao storageDao = new StorageDaoImpl();
        for (Fruit fruit : parsedValues) {
            storageDao.changeQuantityOfFruit(fruit);
        }
        return Storage.storage;
    }
}
