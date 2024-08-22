package service.operation;

import data.db.Storage;
import java.util.Map;
import model.FruitTransaction;

public class BalanceOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        for (Map.Entry<String, Integer> fruit : Storage.getFruitsStorage().entrySet()) {
            if (fruit.getKey().equals(fruitTransaction.getFruit())) {
                Storage.setFruitsStorage(fruit.getKey(), fruitTransaction.getQuantity());
                return;
            }
        }
        Storage.setFruitsStorage(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
