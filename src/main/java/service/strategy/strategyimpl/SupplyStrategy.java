package service.strategy.strategyimpl;

import database.Storage;
import model.FruitRecord;

public class SupplyStrategy implements TypeService {
    @Override
    public void calculation(FruitRecord record) {
        int supplyQuantity = record.getQuantity();
        Storage.storage.merge(record.getFruit(), supplyQuantity, Integer::sum);
    }
}
