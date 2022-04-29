package strategy;

import java.util.Map;
import model.Fruit;
import model.FruitTransaction;
import storage.Storage;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public int changeAmount(FruitTransaction fruitTransaction) {
        for (Map.Entry<Fruit, Integer> fruitEntry : Storage.storage.entrySet()) {
            if (fruitEntry.getKey().equals(fruitTransaction.getFruit())) {
                return fruitEntry.getValue() - fruitTransaction.getQuantity();
            }
        }
        throw new RuntimeException("We don't have fruit -" + fruitTransaction.getFruit());
    }
}
