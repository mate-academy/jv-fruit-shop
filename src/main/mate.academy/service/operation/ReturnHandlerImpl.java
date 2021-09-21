package service.operation;

import model.Fruit;
import model.FruitRecord;
import java.util.Map;

public class ReturnHandlerImpl implements Handler {

    @Override
    public int changeAmount(FruitRecord fruitRecord, Map<Fruit, Integer> storage) {
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : storage.entrySet()) {
            if (fruitIntegerEntry.getKey().equals(fruitRecord.getFruit())) {
                return fruitRecord.getAmount() + fruitIntegerEntry.getValue();
            }
        }
        throw new RuntimeException("Operation is not valid");
    }
}