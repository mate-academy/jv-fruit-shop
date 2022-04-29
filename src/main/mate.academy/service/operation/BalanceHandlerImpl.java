package service.operation;

import db.Storage;
import model.FruitRecord;

public class BalanceHandlerImpl implements Handler {

    @Override
    public int changeAmount(FruitRecord fruitRecord) {
        Storage.storage.put(fruitRecord.getFruit(), fruitRecord.getAmount());
        return fruitRecord.getAmount();
    }
}
