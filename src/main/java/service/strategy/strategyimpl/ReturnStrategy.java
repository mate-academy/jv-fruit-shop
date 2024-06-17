package service.strategy.strategyimpl;

import database.Storage;
import model.FruitRecord;

public class ReturnStrategy implements TypeService {
    @Override
    public void calculation(FruitRecord record) {
        int returnFruits = record.getQuantity();
        Storage.storage.merge(record.getFruit(),returnFruits, Integer::sum);
    }
}
