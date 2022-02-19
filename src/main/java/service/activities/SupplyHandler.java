package service.activities;

import db.Storage;
import fruitrecord.FruitRecord;

public class SupplyHandler implements ActivityHandler {
    @Override
    public void apply(FruitRecord record) {
        if (Storage.fruitsQuantity.containsKey(record.getFruit())) {
            Storage.fruitsQuantity.merge(record.getFruit(),record.getAmount(),(Integer::sum));
        } else {
            Storage.fruitsQuantity.put(record.getFruit(), record.getAmount());
        }
    }
}
