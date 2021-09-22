package service.activities;

import db.Storage;
import fruitrecord.FruitRecord;
import javax.management.openmbean.InvalidKeyException;

public class PurchaseHandler implements ActivityHandler {
    @Override
    public void apply(FruitRecord record) {
        Integer currentBalance;
        if (Storage.fruitsQuantity.containsKey(record.getFruit())) {
            currentBalance = Storage.fruitsQuantity.get(record.getFruit());
        } else {
            throw new InvalidKeyException("Invalid key, " + record.getFruit());
        }
        if (currentBalance > record.getAmount()) {
            Storage.fruitsQuantity.merge(record.getFruit(),record.getAmount(),(Integer::sum));
        } else {
            throw new RuntimeException("Operation Purchase cannot be performed with this data: "
                    + record.getAmount());
        }
    }
}
