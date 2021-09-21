package service.operation;

import model.Fruit;
import model.FruitRecord;
import java.util.Map;

public class PurchaseHandlerImpl implements Handler {

    @Override
    public int changeAmount(FruitRecord fruitRecord, Map<Fruit, Integer> storage) {
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : storage.entrySet()) {
            if (fruitIntegerEntry.getKey().equals(fruitRecord.getFruit())) {
                return fruitIntegerEntry.getValue() - fruitRecord.getAmount();
            }
        }
        throw new RuntimeException("Operation is not valid");
    }
}