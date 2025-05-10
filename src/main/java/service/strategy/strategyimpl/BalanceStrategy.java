package service.strategy.strategyimpl;

import database.Storage;
import model.FruitRecord;

public class BalanceStrategy implements TypeService {
    @Override
    public void calculation(FruitRecord record) {
        Storage.storage.put(record.getFruit(), record.getQuantity());
    }
}
