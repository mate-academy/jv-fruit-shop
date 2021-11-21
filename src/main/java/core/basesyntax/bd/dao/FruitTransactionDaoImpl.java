package core.basesyntax.bd.dao;

import core.basesyntax.bd.TransactionStorage;
import core.basesyntax.model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTransactionDao {

    @Override
    public void add(FruitTransaction fruits) {
        TransactionStorage.fruits.add(fruits);
    }

    @Override
    public FruitTransaction get(String fruitName) {
        return TransactionStorage.fruits.stream()
                .filter(fruit -> fruit.getName().contains(fruitName))
                .findFirst().orElse(null);
    }
}
