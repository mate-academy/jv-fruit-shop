package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction);
    }

    @Override
    public FruitTransaction get(String fruit) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        for (Map.Entry<String, FruitTransaction> entry : Storage.fruits.entrySet()) {
            if (entry.getKey().equals(fruit)) {
                fruitTransaction = entry.getValue();
            }
        }
        return fruitTransaction;
    }

    @Override
    public void update(FruitTransaction fruitTransaction) {
        for (Map.Entry<String, FruitTransaction> entry : Storage.fruits.entrySet()) {
            if (entry.getKey().equals(fruitTransaction.getFruit())) {
                entry.setValue(fruitTransaction);
            }
        }
    }

    @Override
    public List<FruitTransaction> getAll() {
        List<FruitTransaction> fruits = new ArrayList<>();
        for (Map.Entry<String, FruitTransaction> entry : Storage.fruits.entrySet()) {
            fruits.add(entry.getValue());
        }
        return fruits;
    }
}
