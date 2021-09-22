package service.activities;

import db.Storage;
import service.fruitrecord.FruitRecord;

public class Supply implements ActivityHandler {
    @Override
    public void apply(FruitRecord record) {
        if (Storage.fruitsQuantity.containsKey(record.getFruit())) {
            Integer newBalance = record.getAmount() + Storage.fruitsQuantity.get(record.getFruit());
            Storage.fruitsQuantity.replace(record.getFruit(),newBalance);
        } else {
            Storage.fruitsQuantity.put(record.getFruit(), record.getAmount());
        }
    }
}
