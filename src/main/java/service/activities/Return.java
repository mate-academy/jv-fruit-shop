package service.activities;

import db.Storage;
import service.fruitrecord.FruitRecord;

public class Return implements ActivityHandler {
    @Override
    public void apply(FruitRecord record) {
        if (Storage.fruitsQuantity.containsKey(record.getFruit())) {
            Integer newBalance = Storage.fruitsQuantity.get(record.getFruit()) + record.getAmount();
            Storage.fruitsQuantity.replace(record.getFruit(), newBalance);
        } else {
            throw new RuntimeException(
                    "Can't return the product because this product has never sold, "
                    + record.getFruit());
        }
    }
}
