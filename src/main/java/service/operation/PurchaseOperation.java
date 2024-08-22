package service.operation;

import data.db.Storage;
import java.util.Map;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        for (Map.Entry<String, Integer> fruit : Storage.getFruitsStorage().entrySet()) {
            if (fruit.getKey().equals(fruitTransaction.getFruit())) {
                Storage.setFruitsStorage(fruit.getKey(),
                        Math.max(fruit.getValue() - fruitTransaction.getQuantity(), 0));
                return;
            }
        }
    }
}
