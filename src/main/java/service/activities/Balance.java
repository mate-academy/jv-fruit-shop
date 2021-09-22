package service.activities;

import db.Storage;
import fruitrecord.FruitRecord;

public class Balance implements ActivityHandler {
    @Override
    public void apply(FruitRecord record) {
        if (Storage.fruitsQuantity.containsKey(record.getFruit())) {
            Storage.fruitsQuantity.replace(record.getFruit(), record.getAmount());
        } else {
            Storage.fruitsQuantity.put(record.getFruit(), record.getAmount());
        }
    }
}
