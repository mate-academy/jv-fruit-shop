package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }

    @Override
    public FruitTransaction get(String fruit) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            if (entry.getKey().equals(fruit)) {
                fruitTransaction.setFruit(entry.getKey());
                fruitTransaction.setQuantity(entry.getValue());
                return fruitTransaction;
            }
        }
        return fruitTransaction;
    }

    @Override
    public void update(FruitTransaction fruitTransaction) {
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            if (entry.getKey().equals(fruitTransaction.getFruit())) {
                entry.setValue(fruitTransaction.getQuantity());
            }
        }
    }
}
