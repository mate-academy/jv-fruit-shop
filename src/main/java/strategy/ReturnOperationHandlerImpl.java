package strategy;

import java.util.Map;
import model.Fruit;
import model.FruitTransaction;
import storage.Storage;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public int changeAmount(FruitTransaction fruitTransaction) {
        for (Map.Entry<Fruit, Integer> fruitEntry : Storage.storage.entrySet()) {
            if (fruitEntry.getKey().equals(fruitTransaction.getFruit())) {
                return fruitTransaction.getQuantity() + fruitEntry.getValue();
            }
        }
        throw new RuntimeException("Operation is not valid");
    }
}
