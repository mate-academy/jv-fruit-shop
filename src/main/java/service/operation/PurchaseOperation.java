package service.operation;

import data.db.Storage;
import java.util.Map;
import model.FruitTransaction;

public class PurchaseOperation implements OperationHandler {

    @Override
    public void operation(FruitTransaction.Operation operation, FruitTransaction fruitTransaction) {
        for (Map.Entry<String, Integer> fruit : Storage.fruitsStorage.entrySet()) {
            if (fruit.getKey().equals(fruitTransaction.getFruit())) {
                fruit.setValue(Math.max(fruit.getValue() - fruitTransaction.getQuantity(), 0));
                return;
            }
        }
    }
}
