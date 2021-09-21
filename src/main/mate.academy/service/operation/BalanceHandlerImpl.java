package service.operation;

import model.Fruit;
import model.FruitRecord;
import java.util.Map;

public class BalanceHandlerImpl implements Handler {

    @Override
    public int changeAmount(FruitRecord fruitRecord, Map<Fruit, Integer> storage) {
        storage.put(fruitRecord.getFruitName(), 0);
        return fruitRecord.getAmount();
    }
}