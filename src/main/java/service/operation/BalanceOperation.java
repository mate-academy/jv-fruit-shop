package service.operation;

import data.db.Storage;
import java.util.Map;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void operation(FruitTransaction.Operation operation, FruitTransaction fruitTransaction) {
        for (Map.Entry<String, Integer> fruit : Storage.fruitsStorage.entrySet()) {
            if (fruit.getKey().equals(fruitTransaction.getFruit())) {
                fruit.setValue(fruitTransaction.getQuantity());
                return;
            }
        }
        Storage.fruitsStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
