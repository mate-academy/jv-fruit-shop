package strategy;

import db.Storage;
import java.util.Map;
import model.FruitTransaction;

public class SupplyReturnOperation implements FruitOperation {
    @Override
    public void execute(Storage storage, Map<String, Integer> fruitQuantities,
                        FruitTransaction fruitTransaction) {
        Integer currentQuantity = storage.get(fruitTransaction.getFruit());
        int storageValue = (currentQuantity != null) ? currentQuantity : 0;
        storage.put(fruitTransaction.getFruit(), storageValue + fruitTransaction.getQuantity());
        fruitQuantities.put(fruitTransaction.getFruit(), storage.get(fruitTransaction.getFruit()));
    }
}
