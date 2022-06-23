package service.impl;

import dao.StorageDao;
import dao.StorageDaoImpl;
import db.Storage;
import java.util.List;
import model.Fruit;
import service.ProcessDataService;
import strategy.OperationStrategy;

public class ProcessDataServiceImpl implements ProcessDataService {
    @Override
    public List<Fruit> processData(List<Fruit> parsedValues) {
        StorageDao storageDao = new StorageDaoImpl();
        for (Fruit fruit : parsedValues) {
            Fruit f = storageDao.getFruit(fruit);
            if (f == null) {
                storageDao.addFruit(fruit);
            } else {
                fruit.setQuantity(OperationStrategy
                        .getOperationServiceStrategy(fruit.getOperation())
                        .getActionByOperation(fruit.getQuantity()).applyAsInt(f.getQuantity()));
                storageDao.changeQuantityOfFruit(fruit);

            }
        }
        return Storage.storage;
    }
}
