package service.activities;

import db.Storage;
import javax.management.openmbean.InvalidKeyException;
import service.fruitrecord.FruitRecord;

public class Purchase implements ActivityHandler {
    @Override
    public void apply(FruitRecord record) {
        Integer currentBalance;
        if (Storage.fruitsQuantity.containsKey(record.getFruit())) {
            currentBalance = Storage.fruitsQuantity.get(record.getFruit());
        } else {
            throw new InvalidKeyException("Invalid key, " + record.getFruit());
        }
        if (currentBalance > record.getAmount()) {
            Integer newCurrentBalance = currentBalance - record.getAmount();
            Storage.fruitsQuantity.replace(record.getFruit(), newCurrentBalance);
        } else {
            throw new RuntimeException("Operation Purchase cannot be performed with this data: "
                    + record.getAmount());
        }
    }
}
