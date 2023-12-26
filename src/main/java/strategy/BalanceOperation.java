package strategy;

import db.Storage;
import java.util.Map;
import model.FruitTransaction;

public class BalanceOperation implements FruitOperation {
    @Override
    public void execute(Storage storage, Map<String, Integer> fruitQuantities,
                        FruitTransaction fruitTransaction) {
        storage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        fruitQuantities.put(fruitTransaction.getFruit(), storage.get(fruitTransaction.getFruit()));
    }
}
