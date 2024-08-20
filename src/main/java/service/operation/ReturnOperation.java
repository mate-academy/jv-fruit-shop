package service.operation;

import data.db.Storage;
import java.util.Map;
import model.FruitTransaction;

public class ReturnOperation implements OperationHandler {

    @Override
    public void operation(FruitTransaction.Operation operation, FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() <= 0) {
            return;
        }
        for (Map.Entry<String, Integer> fruit : Storage.fruitsStorage.entrySet()) {
            if (fruit.getKey().equals(fruitTransaction.getFruit())) {
                fruit.setValue(fruit.getValue() + fruitTransaction.getQuantity());
                return;
            }
        }
        Storage.fruitsStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
